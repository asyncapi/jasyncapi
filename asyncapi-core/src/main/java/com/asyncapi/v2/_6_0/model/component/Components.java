package com.asyncapi.v2._6_0.model.component;

import com.asyncapi.ExtendableObject;
import com.asyncapi.v2._6_0.jackson.model.component.ComponentsCorrelationIdsDeserializer;
import com.asyncapi.v2._6_0.jackson.model.component.ComponentsMessageTraitsDeserializer;
import com.asyncapi.v2._6_0.jackson.model.component.ComponentsMessagesDeserializer;
import com.asyncapi.v2._6_0.jackson.model.component.ComponentsOperationTraitsDeserializer;
import com.asyncapi.v2._6_0.jackson.model.component.ComponentsParametersDeserializer;
import com.asyncapi.v2._6_0.jackson.model.component.ComponentsSchemasDeserializer;
import com.asyncapi.v2._6_0.jackson.model.component.ComponentsSecuritySchemesDeserializer;
import com.asyncapi.v2._6_0.jackson.model.component.ComponentsServerVariablesDeserializer;
import com.asyncapi.v2._6_0.jackson.model.component.ComponentsServersDeserializer;
import com.asyncapi.v2._6_0.model.channel.ChannelItem;
import com.asyncapi.bindings.ChannelBinding;
import com.asyncapi.bindings.MessageBinding;
import com.asyncapi.bindings.OperationBinding;
import com.asyncapi.bindings.ServerBinding;
import com.asyncapi.bindings.ChannelBindingsDeserializer;
import com.asyncapi.bindings.MessageBindingsDeserializer;
import com.asyncapi.bindings.OperationBindingsDeserializer;
import com.asyncapi.bindings.ServerBindingsDeserializer;
import com.asyncapi.v2.security_scheme.SecurityScheme;
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
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#componentsObject">Components</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Components extends ExtendableObject {

    /**
     * An object to hold reusable {@link }Schema Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2.schema.Schema}</li>
     *     <li>{@link com.asyncapi.Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsSchemasDeserializer.class)
    private Map<String, Object> schemas;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.server.Server} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.server.Server}</li>
     *     <li>{@link com.asyncapi.Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsServersDeserializer.class)
    private Map<String, Object> servers;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.server.ServerVariable} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.server.ServerVariable}</li>
     *     <li>{@link com.asyncapi.Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsServerVariablesDeserializer.class)
    private Map<String, Object> serverVariables;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.channel.ChannelItem} Objects.
     */
    private Map<String, ChannelItem> channels;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.channel.message.Message} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.message.Message}</li>
     *     <li>{@link com.asyncapi.Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsMessagesDeserializer.class)
    private Map<String, Object> messages;

    /**
     * An object to hold reusable {@link SecurityScheme} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link SecurityScheme}</li>
     *     <li>{@link com.asyncapi.Reference}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsSecuritySchemesDeserializer.class)
    private Map<String, Object> securitySchemes;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.channel.Parameter} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.Parameter}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsParametersDeserializer.class)
    private Map<String, Object> parameters;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.channel.message.CorrelationId} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.message.CorrelationId}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsCorrelationIdsDeserializer.class)
    private Map<String, Object> correlationIds;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.channel.operation.OperationTrait} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.operation.OperationTrait}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsOperationTraitsDeserializer.class)
    private Map<String, Object> operationTraits;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.channel.message.MessageTrait} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.message.MessageTrait}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ComponentsMessageTraitsDeserializer.class)
    private Map<String, Object> messageTraits;

    /**
     * An object to hold reusable {@link ServerBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.Reference}</li>
     *     <li>{@link ServerBinding}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ServerBindingsDeserializer.class)
    private Map<String, Object> serverBindings;

    /**
     * An object to hold reusable {@link ChannelBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.Reference}</li>
     *     <li>{@link ChannelBinding}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = ChannelBindingsDeserializer.class)
    private Map<String, Object> channelBindings;

    /**
     * An object to hold reusable {@link OperationBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.Reference}</li>
     *     <li>{@link OperationBinding}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, Object> operationBindings;

    /**
     * An object to hold reusable {@link MessageBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.Reference}</li>
     *     <li>{@link MessageBinding}</li>
     * </ul>
     */
    @Nullable
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    private Map<String, Object> messageBindings;

}
