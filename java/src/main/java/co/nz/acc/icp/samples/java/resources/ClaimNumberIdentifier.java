package co.nz.acc.icp.samples.java.resources;

import co.nz.acc.icp.samples.java.utils.Constants;
import org.hl7.fhir.r4.model.Identifier;
import org.hl7.fhir.r4.model.Type;
import org.hl7.fhir.r4.model.UriType;

public class ClaimNumberIdentifier extends Identifier {

    @Override
    public Identifier setValue(String value) {
        UriType uriType = new UriType(getSystem());
        Identifier identifier = new Identifier();
        identifier.setSystemElement(uriType);
        identifier.setValue(value);
        identifier.setUse(getUse());

        addExtension().setValue(identifier);
        return identifier;
    }

    @Override
    public String getSystem() {
        return Constants.ICP_ACC_CLAIM_NUMBER;
    }

    @Override
    public IdentifierUse getUse() {
        return IdentifierUse.OFFICIAL;
    }

    @Override
    public Identifier setSystemElement(UriType value) {
        Type valueType = getExtensionFirstRep().getValue();
        if (valueType instanceof Identifier identifier) {
            super.setSystemElement(identifier.getSystemElement());
            return identifier;
        }
        return null;
    }

}
