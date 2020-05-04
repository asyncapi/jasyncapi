package com.asyncapi.v2.model.component;

import com.asyncapi.v2.binding.*;
import com.asyncapi.v2.model.channel.message.CorrelationId;
import com.asyncapi.v2.model.channel.message.MessageTrait;
import com.asyncapi.v2.model.channel.operation.OperationTrait;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

/**
 * Holds a set of reusable objects for different aspects of the AsyncAPI specification. All objects defined within the
 * components object will have no effect on the API unless they are explicitly referenced from properties outside the
 * components object.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Components {

    /**
     * TODO: Map[string, Schema Object | Reference Object]
     * An object to hold reusable Schema Objects.
     */
    private Map<String, Object> schemas;

    /**
     * TODO: Map[string, Message Object | Reference Object]
     * An object to hold reusable Message Objects.
     */
    private Map<String, Object> messages;

    /**
     * TODO: Map[string, Security Scheme Object | Reference Object]
     * An object to hold reusable Security Scheme Objects.
     */
    private Map<String, Object> securitySchemes;

    /**
     * TODO: Map[string, Parameter Object | Reference Object]
     * An object to hold reusable Parameter Objects.
     */
    private Map<String, Object> parameters;

    /**
     * An object to hold reusable Correlation ID Objects.
     */
    private Map<String, CorrelationId> correlationIds;

    /**
     * An object to hold reusable Operation Trait Objects.
     */
    private Map<String, OperationTrait> operationTraits;

    /**
     * An object to hold reusable Message Trait Objects.
     */
    private Map<String, MessageTrait> messageTraits;

    /**
     * An object to hold reusable Server Binding Objects.
     */
    @JsonDeserialize(using = ServerBindingsDeserializer.class)
    private Map<String, ? extends ServerBindingsDeserializer> serverBindings;

    /**
     * An object to hold reusable Channel Binding Objects.
     */
    @JsonDeserialize(using = ChannelBindingsDeserializer.class)
    private Map<String, ? extends ChannelBinding> channelBindings;

    /**
     * An object to hold reusable Operation Binding Objects.
     */
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, ? extends OperationBinding> operationBindings;

    /**
     * An object to hold reusable Message Binding Objects.
     */
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    private Map<String, ? extends MessageBinding> messageBindings;

}
