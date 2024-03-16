package co.nz.acc.icp.samples.java.resources;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import co.nz.acc.icp.samples.java.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.EnumFactory;
import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.StringType;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("DefaultAnnotationParam") // keeping the default annotation params for now
@Block
public class ExceptionalFundingExtension extends BackboneElement {

    @Child(name = Constants.ICP_FUNDING_RATIONALE, max = Child.MAX_UNLIMITED, min = 1, modifier = false, summary = false)
    @Extension(url = Constants.ICP_FUNDING_RATIONALE, definedLocally = false, isModifier = false)
    protected List<Enumeration<IcpExceptionalFundingRationalVS>> rationale;
    @Child(
            name = Constants.ICP_SUPPORTING_DETAILS,
            type = {StringType.class},
            min = 0, max = 1,
            modifier = true, summary = true
    )
    @Extension(url = Constants.ICP_SUPPORTING_DETAILS, isModifier = false, definedLocally = false)
    protected StringType supportingDetails;

    public String getSupportingRationale() {
        return Optional.of(supportingDetails).map(StringType::getValue).orElse(StringUtils.EMPTY);
    }

    public List<IcpExceptionalFundingRationalVS> getRationale() {
        return rationale.stream().map(Enumeration::getValue).toList();
    }

    public String getSupportingDetails() {
        return supportingDetails.getValue();
    }

    public void setSupportingDetails(String supportingDetails) {
        this.supportingDetails = new StringType(supportingDetails);
    }

    @Override
    public BackboneElement copy() {
        return null;
    }

    public enum IcpExceptionalFundingRationalVS {
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

        IcpExceptionalFundingRationalVS() {
        }

        public static IcpExceptionalFundingRationalVS fromCode(String codeString) throws IllegalArgumentException {
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
                case OTHER -> "rationaleOther";
                case COMORBIDITY_FACTORS -> "rationaleComorbidityFactors";
                case SOCIAL_SUPPORT -> "rationaleSocialSupport";
                case ACTIVE_PARTICIPATION -> "rationaleActiveParticipation";
                case PATIENT_RESILIENCE -> "rationalePatientResilience";
                case MEDICATION_USE -> "rationaleMedicationUse";
                case EQUITABLE_ACCESS -> "rationaleEquitableAccess";
                case HEALTH_LITERACY -> "rationaleHealthLiteracy";
                case CULTURAL_SUPPORT -> "rationaleCulturalSupport";
                case HOUSING_ACCOMMODATION -> "rationaleHousingAccommodation";
                case FINANCES -> "rationaleFinances";
                case TRAVEL -> "rationaleTravel";
                case RETURN_TO_DAILY_LIFE -> "rationaleReturnToDailyLife";
                case RETURN_TO_SPORT -> "rationaleReturnToSport";
                case NUMBER_OF_DISCIPLINES -> "rationaleNumberOfDisciplines";
                case EMPLOYMENT -> "rationaleEmployment";
                case WORKPLACE_SUPPORT -> "rationaleWorkplaceSupport";
                case RETURN_TO_WORK_SUPPORT -> "rationaleReturnToWorkSupport";
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
    public static class IcpExceptionalFundingRationalVSEnumFactory implements EnumFactory<IcpExceptionalFundingRationalVS> {

        @Override
        public IcpExceptionalFundingRationalVS fromCode(String codeString) throws IllegalArgumentException {
            return IcpExceptionalFundingRationalVS.fromCode(codeString);
        }

        @Override
        public String toCode(IcpExceptionalFundingRationalVS icpExceptionalFundingRationalVS) {
            return icpExceptionalFundingRationalVS.toCode();
        }

        @Override
        public String toSystem(IcpExceptionalFundingRationalVS icpExceptionalFundingRationalVS) {
            return icpExceptionalFundingRationalVS.getSystem();
        }

    }

}
