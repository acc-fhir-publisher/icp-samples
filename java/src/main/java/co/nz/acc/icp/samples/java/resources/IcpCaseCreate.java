package co.nz.acc.icp.samples.java.resources;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import lombok.Getter;
import co.nz.acc.icp.samples.java.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.Base;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.CodeableConcept;
import org.hl7.fhir.r4.model.DateType;
import org.hl7.fhir.r4.model.EnumFactory;
import org.hl7.fhir.r4.model.Enumeration;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static co.nz.acc.icp.samples.java.utils.Constants.*;

@SuppressWarnings({"java:S110"}) // keeping the default annotation params for now
@ResourceDef(name = "EpisodeOfCare", profile = Constants.ICP_CASE_CREATE)
public class IcpCaseCreate extends IcpCaseBase {

    @Child(name = "diagnoses", min = 1)
    @Extension(url = Constants.ICP_DIAGNOSES, definedLocally = false)
    public DiagnosesExtension diagnoses;
    @Child(name = "serviceBundleMsk",
            type = {CodeType.class},
            min = 1
    )
    @Extension(url = Constants.ICP_SERVICE_BUNDLE_MSK, definedLocally = false)
    protected Enumeration<IcpServiceBundleMskVS> serviceBundleMsk;

    @Child(name = "referralSource", min = 1)
    @Extension(url = Constants.ICP_REFERRAL_SOURCE, definedLocally = false)
    protected ReferralSourceExtension referralSource;

    @Getter
    @Child(name = "triage", min = 1)
    @Extension(url = Constants.ICP_TRIAGE, definedLocally = false)
    protected TriageExtension triage;

    @Getter
    @Child(name = "exceptionalFunding")
    @Extension(url = Constants.ICP_EXCEPTIONAL_FUNDING, definedLocally = false)
    protected ExceptionalFundingExtension exceptionalFunding;

    public ReferralSourceExtension.IcpReferralSourceTypeVS getReferralSourceType() {
        return referralSource.getReferralSourceType();
    }

    public boolean hasReferralSourceReceivedDate() {
        return referralSource.receivedDate != null && referralSource.receivedDate.getValue() != null;
    }

    public LocalDate getReferralSourceReceivedDate() {
        return referralSource.receivedDate.getValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public ComplexityScoresExtension getComplexityScores() {
        return triage.complexityScores;
    }

    public boolean getCoversAllClaimDiagnoses() {
        return diagnoses.coversAllClaimDiagnoses.getValue();
    }

    public String getAccClientAuthority() {
        return triage.accClientAuthority.booleanValue()
                ? "True"
                : "False";
    }

    public String getClientParticipationAgreement() {
        return triage.clientParticipationAgreement.booleanValue()
                ? "True"
                : "False";
    }

    public LocalDate getTriageAssessmentDate() {
        return triage.triageAssessmentDate.getValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public IcpServiceBundleMskVS getServiceBundleMsk() {
        return serviceBundleMsk.getValue();
    }

    @Block
    public static class ReferralSourceExtension extends BackboneElement {

        @Child(name = "referral-source-type", min = 1)
        @Extension(url = ICP_REFERRAL_SOURCE_TYPE, definedLocally = false)
        protected Enumeration<IcpReferralSourceTypeVS> referralSourceType;

        @Child(name = "received-date",
                type = {DateType.class}
        )
        @Extension(url = ICP_REFERRAL_RECEIVED_DATE, definedLocally = false)
        protected DateType receivedDate;

        @Override
        public BackboneElement copy() {
            return null;
        }

        public IcpReferralSourceTypeVS getReferralSourceType() {
            return referralSourceType.getValue();
        }

        public enum IcpReferralSourceTypeVS {
            GP,
            PHYSIO,
            SPECIALIST,
            ALLIED,
            EMPLOYER,
            RONGOA,
            OTHER,
            ACC,
            PATIENT;

            IcpReferralSourceTypeVS() {
            }

            public static IcpReferralSourceTypeVS fromCode(String codeString) throws FHIRException {
                if (StringUtils.isNotEmpty(codeString)) {
                    return switch (codeString) {
                        case "gp" -> GP;
                        case "physio" -> PHYSIO;
                        case "specialist" -> SPECIALIST;
                        case "allied" -> ALLIED;
                        case "employer" -> EMPLOYER;
                        case "rongoa" -> RONGOA;
                        case "other" -> OTHER;
                        case "acc" -> ACC;
                        case "patient" -> PATIENT;
                        default -> throw new IllegalStateException(UNEXPECTED_VALUE + codeString);
                    };
                }
                throw new IllegalStateException(UNEXPECTED_VALUE + codeString);
            }

            public String toCode() {
                return switch (this) {
                    case GP -> "gp";
                    case PHYSIO -> "physio";
                    case SPECIALIST -> "specialist";
                    case ALLIED -> "allied";
                    case EMPLOYER -> "employer";
                    case RONGOA -> "rongoa";
                    case OTHER -> "other";
                    case ACC -> "acc";
                    case PATIENT -> "patient";
                };
            }

            public String getSystem() {
                return Constants.ICP_REFERRAL_SOURCE_TYPE_CS;
            }

            public String getDefinition() {
                return switch (this) {
                    case GP -> "GP referral";
                    case PHYSIO -> "Physio referral";
                    case SPECIALIST -> "Specialist referral";
                    case ALLIED -> "Other Allied health referral";
                    case EMPLOYER -> "Employer referral";
                    case RONGOA -> "Rongoa referral";
                    case OTHER -> "Other referral type";
                    case ACC -> "ACC referral";
                    case PATIENT -> "Patient-led referral";
                };
            }

            public String getDisplay() {
                return switch (this) {
                    case GP -> "General Practitioner";
                    case PHYSIO -> "Physiotherapist";
                    case SPECIALIST -> "Specialist";
                    case ALLIED -> "Allied Health Professional";
                    case EMPLOYER -> "Employer";
                    case RONGOA -> "Rongoa";
                    case OTHER -> "Other";
                    case ACC -> "ACC";
                    case PATIENT -> "Patient";
                };
            }
        }

        @SuppressWarnings("unused") // used by HAPI
        public static class IcpReferralSourceTypeVSEnumFactory implements EnumFactory<IcpReferralSourceTypeVS> {

            public IcpReferralSourceTypeVS fromCode(String codeString) throws IllegalArgumentException {
                if (StringUtils.isEmpty(codeString)) {
                    return null;
                }
                return IcpReferralSourceTypeVS.fromCode(codeString);
            }

            public Enumeration<IcpReferralSourceTypeVS> fromType(Base code) throws FHIRException {
                if (code == null) {
                    return null;
                }
                if (code.isEmpty()) {
                    return new Enumeration<>(this);
                }

                String codeString = code.primitiveValue();
                return new Enumeration<>(this, IcpReferralSourceTypeVS.fromCode(codeString));
            }

            public String toCode(IcpReferralSourceTypeVS code) {
                return code.toCode();
            }

            public String toSystem(IcpReferralSourceTypeVS code) {
                return code.getSystem();
            }
        }
    }

    @Block
    public static class DiagnosesExtension extends BackboneElement {
        @Child(name = "covers-all-claim-diagnoses",
                type = {BooleanType.class}
        )
        @Extension(url = Constants.ICP_COVERS_ALL_CLAIM_DIAGNOSES, definedLocally = false)
        protected BooleanType coversAllClaimDiagnoses;

        @Child(name = "diagnosis", max = 10, min = 1)
        @Extension(url = ICP_DIAGNOSIS, definedLocally = false)
        protected List<DiagnosisExtension> diagnosis;

        public List<DiagnosisExtension> getDiagnosis() {
            if (diagnosis == null) {
                diagnosis = new ArrayList<>();
            }
            return diagnosis;
        }

        @Override
        public BackboneElement copy() {
            return null;
        }

        @Block
        public static class DiagnosisExtension extends BackboneElement {
            @Child(name = "diagnosis-side",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = Constants.ICP_DIAGNOSIS_SIDE, definedLocally = false)
            protected Enumeration<DiagnosisSideVS> diagnosisSide;
            @Child(name = "diagnosis-code",
                    type = {CodeableConcept.class},
                    min = 1
            )
            @Extension(url = Constants.ICP_DIAGNOSIS_CODE, definedLocally = false)
            protected CodeableConcept diagnosisCode;

            public String getDiagnosisType() {
                return switch (diagnosisCode.getCodingFirstRep().getSystem()) {
                    case READ -> "READ";
                    case SCT -> "SNOMED";
                    case ICD_9_CM_DIAGNOSIS_CODES,
                            ICD_9 -> "ICD9";
                    case ICD10CM,
                            ICD10PCS,
                            ICD_10_AE -> "ICD10";
                    default ->
                            throw new IllegalStateException(UNEXPECTED_VALUE + diagnosisCode.getCodingFirstRep().getSystem());
                };
            }

            public String getDiagnosisCode() {
                return diagnosisCode.getCodingFirstRep().getCode();
            }

            @Override
            public BackboneElement copy() {
                return null;
            }

            public DiagnosisSideVS getDiagnosisSide() {
                return diagnosisSide.getValue();
            }

            public enum DiagnosisSideVS {
                LEFT,
                RIGHT,
                NA;

                DiagnosisSideVS() {
                }

                public static DiagnosisSideVS fromCode(String codeString) throws FHIRException {
                    if (StringUtils.isNotEmpty(codeString)) {
                        return switch (codeString) {
                            case "left" -> LEFT;
                            case "right" -> RIGHT;
                            case "na" -> NA;
                            default -> throw new FHIRException("Unknown DiagnosisSideVS code '" + codeString + "'");
                        };
                    }
                    throw new FHIRException("Unknown DiagnosisSideVS code '" + codeString + "'");
                }

                public String toCode() {
                    return switch (this) {
                        case LEFT -> "left";
                        case RIGHT -> "right";
                        case NA -> "na";
                    };
                }

                public String getSystem() {
                    return Constants.ICP_DIAGNOSIS_SIDE_CS;
                }

                public String getDefinition() {
                    return toCode();
                }

                public String getDisplay() {
                    return switch (this) {
                        case LEFT -> "Left";
                        case RIGHT -> "Right";
                        case NA -> "N/A";
                    };
                }

            }

            @SuppressWarnings("unused") // used by HAPI
            public static class DiagnosisSideVSEnumFactory implements EnumFactory<DiagnosisSideVS> {

                public DiagnosisSideVS fromCode(String codeString) throws IllegalArgumentException {
                    return DiagnosisSideVS.fromCode(codeString);
                }

                public Enumeration<DiagnosisSideVS> fromType(CodeType code) throws IllegalArgumentException {
                    if (code == null) {
                        return null;
                    }
                    if (code.isEmpty()) {
                        return new Enumeration<>(this);
                    }

                    String codeString = code.primitiveValue();
                    return new Enumeration<>(this, DiagnosisSideVS.fromCode(codeString));
                }

                public String toCode(DiagnosisSideVS code) {
                    return code.toCode();
                }

                public String toSystem(DiagnosisSideVS code) {
                    return code.getSystem();
                }
            }
        }
    }

    @Block
    public static class ComplexityScoresExtension extends BackboneElement {

        @Child(name = "complexityScore",
                type = {CodeType.class},
                min = 1
        )
        @Extension(url = Constants.ICP_COMPLEXITY_SCORE, definedLocally = false)
        protected Enumeration<ComplexityScoreVS> complexityScore;
        public ComplexityScoreVS getComplexityScore() {
            return complexityScore.getValue();
        }

        @Getter
        @Child(name = "categoryCoMorbidities", min = 1)
        @Extension(url = ICP_CATEGORY_CO_MORBIDITIES, definedLocally = false)
        protected CategoryComorbiditiesExtension categoryCoMorbidities;

        @Getter
        @Child(name = "categoryPsychosocial", min = 1)
        @Extension(url = ICP_CATEGORY_PSYCHOSOCIAL, definedLocally = false)
        protected CategoryPsychosocialExtension categoryPsychosocial;

        @Getter
        @Child(name = "categoryContextual", min = 1)
        @Extension(url = ICP_CATEGORY_CONTEXTUAL, definedLocally = false)
        protected CategoryContextualExtension categoryContextual;

        @Getter
        @Child(name = "categoryDisciplines", min = 1)
        @Extension(url = ICP_CATEGORY_DISCIPLINES, definedLocally = false)
        protected CategoryDisciplinesExtension categoryDisciplines;

        @Getter
        @Child(name = "categoryVocational")
        @Extension(url = ICP_CATEGORY_VOCATIONAL, definedLocally = false)
        protected CategoryVocationalExtension categoryVocational;

        @Override
        public BackboneElement copy() {
            return null;
        }

        public enum ComplexityScoreVS {
            LOW,
            MEDIUM,
            HIGH;

            public static final String MEDIUM1 = "medium";
            public static final String LOW1 = "low";
            public static final String HIGH1 = "high";

            ComplexityScoreVS() {
            }

            public static ComplexityScoreVS fromCode(String codeString) throws FHIRException {
                if (StringUtils.isNotEmpty(codeString)) {
                    return switch (codeString) {
                        case LOW1 -> LOW;
                        case MEDIUM1 -> MEDIUM;
                        case HIGH1 -> HIGH;
                        default -> throw new IllegalStateException(UNEXPECTED_VALUE + codeString);
                    };
                }
                throw new IllegalStateException(UNEXPECTED_VALUE + codeString);
            }

            public String toCode() {
                return switch (this) {
                    case LOW -> LOW1;
                    case MEDIUM -> MEDIUM1;
                    case HIGH -> HIGH1;
                };
            }

            public String getSystem() {
                return Constants.ICP_COMPLEXITY_SCORE_CS;
            }

            public String getDefinition() {
                return switch (this) {
                    case LOW -> "Low";
                    case MEDIUM -> "Medium";
                    case HIGH -> "High";
                };
            }

            public String getDisplay() {
                return switch (this) {
                    case LOW -> "Low";
                    case MEDIUM -> "Medium";
                    case HIGH -> "High";
                };
            }

        }

        @SuppressWarnings("unused") // used by HAPI
        public static class ComplexityScoreVSEnumFactory implements EnumFactory<IcpCaseCreate.ComplexityScoresExtension.ComplexityScoreVS> {

            public IcpCaseCreate.ComplexityScoresExtension.ComplexityScoreVS fromCode(String codeString) throws IllegalArgumentException {
                return ComplexityScoreVS.fromCode(codeString);
            }

            public String toCode(IcpCaseCreate.ComplexityScoresExtension.ComplexityScoreVS code) {
                return code.toCode();
            }

            public String toSystem(IcpCaseCreate.ComplexityScoresExtension.ComplexityScoreVS code) {
                return code.getSystem();
            }
        }

        @Block
        public static class CategoryComorbiditiesExtension extends BackboneElement {

            @Child(name = "co-morbidity-factors",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "co-morbidity-factors", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> comorbidityFactors;


            public ComplexityScoreVS getComorbidityFactorsScore() {
                return comorbidityFactors.getValue();
            }

            @Override
            public BackboneElement copy() {
                return null;
            }
        }

        @Block
        public static class CategoryPsychosocialExtension extends BackboneElement {

            @Child(name = "social-support-network",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "social-support-network", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> socialSupportNetwork;
            @Child(name = "patient-resilience",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "patient-resilience", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> patientResilience;
            @Child(name = "equitable-access",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "equitable-access", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> equitableAccess;
            @Child(name = "cultural-support",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "cultural-support", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> culturalSupport;
            @Child(name = "active-participation",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "active-participation", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> activeParticipation;
            @Child(name = "medication-use",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "medication-use", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> medicationUse;
            @Child(name = "health-literacy",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "health-literacy", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> healthLiteracy;


            public ComplexityScoreVS getSocialSupportNetworkScore() {
                return socialSupportNetwork.getValue();
            }

            public ComplexityScoreVS getPatientResilienceScore() {
                return patientResilience.getValue();
            }

            public ComplexityScoreVS getEquitableAccessScore() {
                return equitableAccess.getValue();
            }

            public ComplexityScoreVS getCulturalSupportScore() {
                return culturalSupport.getValue();
            }

            public ComplexityScoreVS getActiveParticipationScore() {
                return activeParticipation.getValue();
            }

            public ComplexityScoreVS getMedicationUseScore() {
                return medicationUse.getValue();
            }

            public ComplexityScoreVS getHealthLiteracyScore() {
                return healthLiteracy.getValue();
            }

            @Override
            public BackboneElement copy() {
                return null;
            }
        }

        @Block
        public static class CategoryContextualExtension extends BackboneElement {

            @Child(name = "travel",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "travel", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> travel;

            public ComplexityScoreVS getHousingAccommodationScore() {
                return housingAccommodation.getValue();
            }
            @Child(name = "housing-accommodation",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "housing-accommodation", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> housingAccommodation;

            public ComplexityScoreVS getTravelScore() {
                return travel.getValue();
            }
            @Child(name = "return-to-sport",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "return-to-sport", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> returnToSport;
            public ComplexityScoreVS getReturnToSportScore() {
                return returnToSport.getValue();
            }

            @Child(name = "finances",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "finances", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> finances;

            public ComplexityScoreVS getFinancesScore() {
                return finances.getValue();
            }

            @Child(name = "return-to-adls",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "return-to-adls", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> returnToAdls;

            public ComplexityScoreVS getReturnToAdlsScore() {
                return returnToAdls.getValue();
            }


            @Override
            public BackboneElement copy() {
                return null;
            }
        }

        @Block
        public static class CategoryDisciplinesExtension extends BackboneElement {

            @Child(name = "number-of-disciplines",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "number-of-disciplines", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> numberOfDisciplines;


            public ComplexityScoreVS getNumberOfDisciplinesScore() {
                return numberOfDisciplines.getValue();
            }

            @Override
            public BackboneElement copy() {
                return null;
            }
        }

        @Block
        public static class CategoryVocationalExtension extends BackboneElement {

            @Child(name = "employment",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "employment", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> employment;

            public ComplexityScoreVS getEmploymentScore() {
                return employment.getValue();
            }
            @Child(name = "return-to-work",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "return-to-work", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> returnToWork;

            public ComplexityScoreVS getReturnToWorkScore() {
                return returnToWork.getValue();
            }
            @Child(name = "workplace-support",
                    type = {CodeType.class},
                    min = 1
            )
            @Extension(url = "workplace-support", definedLocally = false)
            protected Enumeration<ComplexityScoreVS> workplaceSupport;
            public ComplexityScoreVS getWorkplaceSupportScore() {
                return workplaceSupport.getValue();
            }

            @Override
            public BackboneElement copy() {
                return null;
            }
        }
    }
}
