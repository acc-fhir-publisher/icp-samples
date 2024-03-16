package co.nz.acc.icp.samples.java.resources;

import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import co.nz.acc.icp.samples.java.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.EpisodeOfCare;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Patient;
import org.hl7.fhir.r4.model.StringType;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@SuppressWarnings({"java:S110"}) // keeping the default annotation params for now
@ResourceDef(name = "EpisodeOfCare", profile = Constants.ICP_CASE)
public class IcpCaseBase extends EpisodeOfCare {

    @Child(
            name = "providerId",
            type = {CodeType.class},
            min = 1,
        modifier = true, summary = true
    )
    @Extension(url = Constants.ACC_PROVIDER_ID, definedLocally = false)
    protected StringType providerId;
    IcpPatient icpPatient;

    public String getProviderId() {
        return providerId.getValue();
    }

    @Override
    public EpisodeOfCare setType(List<CodeableConcept> theType) {
        final IcpEpisodeOfCareTypeVS icpEpisodeOfCareTypeVS = IcpEpisodeOfCareTypeVS.fromCode(theType.get(0).getCodingFirstRep().getCode());
        CodeableConcept codeableConcept = new CodeableConcept();
        codeableConcept.addCoding().setSystem(icpEpisodeOfCareTypeVS.getSystem()).setCode(icpEpisodeOfCareTypeVS.toCode());
        this.addType(codeableConcept);

        return this;
    }

    public IcpEpisodeOfCareTypeVS getServiceType() {
        return IcpEpisodeOfCareTypeVS.fromCode(this.getType().get(0).getCodingFirstRep().getCode());
    }

    @Override
    public EpisodeOfCare.EpisodeOfCareStatus getStatus() {
        final IcpEpisodeOfCareStatusVS icpEpisodeOfCareStatusVS = IcpEpisodeOfCareStatusVS.fromCode(status.getValueAsString());
        return EpisodeOfCare.EpisodeOfCareStatus.fromCode(icpEpisodeOfCareStatusVS.toCode());
    }

    public IcpEpisodeOfCareStatusVS getIcpStatus() {
        return IcpEpisodeOfCareStatusVS.fromCode(status.getValueAsString());
    }

    @Override
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
                    .findFirst().orElseThrow(() -> new IllegalStateException(Constants.NO_ICP_PATIENT_FOUND_IN_EPISODE_OF_CARE));
        }

        return icpPatient;
    }

    @Override
    public IcpCaseBase setPatientTarget(Patient value) {
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
        final String reference = super.getManagingOrganization().getReference();
        return reference.substring(reference.indexOf("/") + 1);
    }

    public String getClaimNumber() {
        return this.getIdentifier().stream()
                .filter(id -> id.getSystem().equalsIgnoreCase(Constants.ICP_ACC_CLAIM_NUMBER))
                .map(Identifier::getValue)
                .findFirst().orElseThrow();
    }

    public LocalDate getPeriodStartDate() {
        return period.getStart().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public LocalDate getPeriodEndDate() {
        return period.getEnd().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public enum IcpEpisodeOfCareStatusVS {

        ACTIVE,
        FINISHED;


        IcpEpisodeOfCareStatusVS() {
        }

        public static IcpEpisodeOfCareStatusVS fromCode(String codeString) throws FHIRException {
            if (StringUtils.isNotEmpty(codeString)) {
                if ("active".equals(codeString)) {
                    return ACTIVE;
                } else if ("finished".equals(codeString)) {
                    return FINISHED;
                }
            }

            throw new FHIRException("Unknown EpisodeOfCareStatus code '" + codeString + "'");
        }

        public String toCode() {
            return switch (this) {
                case ACTIVE -> "active";
                case FINISHED -> "finished";
            };
        }

        public String getSystem() {
            return EpisodeOfCareStatus.ACTIVE.getSystem();
        }

        public String getDefinition() {
            return switch (this) {
                case ACTIVE -> "Accepted";
                case FINISHED -> "Completed";
            };
        }

        public String getDisplay() {
            return switch (this) {
                case ACTIVE -> "Active";
                case FINISHED -> "Finished";
            };
        }
    }

    public enum IcpEpisodeOfCareTypeVS {
        MSK;

        IcpEpisodeOfCareTypeVS() {
        }

        public static IcpEpisodeOfCareTypeVS fromCode(String codeString) throws FHIRException {
            if (("msk".equals(codeString))) {
                return MSK;
            }
            throw new FHIRException("Unknown IcpEpisodeOfCareTypeVS code '" + codeString + "'");
        }

        public String toCode() {
            if (this == IcpEpisodeOfCareTypeVS.MSK) {
                return "msk";
            }
            throw new IllegalArgumentException();
        }

        public String getSystem() {
            return Constants.ICP_SERVICE_TYPE_CS;
        }

        public String getDefinition() {
            if (this == IcpEpisodeOfCareTypeVS.MSK) {
                return "MSK";
            }
            throw new IllegalArgumentException();
        }

        public String getDisplay() {
            if (this == IcpEpisodeOfCareTypeVS.MSK) {
                return "Muscular Skeletal";
            }
            throw new IllegalArgumentException();
        }
    }
}


