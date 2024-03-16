package co.nz.acc.icp.samples.java.resources;

import co.nz.acc.icp.samples.java.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.exceptions.FHIRException;

import java.util.Optional;
import java.util.stream.Stream;

public enum IcpServiceBundleMskVS {
    ICPKAR1,
    ICPKAR2,
    ICPKAR3,
    ICPKRR1,
    ICPKRR2,
    ICPKRR3,
    ICPKRR4,
    ICPKRR5,
    ICPSPR1,
    ICPSPR2,
    ICPSPR3,
    ICPSPR4,
    ICPSPR5,
    ICPSPR6,
    ICPSPR7,
    ICPSPR8,
    ICPSHR1,
    ICPSHR2,
    ICPSHR3,
    ICPSHR4,
    ICPSHR5,
    ICPSHR6;

    IcpServiceBundleMskVS() {
    }

    public static IcpServiceBundleMskVS fromCode(String codeString) throws FHIRException {
        if (StringUtils.isNotEmpty(codeString)) {
            Optional<IcpServiceBundleMskVS> result = Stream.of(IcpServiceBundleMskVS.values())
                    .filter(v -> v.toCode().equals(codeString))
                    .findFirst();
            if (result.isPresent()) {
                return result.get();
            }
        }
        throw new FHIRException("Unable to determine IcpServiceBundle2VS value for code: " + codeString);
    }

    public String toCode() {
        return switch (this) {
            case ICPKAR1 -> "icpkar1";
            case ICPKAR2 -> "icpkar2";
            case ICPKAR3 -> "icpkar3";
            case ICPKRR1 -> "icpkrr1";
            case ICPKRR2 -> "icpkrr2";
            case ICPKRR3 -> "icpkrr3";
            case ICPKRR4 -> "icpkrr4";
            case ICPKRR5 -> "icpkrr5";
            case ICPSPR1 -> "icpspr1";
            case ICPSPR2 -> "icpspr2";
            case ICPSPR3 -> "icpspr3";
            case ICPSPR4 -> "icpspr4";
            case ICPSPR5 -> "icpspr5";
            case ICPSPR6 -> "icpspr6";
            case ICPSPR7 -> "icpspr7";
            case ICPSPR8 -> "icpspr8";
            case ICPSHR1 -> "icpshr1";
            case ICPSHR2 -> "icpshr2";
            case ICPSHR3 -> "icpshr3";
            case ICPSHR4 -> "icpshr4";
            case ICPSHR5 -> "icpshr5";
            case ICPSHR6 -> "icpshr6";
        };
    }

    public String getSystem() {
        return Constants.ICP_SERVICE_BUNDLE_MSK_CS;
    }

    public String getDefinition() {
        return switch (this) {
            case ICPKAR1 -> "Rehab Bundle Payment for Knee Arthroscopy and Debridement Level 1";
            case ICPKAR2 -> "Rehab Bundle Payment for Knee Arthroscopy and Debridement Level 2";
            case ICPKAR3 -> "Rehab Bundle Payment for Knee Arthroscopy and Debridement Level 3";
            case ICPKRR1 ->
                    "Rehab Bundle Payment for Knee Ligament/Tendon Reconstruction, ORIF, joint replacement Level 1";
            case ICPKRR2 ->
                    "Rehab Bundle Payment for Knee Ligament/Tendon Reconstruction, ORIF, joint replacement Level 2";
            case ICPKRR3 ->
                    "Rehab Bundle Payment for Knee Ligament/Tendon Reconstruction, ORIF, joint replacement Level 3";
            case ICPKRR4 ->
                    "Rehab Bundle Payment for Knee Ligament/Tendon Reconstruction, ORIF, joint replacement Level 4";
            case ICPKRR5 ->
                    "Rehab Bundle Payment for Knee Ligament/Tendon Reconstruction, ORIF, joint replacement Level 5";
            case ICPSPR1 -> "Rehab Bundle Payment for Lower Back/spine Level 1";
            case ICPSPR2 -> "Rehab Bundle Payment for Lower Back/spine Level 2";
            case ICPSPR3 -> "Rehab Bundle Payment for Lower Back/spine Level 3";
            case ICPSPR4 -> "Rehab Bundle Payment for Lower Back/spine Level 4";
            case ICPSPR5 -> "Rehab Bundle Payment for Lower Back/spine Level 5";
            case ICPSPR6 -> "Rehab Bundle Payment for Lower Back/spine Level 6";
            case ICPSPR7 -> "Rehab Bundle Payment for Lower Back/spine Level 7";
            case ICPSPR8 -> "Rehab Bundle Payment for Lower Back/spine Level 8";
            case ICPSHR1 -> "Rehab Bundle Payment for Shoulder (incl Clavicle) Level 1";
            case ICPSHR2 -> "Rehab Bundle Payment for Shoulder (incl Clavicle) Level 2";
            case ICPSHR3 -> "Rehab Bundle Payment for Shoulder (incl Clavicle) Level 3";
            case ICPSHR4 -> "Rehab Bundle Payment for Shoulder (incl Clavicle) Level 4";
            case ICPSHR5 -> "Rehab Bundle Payment for Shoulder (incl Clavicle) Level 5";
            case ICPSHR6 -> "Rehab Bundle Payment for Shoulder (incl Clavicle) Level 6";
        };
    }

    public String getDisplay() {
        return getDefinition();
    }
}
