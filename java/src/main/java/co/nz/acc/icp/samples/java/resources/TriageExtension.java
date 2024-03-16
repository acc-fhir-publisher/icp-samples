package co.nz.acc.icp.samples.java.resources;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import lombok.Getter;
import co.nz.acc.icp.samples.java.utils.Constants;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.DateType;

import java.time.LocalDate;
import java.time.ZoneId;

@SuppressWarnings("DefaultAnnotationParam") // keeping the default annotation params for now
@Block
public class TriageExtension extends BackboneElement {

    @Child(name = "triageAssessmentDate",
        type = {DateType.class},
        min = 1,
        max = 1,
        modifier = false,
        summary = false)
    @Extension(url = Constants.ICP_TRIAGE_ASSESSMENT_DATE, isModifier = false, definedLocally = false)
    protected DateType triageAssessmentDate;
    @Child(name = "accClientAuthority",
        type = {BooleanType.class},
        min = 1,
        max = 1,
        modifier = false,
        summary = false)
    @Extension(url = Constants.ICP_ACC_CLIENT_AUTHORITY, isModifier = false, definedLocally = false)
    protected BooleanType accClientAuthority;

    @Getter
    @Child(name = "complexityScores", min = 1, max = 1)
    @Extension(url = Constants.ICP_COMPLEXITY_SCORES, definedLocally = false, isModifier = false)
    protected IcpCaseCreate.ComplexityScoresExtension complexityScores;

    @Child(name = "clientParticipationAgreement",
        type = {BooleanType.class},
        min = 0,
        max = 1,
        modifier = false,
        summary = false)
    @Extension(url = Constants.ICP_CLIENT_PARTICIPATION_AGREEMENT, isModifier = false, definedLocally = false)
    protected BooleanType clientParticipationAgreement;

    public LocalDate getTriageAssessmentDate() {
        return triageAssessmentDate.getValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public String getAccClientAuthority() {
        return accClientAuthority.booleanValue()
            ? "True"
            : "False";
    }

    @Override
    public BackboneElement copy() {
        return null;
    }
}
