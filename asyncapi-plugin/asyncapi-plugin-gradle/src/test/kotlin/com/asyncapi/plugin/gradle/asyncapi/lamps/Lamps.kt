package com.asyncapi.plugin.gradle.asyncapi.lamps

import com.asyncapi.v2.binding.kafka.KafkaOperationBinding
import com.asyncapi.v2.model.AsyncAPI
import com.asyncapi.v2.model.ExternalDocumentation
import com.asyncapi.v2.model.Reference
import com.asyncapi.v2.model.Tag
import com.asyncapi.v2.model.channel.ChannelItem
import com.asyncapi.v2.model.channel.Parameter
import com.asyncapi.v2.model.channel.message.Message
import com.asyncapi.v2.model.channel.message.MessageTrait
import com.asyncapi.v2.model.channel.operation.Operation
import com.asyncapi.v2.model.channel.operation.OperationTrait
import com.asyncapi.v2.model.component.Components
import com.asyncapi.v2.model.info.Info
import com.asyncapi.v2.model.info.License
import com.asyncapi.v2.model.schema.Schema
import com.asyncapi.v2.model.schema.Type
import com.asyncapi.v2.model.security_scheme.ApiKeySecurityScheme
import com.asyncapi.v2.model.security_scheme.SecurityScheme
import com.asyncapi.v2.model.server.Server
import com.asyncapi.v2.model.server.ServerVariable

class Lamps(asyncapi: String = "2.0.0",
            id: String? = null,
            defaultContentType: String? = null,
            info: Info = Info(),
            servers: MutableMap<String, Server>? = null,
            channels: MutableMap<String, ChannelItem> = mutableMapOf(),
            components: Components? = null,
            tags: MutableList<Tag>? = null,
            externalDocs: ExternalDocumentation? = null
) : AsyncAPI(asyncapi, id, defaultContentType, info, servers, channels, components, tags, externalDocs) {

    override fun getAsyncapi() = "2.0.0"

    override fun getInfo(): Info {
        return Info.builder()
                .title("Lamps API")
                .version("1.0.0")
                .description("Recive real-time information about lamps")
                .license(License.builder()
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0")
                        .build()
                )
                .build()
    }

    override fun getServers(): MutableMap<String, Server> {
        return mutableMapOf(
                Pair("production", Server.builder()
                        .url("api.streetlights.smartylighting.com:{port}")
                        .protocol("mqtt")
                        .description("Test broker")
                        .variables(mapOf(
                                Pair("port", ServerVariable.builder()
                                        .description("Secure connection (TLS) is available through port 8883.")
                                        .defaultValue("1883")
                                        .enumValues(listOf("1883", "8883"))
                                        .build()
                                )
                        ))
                        .security(listOf(
                                mapOf(Pair("apiKey", emptyList())),
                                mapOf(Pair("supportedOauthFlows", listOf(
                                        "streetlights:on",
                                        "streetlights:off",
                                        "streetlights:dim")
                                )),
                                mapOf(Pair("openIdConnectWellKnown", emptyList()))
                        ))
                        .build()
                )
        )
    }

    override fun getDefaultContentType() = "application/json"

    override fun getChannels(): MutableMap<String, ChannelItem> {
        return mutableMapOf(
                Pair("smartylighting/lamps/1/0/event/{lampId}/info", ChannelItem.builder()
                        .description("The topic on which lamp info may be produced and consumed.")
                        .parameters(mapOf(
                                Pair("lampId", Reference("#/components/parameters/lampId"))
                        ))
                        .subscribe(Operation.builder()
                                .summary("Receive information about lamp.")
                                .operationId("receiveLampInfo")
                                .traits(listOf(Reference("#/components/operationTraits/kafka")))
                                .message(Reference("#/components/messages/lampInfo"))
                                .build()
                        )
                        .build()
                )
        )
    }

    override fun getComponents(): Components? {
        return Components.builder()
                .messages(mapOf(
                        Pair("lampInfo", Message.builder()
                                .name("lampInfo")
                                .title("Lamp info")
                                .summary("Lamp information.")
                                .contentType("application/json")
                                .traits(listOf(Reference("#/components/messageTraits/commonHeaders")))
                                .payload(Reference("#/components/schemas/lampInfoPayload"))
                                .build())
                ))
                .schemas(getSchemas())
                .securitySchemes(getSecuritySchemes())
                .parameters(getParameters())
                .messageTraits(getMessageTraits())
                .operationTraits(getOperationTraits())
                .build()
    }

    private fun getSchemas(): Map<String, Any> {
        return mapOf(
                Pair("lampInfoPayload", Schema.builder()
                        .type(Type.OBJECT)
                        .properties(mapOf(
                                Pair("lumens", Schema.builder()
                                        .type(Type.INTEGER)
                                        .minimum(0)
                                        .description("Lamp intensity measured in lumens.")
                                        .build()
                                ),
                                Pair("watts", Schema.builder()
                                        .type(Type.INTEGER)
                                        .minimum(0)
                                        .maximum(100)
                                        .description("Lamp watt consumption.")
                                        .build())
                        ))
                        .build()
                )
        )
    }

    private fun getSecuritySchemes(): Map<String, Any> {
        return mapOf(
                Pair("apiKey", ApiKeySecurityScheme.apiKeySecuritySchemeBuilder()
                        .type(SecurityScheme.Type.API_KEY)
                        .`in`(ApiKeySecurityScheme.ApiKeyLocation.USER)
                        .description("Provide your API key as the user and leave the password empty.")
                        .build()
                )
        )
    }

    private fun getParameters(): Map<String, Any> {
        return mapOf(
                Pair("lampId", Parameter.builder()
                        .description("The ID of the lamp.")
                        .schema(Schema.builder()
                                .type(Type.STRING)
                                .build()
                        )
                        .build())
        )
    }

    private fun getMessageTraits(): Map<String, MessageTrait> {
        return mapOf(
                Pair("commonHeaders", MessageTrait.builder()
                        .headers(Schema.builder()
                                .type(Type.OBJECT)
                                .properties(mapOf(
                                        Pair("my-app-header", Schema.builder()
                                                .type(Type.INTEGER)
                                                .minimum(0)
                                                .maximum(100)
                                                .build())
                                ))
                                .build()
                        )
                        .build())
        )
    }

    private fun getOperationTraits(): Map<String, OperationTrait> {
        return mapOf(
                Pair("kafka", OperationTrait.builder()
                        .bindings(mapOf(
                                Pair("kafka", KafkaOperationBinding.builder()
                                        .clientId("my-app-id")
                                        .build())
                        ))
                        .build())
        )
    }

}