using Firely.Fhir.Packages;
using Hl7.Fhir.Model;
using Hl7.Fhir.Specification.Source;
using Hl7.Fhir.Specification.Terminology;

var packageResolver = new FhirPackageSource(ModelInfo.ModelInspector, new string[] {""});
var resourceResolver = new CachedResolver(packageResolver);
var terminologyService = new LocalTerminologyService(resourceResolver);


// var validator = new Validator(resourceResolver, terminologyService);