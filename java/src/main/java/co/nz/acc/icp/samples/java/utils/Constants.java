package co.nz.acc.icp.samples.java.utils;

@SuppressWarnings("HttpUrlsUsage") // fhir namespace definitions, not used to make http requests
public class Constants {

    public static final String SCT = "http://snomed.info/sct";
    public static final String ICD_9_CM_DIAGNOSIS_CODES = "http://terminology.hl7.org/CodeSystem/ICD-9CM-diagnosiscodes";
    public static final String ICD_9 = "http://terminology.hl7.org/CodeSystem/icd9";
    public static final String ICD10CM = "http://hl7.org/fhir/sid/icd-10-cm";
    public static final String ICD10PCS = "http://www.cms.gov/Medicare/Coding/ICD10";
    public static final String ICD_10_AE = "http://terminology.hl7.org/CodeSystem/icd10ae";
    public static final String ICP_CASE = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-case";
    public static final String ICP_CASE_CREATE = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-case-create";
    public static final String ICP_CASE_MODIFY = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-case-modify";
    public static final String ICP_CASE_EXIT = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-case-exit";
    public static final String ICP_MEASUREMENT_CLINICAL = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-measurement-clinical";
    public static final String ICP_MEASUREMENT_PROM = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-measurement-prom";
    public static final String ICP_MEASUREMENT = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-measurement";
    public static final String ICP_REFERRAL_DECLINE = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-referral-decline";
    public static final String ICP_PATIENT = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-patient";
    public static final String ICP_TRIAGE_ASSESSMENT_DATE = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-triage-assessment-date";
    public static final String ICP_REFERRAL_DECLINED_DATE = "date-declined";
    public static final String ICP_EXCEPTIONAL_FUNDING = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-exceptional-funding";
    public static final String ICP_SERVICE_BUNDLE_CHANGE = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-service-bundle-change";
    public static final String ICP_SERVICE_BUNDLE_CHANGE_RATIONALE = "rationale";
    public static final String ICP_SUPPORTING_DETAILS = "supporting-details";
    public static final String ICP_EXIT_REASON = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-exit-reason";
    public static final String OUTCOME_SUMMARY = "outcome-summary";
    public static final String ICP_EXIT_REASON_VALUE = "reason";
    public static final String ICP_EXIT_REASON_CS = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-exit-reason";
    public static final String ICP_REFERRAL_DECLINED_REASON_CS = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-declined-reason";
    public static final String ICP_COMPLEXITY_SCORES = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-complexity-scores";
    public static final String ICP_ACC_CLIENT_AUTHORITY = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-client-authority";
    public static final String ICP_CLIENT_PARTICIPATION_AGREEMENT = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-client-participation-agreement";
    public static final String ICP_ADDITIONAL_ACC_SUPPORT = "additional-acc-support-needed";
    public static final String ICP_DIAGNOSIS = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-diagnosis";
    public static final String ICP_DIAGNOSES = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-diagnoses";
    public static final String ICP_COVERS_ALL_CLAIM_DIAGNOSES = "covers-all-claim-diagnoses";
    public static final String ICP_REFERRAL_SOURCE = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-referral-source";
    public static final String ACC_PROVIDER_ID = "http://hl7.org.nz/fhir/StructureDefinition/acc-providerid";
    public static final String ICP_RECORDED_OUTCOME_STAGE = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-recorded-outcome-stage";
    public static final String ICP_ACC_CLAIM_NUMBER = "https://standards.digital.health.nz/ns/acc-45-number";
    public static final String ICP_DIAGNOSIS_CODE = "diagnosis-code";
    public static final String ICP_SERVICE_TYPE_CS = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-service-type";
    public static final String ICP_SERVICE_BUNDLE_MSK = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-service-bundle-msk";
    public static final String ICP_SERVICE_BUNDLE_MSK_CS = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-service-bundle-msk";
    public static final String ICP_DIAGNOSIS_SIDE = "diagnosis-side";
    public static final String ICP_DIAGNOSIS_SIDE_CS = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-diagnosis-side";
    public static final String ICP_REFERRAL_SOURCE_TYPE = "referral-source-type";
    public static final String ICP_REFERRAL_RECEIVED_DATE = "received-date";
    public static final String ICP_REFERRAL_SOURCE_TYPE_CS = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-referral-source-type";
    public static final String ICP_FUNDING_RATIONALE = "rationale";
    public static final String ICP_FUNDING_RATIONALE_CS = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-funding-rationale";
    public static final String ICP_TRIAGE = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-triage";
    public static final String ICP_REFERRAL_DECLINED = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-referral-declined";
    public static final String ICP_COMPLEXITY_SCORE = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-complexity-score";
    public static final String ICP_COMPLEXITY_SCORE_CS = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-complexity-score";
    public static final String ICP_CATEGORY_CO_MORBIDITIES = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-category-co-morbidities";
    public static final String ICP_CATEGORY_PSYCHOSOCIAL = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-category-psychosocial";
    public static final String ICP_CATEGORY_CONTEXTUAL = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-category-contextual";
    public static final String ICP_CATEGORY_DISCIPLINES = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-category-disciplines";
    public static final String ICP_CATEGORY_VOCATIONAL = "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-category-vocational";
    public static final String READ = "http://hl7.org.nz/fhir/CodeSystem/acc-read-code";
    public static final String UNEXPECTED_VALUE = "Unexpected value: ";
    public static final String ICP_EXIT_OTHER_REASON = "other-reason";
    public static final String ICP_REFERRAL_DECLINED_NEXT_STEPS = "recommended-next-steps";
    public static final String ICP_REFERRAL_DECLINED_REASON_VALUE = "reason";
    public static final String ICP_REFERRAL_DECLINED_OTHER_REASON = "other-reason";
    public static final String NO_ICP_PATIENT_FOUND_IN_OBSERVATION = "No IcpPatient found in Observation";
    public static final String NO_ICP_PATIENT_FOUND_IN_ENCOUNTER = "No IcpPatient found in Encounter";
    public static final String NO_ICP_PATIENT_FOUND_IN_EPISODE_OF_CARE = "No IcpPatient found in EpisodeOfCare";

    private Constants() {
    }
}
