package co.nz.acc.icp.samples.java.resources;

import ca.uhn.fhir.model.api.annotation.ResourceDef;
import co.nz.acc.icp.samples.java.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.FHIRException;
import org.hl7.fhir.r4.model.EnumFactory;

import static co.nz.acc.icp.samples.java.utils.Constants.ICP_MEASUREMENT_CLINICAL;
import static co.nz.acc.icp.samples.java.utils.Constants.UNEXPECTED_VALUE;

@SuppressWarnings({"java:S110"}) // keeping the default annotation params for now
@ResourceDef(name = "Observation", profile = ICP_MEASUREMENT_CLINICAL)
public class IcpClinicalMeasurement extends IcpMeasurementBase {

    public IcpCodeTypeVS getIcpCode() {
        return IcpCodeTypeVS.fromCode(this.getCode().getCodingFirstRep().getCode());
    }

    public enum IcpCodeTypeVS {
        SHOULDER_ABDUCTION_45_DEG_HANDHELD_DYNAMO_METER,
            LOWERBACK_NEUTRAL_PRONE_EXTENSION_HANDHELD_DYNAMO_METER,
            KNEE_EXTENSION_HANDHELD_DYNAMO_METER,
            KNEE_EXTENSION_ISO_KINETIC_DYNAMO_METER;

            IcpCodeTypeVS() {
        }

        public static IcpCodeTypeVS fromCode(String codeString) throws FHIRException {
            if (StringUtils.isNotEmpty(codeString)) {
                return switch (codeString) {
                    case "shoulder-abduction-45deg-hand-held-dynamometer" -> SHOULDER_ABDUCTION_45_DEG_HANDHELD_DYNAMO_METER;
                    case "lower-back-neutral-prone-extension-hand-held-dynamometer" ->
                        LOWERBACK_NEUTRAL_PRONE_EXTENSION_HANDHELD_DYNAMO_METER;
                    case "knee-extension-hand-held-dynamometer" -> KNEE_EXTENSION_HANDHELD_DYNAMO_METER;
                    case "knee-extension-isokinetic-dynamometer" -> KNEE_EXTENSION_ISO_KINETIC_DYNAMO_METER;
                    default -> throw new IllegalStateException(UNEXPECTED_VALUE + codeString);
                };
            }
            throw new IllegalStateException(UNEXPECTED_VALUE + codeString);
        }

        public String toCode() {
            return switch (this) {
                case SHOULDER_ABDUCTION_45_DEG_HANDHELD_DYNAMO_METER -> "shoulder-abduction-45deg-hand-held-dynamometer";
                case LOWERBACK_NEUTRAL_PRONE_EXTENSION_HANDHELD_DYNAMO_METER ->
                    "lower-back-neutral-prone-extension-hand-held-dynamometer";
                case KNEE_EXTENSION_HANDHELD_DYNAMO_METER -> "knee-extension-hand-held-dynamometer";
                case KNEE_EXTENSION_ISO_KINETIC_DYNAMO_METER -> "knee-extension-isokinetic-dynamometer";
            };
        }

        public String getSystem() {
            return Constants.ICP_REFERRAL_SOURCE_TYPE_CS;
        }

        public String getDefinition() {
            return switch (this) {
                case SHOULDER_ABDUCTION_45_DEG_HANDHELD_DYNAMO_METER ->
                    "Shoulder abduction 45 degrees - Hand held dynamometer";
                case LOWERBACK_NEUTRAL_PRONE_EXTENSION_HANDHELD_DYNAMO_METER ->
                    "Lower back neutral prone extension - Hand held dynamometer";
                case KNEE_EXTENSION_HANDHELD_DYNAMO_METER -> "Knee extension - Hand held dynamometer";
                case KNEE_EXTENSION_ISO_KINETIC_DYNAMO_METER -> "Knee extension - Isokinetic dynamometer";
            };
        }

        public String getDisplay() {
            return switch (this) {
                case SHOULDER_ABDUCTION_45_DEG_HANDHELD_DYNAMO_METER -> "Shoulder abduction 45deg hand held dynamometer";
                case LOWERBACK_NEUTRAL_PRONE_EXTENSION_HANDHELD_DYNAMO_METER ->
                    "Lower back neutral prone extension hand held dynamometer";
                case KNEE_EXTENSION_HANDHELD_DYNAMO_METER -> "Knee extension hand held dynamometer";
                case KNEE_EXTENSION_ISO_KINETIC_DYNAMO_METER -> "Knee extension isokinetic dynamometer";
            };
        }
    }

    @SuppressWarnings("unused") // used by HAPI
    public static class IcpCodeTypeVSEnumFactory implements EnumFactory<IcpClinicalMeasurement.IcpCodeTypeVS> {

        @Override
        public IcpClinicalMeasurement.IcpCodeTypeVS fromCode(String codeString) throws IllegalArgumentException {
            return IcpClinicalMeasurement.IcpCodeTypeVS.fromCode(codeString);
        }

        @Override
        public String toCode(IcpClinicalMeasurement.IcpCodeTypeVS icpCodeTypeVS) {
            return icpCodeTypeVS.toCode();
        }

        @Override
        public String toSystem(IcpClinicalMeasurement.IcpCodeTypeVS icpCodeTypeVS) {
            return icpCodeTypeVS.getSystem();
        }
    }

}


