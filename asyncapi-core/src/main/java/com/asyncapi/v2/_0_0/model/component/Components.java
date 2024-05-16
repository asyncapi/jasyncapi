package com.asyncapi.v2._0_0.model.component;

import com.asyncapi.schemas.asyncapi.ExtendableObject;
import com.asyncapi.v2._0_0.jackson.model.component.ComponentsMessagesDeserializer;
import com.asyncapi.v2._0_0.jackson.model.component.ComponentsParametersDeserializer;
import com.asyncapi.v2._0_0.jackson.model.component.ComponentsSchemasDeserializer;
import com.asyncapi.v2._0_0.jackson.model.component.ComponentsSecuritySchemesDeserializer;
import com.asyncapi.schemas.asyncapi.Reference;
import com.asyncapi.v2._0_0.model.channel.Parameter;
import com.asyncapi.v2._0_0.model.channel.message.CorrelationId;
import com.asyncapi.v2._0_0.model.channel.message.Message;
import com.asyncapi.v2._0_0.model.channel.message.MessageTrait;
import com.asyncapi.v2._0_0.model.channel.operation.OperationTrait;
import com.asyncapi.schemas.asyncapi.AsyncAPISchema;
import com.asyncapi.bindings.ChannelBinding;
import com.asyncapi.bindings.MessageBinding;
import com.asyncapi.bindings.OperationBinding;
import com.asyncapi.bindings.ServerBinding;
import com.asyncapi.bindings.ChannelBindingsDeserializer;
import com.asyncapi.bindings.MessageBindingsDeserializer;
import com.asyncapi.bindings.OperationBindingsDeserializer;
import com.asyncapi.bindings.ServerBindingsDeserializer;
import com.asyncapi.schemas.asyncapi.security.v2.SecurityScheme;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Holds a set of reusable objects for different aspects of the AsyncAPI specification. All objects defined within the
 * components object will have no effect on the API unless they are explicitly referenced from properties outside the
 * components object.
 *
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#componentsObject">Components</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Components extends ExtendableObject {

    /**
     * An object to hold reusable Schema Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link AsyncAPISchema}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsSchemasDeserializer.class)
    private Map<String, Object> schemas;

    /**
     * An object to hold reusable Message Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Message}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsMessagesDeserializer.class)
    private Map<String, Object> messages;

    /**
     * An object to hold reusable Security Scheme Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link SecurityScheme}</li>
     *     <li>{@link Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsSecuritySchemesDeserializer.class)
    private Map<String, Object> securitySchemes;

    /**
     * An object to hold reusable Parameter Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link Reference}</li>
     *     <li>{@link Parameter}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsParametersDeserializer.class)
    private Map<String, Object> parameters;

    /**
     * An object to hold reusable Correlation ID Objects.
     */
    @Nullable
    private Map<String, CorrelationId> correlationIds;

    /**
     * An object to hold reusable Operation Trait Objects.
     */
    @Nullable
    private Map<String, OperationTrait> operationTraits;

    /**
     * An object to hold reusable Message Trait Objects.
     */
    @Nullable
    private Map<String, MessageTrait> messageTraits;

    /**
     * An object to hold reusable Server Binding Objects.
     */
    @Nullable
    @JsonDeserialize(using = ServerBindingsDeserializer.class)
    private Map<String, ? extends ServerBinding> serverBindings;

    /**
     * An object to hold reusable Channel Binding Objects.
     */
    @Nullable
    @JsonDeserialize(using = ChannelBindingsDeserializer.class)
    private Map<String, ? extends ChannelBinding> channelBindings;

    /**
     * An object to hold reusable Operation Binding Objects.
     */
    @Nullable
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, ? extends OperationBinding> operationBindings;

    /**
     * An object to hold reusable Message Binding Objects.
     */
    @Nullable
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    private Map<String, ? extends MessageBinding> messageBindings;

}
