package co.nz.acc.icp.samples.java.resources;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import co.nz.acc.icp.samples.java.utils.Constants;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r4.model.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@SuppressWarnings({"java:S110"}) // keeping the default annotation params for now
@ResourceDef(name = "Encounter", profile = Constants.ICP_REFERRAL_DECLINE)
public class IcpReferralDecline extends Encounter {
    IcpPatient icpPatient;

    @Child(
        name = "providerId",
        type = {CodeType.class},
        min = 1,
        modifier = true, summary = true
    )
    @Extension(url = Constants.ACC_PROVIDER_ID, definedLocally = false)
    protected StringType providerId;

    @Child(name = "referralSource", min = 1)
    @Extension(url = Constants.ICP_REFERRAL_SOURCE, definedLocally = false)
    protected IcpCaseCreate.ReferralSourceExtension referralSource;

    public IcpCaseCreate.ReferralSourceExtension.IcpReferralSourceTypeVS getReferralSourceType() {
        return referralSource.getReferralSourceType();
    }

    public IcpCaseBase.IcpEpisodeOfCareTypeVS getICPServiceType() {
        return IcpCaseBase.IcpEpisodeOfCareTypeVS.fromCode(this.getServiceType().getCodingFirstRep().getCode());
    }

    public boolean hasReferralSourceReceivedDate() {
        return referralSource.receivedDate != null && referralSource.receivedDate.getValue() != null;
    }
    public LocalDate getReferralSourceReceivedDate() {
        return referralSource.receivedDate.getValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    @Getter
    @Child(name = "triage")
    @Extension(url = Constants.ICP_TRIAGE, definedLocally = false)
    public TriageExtension triage;

    @Getter
    @Child(name = "referralDeclined", min = 1)
    @Extension(url = Constants.ICP_REFERRAL_DECLINED, definedLocally = false)
    protected IcpReferralDecline.ReferralDeclinedExtension referralDeclined;


    public LocalDate getReferralDeclinedDate() {
        return referralDeclined
            .getReferralDeclinedDate()
            .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public String getProviderId() {
        return providerId.getValue();
    }

    @Override
    public IcpPatient getSubjectTarget() {
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
                .findFirst().orElseThrow(() -> new IllegalStateException(Constants.NO_ICP_PATIENT_FOUND_IN_ENCOUNTER));
        }

        return icpPatient;
    }

    @Override
    public Encounter setSubjectTarget(Resource value) {
        if (value instanceof IcpPatient icpPatient1) {
            getContained().clear();
            addContained(icpPatient1);
        }

        return this;
    }

    public LocalDate getPatientDOB() {
        return getSubjectTarget()
            .getBirthDate()
            .toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public String getVendorId() {
        final String reference = super.getServiceProvider().getReference();
        return reference.substring(reference.indexOf("/") + 1);
    }

    public String getClaimNumber() {
        return this.getIdentifier().stream()
            .filter(id -> id.getSystem().equalsIgnoreCase(Constants.ICP_ACC_CLAIM_NUMBER))
            .map(Identifier::getValue)
            .findFirst().orElseThrow();
    }


    @Block
    public static class ReferralDeclinedExtension extends BackboneElement {

        @Child(name = Constants.ICP_REFERRAL_DECLINED_DATE,
            type = {DateType.class},
            min = 1
        )
        @Extension(url = Constants.ICP_REFERRAL_DECLINED_DATE, definedLocally = false)
        protected DateType referralDeclinedDate;

        @Child(
            name = Constants.ICP_REFERRAL_DECLINED_NEXT_STEPS,
            type = {StringType.class},
            min = 1,
            modifier = true, summary = true
        )
        @Extension(url = Constants.ICP_REFERRAL_DECLINED_NEXT_STEPS, definedLocally = false)
        protected StringType recommendedNextSteps;

        @Child(name = Constants.ICP_REFERRAL_DECLINED_REASON_VALUE,
            type = {CodeType.class},
            min = 1
        )
        @Extension(url = Constants.ICP_REFERRAL_DECLINED_REASON_VALUE, definedLocally = false)
        protected Enumeration<IcpReferralDeclinedReasonVS> declineReason;

        public IcpReferralDeclinedReasonVS getDeclineReason() {
            return declineReason.getValue();
        }

        @Child(
            name = Constants.ICP_REFERRAL_DECLINED_OTHER_REASON,
            type = {StringType.class},
            modifier = true, summary = true
        )
        @Extension(url = Constants.ICP_REFERRAL_DECLINED_OTHER_REASON, definedLocally = false)
        protected StringType otherReason;

        public boolean hasOtherReason() {
            return otherReason != null;
        }

        public String getOtherReason() {
            return otherReason.getValue();
        }

        @Override
        public BackboneElement copy() {
            return null;
        }

        public String getRecommendedNextSteps() {
            return recommendedNextSteps.getValue();
        }

        public Date getReferralDeclinedDate() {
            return referralDeclinedDate.getValue();
        }

        public enum IcpReferralDeclinedReasonVS {
            ACCREDITED_EMPLOYER,
            CLIENT_NOT_CONTACTABLE,
            CLIENT_DECLINED_ENTRY_TO_ICPMSK,
            BODY_SITE_OUT_OF_SCOPE_INELIGIBLE,
            OUT_OF_REGION,
            NOT_ELIGIBLE_UNDER_ACC,
            ALTERNATE_ACC_SERVICE,
            OTHER;

            IcpReferralDeclinedReasonVS() {
            }

            public static IcpReferralDecline.ReferralDeclinedExtension.IcpReferralDeclinedReasonVS fromCode(String codeString) throws IllegalArgumentException {
                if (StringUtils.isNotEmpty(codeString)) {
                    return switch (codeString) {
                        case "accredited-employer" -> ACCREDITED_EMPLOYER;
                        case "client-not-contactable" -> CLIENT_NOT_CONTACTABLE;
                        case "client-declined-entry-to-icpmsk" -> CLIENT_DECLINED_ENTRY_TO_ICPMSK;
                        case "body-site-out-of-scope-ineligible" -> BODY_SITE_OUT_OF_SCOPE_INELIGIBLE;
                        case "out-of-region" -> OUT_OF_REGION;
                        case "not-eligible-under-acc" -> NOT_ELIGIBLE_UNDER_ACC;
                        case "alternate-acc-service" -> ALTERNATE_ACC_SERVICE;
                        case "other" -> OTHER;
                        default -> throw new IllegalArgumentException("Unknown IcpReferralDeclinedReasonVS code '" + codeString + "'");
                    };
                }
                throw new IllegalArgumentException("Unknown IcpReferralDeclinedReasonVS code '" + codeString + "'");
            }

            public String toCode() {
                return switch (this) {
                    case ACCREDITED_EMPLOYER -> "accredited-employer";
                    case CLIENT_NOT_CONTACTABLE -> "client-not-contactable";
                    case CLIENT_DECLINED_ENTRY_TO_ICPMSK -> "client-declined-entry-to-icpmsk";
                    case BODY_SITE_OUT_OF_SCOPE_INELIGIBLE -> "body-site-out-of-scope-ineligible";
                    case OUT_OF_REGION -> "out-of-region";
                    case NOT_ELIGIBLE_UNDER_ACC -> "not-eligible-under-acc";
                    case ALTERNATE_ACC_SERVICE -> "alternate-acc-service";
                    case OTHER -> "other";
                };
            }

            public String getSystem() {
                return Constants.ICP_REFERRAL_DECLINED_REASON_CS;
            }

            public String getDefinition() {
                return switch (this) {
                    case ACCREDITED_EMPLOYER -> "Accredited Employer (work injury)";
                    case CLIENT_NOT_CONTACTABLE -> "Client not contactable";
                    case CLIENT_DECLINED_ENTRY_TO_ICPMSK -> "Client declined entry to ICPMSK";
                    case BODY_SITE_OUT_OF_SCOPE_INELIGIBLE -> "Body site out of scope/ineligible";
                    case OUT_OF_REGION -> "Out of region";
                    case NOT_ELIGIBLE_UNDER_ACC -> "Not eligible under ACC (cover/causation)";
                    case ALTERNATE_ACC_SERVICE -> "Alternate ACC service more appropriate for client";
                    case OTHER -> "Other - please specify";
                };
            }

            public String getDisplay() {
                return getDefinition();
            }
        }

        @SuppressWarnings("unused") // used by HAPI
        public static class IcpReferralDeclinedReasonVSEnumFactory implements EnumFactory<IcpReferralDeclinedReasonVS> {

            @Override
            public IcpReferralDeclinedReasonVS fromCode(String codeString) throws IllegalArgumentException {
                return IcpReferralDeclinedReasonVS.fromCode(codeString);
            }

            @Override
            public String toCode(IcpReferralDeclinedReasonVS icpReferralDeclinedReasonVS) {
                return icpReferralDeclinedReasonVS.toCode();
            }

            @Override
            public String toSystem(IcpReferralDeclinedReasonVS icpReferralDeclinedReasonVS) {
                return icpReferralDeclinedReasonVS.getSystem();
            }

        }
    }
}


