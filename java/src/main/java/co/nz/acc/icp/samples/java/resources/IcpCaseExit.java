package co.nz.acc.icp.samples.java.resources;

import ca.uhn.fhir.model.api.annotation.Block;
import ca.uhn.fhir.model.api.annotation.Child;
import ca.uhn.fhir.model.api.annotation.Extension;
import ca.uhn.fhir.model.api.annotation.ResourceDef;
import lombok.Getter;
import co.nz.acc.icp.samples.java.utils.Constants;
import org.apache.commons.lang3.StringUtils;
import org.hl7.fhir.r4.model.BackboneElement;
import org.hl7.fhir.r4.model.BooleanType;
import org.hl7.fhir.r4.model.CodeType;
import org.hl7.fhir.r4.model.EnumFactory;
import org.hl7.fhir.r4.model.Enumeration;
import org.hl7.fhir.r4.model.StringType;

import static co.nz.acc.icp.samples.java.utils.Constants.ICP_ADDITIONAL_ACC_SUPPORT;
import static co.nz.acc.icp.samples.java.utils.Constants.ICP_EXIT_REASON_VALUE;

@Getter
@SuppressWarnings({"java:S110"}) // keeping the default annotation params for now
@ResourceDef(name = "EpisodeOfCare", profile = Constants.ICP_CASE_EXIT)
public class IcpCaseExit extends IcpCaseBase {

    @Child(name = "exit-reason", min = 1)
    @Extension(url = Constants.ICP_EXIT_REASON, definedLocally = false)
    protected IcpCaseExitExtension caseExit;

    @SuppressWarnings("DefaultAnnotationParam") // keeping the default annotation params for now
    @Block
    public static class IcpCaseExitExtension extends BackboneElement {

        @Child(name = ICP_EXIT_REASON_VALUE,
                type = {CodeType.class},
                min = 1,
                max = 1,
                modifier = false,
                summary = false)
        @Extension(url = ICP_EXIT_REASON_VALUE, definedLocally = false, isModifier = false)
        protected Enumeration<IcpExitReasonVS> exitReason;

        @Child(
            name = Constants.ICP_EXIT_OTHER_REASON,
            type = {StringType.class},
            min = 0, max = 1,
            modifier = true, summary = true
        )
        @Extension(url = Constants.ICP_EXIT_OTHER_REASON, isModifier = false, definedLocally = false)
        protected StringType otherReason;

        @Child(name = ICP_ADDITIONAL_ACC_SUPPORT,
                type = {BooleanType.class},
                min = 1,
                max = 1,
                modifier = false,
                summary = false)
        @Extension(url = ICP_ADDITIONAL_ACC_SUPPORT, isModifier = false, definedLocally = false)
        protected BooleanType additionalACCSupportNeeded;
        @Child(
                name = Constants.ICP_SUPPORTING_DETAILS,
                type = {StringType.class},
                min = 0, max = 1,
                modifier = true, summary = true
        )
        @Extension(url = Constants.ICP_SUPPORTING_DETAILS, isModifier = false, definedLocally = false)
        protected StringType supportingDetails;
        @Child(
                name = Constants.OUTCOME_SUMMARY,
                type = {StringType.class},
                min = 0, max = 1,
                modifier = true, summary = true
        )
        @Extension(url = Constants.OUTCOME_SUMMARY, isModifier = false, definedLocally = false)
        protected StringType outcomeSummary;

        public boolean getAdditionalACCSupportNeeded() {
            return additionalACCSupportNeeded.booleanValue();
        }

        public String getSupportingDetails() {
            return supportingDetails.getValue();
        }

        public String getOutcomeSummary() {
            return outcomeSummary.getValue();
        }

        @Override
        public BackboneElement copy() {
            return null;
        }

        public IcpExitReasonVS getExitReason() {
            return exitReason.getValue();
        }

        public boolean hasSupportingDetails() {
            return supportingDetails != null;
        }

        public boolean hasOutcomeSummary() {
            return outcomeSummary != null;
        }

        public String getOtherReason() {
            return otherReason.getValue();
        }

        public boolean hasOtherReason() {
            return otherReason != null;
        }

        public enum IcpExitReasonVS {
            GOAL_ACHIEVED,
            PARTIALLY_ACHIEVED,
            GOAL_NOT_ACHIEVED,
            NON_COMPLIANCE,
            ALT_SERVICES,
            NEW_DIAGNOSIS,
            NOT_ELIGIBLE,
            CLIENT_MOVED,
            OTHER;

            IcpExitReasonVS() {
            }

            public static IcpExitReasonVS fromCode(String codeString) throws IllegalArgumentException {
                if (StringUtils.isNotEmpty(codeString)) {
                    return switch (codeString) {
                        case "goal-achieved" -> GOAL_ACHIEVED;
                        case "partially-achieved" -> PARTIALLY_ACHIEVED;
                        case "goal-not-achieved" -> GOAL_NOT_ACHIEVED;
                        case "non-compliance" -> NON_COMPLIANCE;
                        case "alt-services" -> ALT_SERVICES;
                        case "new-diagnosis" -> NEW_DIAGNOSIS;
                        case "not-eligible" -> NOT_ELIGIBLE;
                        case "client-moved" -> CLIENT_MOVED;
                        case "other" -> OTHER;
                        default -> throw new IllegalStateException("Unexpected value: " + codeString);
                    };
                }
                throw new IllegalArgumentException("Unknown IcpExitReasonVS code '" + codeString + "'");
            }

            public String toCode() {
                return switch (this) {
                    case GOAL_ACHIEVED -> "goal-achieved";
                    case PARTIALLY_ACHIEVED -> "partially-achieved";
                    case GOAL_NOT_ACHIEVED -> "goal-not-achieved";
                    case NON_COMPLIANCE -> "non-compliance";
                    case ALT_SERVICES -> "alt-services";
                    case NEW_DIAGNOSIS -> "new-diagnosis";
                    case NOT_ELIGIBLE -> "not-eligible";
                    case CLIENT_MOVED -> "client-moved";
                    case OTHER -> "other";
                };
            }

            public String getSystem() {
                return Constants.ICP_EXIT_REASON_CS;
            }

            public String getDefinition() {
                return switch (this) {
                    case GOAL_ACHIEVED -> "Recovery goal achieved";
                    case PARTIALLY_ACHIEVED -> "Recovery goal partially achieved";
                    case GOAL_NOT_ACHIEVED -> "Recovery goal not achieved";
                    case NON_COMPLIANCE -> "Non-compliance";
                    case ALT_SERVICES -> "Client opts for alternative ACC services";
                    case NEW_DIAGNOSIS -> "New ACC diagnosis (out of ICPMSK scope)";
                    case NOT_ELIGIBLE -> "Not eligible under ACC";
                    case CLIENT_MOVED -> "Client moved out of region";
                    case OTHER -> "Other - please specify";
                };
            }

            public String getDisplay() {
                return getDefinition();
            }
        }

        @SuppressWarnings("unused") // used by HAPI
        public static class IcpExitReasonVSEnumFactory implements EnumFactory<IcpExitReasonVS> {

            @Override
            public IcpExitReasonVS fromCode(String codeString) throws IllegalArgumentException {
                return IcpExitReasonVS.fromCode(codeString);
            }

            @Override
            public String toCode(IcpExitReasonVS icpExitReasonVS) {
                return icpExitReasonVS.toCode();
            }

            @Override
            public String toSystem(IcpExitReasonVS icpServiceBundleChangeRationaleVS) {
                return icpServiceBundleChangeRationaleVS.getSystem();
            }

        }

    }
}
