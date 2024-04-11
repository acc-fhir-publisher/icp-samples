using Firely.Fhir.Packages;
using Firely.Fhir.Validation;
using Hl7.Fhir.Model;
using Hl7.Fhir.Serialization;
using Hl7.Fhir.Specification.Source;
using Hl7.Fhir.Specification.Terminology;
using Hl7.Fhir.Support;

var packageResolver = new FhirPackageSource(ModelInfo.ModelInspector, [
    @"..\..\..\..\java\src\main\resources\package.r4.tgz"
]);
var resourceResolver = new CachedResolver(packageResolver);
var terminologyService = new LocalTerminologyService(resourceResolver);
var validator = new Validator(resourceResolver, terminologyService);

var jsonFilePath = @"..\..\..\..\java\src\main\resources\icp-case-create.json";
var json = File.ReadAllText(jsonFilePath);

var parser = new FhirJsonParser();
var resource = parser.Parse<EpisodeOfCare>(json);

var result = validator.Validate(resource, "http://hl7.org.nz/fhir/StructureDefinition/acc-icp-case-create");

foreach (var validationError in result.ListErrors())
{
    Console.WriteLine(validationError.Details.Text);
}