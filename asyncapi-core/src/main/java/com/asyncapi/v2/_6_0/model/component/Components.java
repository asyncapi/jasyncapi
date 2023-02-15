package com.asyncapi.v2._6_0.model.component;

import com.asyncapi.v2._6_0.jackson.binding.channel.ChannelBindingsDeserializer;
import com.asyncapi.v2._6_0.jackson.binding.message.MessageBindingsDeserializer;
import com.asyncapi.v2._6_0.jackson.binding.operation.OperationBindingsDeserializer;
import com.asyncapi.v2._6_0.jackson.binding.server.ServerBindingsDeserializer;
import com.asyncapi.v2._6_0.jackson.model.component.*;
import com.asyncapi.v2._6_0.model.channel.ChannelItem;
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
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#componentsObject">Components</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Components {

    /**
     * An object to hold reusable {@link }Schema Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.schema.Schema}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsSchemasDeserializer.class)
    private Map<String, Object> schemas;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.server.Server} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.server.Server}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsServersDeserializer.class)
    private Map<String, Object> servers;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.server.ServerVariable} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.server.ServerVariable}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
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
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsMessagesDeserializer.class)
    private Map<String, Object> messages;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.security_scheme.SecurityScheme} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.security_scheme.SecurityScheme}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsSecuritySchemesDeserializer.class)
    private Map<String, Object> securitySchemes;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.channel.Parameter} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.Parameter}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsParametersDeserializer.class)
    private Map<String, Object> parameters;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.channel.message.CorrelationId} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.message.CorrelationId}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsCorrelationIdsDeserializer.class)
    private Map<String, Object> correlationIds;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.channel.operation.OperationTrait} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.operation.OperationTrait}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsOperationTraitsDeserializer.class)
    private Map<String, Object> operationTraits;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.model.channel.message.MessageTrait} Objects.
     * <p>
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.model.channel.message.MessageTrait}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ComponentsMessageTraitsDeserializer.class)
    private Map<String, Object> messageTraits;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.binding.server.ServerBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.binding.server.ServerBinding}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ServerBindingsDeserializer.class)
    private Map<String, Object> serverBindings;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.binding.channel.ChannelBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.binding.channel.ChannelBinding}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = ChannelBindingsDeserializer.class)
    private Map<String, Object> channelBindings;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.binding.operation.OperationBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.binding.operation.OperationBinding}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = OperationBindingsDeserializer.class)
    private Map<String, Object> operationBindings;

    /**
     * An object to hold reusable {@link com.asyncapi.v2._6_0.binding.message.MessageBinding} Objects.
     * MUST BE:
     * <ul>
     *     <li>{@link com.asyncapi.v2._6_0.model.Reference}</li>
     *     <li>{@link com.asyncapi.v2._6_0.binding.message.MessageBinding}</li>
     * </ul>
     */
    @CheckForNull
    @JsonDeserialize(using = MessageBindingsDeserializer.class)
    private Map<String, Object> messageBindings;

}
