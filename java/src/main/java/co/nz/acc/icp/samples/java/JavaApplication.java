package co.nz.acc.icp.samples.java;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.support.DefaultProfileValidationSupport;
import ca.uhn.fhir.parser.IParser;
import ca.uhn.fhir.rest.api.MethodOutcome;
import ca.uhn.fhir.rest.client.api.IGenericClient;
import ca.uhn.fhir.rest.client.api.ServerValidationModeEnum;
import ca.uhn.fhir.validation.FhirValidator;
import ca.uhn.fhir.validation.ValidationResult;
import org.hl7.fhir.common.hapi.validation.support.*;
import org.hl7.fhir.common.hapi.validation.validator.FhirInstanceValidator;
import org.hl7.fhir.r4.model.EpisodeOfCare;
import org.hl7.fhir.r4.model.OperationOutcome;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootApplication
public class JavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }

    @Bean
    public FhirContext r4FhirContext() {
        return FhirContext.forR4();
    }

    @Bean
    public NpmPackageValidationSupport npmPackageValidationSupport(FhirContext fhirContext) throws IOException {
        NpmPackageValidationSupport npmPackageValidationSupport = new NpmPackageValidationSupport(fhirContext);
        npmPackageValidationSupport.loadPackageFromClasspath("classpath:package.r4.tgz"); // this must reference the ICP IG package
        return npmPackageValidationSupport;
    }

    @Bean
    public FhirInstanceValidator fhirInstanceValidator(
        FhirContext fhirContext,
        NpmPackageValidationSupport npmPackageValidationSupport) {

        return new FhirInstanceValidator(
            new CachingValidationSupport(
                new ValidationSupportChain(
                    npmPackageValidationSupport,
                    new DefaultProfileValidationSupport(fhirContext),
                    new CommonCodeSystemsTerminologyService(fhirContext),
                    new InMemoryTerminologyServerValidationSupport(fhirContext)
                )));
    }

    @Bean
    public FhirValidator fhirValidator(
        FhirContext fhirContext,
        FhirInstanceValidator fhirInstanceValidator) {
        FhirValidator fhirValidator = fhirContext.newValidator();
        fhirValidator.registerValidatorModule(fhirInstanceValidator);
        return fhirValidator;
    }
}

@ShellComponent
class ICPCommands {

    private final FhirContext fhirContext;
    private final FhirValidator fhirValidator;

    ICPCommands(FhirContext fhirContext, FhirValidator fhirValidator) {
        this.fhirContext = fhirContext;
        this.fhirValidator = fhirValidator;
        fhirContext.getRestfulClientFactory().setServerValidationMode(ServerValidationModeEnum.NEVER);
    }

    /**
     * Create an ICP Referral Accept FHIR message.
     *
     * @param filePath the file path of the input file
     * @return 1 if the message is successfully created, -1 otherwise
     */
    @ShellMethod(value = "Create an ICP Referral Accept FHIR message.", key = "cra")
    public int createReferralAccept(String filePath) {

        final IParser fhirJsonParser = fhirContext.newJsonParser();

        try (InputStream inputStream = Files.newInputStream(Paths.get(filePath))) {
            EpisodeOfCare newIcpCase = fhirJsonParser.parseResource(EpisodeOfCare.class, inputStream);

            ValidationResult validationResult = fhirValidator.validateWithResult(newIcpCase);
            OperationOutcome operationOutcome = (OperationOutcome) validationResult.toOperationOutcome();

            if (validationResult.isSuccessful()) {

                IGenericClient client = fhirContext.newRestfulGenericClient("https://icp.endpoint");
                MethodOutcome createOutcome = client.create()
                    .resource(newIcpCase)
                    .encodedJson()
                    .execute();

                if (createOutcome.getResponseStatusCode() == 201) {
                    return 1;
                }

                operationOutcome = (OperationOutcome) createOutcome.getOperationOutcome();
            }

            for (OperationOutcome.OperationOutcomeIssueComponent referralAcceptIssue : operationOutcome.getIssue()) {
                System.out.println("Validation failed: " + referralAcceptIssue.getDiagnostics());
            }
            return -1;
        } catch (IOException e) {
            System.out.println("Unable to read the file: " + e.getMessage());
            return -1;
        }
    }

}
