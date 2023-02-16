package com.asyncapi.v2._0_0.binding.solace;

import com.asyncapi.v2.binding.operation.OperationBinding;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

import lombok.*;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Describes Solace operation binding.
 *
 * Contains information about the operation representation in Solace PubSub+ Broker.
 *
 * @version 0.2.0
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/solace#operation-binding-object">Solace operation binding</a>
 * @author Dennis Brinley
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SolaceOperationBinding extends OperationBinding {

    /**
     * Version of the binding object (e.g. bindingVersion: 0.2.0)
     */
    @Nullable
    @CheckForNull
    @JsonProperty
    protected String bindingVersion;

    /**
     * List of destinations
     */
    @Nullable
    @CheckForNull
    @Builder.Default
    protected List<SolaceDestination> destinations = new ArrayList<SolaceDestination>();

    public enum SolaceDestinationType {
        QUEUE("queue"),
        TOPIC("topic");

        private String value;

        private SolaceDestinationType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        public static SolaceDestinationType fromValue(String value) {
            if (value == null || "".equals(value)) {
                throw new IllegalArgumentException( "Value cannot be empty or NULL" );
            }

            for (SolaceDestinationType enumEntry : SolaceDestinationType.values()) {
                if (enumEntry.toString().equals(value)) {
                    return enumEntry;
                }
            }

            throw new IllegalArgumentException( "Value must be member of [ queue, topic ]" );
        }
    }

    public enum SolaceDeliveryModeType {
        DIRECT("direct"),
        PERISTENT("persistent");

        private String value;

        private SolaceDeliveryModeType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String getValue() {
            return this.value;
        }

        public static SolaceDeliveryModeType fromValue(String value) {
            if (value == null || "".equals(value)) {
                throw new IllegalArgumentException( "Value cannot be empty or NULL" );
            }

            for (SolaceDeliveryModeType enumEntry : SolaceDeliveryModeType.values()) {
                if (enumEntry.toString().equals(value)) {
                    return enumEntry;
                }
            }

            throw new IllegalArgumentException( "Value must be member of [ direct, persistent ]" );
        }
    }

    public enum SolaceQueueAccessType {
        EXCLUSIVE("exclusive"),
        NON_EXCLUSIVE("non-exclusive");

        private String value;

        private SolaceQueueAccessType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String getValue() {
            return this.value;
        }

        public static SolaceQueueAccessType fromValue(String value) {
            if (value == null || "".equals(value)) {
                throw new IllegalArgumentException( "Value cannot be empty or NULL" );
            }

            for (SolaceQueueAccessType enumEntry : SolaceQueueAccessType.values()) {
                if (enumEntry.toString().equals(value)) {
                    return enumEntry;
                }
            }

            throw new IllegalArgumentException( "Value must be member of [ exclusive, non-exclusive ]" );
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SolaceQueueType {
        
        @NonNull
        @Nonnull
        @CheckForNull
        String name;

        @CheckForNull
        List<String> topicSubscriptions;

        @CheckForNull
        SolaceQueueAccessType accessType;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SolaceTopicType {

        @CheckForNull
        @JsonProperty
        protected List<String> topicSubscriptions;    
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SolaceDestination {

        /**
         * The destination type. enum SolaceDestinationType enum can be 'topic' or 'queue'
         */
        @NonNull
        @Nonnull
        @CheckForNull
        @JsonProperty
        protected SolaceDestinationType destinationType;

        /**
         * The delivery mode for messages associated with this destination. enum SolaceDeliveryModeType
         * can be 'direct' or 'persistent'
         */
        @NonNull
        @Nonnull
        @CheckForNull
        @JsonProperty
        protected SolaceDeliveryModeType deliveryMode;

        /**
         * Solace queue destination details.
         */
        @Nullable
        @CheckForNull
        @JsonProperty
        protected SolaceQueueType queue;

        /**
         * Solace topic destination details
         */
        @Nullable
        @CheckForNull
        @JsonProperty
        protected SolaceTopicType topic;
    }

}
