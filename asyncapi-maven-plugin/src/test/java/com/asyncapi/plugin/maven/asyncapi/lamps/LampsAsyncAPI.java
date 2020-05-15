package com.asyncapi.plugin.maven.asyncapi.lamps;

import com.asyncapi.v2.binding.OperationBinding;
import com.asyncapi.v2.binding.kafka.KafkaOperationBinding;
import com.asyncapi.v2.model.AsyncAPI;
import com.asyncapi.v2.model.Reference;
import com.asyncapi.v2.model.channel.ChannelItem;
import com.asyncapi.v2.model.channel.Parameter;
import com.asyncapi.v2.model.channel.message.Message;
import com.asyncapi.v2.model.channel.message.MessageTrait;
import com.asyncapi.v2.model.channel.operation.Operation;
import com.asyncapi.v2.model.channel.operation.OperationTrait;
import com.asyncapi.v2.model.component.Components;
import com.asyncapi.v2.model.info.Info;
import com.asyncapi.v2.model.info.License;
import com.asyncapi.v2.model.schema.Schema;
import com.asyncapi.v2.model.schema.Type;
import com.asyncapi.v2.model.security_scheme.ApiKeySecurityScheme;
import com.asyncapi.v2.model.security_scheme.SecurityScheme;
import com.asyncapi.v2.model.server.Server;
import com.asyncapi.v2.model.server.ServerVariable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LampsAsyncAPI extends AsyncAPI {

    @Nonnull
    @Override
    public String getAsyncapi() {
        return "2.0.0";
    }

    @NotNull
    @Override
    public Info getInfo() {
        return Info.builder()
                .title("Lamps API")
                .version("1.0.0")
                .description("Recive real-time information about lamps")
                .license(License.builder()
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0")
                        .build()
                )
                .build();
    }

    @CheckForNull
    @Override
    public Map<String, Server> getServers() {
        Map<String, ServerVariable> serverVariables = new HashMap<>();
        serverVariables.put("port", ServerVariable.builder()
                .description("Secure connection (TLS) is available through port 8883.")
                .defaultValue("1883")
                .enumValues(Arrays.asList("1883", "8883"))
                .build()
        );

        Map<String, Server> servers = new HashMap<>();
        servers.put("production", Server.builder()
                .url("api.streetlights.smartylighting.com:{port}")
                .protocol("mqtt")
                .description("Test broker")
                .variables(serverVariables)
                .security(Arrays.asList(
                        Collections.unmodifiableMap(Stream.of(
                                new AbstractMap.SimpleEntry<String, List<String>>("apiKey", Collections.emptyList()))
                                .collect(Collectors.toMap(it -> it.getKey(), it -> it.getValue()))
                        ),
                        Collections.unmodifiableMap(Stream.of(
                                new AbstractMap.SimpleEntry<String, List<String>>("supportedOauthFlows", Arrays.asList(
                                        "streetlights:on",
                                        "streetlights:off",
                                        "streetlights:dim"
                                )))
                                .collect(Collectors.toMap( it -> it.getKey(), it -> it.getValue()))
                        ),
                        Collections.unmodifiableMap(Stream.of(
                                new AbstractMap.SimpleEntry<String, List<String>>("openIdConnectWellKnown", Collections.emptyList()))
                                .collect(Collectors.toMap( it -> it.getKey(), it -> it.getValue()))
                        )
                ))
                .build()
        );

        return servers;
    }

    @CheckForNull
    @Override
    public String getDefaultContentType() {
        return "application/json";
    }

    @Nonnull
    @Override
    public Map<String, ChannelItem> getChannels() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("lampId", new Reference("#/components/parameters/lampId"));

        Map<String, ChannelItem> channels = new HashMap<>();
        channels.put("smartylighting/lamps/1/0/event/{lampId}/info", ChannelItem.builder()
                .description("The topic on which lamp info may be produced and consumed.")
                .parameters(parameters)
                .subscribe(Operation.builder()
                        .summary("Receive information about lamp.")
                        .operationId("receiveLampInfo")
                        .traits(Collections.singletonList(new Reference("#/components/operationTraits/kafka")))
                        .message(new Reference("#/components/messages/lampInfo"))
                        .build()
                )
                .build()
        );

        return channels;
    }

    @CheckForNull
    @Override
    public Components getComponents() {
        Map<String, Object> messages = new HashMap<>();
        messages.put("lampInfo", Message.builder()
                .name("lampInfo")
                .title("Lamp info")
                .summary("Lamp information.")
                .contentType("application/json")
                .traits(Collections.singletonList(new Reference("#/components/messageTraits/commonHeaders")))
                .payload(new Reference("#/components/schemas/lampInfoPayload"))
                .build()
        );

        return Components.builder()
                .messages(messages)
                .schemas(getSchemas())
                .securitySchemes(getSecuritySchemes())
                .parameters(getParameters())
                .messageTraits(getMessageTraits())
                .operationTraits(getOperationTraits())
                .build();
    }

    private Map<String, Object> getSchemas() {
        Map<String, Object> schemas = new HashMap<>();

        // lampInfoPayload
        Map<String, Schema> lampInfoPayloadProperties = new HashMap<>();
        lampInfoPayloadProperties.put("lumens", Schema.builder()
                .type(Type.INTEGER)
                .minimum(0)
                .description("Lamp intensity measured in lumens.")
                .build()
        );
        lampInfoPayloadProperties.put("watts", Schema.builder()
                .type(Type.INTEGER)
                .minimum(0)
                .maximum(100)
                .description("Lamp watt consumption.")
                .build()
        );

        schemas.put("lampInfoPayload", Schema.builder()
                .type(Type.OBJECT)
                .properties(lampInfoPayloadProperties)
                .build()
        );

        return schemas;
    }

    private Map<String, Object> getSecuritySchemes() {
        Map<String, Object> securitySchemes = new HashMap<>();
        securitySchemes.put("apiKey", ApiKeySecurityScheme.apiKeySecuritySchemeBuilder()
                .type(SecurityScheme.Type.API_KEY)
                .in(ApiKeySecurityScheme.ApiKeyLocation.USER)
                .description("Provide your API key as the user and leave the password empty.")
                .build()
        );

        return securitySchemes;
    }

    private Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("lampId", Parameter.builder()
                .description("The ID of the lamp.")
                .schema(Schema.builder()
                        .type(Type.STRING)
                        .build()
                )
                .build()
        );

        return parameters;
    }

    private Map<String, MessageTrait> getMessageTraits() {
        Map<String, MessageTrait> messageTraits = new HashMap<>();

        Map<String, Schema> commonHeadersProperties = new HashMap<>();
        commonHeadersProperties.put("my-app-header", Schema.builder()
                .type(Type.INTEGER)
                .minimum(0)
                .maximum(100)
                .build()
        );

        messageTraits.put("commonHeaders", MessageTrait.builder()
                .headers(Schema.builder()
                        .type(Type.OBJECT)
                        .properties(commonHeadersProperties)
                        .build()
                )
                .build()
        );

        return messageTraits;
    }

    private Map<String, OperationTrait> getOperationTraits() {
        Map<String, OperationTrait> operationTraits = new HashMap<>();

        Map<String, OperationBinding> bindigs = new HashMap<>();
        bindigs.put("kafka", KafkaOperationBinding.builder()
                .clientId("my-app-id")
                .build()
        );

        operationTraits.put("kafka", OperationTrait.builder()
                .bindings(bindigs)
                .build()
        );

        return operationTraits;
    }

}
