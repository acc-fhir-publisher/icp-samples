// <auto-generated />
// Built from: hl7.org.nz.fhir.ig.icp version: dev
  // Option: "access-modifier" = "public"


  using Hl7.Fhir.Model;

  namespace Fhir.R4.ValueSets
{
  /// <summary>
  /// The type of ICP service. Currently only musculoskeletal (msk) is allowed, with more to be added in the future, e.g. concussion.
  /// </summary>
  public static class Acc_icp_errorCodes
  {
    /// <summary>
    /// {EmailAddress} isn't a valid user. Contact ACC Digital Operations at digitaloperations@acc.co.nz to arrange permission.
    /// </summary>
    public static readonly Coding EmailAddress_isn_quote_t_a_valid_user_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission = new Coding
    {
      Code = "icp-auth-2000",
      Display = "{EmailAddress} isn't a valid user. Contact ACC Digital Operations at digitaloperations@acc.co.nz to arrange permission.",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// You are not authorised to access this service. Contact ACC Digital Operations at digitaloperations@acc.co.nz to arrange permission.
    /// </summary>
    public static readonly Coding You_are_not_authorised_to_access_this_service_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission = new Coding
    {
      Code = "icp-auth-2001",
      Display = "You are not authorised to access this service. Contact ACC Digital Operations at digitaloperations@acc.co.nz to arrange permission.",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// You are not authorised to access this vendor record. Contact ACC Digital Operations at digitaloperations@acc.co.nz to arrange permission.
    /// </summary>
    public static readonly Coding You_are_not_authorised_to_access_this_vendor_record_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission = new Coding
    {
      Code = "icp-auth-2002",
      Display = "You are not authorised to access this vendor record. Contact ACC Digital Operations at digitaloperations@acc.co.nz to arrange permission.",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// The Provider record is not currently active or in use. Please contact ACC Digital Operations via digitaloperations@acc.co.nz
    /// </summary>
    public static readonly Coding Invalid_Provider_ID = new Coding
    {
      Code = "icp-val-01",
      Display = "Invalid Provider ID",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// The Vendor record is not currently active or in use. Please contact ACC Digital Operations via digitaloperations@acc.co.nz
    /// </summary>
    public static readonly Coding Invalid_Vendor_ID = new Coding
    {
      Code = "icp-val-02",
      Display = "Invalid Vendor ID",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// The specified claim number was not found.
    /// </summary>
    public static readonly Coding Claim_number_not_found = new Coding
    {
      Code = "icp-val-03",
      Display = "Claim number not found",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// The Claim and specified Patient DOB do not match.
    /// </summary>
    public static readonly Coding Claim_number_found_but_DOB_doesn_quote_t_match = new Coding
    {
      Code = "icp-val-04",
      Display = "Claim number found but DOB doesn't match",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// This claim has not yet been accepted for cover and cannot be entered into ICP. Please contact ACC on 0800 101 996 for more information if required.
    /// </summary>
    public static readonly Coding Cover_Status_is_Held = new Coding
    {
      Code = "icp-val-05",
      Display = "Cover Status is Held",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// This claim has been declined for cover and cannot be entered into ICP.
    /// </summary>
    public static readonly Coding Cover_Status_is_Decline = new Coding
    {
      Code = "icp-val-06",
      Display = "Cover Status is Decline",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// This claim is managed by a Third Party Administrator (TPA) and cannot be entered into ICP. Please ask the Client to contact their TPA Provider and discuss having their claim returned to ACC if they would like to enter ICP.
    /// </summary>
    public static readonly Coding TPA_Exclusion = new Coding
    {
      Code = "icp-val-07",
      Display = "TPA Exclusion",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// This claim is not eligible for ICP. Please check that the correct claim number has been used.
    /// </summary>
    public static readonly Coding This_claim_is_not_eligible_for_ICP = new Coding
    {
      Code = "icp-val-08",
      Display = "This claim is not eligible for ICP",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// This claim is unlikely to be eligible for ICP. Please check the claim number used. Contact ACC on 0800 101 996 ext. 77097 for more information or have a staff member assess eligibility.
    /// </summary>
    public static readonly Coding This_claim_is_unlikely_to_be_eligible_for_ICP = new Coding
    {
      Code = "icp-val-09",
      Display = "This claim is unlikely to be eligible for ICP",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// This claim requires assessment from an ACC staff member before it can be entered into ICP. Please contact ACC on 0800 101 996 ext. 77097 to discuss.
    /// </summary>
    public static readonly Coding This_claim_requires_assessment_from_an_ACC_staff_member_before_it_can_be_entered_into_ICP = new Coding
    {
      Code = "icp-val-10",
      Display = "This claim requires assessment from an ACC staff member before it can be entered into ICP",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// The claim number can only contain letters and numbers, no more than 7 characters in all.
    /// </summary>
    public static readonly Coding The_claim_number_can_only_contain_letters_and_numbers_no_more_than_7_characters_in_all = new Coding
    {
      Code = "icp-val-1000",
      Display = "The claim number can only contain letters and numbers, no more than 7 characters in all.",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// The claim number is required.
    /// </summary>
    public static readonly Coding The_claim_number_is_required = new Coding
    {
      Code = "icp-val-1001",
      Display = "The claim number is required.",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// The vendor ID is invalid;  it can only contain letters, numbers, and '/', no more than 12 characters in all.
    /// </summary>
    public static readonly Coding The_vendor_ID_is_invalid_it_can_only_contain_letters_numbers_and_quote_quote_no_more_than_12_characters_in_all = new Coding
    {
      Code = "icp-val-1002",
      Display = "The vendor ID is invalid;  it can only contain letters, numbers, and '/', no more than 12 characters in all.",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// The provider ID can only contain letters and numbers, no more than 12 characters in all.
    /// </summary>
    public static readonly Coding The_provider_ID_can_only_contain_letters_and_numbers_no_more_than_12_characters_in_all = new Coding
    {
      Code = "icp-val-1003",
      Display = "The provider ID can only contain letters and numbers, no more than 12 characters in all.",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// The ICP Case against this claim is currently being processed. Please try again in 5 minutes or contact ACC on 0800 101 996 ext. 77097 to discuss.
    /// </summary>
    public static readonly Coding The_ICP_Case_against_this_claim_is_currently_being_processed_Please_try_again_in_5_minutes_or_contact_ACC_on_0800_101_996_ext_77097_to_discuss = new Coding
    {
      Code = "icp-val-1004",
      Display = "The ICP Case against this claim is currently being processed. Please try again in 5 minutes or contact ACC on 0800 101 996 ext. 77097 to discuss.",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// The date cannot be before 1900-01-01.
    /// </summary>
    public static readonly Coding The_date_cannot_be_before_1900_01_01 = new Coding
    {
      Code = "icp-val-1005",
      Display = "The date cannot be before 1900-01-01.",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// This claim already has an ICP Case against it. Please contact ACC on 0800 101 996 ext. 77097 to discuss.
    /// </summary>
    public static readonly Coding This_claim_already_has_an_ICP_Case_against_it = new Coding
    {
      Code = "icp-val-11",
      Display = "This claim already has an ICP Case against it.",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// Unable to find an ICP Case against this Claim. Please contact ACC via registrations@acc.co.nz
    /// </summary>
    public static readonly Coding There_quote_s_no_ICP_Subcase_against_the_specified_Claim_in_Eos = new Coding
    {
      Code = "icp-val-12",
      Display = "There's no ICP Subcase against the specified Claim in Eos",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// The ICP Case against this Claim is no longer Active. Please contact ACC via registrations@acc.co.nz
    /// </summary>
    public static readonly Coding There_quote_s_an_ICP_Subcase_against_the_specified_Claim_in_Eos_but_the_Status_isn_quote_t_Accepted = new Coding
    {
      Code = "icp-val-13",
      Display = "There's an ICP Subcase against the specified Claim in Eos but the Status isn't Accepted",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// The ICP Case against this claim belongs to a different supplier. Please contact ACC via registrations@acc.co.nz
    /// </summary>
    public static readonly Coding There_quote_s_an_Active_ICP_Subcase_against_the_specified_Claim_in_Eos_but_it_came_from_a_different_Vendor_ID = new Coding
    {
      Code = "icp-val-14",
      Display = "There's an Active ICP Subcase against the specified Claim in Eos but it came from a different Vendor ID.",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// There is an ACC system issue. You'll need to resubmit your content later. Advise ACC Digital Operations at digitaloperations@acc.co.nz.
    /// </summary>
    public static readonly Coding There_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_Advise_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz = new Coding
    {
      Code = "icp-val-9000",
      Display = "There is an ACC system issue. You'll need to resubmit your content later. Advise ACC Digital Operations at digitaloperations@acc.co.nz.",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };
    /// <summary>
    /// There is an ACC system issue. You'll need to resubmit your content later. If the issue persists please advise the ACC Digital Operations team at digitaloperations@acc.co.nz.
    /// </summary>
    public static readonly Coding There_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_If_the_issue_persists_please_advise_the_ACC_Digital_Operations_team_at_digitaloperations_at_acc_co_nz = new Coding
    {
      Code = "icp-val-9001",
      Display = "There is an ACC system issue. You'll need to resubmit your content later. If the issue persists please advise the ACC Digital Operations team at digitaloperations@acc.co.nz.",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error"
    };

    /// <summary>
    /// Literal for code: EmailAddress_isn_quote_t_a_valid_user_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission
    /// </summary>
    public const string LiteralEmailAddress_isn_quote_t_a_valid_user_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission = "icp-auth-2000";

    /// <summary>
    /// Literal for code: Acc_icp_errorEmailAddress_isn_quote_t_a_valid_user_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission
    /// </summary>
    public const string LiteralAcc_icp_errorEmailAddress_isn_quote_t_a_valid_user_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-auth-2000";

    /// <summary>
    /// Literal for code: You_are_not_authorised_to_access_this_service_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission
    /// </summary>
    public const string LiteralYou_are_not_authorised_to_access_this_service_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission = "icp-auth-2001";

    /// <summary>
    /// Literal for code: Acc_icp_errorYou_are_not_authorised_to_access_this_service_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission
    /// </summary>
    public const string LiteralAcc_icp_errorYou_are_not_authorised_to_access_this_service_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-auth-2001";

    /// <summary>
    /// Literal for code: You_are_not_authorised_to_access_this_vendor_record_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission
    /// </summary>
    public const string LiteralYou_are_not_authorised_to_access_this_vendor_record_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission = "icp-auth-2002";

    /// <summary>
    /// Literal for code: Acc_icp_errorYou_are_not_authorised_to_access_this_vendor_record_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission
    /// </summary>
    public const string LiteralAcc_icp_errorYou_are_not_authorised_to_access_this_vendor_record_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-auth-2002";

    /// <summary>
    /// Literal for code: Invalid_Provider_ID
    /// </summary>
    public const string LiteralInvalid_Provider_ID = "icp-val-01";

    /// <summary>
    /// Literal for code: Acc_icp_errorInvalid_Provider_ID
    /// </summary>
    public const string LiteralAcc_icp_errorInvalid_Provider_ID = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-01";

    /// <summary>
    /// Literal for code: Invalid_Vendor_ID
    /// </summary>
    public const string LiteralInvalid_Vendor_ID = "icp-val-02";

    /// <summary>
    /// Literal for code: Acc_icp_errorInvalid_Vendor_ID
    /// </summary>
    public const string LiteralAcc_icp_errorInvalid_Vendor_ID = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-02";

    /// <summary>
    /// Literal for code: Claim_number_not_found
    /// </summary>
    public const string LiteralClaim_number_not_found = "icp-val-03";

    /// <summary>
    /// Literal for code: Acc_icp_errorClaim_number_not_found
    /// </summary>
    public const string LiteralAcc_icp_errorClaim_number_not_found = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-03";

    /// <summary>
    /// Literal for code: Claim_number_found_but_DOB_doesn_quote_t_match
    /// </summary>
    public const string LiteralClaim_number_found_but_DOB_doesn_quote_t_match = "icp-val-04";

    /// <summary>
    /// Literal for code: Acc_icp_errorClaim_number_found_but_DOB_doesn_quote_t_match
    /// </summary>
    public const string LiteralAcc_icp_errorClaim_number_found_but_DOB_doesn_quote_t_match = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-04";

    /// <summary>
    /// Literal for code: Cover_Status_is_Held
    /// </summary>
    public const string LiteralCover_Status_is_Held = "icp-val-05";

    /// <summary>
    /// Literal for code: Acc_icp_errorCover_Status_is_Held
    /// </summary>
    public const string LiteralAcc_icp_errorCover_Status_is_Held = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-05";

    /// <summary>
    /// Literal for code: Cover_Status_is_Decline
    /// </summary>
    public const string LiteralCover_Status_is_Decline = "icp-val-06";

    /// <summary>
    /// Literal for code: Acc_icp_errorCover_Status_is_Decline
    /// </summary>
    public const string LiteralAcc_icp_errorCover_Status_is_Decline = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-06";

    /// <summary>
    /// Literal for code: TPA_Exclusion
    /// </summary>
    public const string LiteralTPA_Exclusion = "icp-val-07";

    /// <summary>
    /// Literal for code: Acc_icp_errorTPA_Exclusion
    /// </summary>
    public const string LiteralAcc_icp_errorTPA_Exclusion = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-07";

    /// <summary>
    /// Literal for code: This_claim_is_not_eligible_for_ICP
    /// </summary>
    public const string LiteralThis_claim_is_not_eligible_for_ICP = "icp-val-08";

    /// <summary>
    /// Literal for code: Acc_icp_errorThis_claim_is_not_eligible_for_ICP
    /// </summary>
    public const string LiteralAcc_icp_errorThis_claim_is_not_eligible_for_ICP = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-08";

    /// <summary>
    /// Literal for code: This_claim_is_unlikely_to_be_eligible_for_ICP
    /// </summary>
    public const string LiteralThis_claim_is_unlikely_to_be_eligible_for_ICP = "icp-val-09";

    /// <summary>
    /// Literal for code: Acc_icp_errorThis_claim_is_unlikely_to_be_eligible_for_ICP
    /// </summary>
    public const string LiteralAcc_icp_errorThis_claim_is_unlikely_to_be_eligible_for_ICP = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-09";

    /// <summary>
    /// Literal for code: This_claim_requires_assessment_from_an_ACC_staff_member_before_it_can_be_entered_into_ICP
    /// </summary>
    public const string LiteralThis_claim_requires_assessment_from_an_ACC_staff_member_before_it_can_be_entered_into_ICP = "icp-val-10";

    /// <summary>
    /// Literal for code: Acc_icp_errorThis_claim_requires_assessment_from_an_ACC_staff_member_before_it_can_be_entered_into_ICP
    /// </summary>
    public const string LiteralAcc_icp_errorThis_claim_requires_assessment_from_an_ACC_staff_member_before_it_can_be_entered_into_ICP = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-10";

    /// <summary>
    /// Literal for code: The_claim_number_can_only_contain_letters_and_numbers_no_more_than_7_characters_in_all
    /// </summary>
    public const string LiteralThe_claim_number_can_only_contain_letters_and_numbers_no_more_than_7_characters_in_all = "icp-val-1000";

    /// <summary>
    /// Literal for code: Acc_icp_errorThe_claim_number_can_only_contain_letters_and_numbers_no_more_than_7_characters_in_all
    /// </summary>
    public const string LiteralAcc_icp_errorThe_claim_number_can_only_contain_letters_and_numbers_no_more_than_7_characters_in_all = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-1000";

    /// <summary>
    /// Literal for code: The_claim_number_is_required
    /// </summary>
    public const string LiteralThe_claim_number_is_required = "icp-val-1001";

    /// <summary>
    /// Literal for code: Acc_icp_errorThe_claim_number_is_required
    /// </summary>
    public const string LiteralAcc_icp_errorThe_claim_number_is_required = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-1001";

    /// <summary>
    /// Literal for code: The_vendor_ID_is_invalid_it_can_only_contain_letters_numbers_and_quote_quote_no_more_than_12_characters_in_all
    /// </summary>
    public const string LiteralThe_vendor_ID_is_invalid_it_can_only_contain_letters_numbers_and_quote_quote_no_more_than_12_characters_in_all = "icp-val-1002";

    /// <summary>
    /// Literal for code: Acc_icp_errorThe_vendor_ID_is_invalid_it_can_only_contain_letters_numbers_and_quote_quote_no_more_than_12_characters_in_all
    /// </summary>
    public const string LiteralAcc_icp_errorThe_vendor_ID_is_invalid_it_can_only_contain_letters_numbers_and_quote_quote_no_more_than_12_characters_in_all = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-1002";

    /// <summary>
    /// Literal for code: The_provider_ID_can_only_contain_letters_and_numbers_no_more_than_12_characters_in_all
    /// </summary>
    public const string LiteralThe_provider_ID_can_only_contain_letters_and_numbers_no_more_than_12_characters_in_all = "icp-val-1003";

    /// <summary>
    /// Literal for code: Acc_icp_errorThe_provider_ID_can_only_contain_letters_and_numbers_no_more_than_12_characters_in_all
    /// </summary>
    public const string LiteralAcc_icp_errorThe_provider_ID_can_only_contain_letters_and_numbers_no_more_than_12_characters_in_all = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-1003";

    /// <summary>
    /// Literal for code: The_ICP_Case_against_this_claim_is_currently_being_processed_Please_try_again_in_5_minutes_or_contact_ACC_on_0800_101_996_ext_77097_to_discuss
    /// </summary>
    public const string LiteralThe_ICP_Case_against_this_claim_is_currently_being_processed_Please_try_again_in_5_minutes_or_contact_ACC_on_0800_101_996_ext_77097_to_discuss = "icp-val-1004";

    /// <summary>
    /// Literal for code: Acc_icp_errorThe_ICP_Case_against_this_claim_is_currently_being_processed_Please_try_again_in_5_minutes_or_contact_ACC_on_0800_101_996_ext_77097_to_discuss
    /// </summary>
    public const string LiteralAcc_icp_errorThe_ICP_Case_against_this_claim_is_currently_being_processed_Please_try_again_in_5_minutes_or_contact_ACC_on_0800_101_996_ext_77097_to_discuss = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-1004";

    /// <summary>
    /// Literal for code: The_date_cannot_be_before_1900_01_01
    /// </summary>
    public const string LiteralThe_date_cannot_be_before_1900_01_01 = "icp-val-1005";

    /// <summary>
    /// Literal for code: Acc_icp_errorThe_date_cannot_be_before_1900_01_01
    /// </summary>
    public const string LiteralAcc_icp_errorThe_date_cannot_be_before_1900_01_01 = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-1005";

    /// <summary>
    /// Literal for code: This_claim_already_has_an_ICP_Case_against_it
    /// </summary>
    public const string LiteralThis_claim_already_has_an_ICP_Case_against_it = "icp-val-11";

    /// <summary>
    /// Literal for code: Acc_icp_errorThis_claim_already_has_an_ICP_Case_against_it
    /// </summary>
    public const string LiteralAcc_icp_errorThis_claim_already_has_an_ICP_Case_against_it = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-11";

    /// <summary>
    /// Literal for code: There_quote_s_no_ICP_Subcase_against_the_specified_Claim_in_Eos
    /// </summary>
    public const string LiteralThere_quote_s_no_ICP_Subcase_against_the_specified_Claim_in_Eos = "icp-val-12";

    /// <summary>
    /// Literal for code: Acc_icp_errorThere_quote_s_no_ICP_Subcase_against_the_specified_Claim_in_Eos
    /// </summary>
    public const string LiteralAcc_icp_errorThere_quote_s_no_ICP_Subcase_against_the_specified_Claim_in_Eos = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-12";

    /// <summary>
    /// Literal for code: There_quote_s_an_ICP_Subcase_against_the_specified_Claim_in_Eos_but_the_Status_isn_quote_t_Accepted
    /// </summary>
    public const string LiteralThere_quote_s_an_ICP_Subcase_against_the_specified_Claim_in_Eos_but_the_Status_isn_quote_t_Accepted = "icp-val-13";

    /// <summary>
    /// Literal for code: Acc_icp_errorThere_quote_s_an_ICP_Subcase_against_the_specified_Claim_in_Eos_but_the_Status_isn_quote_t_Accepted
    /// </summary>
    public const string LiteralAcc_icp_errorThere_quote_s_an_ICP_Subcase_against_the_specified_Claim_in_Eos_but_the_Status_isn_quote_t_Accepted = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-13";

    /// <summary>
    /// Literal for code: There_quote_s_an_Active_ICP_Subcase_against_the_specified_Claim_in_Eos_but_it_came_from_a_different_Vendor_ID
    /// </summary>
    public const string LiteralThere_quote_s_an_Active_ICP_Subcase_against_the_specified_Claim_in_Eos_but_it_came_from_a_different_Vendor_ID = "icp-val-14";

    /// <summary>
    /// Literal for code: Acc_icp_errorThere_quote_s_an_Active_ICP_Subcase_against_the_specified_Claim_in_Eos_but_it_came_from_a_different_Vendor_ID
    /// </summary>
    public const string LiteralAcc_icp_errorThere_quote_s_an_Active_ICP_Subcase_against_the_specified_Claim_in_Eos_but_it_came_from_a_different_Vendor_ID = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-14";

    /// <summary>
    /// Literal for code: There_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_Advise_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz
    /// </summary>
    public const string LiteralThere_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_Advise_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz = "icp-val-9000";

    /// <summary>
    /// Literal for code: Acc_icp_errorThere_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_Advise_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz
    /// </summary>
    public const string LiteralAcc_icp_errorThere_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_Advise_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-9000";

    /// <summary>
    /// Literal for code: There_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_If_the_issue_persists_please_advise_the_ACC_Digital_Operations_team_at_digitaloperations_at_acc_co_nz
    /// </summary>
    public const string LiteralThere_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_If_the_issue_persists_please_advise_the_ACC_Digital_Operations_team_at_digitaloperations_at_acc_co_nz = "icp-val-9001";

    /// <summary>
    /// Literal for code: Acc_icp_errorThere_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_If_the_issue_persists_please_advise_the_ACC_Digital_Operations_team_at_digitaloperations_at_acc_co_nz
    /// </summary>
    public const string LiteralAcc_icp_errorThere_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_If_the_issue_persists_please_advise_the_ACC_Digital_Operations_team_at_digitaloperations_at_acc_co_nz = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-9001";

    /// <summary>
    /// Dictionary for looking up Acc_icp_error Codings based on Codes
    /// </summary>
    public static Dictionary<string, Coding> Values = new Dictionary<string, Coding>() {
      { "icp-auth-2000", EmailAddress_isn_quote_t_a_valid_user_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-auth-2000", EmailAddress_isn_quote_t_a_valid_user_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission }, 
      { "icp-auth-2001", You_are_not_authorised_to_access_this_service_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-auth-2001", You_are_not_authorised_to_access_this_service_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission }, 
      { "icp-auth-2002", You_are_not_authorised_to_access_this_vendor_record_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-auth-2002", You_are_not_authorised_to_access_this_vendor_record_Contact_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz_to_arrange_permission }, 
      { "icp-val-01", Invalid_Provider_ID }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-01", Invalid_Provider_ID }, 
      { "icp-val-02", Invalid_Vendor_ID }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-02", Invalid_Vendor_ID }, 
      { "icp-val-03", Claim_number_not_found }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-03", Claim_number_not_found }, 
      { "icp-val-04", Claim_number_found_but_DOB_doesn_quote_t_match }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-04", Claim_number_found_but_DOB_doesn_quote_t_match }, 
      { "icp-val-05", Cover_Status_is_Held }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-05", Cover_Status_is_Held }, 
      { "icp-val-06", Cover_Status_is_Decline }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-06", Cover_Status_is_Decline }, 
      { "icp-val-07", TPA_Exclusion }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-07", TPA_Exclusion }, 
      { "icp-val-08", This_claim_is_not_eligible_for_ICP }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-08", This_claim_is_not_eligible_for_ICP }, 
      { "icp-val-09", This_claim_is_unlikely_to_be_eligible_for_ICP }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-09", This_claim_is_unlikely_to_be_eligible_for_ICP }, 
      { "icp-val-10", This_claim_requires_assessment_from_an_ACC_staff_member_before_it_can_be_entered_into_ICP }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-10", This_claim_requires_assessment_from_an_ACC_staff_member_before_it_can_be_entered_into_ICP }, 
      { "icp-val-1000", The_claim_number_can_only_contain_letters_and_numbers_no_more_than_7_characters_in_all }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-1000", The_claim_number_can_only_contain_letters_and_numbers_no_more_than_7_characters_in_all }, 
      { "icp-val-1001", The_claim_number_is_required }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-1001", The_claim_number_is_required }, 
      { "icp-val-1002", The_vendor_ID_is_invalid_it_can_only_contain_letters_numbers_and_quote_quote_no_more_than_12_characters_in_all }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-1002", The_vendor_ID_is_invalid_it_can_only_contain_letters_numbers_and_quote_quote_no_more_than_12_characters_in_all }, 
      { "icp-val-1003", The_provider_ID_can_only_contain_letters_and_numbers_no_more_than_12_characters_in_all }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-1003", The_provider_ID_can_only_contain_letters_and_numbers_no_more_than_12_characters_in_all }, 
      { "icp-val-1004", The_ICP_Case_against_this_claim_is_currently_being_processed_Please_try_again_in_5_minutes_or_contact_ACC_on_0800_101_996_ext_77097_to_discuss }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-1004", The_ICP_Case_against_this_claim_is_currently_being_processed_Please_try_again_in_5_minutes_or_contact_ACC_on_0800_101_996_ext_77097_to_discuss }, 
      { "icp-val-1005", The_date_cannot_be_before_1900_01_01 }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-1005", The_date_cannot_be_before_1900_01_01 }, 
      { "icp-val-11", This_claim_already_has_an_ICP_Case_against_it }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-11", This_claim_already_has_an_ICP_Case_against_it }, 
      { "icp-val-12", There_quote_s_no_ICP_Subcase_against_the_specified_Claim_in_Eos }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-12", There_quote_s_no_ICP_Subcase_against_the_specified_Claim_in_Eos }, 
      { "icp-val-13", There_quote_s_an_ICP_Subcase_against_the_specified_Claim_in_Eos_but_the_Status_isn_quote_t_Accepted }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-13", There_quote_s_an_ICP_Subcase_against_the_specified_Claim_in_Eos_but_the_Status_isn_quote_t_Accepted }, 
      { "icp-val-14", There_quote_s_an_Active_ICP_Subcase_against_the_specified_Claim_in_Eos_but_it_came_from_a_different_Vendor_ID }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-14", There_quote_s_an_Active_ICP_Subcase_against_the_specified_Claim_in_Eos_but_it_came_from_a_different_Vendor_ID }, 
      { "icp-val-9000", There_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_Advise_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-9000", There_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_Advise_ACC_Digital_Operations_at_digitaloperations_at_acc_co_nz }, 
      { "icp-val-9001", There_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_If_the_issue_persists_please_advise_the_ACC_Digital_Operations_team_at_digitaloperations_at_acc_co_nz }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-error#icp-val-9001", There_is_an_ACC_system_issue_You_quote_ll_need_to_resubmit_your_content_later_If_the_issue_persists_please_advise_the_ACC_Digital_Operations_team_at_digitaloperations_at_acc_co_nz }, 
    };
  };
}
