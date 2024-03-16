package co.nz.acc.icp.samples.java.resources;

import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r4.model.EnumFactory;

@SuppressWarnings("unused") // used by HAPI
public class IcpServiceBundleMskVSEnumFactory implements EnumFactory<IcpServiceBundleMskVS> {


    @Override
    public IcpServiceBundleMskVS fromCode(String codeString) throws IllegalArgumentException {
        if (StringUtils.isNotEmpty(codeString)) {
            return IcpServiceBundleMskVS.fromCode(codeString);
        }
        throw new IllegalStateException("Unexpected value: " + codeString);
    }

    @Override
    public String toCode(IcpServiceBundleMskVS icpServiceBundleVS) {
        return icpServiceBundleVS.toCode();
    }

    @Override
    public String toSystem(IcpServiceBundleMskVS icpServiceBundleVS) {
        return icpServiceBundleVS.getSystem();
    }
}
