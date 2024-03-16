package co.nz.acc.icp.samples.java.resources;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import co.nz.acc.icp.samples.java.utils.Constants;
import org.hl7.fhir.r4.model.Patient;

@SuppressWarnings({"java:S110"}) // keeping the default annotation params for now
@ResourceDef(name = "Patient", profile = Constants.ICP_PATIENT)
public class IcpPatient extends Patient {
}
