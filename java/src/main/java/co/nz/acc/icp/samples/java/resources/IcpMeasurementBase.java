package co.nz.acc.icp.samples.java.resources;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import co.nz.acc.icp.samples.java.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.DateTimeType;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Observation;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.Resource;
import org.hl7.fhir.r4.model.StringType;

import java.time.LocalDate;
import java.time.ZoneId;

@SuppressWarnings({"java:S110"}) // keeping the default annotation params for now
@ResourceDef(name = "Observation", profile = Constants.ICP_MEASUREMENT)
public class IcpMeasurementBase extends Observation {

    @Child(
        name = "providerId",
        type = {CodeType.class},
        min = 1,
        modifier = true, summary = true
    )
    @Extension(url = Constants.ACC_PROVIDER_ID, definedLocally = false)
    protected StringType providerId;
    @Child(
        name = "stage",
        type = {CodeType.class},
        min = 1,
        modifier = true, summary = true
    )
    @Extension(url = Constants.ICP_RECORDED_OUTCOME_STAGE, definedLocally = false)
    protected StringType recordedOutcomeStage;
    IcpPatient icpPatient;

    @Override
    public Observation setSubjectTarget(Resource value) {
        if (value instanceof IcpPatient icpPatient1) {
            getContained().clear();
            addContained(icpPatient1);
        }

        return this;
    }

    public String getProviderId() {
        return providerId.getValue();
    }

    public IcpRecordedOutcomeStageVS getStage() {
        return IcpRecordedOutcomeStageVS.fromCode(recordedOutcomeStage.getValue());
    }

    public IcpObservationDataAbsentVS getObservationDataAbsentReason() {
        return IcpObservationDataAbsentVS.fromCode(dataAbsentReason.getCodingFirstRep().getCode());
    }

    public IcpObservationStatusVS getIcpStatus() {
        return IcpObservationStatusVS.fromCode(status.getValueAsString());
    }

    //@Override
    public IcpPatient getPatientTarget() {
        if (null == icpPatient) {
            icpPatient = this.getContained().stream()
                .filter(Patient.class::isInstance)
                .map(Patient.class::cast)
                .filter(patient -> patient.getMeta().hasProfile(Constants.ICP_PATIENT))
                .map(patient -> {
                    IcpPatient icpPatient1 = new IcpPatient();
                    icpPatient1.setId(patient.getId());
                    icpPatient1.setBirthDateElement(patient.getBirthDateElement());
                    icpPatient1.setMeta(patient.getMeta());
                    return icpPatient1;
                })
                .findFirst().orElseThrow(() -> new IllegalStateException(Constants.NO_ICP_PATIENT_FOUND_IN_OBSERVATION));
        }

        return icpPatient;
    }

    //@Override
    public IcpMeasurementBase setPatientTarget(Patient value) {
        if (value instanceof IcpPatient icpPatient1) {
            getContained().clear();
            addContained(icpPatient1);
        }

        return this;
    }

    public LocalDate getPatientDOB() {
        return getPatientTarget()
            .getBirthDate()
            .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public String getVendorId() {
        final String reference = super.getPerformer().get(0).getReference();
        return reference.substring(reference.indexOf("/") + 1);
    }

    public String getClaimNumber() {
        return this.getIdentifier().stream()
            .filter(id -> id.getSystem().equalsIgnoreCase(Constants.ICP_ACC_CLAIM_NUMBER))
            .map(Identifier::getValue)
            .findFirst()
            .orElseThrow();
    }

    public DateTimeType getEffectiveDateTime() {
        return super.getEffectiveDateTimeType();
    }

    public enum IcpObservationDataAbsentVS {
        NOTTESTED,
        UNABLETOTEST;

        public static final String NOT_TESTED = "not-tested";
        public static final String UNABLE_TO_TEST = "unable-to-test";

        IcpObservationDataAbsentVS() {
        }

        public static IcpObservationDataAbsentVS fromCode(String codeString) throws FHIRException {
            return switch (codeString) {
                case NOT_TESTED -> NOTTESTED;
                case UNABLE_TO_TEST -> UNABLETOTEST;
                default -> throw new FHIRException("Unknown IcpObservationDataAbsentVS code '" + codeString + "'");
            };
        }

        public String toCode() {
            return switch (this) {
                case NOTTESTED -> NOT_TESTED;
                case UNABLETOTEST -> UNABLE_TO_TEST;
            };
        }

        public String getDefinition() {
            return switch (this) {
                case NOTTESTED -> NOT_TESTED;
                case UNABLETOTEST -> UNABLE_TO_TEST;
            };
        }

        public String getDisplay() {
            return switch (this) {
                case NOTTESTED -> NOT_TESTED;
                case UNABLETOTEST -> UNABLE_TO_TEST;
            };
        }
    }

    public enum IcpObservationStatusVS {

        FINAL;

        public static final String FINAL1 = "final";

        IcpObservationStatusVS() {
        }

        public static IcpObservationStatusVS fromCode(String codeString) throws FHIRException {
            if (StringUtils.isNotEmpty(codeString) && FINAL1.equals(codeString)) {
                return FINAL;
            }

            throw new FHIRException("Unknown Observation code '" + codeString + "'");
        }

        public String toCode() {
            return switch (this) {
                case FINAL -> FINAL1;
            };
        }

        public String getSystem() {
            return ObservationStatus.FINAL.getSystem();
        }

        public String getDefinition() {
            return switch (this) {
                case FINAL -> FINAL1;
            };
        }

        public String getDisplay() {
            return switch (this) {
                case FINAL -> FINAL1;
            };
        }
    }

    public enum IcpRecordedOutcomeStageVS {
        ADHOC,
        BASELINE,
        EXIT,
        MIDPOINT;

        public static final String ADHOC1 = "adhoc";
        public static final String BASELINE1 = "baseline";
        public static final String EXIT1 = "exit";
        public static final String MID_POINT = "mid-point";

        IcpRecordedOutcomeStageVS() {
        }

        public static IcpRecordedOutcomeStageVS fromCode(String codeString) throws FHIRException {
            if (StringUtils.isNotEmpty(codeString)) {
                if (ADHOC1.equals(codeString)) {
                    return ADHOC;
                }
                if (BASELINE1.equals(codeString)) {
                    return BASELINE;
                }
                if (EXIT1.equals(codeString)) {
                    return EXIT;
                }
                if (MID_POINT.equals(codeString)) {
                    return MIDPOINT;
                }
                throw new FHIRException("Unknown IcpObservationStage code '" + codeString + "'");
            }

            throw new FHIRException("Unknown Observation code '" + codeString + "'");
        }

        public String toCode() {
            return switch (this) {
                case ADHOC -> ADHOC1;
                case BASELINE -> BASELINE1;
                case EXIT -> EXIT1;
                case MIDPOINT -> MID_POINT;

            };
        }

        public String getDefinition() {
            return switch (this) {
                case ADHOC -> ADHOC1;
                case BASELINE -> BASELINE1;
                case EXIT -> EXIT1;
                case MIDPOINT -> MID_POINT;
            };
        }

    }

}


