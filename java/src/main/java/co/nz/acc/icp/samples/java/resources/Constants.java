package co.nz.acc.icp.samples.java.resources.utils;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.time.format.DateTimeFormatter;
import java.util.AbstractMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;

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
    public static final String FIELD_PROVIDER_ID = "providerId";
    public static final String FIELD_VENDOR_ID = "vendorId";
    public static final String FIELD_CLAIM_NUMBER = "claimNumber";
    public static final String EOS_CONTACT_CENTRE = "eosContactCentre";
    public static final String READ = "http://hl7.org.nz/fhir/CodeSystem/acc-read-code";
    public static final String CLAIM_VALIDATION_ENDPOINT = "claimValidation";

    public static final String CLAIM_ALREADY_HAS_AN_ICP_SUBCASE = "That claim already has an ICP subcase.";
    public static final String ALREADY_HAS_AN_ICP_SUBCASE = "This claim already has an ICP Case against it. Please contact ACC on 0800 101 996 ext. 17 to discuss.";
    public static final String UNEXPECTED_VALUE = "Unexpected value: ";
    public static final String CACHE_FORMS = "forms";
    public static final String ICP_EOS_SUBMIT = "ICP_EOS_SUBMIT";
    public static final String ICP_EOS_RESPONSE = "ICP_EOS_RESPONSE";
    public static final String LABEL_MSG = "msg";
    public static final String LABEL_PHASE = "phase";
    public static final String ICP_RESPONSE_EXCEPTION = "ICP_RESPONSE_EXCEPTION";
    public static final String ICP_REQUEST_VALIDATE = "ICP_REQUEST_VALIDATE";
    public static final String ICP_RESPONSE_VALIDATE = "ICP_RESPONSE_VALIDATE";
    public static final String ICP_VALIDATION_ERROR = "ICP_VALIDATION_ERROR";
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final String ACC_ICP_ERROR = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error";
    public static final String ICP_VAL_11 = "icp-val-11";
    public static final String THERE_IS_AN_ACC_SYSTEM_ISSUE = "There is an ACC system issue. You'll need to resubmit your content later. If the issue persists please advise the ACC Digital Operations team at digitaloperations@acc.co.nz.";
    public static final String INVALID_PROFILE = "Invalid profile";
    public static final String FIELD_DATE_OF_BIRTH = "dateOfBirth";

    public static final String ICP_AUTH_FORBIDDEN_ISSUE = "isn't a valid user. Contact ACC Digital Operations at digitaloperations@acc.co.nz to arrange permission.";
    public static final String CASE_IS_CURRENTLY_BEING_PROCESSED = "This ICP Case is currently being processed. Please try again in a few minutes; or, if the issue persists, contact ACC Digital Operations via digitaloperations@acc.co.nz.";
    public static final String INTERNAL = "internal";
    public static final String ICP_EXIT_OTHER_REASON = "other-reason";
    public static final String ICP_REFERRAL_DECLINED_NEXT_STEPS = "recommended-next-steps";
    public static final String ICP_REFERRAL_DECLINED_REASON_VALUE = "reason";
    public static final String ICP_REFERRAL_DECLINED_OTHER_REASON = "other-reason";
    public static final String HTTP_HEADER_EOS_ENVIRONMENT = "EosEnvironment";
    public static final String VALUE_ATTRIBUTE = "value";
    static final String ICP_REQUEST = "ICP_REQUEST";
    static final String ICP_RESPONSE = "ICP_RESPONSE";
    public static final String ICP_PROM_BODY_SITE_ENUM_VALUE = "ICPPromBodySite";
    public static final String ICP_MEASUREMENT_STANDARD_ENUM_VALUE = "ICPMeasurementStandard";
    public static final String ICP_MEASUREMENT_CATEGORY_ENUM_VALUE = "ICPMeasurementCategory";
    public static final String BODY_SITE_ATTRIBUTE = "bodySite";
    public static final String MEASUREMENT_STANDARD_ATTRIBUTE = "measurementStandard";
    public static final String CATEGORY_ATTRIBUTE = "category";
    public static final String DATE_OF_MEASUREMENT_ATTRIBUTE = "dateOfMeasurement";
    public static final String DATA_ABSENT_REASON_ATTRIBUTE = "dataAbsentReason";
    public static final String SUBCASE_NO_ATTRIBUTE = "subcaseNo";
    public static final String KNEE_VALUE = "Knee";
    public static final String SHOULDER_VALUE = "Shoulder";
    public static final String LOWER_BACK_VALUE = "Lower back";
    public static final String ICP_CLINICAL_FUNCTIONAL_MEASURES_DOCUMENT_TYPE = "ICP Clinical Functional Measures";
    public static final String NO_ICP_PATIENT_FOUND_IN_OBSERVATION = "No IcpPatient found in Observation";
    public static final String NO_ICP_PATIENT_FOUND_IN_ENCOUNTER = "No IcpPatient found in Encounter";
    public static final String NO_ICP_PATIENT_FOUND_IN_EPISODE_OF_CARE = "No IcpPatient found in EpisodeOfCare";
    public static final String CONTAINED_META_PROFILE = "contained.meta.profile";


    private Constants() {
    }
}
