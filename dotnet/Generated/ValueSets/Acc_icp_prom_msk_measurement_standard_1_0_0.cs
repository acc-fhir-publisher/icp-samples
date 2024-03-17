// <auto-generated />
// Built from: hl7.org.nz.fhir.ig.icp version: dev
  // Option: "access-modifier" = "public"


  using Hl7.Fhir.Model;

  namespace Fhir.R4.ValueSets
{
  /// <summary>
  /// The measurement standards applicable to site-specific patient reported outcome measures (PROMs) for ICPMSK.
  /// </summary>
  public static class Acc_icp_prom_msk_measurement_standardCodes
  {
    /// <summary>
    /// KOOS
    /// </summary>
    public static readonly Coding KOOS = new Coding
    {
      Code = "koos",
      Display = "KOOS",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-prom-msk-measurement-standard"
    };
    /// <summary>
    /// Oswestry
    /// </summary>
    public static readonly Coding Oswestry = new Coding
    {
      Code = "oswestry",
      Display = "Oswestry",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-prom-msk-measurement-standard"
    };
    /// <summary>
    /// QuickDASH
    /// </summary>
    public static readonly Coding QuickDASH = new Coding
    {
      Code = "quickdash",
      Display = "QuickDASH",
      System = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-prom-msk-measurement-standard"
    };

    /// <summary>
    /// Literal for code: KOOS
    /// </summary>
    public const string LiteralKOOS = "koos";

    /// <summary>
    /// Literal for code: Acc_icp_prom_msk_measurement_standardKOOS
    /// </summary>
    public const string LiteralAcc_icp_prom_msk_measurement_standardKOOS = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-prom-msk-measurement-standard#koos";

    /// <summary>
    /// Literal for code: Oswestry
    /// </summary>
    public const string LiteralOswestry = "oswestry";

    /// <summary>
    /// Literal for code: Acc_icp_prom_msk_measurement_standardOswestry
    /// </summary>
    public const string LiteralAcc_icp_prom_msk_measurement_standardOswestry = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-prom-msk-measurement-standard#oswestry";

    /// <summary>
    /// Literal for code: QuickDASH
    /// </summary>
    public const string LiteralQuickDASH = "quickdash";

    /// <summary>
    /// Literal for code: Acc_icp_prom_msk_measurement_standardQuickDASH
    /// </summary>
    public const string LiteralAcc_icp_prom_msk_measurement_standardQuickDASH = "http://hl7.org.nz/fhir/CodeSystem/acc-icp-prom-msk-measurement-standard#quickdash";

    /// <summary>
    /// Dictionary for looking up Acc_icp_prom_msk_measurement_standard Codings based on Codes
    /// </summary>
    public static Dictionary<string, Coding> Values = new Dictionary<string, Coding>() {
      { "koos", KOOS }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-prom-msk-measurement-standard#koos", KOOS }, 
      { "oswestry", Oswestry }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-prom-msk-measurement-standard#oswestry", Oswestry }, 
      { "quickdash", QuickDASH }, 
      { "http://hl7.org.nz/fhir/CodeSystem/acc-icp-prom-msk-measurement-standard#quickdash", QuickDASH }, 
    };
  };
}