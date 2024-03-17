// <auto-generated />
// Built from: hl7.org.nz.fhir.ig.icp version: dev
  // Option: "access-modifier" = "public"


  using Hl7.Fhir.Model;

  namespace Fhir.R4.ValueSets
{
  /// <summary>
  /// The Status of the ICP referral (Finished)
  /// </summary>
  public static class Acc_icp_encounter_statusCodes
  {
    /// <summary>
    /// Finished
    /// </summary>
    public static readonly Coding Finished = new Coding
    {
      Code = "finished",
      Display = "Finished",
      System = "http://hl7.org/fhir/encounter-status"
    };

    /// <summary>
    /// Literal for code: Finished
    /// </summary>
    public const string LiteralFinished = "finished";

    /// <summary>
    /// Literal for code: Encounter_statusFinished
    /// </summary>
    public const string LiteralEncounter_statusFinished = "http://hl7.org/fhir/encounter-status#finished";

    /// <summary>
    /// Dictionary for looking up Acc_icp_encounter_status Codings based on Codes
    /// </summary>
    public static Dictionary<string, Coding> Values = new Dictionary<string, Coding>() {
      { "finished", Finished }, 
      { "http://hl7.org/fhir/encounter-status#finished", Finished }, 
    };
  };
}