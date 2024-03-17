// <auto-generated />
// Built from: hl7.org.nz.fhir.ig.icp version: dev
  // Option: "access-modifier" = "public"

using System;
using System.Buffers;
using System.Collections.Generic;
using System.IO;
using System.Text;
using System.Text.Json;
using System.Text.Json.Serialization;
using System.Xml;


namespace Fhir.R4.Serialization
{
  /// <summary>
  /// Default XmlSerializerOptions to format XML serialization as expected.
  /// </summary>
  public static class FhirXmlSerializerOptions
  {
#pragma warning disable CA1810 // Initialize reference type static fields inline

    /// <summary>
    /// Compact format internal variable.
    /// </summary>
    private static readonly XmlWriterSettings _compactFormat;

    /// <summary>
    /// Pretty print format internal variable.
    /// </summary>
    private static readonly XmlWriterSettings _prettyFormat;

    /// <summary>
    /// Parser settings internal variable.
    /// </summary>
    private static readonly XmlReaderSettings _readerSettings;

    /// <summary>
    /// Initializes static members of the &lt;see cref="FhirXmlSerializerOptions"/&gt; class.
    /// </summary>
    static FhirXmlSerializerOptions()
    {
      _prettyFormat = new XmlWriterSettings()
      {
        Indent = true,
        OmitXmlDeclaration = false,
        NewLineOnAttributes = true,
      };

      _compactFormat = new XmlWriterSettings()
      {
        Indent = true,
        OmitXmlDeclaration = false,
        NewLineOnAttributes = true,
      };

      _readerSettings = new XmlReaderSettings()
      {
        CheckCharacters = true,
        DtdProcessing = DtdProcessing.Ignore,
      };
    }

#pragma warning restore CA1810 // Initialize reference type static fields inline

    /// <summary>
    /// Compact (no extra whitespace) format.
    /// </summary>
    public static XmlWriterSettings Compact => _compactFormat;

    /// <summary>
    /// Pretty-printed (newlines and indentation) format.
    /// </summary>
    public static XmlWriterSettings Pretty => _prettyFormat;
    /// <summary>
    /// Default Parser settings.
    /// </summary>
    public static XmlReaderSettings ParseSettings => _readerSettings;
  }
}
