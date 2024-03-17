// <auto-generated />
// Built from: hl7.org.nz.fhir.ig.icp version: dev
  // Option: "access-modifier" = "public"


  using Hl7.Fhir.Model;

  namespace Fhir.R4.ValueSets
{
  /// <summary>
  /// The Status of the ICP case (Active or Finished)
  /// </summary>
  public static class Acc_icp_episodeofcare_statusCodes
  {
    /// <summary>
    /// Active
    /// </summary>
    public static readonly Coding Active = new Coding
    {
      Code = "active",
      Display = "Active",
      System = "http://hl7.org/fhir/episode-of-care-status"
    };
    /// <summary>
    /// Finished
    /// </summary>
    public static readonly Coding Finished = new Coding
    {
      Code = "finished",
      Display = "Finished",
      System = "http://hl7.org/fhir/episode-of-care-status"
    };

    /// <summary>
    /// Literal for code: Active
    /// </summary>
    public const string LiteralActive = "active";

    /// <summary>
    /// Literal for code: Episode_of_care_statusActive
    /// </summary>
    public const string LiteralEpisode_of_care_statusActive = "http://hl7.org/fhir/episode-of-care-status#active";

    /// <summary>
    /// Literal for code: Finished
    /// </summary>
    public const string LiteralFinished = "finished";

    /// <summary>
    /// Literal for code: Episode_of_care_statusFinished
    /// </summary>
    public const string LiteralEpisode_of_care_statusFinished = "http://hl7.org/fhir/episode-of-care-status#finished";

    /// <summary>
    /// Dictionary for looking up Acc_icp_episodeofcare_status Codings based on Codes
    /// </summary>
    public static Dictionary<string, Coding> Values = new Dictionary<string, Coding>() {
      { "active", Active }, 
      { "http://hl7.org/fhir/episode-of-care-status#active", Active }, 
      { "finished", Finished }, 
      { "http://hl7.org/fhir/episode-of-care-status#finished", Finished }, 
    };
  };
}
