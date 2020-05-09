package com.asyncapi.v2.model.component;

import com.asyncapi.v2.binding.*;
import com.asyncapi.v2.jackson.ComponentsParametersDeserializer;
import com.asyncapi.v2.model.channel.message.CorrelationId;
import com.asyncapi.v2.model.channel.message.MessageTrait;
import com.asyncapi.v2.model.channel.operation.OperationTrait;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
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
public class Components<HeadersType, CorrelationIdType> {

    /**
     * TODO: Map[string, Schema Object | Reference Object]
     * An object to hold reusable Schema Objects.
     */
    @CheckForNull
    private Map<String, Object> schemas;

    /**
     * TODO: Map[string, Message Object | Reference Object]
     * An object to hold reusable Message Objects.
     */
    @CheckForNull
    private Map<String, Object> messages;

    /**
     * TODO: Map[string, Security Scheme Object | Reference Object]
     * An object to hold reusable Security Scheme Objects.
     */
    @CheckForNull
    private Map<String, Object> securitySchemes;

    /**
     * An object to hold reusable Parameter Objects.
     *
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2.model.channel.Parameter}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsParametersDeserializer.class)
    private Map<String, Object> parameters;

    /**
     * An object to hold reusable Correlation ID Objects.
     */
    @CheckForNull
    private Map<String, CorrelationId> correlationIds;

    /**
     * An object to hold reusable Operation Trait Objects.
     */
    @CheckForNull
    private Map<String, OperationTrait> operationTraits;

    /**
     * An object to hold reusable Message Trait Objects.
     */
    @CheckForNull
    private Map<String, MessageTrait<HeadersType, CorrelationIdType>> messageTraits;

    /**
     * An object to hold reusable Server Binding Objects.
     */
    @CheckForNull
    @JsonDeserialize(using = ServerBindingsDeserializer.class)
    private Map<String, ? extends ServerBindingsDeserializer> serverBindings;

    /**
     * An object to hold reusable Channel Binding Objects.
     */
    @CheckForNull
    @JsonDeserialize(using = ChannelBindingsDeserializer.class)
    private Map<String, ? extends ChannelBinding> channelBindings;

    /**
     * An object to hold reusable Operation Binding Objects.
     */
    @CheckForNull
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, ? extends OperationBinding> operationBindings;

    /**
     * An object to hold reusable Message Binding Objects.
     */
    @CheckForNull
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    private Map<String, ? extends MessageBinding> messageBindings;

}
