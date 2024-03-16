package co.nz.acc.icp.samples.java.resources;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import lombok.Getter;
import co.nz.acc.icp.samples.java.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.EnumFactory;
import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.StringType;

import java.util.List;
import java.util.Optional;

@Getter
@SuppressWarnings({"java:S110"}) // keeping the default annotation params for now
@ResourceDef(name = "EpisodeOfCare", profile = Constants.ICP_CASE_MODIFY)
public class IcpCaseModify extends IcpCaseBase {

    @Child(name = "service-bundle-change", min = 1)
    @Extension(url = Constants.ICP_SERVICE_BUNDLE_CHANGE, definedLocally = false)
    protected ServiceBundleChangeExtension serviceBundleChange;

    @Child(name = "exceptional-funding")
    @Extension(url = Constants.ICP_EXCEPTIONAL_FUNDING, definedLocally = false)
    protected ExceptionalFundingExtension exceptionalFunding;

    @SuppressWarnings("DefaultAnnotationParam") // keeping the default annotation params for now
    @Block
    public static class ServiceBundleChangeExtension extends BackboneElement {

        @Child(name = "service-bundle",
                type = {CodeType.class},
                min = 1,
                max = 1,
                modifier = false,
                summary = false)
        @Extension(url = Constants.ICP_SERVICE_BUNDLE_MSK, definedLocally = false, isModifier = false)
        protected Enumeration<IcpServiceBundleMskVS> serviceBundle;

        @Child(name = Constants.ICP_SERVICE_BUNDLE_CHANGE_RATIONALE,
                max = Child.MAX_UNLIMITED,
                min = 1,
                modifier = false,
                summary = false)
        @Extension(url = Constants.ICP_SERVICE_BUNDLE_CHANGE_RATIONALE, definedLocally = false, isModifier = false)
        protected List<Enumeration<IcpServiceBundleChangeRationaleVS>> rationale;
        @Child(
                name = Constants.ICP_SUPPORTING_DETAILS,
                type = {StringType.class},
                min = 0, max = 1,
                modifier = true, summary = true
        )
        @Extension(url = Constants.ICP_SUPPORTING_DETAILS, isModifier = false, definedLocally = false)
        protected StringType supportingDetails;

        public String getSupportingRationale() {
            return Optional.ofNullable(supportingDetails).map(StringType::getValue).orElse(StringUtils.EMPTY);
        }

        public List<IcpServiceBundleChangeRationaleVS> getRationales() {
            return rationale.stream().map(Enumeration::getValue).toList();
        }

        public String getSupportingDetails() {
            return supportingDetails.getValue();
        }

        @SuppressWarnings("unused") // used by HAPI
        public void setSupportingDetails(String supportingDetails) {
            this.supportingDetails = new StringType(supportingDetails);
        }

        @Override
        public BackboneElement copy() {
            return null;
        }

        public IcpServiceBundleMskVS getServiceBundle() {
            return serviceBundle.getValue();
        }

        public enum IcpServiceBundleChangeRationaleVS {
            OTHER,
            COMORBIDITY_FACTORS,
            SOCIAL_SUPPORT,
            ACTIVE_PARTICIPATION,
            PATIENT_RESILIENCE,
            MEDICATION_USE,
            EQUITABLE_ACCESS,
            HEALTH_LITERACY,
            CULTURAL_SUPPORT,
            HOUSING_ACCOMMODATION,
            FINANCES,
            TRAVEL,
            RETURN_TO_DAILY_LIFE,
            RETURN_TO_SPORT,
            NUMBER_OF_DISCIPLINES,
            EMPLOYMENT,
            WORKPLACE_SUPPORT,
            RETURN_TO_WORK_SUPPORT;

            IcpServiceBundleChangeRationaleVS() {
            }

            public static IcpServiceBundleChangeRationaleVS fromCode(String codeString) throws IllegalArgumentException {
                if (StringUtils.isNotEmpty(codeString)) {
                    return switch (codeString) {
                        case "other" -> OTHER;
                        case "comorbidity-factors" -> COMORBIDITY_FACTORS;
                        case "social-support" -> SOCIAL_SUPPORT;
                        case "active-participation" -> ACTIVE_PARTICIPATION;
                        case "patient-resilience" -> PATIENT_RESILIENCE;
                        case "medication-use" -> MEDICATION_USE;
                        case "equitable-access" -> EQUITABLE_ACCESS;
                        case "health-literacy" -> HEALTH_LITERACY;
                        case "cultural-support" -> CULTURAL_SUPPORT;
                        case "housing-accommodation" -> HOUSING_ACCOMMODATION;
                        case "finances" -> FINANCES;
                        case "travel" -> TRAVEL;
                        case "return-to-daily-life" -> RETURN_TO_DAILY_LIFE;
                        case "return-to-sport" -> RETURN_TO_SPORT;
                        case "number-of-disciplines" -> NUMBER_OF_DISCIPLINES;
                        case "employment" -> EMPLOYMENT;
                        case "workplace-support" -> WORKPLACE_SUPPORT;
                        case "return-to-work-support" -> RETURN_TO_WORK_SUPPORT;
                        default -> throw new IllegalArgumentException("Unknown IcpExceptionalFundingRationalVS code: " + codeString);
                    };
                }
                throw new IllegalStateException("Unknown IcpExceptionalFundingRationalVS code: " + codeString);
            }

            public String toCode() {
                return switch (this) {
                    case OTHER -> "other";
                    case COMORBIDITY_FACTORS -> "comorbidity-factors";
                    case SOCIAL_SUPPORT -> "social-support";
                    case ACTIVE_PARTICIPATION -> "active-participation";
                    case PATIENT_RESILIENCE -> "patient-resilience";
                    case MEDICATION_USE -> "medication-use";
                    case EQUITABLE_ACCESS -> "equitable-access";
                    case HEALTH_LITERACY -> "health-literacy";
                    case CULTURAL_SUPPORT -> "cultural-support";
                    case HOUSING_ACCOMMODATION -> "housing-accommodation";
                    case FINANCES -> "finances";
                    case TRAVEL -> "travel";
                    case RETURN_TO_DAILY_LIFE -> "return-to-daily-life";
                    case RETURN_TO_SPORT -> "return-to-sport";
                    case NUMBER_OF_DISCIPLINES -> "number-of-disciplines";
                    case EMPLOYMENT -> "employment";
                    case WORKPLACE_SUPPORT -> "workplace-support";
                    case RETURN_TO_WORK_SUPPORT -> "return-to-work-support";
                };
            }

            public String getSystem() {
                return Constants.ICP_FUNDING_RATIONALE_CS;
            }

            public String getDefinition() {
                return switch (this) {
                    case OTHER -> "sbcRationaleOther";
                    case COMORBIDITY_FACTORS -> "sbcRationaleComorbidityFactors";
                    case SOCIAL_SUPPORT -> "sbcRationaleSocialSupport";
                    case ACTIVE_PARTICIPATION -> "sbcRationaleActiveParticipation";
                    case PATIENT_RESILIENCE -> "sbcRationalePatientResilience";
                    case MEDICATION_USE -> "sbcRationaleMedicationUse";
                    case EQUITABLE_ACCESS -> "sbcRationaleEquitableAccess";
                    case HEALTH_LITERACY -> "sbcRationaleHealthLiteracy";
                    case CULTURAL_SUPPORT -> "sbcRationaleCulturalSupport";
                    case HOUSING_ACCOMMODATION -> "sbcRationaleHousingAccommodation";
                    case FINANCES -> "sbcRationaleFinances";
                    case TRAVEL -> "sbcRationaleTravel";
                    case RETURN_TO_DAILY_LIFE -> "sbcRationaleReturnToDailyLife";
                    case RETURN_TO_SPORT -> "sbcRationaleReturnToSport";
                    case NUMBER_OF_DISCIPLINES -> "sbcRationaleNumberOfDisciplines";
                    case EMPLOYMENT -> "sbcRationaleEmployment";
                    case WORKPLACE_SUPPORT -> "sbcRationaleWorkplaceSupport";
                    case RETURN_TO_WORK_SUPPORT -> "sbcRationaleReturnToWorkSupport";
                };
            }

            public String getDisplay() {
                return switch (this) {
                    case OTHER -> "Other";
                    case COMORBIDITY_FACTORS -> "Comorbidity factors";
                    case SOCIAL_SUPPORT -> "Social support";
                    case ACTIVE_PARTICIPATION -> "Active participation";
                    case PATIENT_RESILIENCE -> "Patient resilience";
                    case MEDICATION_USE -> "Medication use";
                    case EQUITABLE_ACCESS -> "Equitable access";
                    case HEALTH_LITERACY -> "Health literacy";
                    case CULTURAL_SUPPORT -> "Cultural support";
                    case HOUSING_ACCOMMODATION -> "Housing accommodation";
                    case FINANCES -> "Finances";
                    case TRAVEL -> "Travel";
                    case RETURN_TO_DAILY_LIFE -> "Return to daily life";
                    case RETURN_TO_SPORT -> "Return to sport";
                    case NUMBER_OF_DISCIPLINES -> "Number of disciplines";
                    case EMPLOYMENT -> "Employment";
                    case WORKPLACE_SUPPORT -> "Workplace support";
                    case RETURN_TO_WORK_SUPPORT -> "Return to work support";
                };
            }
        }

        @SuppressWarnings("unused") // used by HAPI
        public static class IcpServiceBundleChangeRationaleVSEnumFactory implements EnumFactory<IcpServiceBundleChangeRationaleVS> {

            @Override
            public IcpServiceBundleChangeRationaleVS fromCode(String codeString) throws IllegalArgumentException {
                if (StringUtils.isNotEmpty(codeString)) {
                    return IcpServiceBundleChangeRationaleVS.fromCode(codeString);
                }
                throw new IllegalStateException("Unexpected value: " + codeString);
            }

            @Override
            public String toCode(IcpServiceBundleChangeRationaleVS icpServiceBundleChangeRationaleVS) {
                return icpServiceBundleChangeRationaleVS.toCode();
            }

            @Override
            public String toSystem(IcpServiceBundleChangeRationaleVS icpServiceBundleChangeRationaleVS) {
                return icpServiceBundleChangeRationaleVS.getSystem();
            }

        }

    }
}
