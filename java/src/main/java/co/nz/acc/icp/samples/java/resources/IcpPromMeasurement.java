package co.nz.acc.icp.samples.java.resources;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import co.nz.acc.icp.samples.java.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.EnumFactory;

import static co.nz.acc.icp.samples.java.utils.Constants.ICP_MEASUREMENT_PROM;
import static co.nz.acc.icp.samples.java.utils.Constants.UNEXPECTED_VALUE;

@SuppressWarnings("java:S110") // keeping the default annotation params for now
@ResourceDef(name = "Observation", profile = ICP_MEASUREMENT_PROM)
public class IcpPromMeasurement extends IcpMeasurementBase {

    public IcpCodeTypeVS getIcpCode() {
        return IcpCodeTypeVS.fromCode(this.getCode().getCodingFirstRep().getCode());
    }

    public String getIntegerValue() {
        return super.getValueIntegerType().getValue().toString();
    }

    public enum IcpCodeTypeVS {
        QUICKDASH,
        OSWESTRY,
        KOOS;

        public static final String OSWESTRY1 = "oswestry";
        public static final String QUICKDASH1 = "quickdash";
        public static final String KOOS1 = "koos";

        IcpCodeTypeVS() {
        }

        public static IcpCodeTypeVS fromCode(String codeString) throws FHIRException {
            if (StringUtils.isNotEmpty(codeString)) {
                return switch (codeString) {
                    case KOOS1 -> KOOS;
                    case OSWESTRY1 -> OSWESTRY;
                    case QUICKDASH1 -> QUICKDASH;
                    default -> throw new IllegalStateException(UNEXPECTED_VALUE + codeString);
                };
            }
            throw new IllegalStateException(UNEXPECTED_VALUE + codeString);
        }

        public String toCode() {
            return switch (this) {
                case KOOS -> KOOS1;
                case OSWESTRY -> OSWESTRY1;
                case QUICKDASH -> QUICKDASH1;
            };
        }

        public String getSystem() {
            return Constants.ICP_REFERRAL_SOURCE_TYPE_CS;
        }

        public String getDefinition() {
            return switch (this) {
                case KOOS -> KOOS1;
                case OSWESTRY -> OSWESTRY1;
                case QUICKDASH -> QUICKDASH1;

            };
        }

        public String getDisplay() {
            return switch (this) {
                case KOOS -> KOOS1;
                case OSWESTRY -> OSWESTRY1;
                case QUICKDASH -> QUICKDASH1;
            };
        }
    }

    @SuppressWarnings("unused") // used by HAPI
    public static class IcpCodeTypeVSEnumFactory implements EnumFactory<IcpPromMeasurement.IcpCodeTypeVS> {

        @Override
        public IcpPromMeasurement.IcpCodeTypeVS fromCode(String codeString) throws IllegalArgumentException {
            return IcpPromMeasurement.IcpCodeTypeVS.fromCode(codeString);
        }

        @Override
        public String toCode(IcpPromMeasurement.IcpCodeTypeVS icpCodeTypeVS) {
            return icpCodeTypeVS.toCode();
        }

        @Override
        public String toSystem(IcpPromMeasurement.IcpCodeTypeVS icpCodeTypeVS) {
            return icpCodeTypeVS.getSystem();
        }
    }

}


