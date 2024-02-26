package com.asyncapi.examples.v3._0_0

import com.asyncapi.v3.Reference
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.v3.binding.operation.http.HTTPOperationBinding
import com.asyncapi.v3.binding.operation.http.HTTPOperationMethod
import com.asyncapi.v3.schema.Schema
import com.asyncapi.v3.security_scheme.oauth2.OAuth2SecurityScheme
import com.asyncapi.v3.security_scheme.oauth2.OAuthFlows
import com.asyncapi.v3.security_scheme.oauth2.flow.ClientCredentialsOAuthFlow

class OperationSecurityAsyncAPI: AbstractExampleValidationTest() {

    override fun specificationLocation(): String = "/examples/v3.0.0/operation-security-asyncapi.yml"

    override fun expectedInfo(): Info {
        return Info.builder()
                .title("Notifications")
                .version("1.0.0")
                .description("This contract defines HTTP Push notification for  application authorization revocation topic")
                .build()
    }

    override fun expectedServers(): Map<String, Any> = emptyMap()

    override fun expectedChannels(): Map<String, Any> {
        return mapOf(
                Pair("authRevoke",
                        Channel.builder()
                                .address("AUTHORIZATION_REVOCATION")
                                .messages(mapOf(
                                        Pair("message", Reference("#/components/messages/message"))
                                ))
                                .build()
                )
        )
    }

    override fun expectedOperations(): Map<String, Any> {
        return mapOf(
                Pair("sendAuthRevoke",
                        Operation.builder()
                                .action(OperationAction.SEND)
                                .channel(Reference("#/channels/authRevoke"))
                                .security(listOf(
                                        OAuth2SecurityScheme(
                                                "The oauth security descriptions",
                                                OAuthFlows(
                                                        null,
                                                        null,
                                                        ClientCredentialsOAuthFlow(
                                                                "",
                                                                mapOf(
                                                                        Pair("subscribe:auth_revocations", "Scope required for authorization revocation topic")
                                                                ),
                                                                "https://example.com/api/oauth/dialog"
                                                        ),
                                                        null
                                                ),
                                                listOf("subscribe:auth_revocations"),
                                        )
                                ))
                                .bindings(mapOf(
                                        Pair("http", HTTPOperationBinding.builder()
                                                .method(HTTPOperationMethod.POST)
                                                .build())
                                ))
                                .messages(listOf(
                                        Reference("#/channels/authRevoke/messages/message")
                                ))
                                .build()
                )
        )
    }

    override fun expectedComponents(): Components? {
        return Components.builder()
                .messages(mapOf(
                        Pair("message",
                                Message.builder()
                                        .headers(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("X-SIGNATURE", Schema.builder()
                                                                .description("ECC message signature")
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("Content-Type", Schema.builder()
                                                                .type("string")
                                                                .enumValue(listOf(
                                                                        "application/json"
                                                                ))
                                                                .build()
                                                        )
                                                ))
                                                .build())
                                        .payload(Schema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("metadata", Schema.builder().ref("#/components/schemas/MetaData").build()),
                                                        Pair("notification", Schema.builder().ref("#/components/schemas/Notification").build())
                                                ))
                                                .build())
                                        .build()
                        )
                ))
                .schemas(mapOf(
                        Pair("MetaData",
                                Schema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("topic", Schema.builder()
                                                        .type("string")
                                                        .description("Topic subscribed to.")
                                                        .build()
                                                ),
                                                Pair("schemaVersion", Schema.builder()
                                                        .type("string")
                                                        .description("The schema for this topic.")
                                                        .build()
                                                ),
                                                Pair("deprecated", Schema.builder()
                                                        .type("boolean")
                                                        .description("If this is a deprecated schema or topic.")
                                                        .defaultValue("false")
                                                        .build()
                                                )
                                        ))
                                        .build()
                        ),
                        Pair("Notification",
                                Schema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("notificationId", Schema.builder()
                                                        .type("string")
                                                        .description("The notification Id.")
                                                        .build()
                                                ),
                                                Pair("eventDate", Schema.builder()
                                                        .type("string")
                                                        .description("The event date associated with this notification in UTC.")
                                                        .build()
                                                ),
                                                Pair("publishDate", Schema.builder()
                                                        .type("string")
                                                        .description("The message publish date in UTC.")
                                                        .build()
                                                ),
                                                Pair("publishAttemptCount", Schema.builder()
                                                        .type("integer")
                                                        .description("The number of attempts made to publish this message.")
                                                        .build()
                                                ),
                                                Pair("data", Schema.builder()
                                                        .ref("#/components/schemas/AuthorizationRevocationData")
                                                        .build()
                                                )
                                        ))
                                        .build()
                        ),
                        Pair("AuthorizationRevocationData",
                                Schema.builder()
                                        .type("object")
                                        .description("The Authorization Revocation payload.")
                                        .properties(mapOf(
                                                Pair("username", Schema.builder()
                                                        .type("string")
                                                        .description("The username for the user.")
                                                        .build()
                                                ),
                                                Pair("userId", Schema.builder()
                                                        .type("string")
                                                        .description("The immutable public userId for the user")
                                                        .build()
                                                ),
                                                Pair("eiasToken", Schema.builder()
                                                        .type("string")
                                                        .description("The legacy eiasToken specific to the user")
                                                        .build()
                                                ),
                                                Pair("revokeReason", Schema.builder()
                                                        .type("string")
                                                        .description("The reason for authorization revocation")
                                                        .enumValue(listOf(
                                                                "REVOKED_BY_APP",
                                                                "REVOKED_BY_USER",
                                                                "REVOKED_BY_ADMIN",
                                                                "PASSWORD_CHANGE"
                                                        ))
                                                        .build()
                                                ),
                                                Pair("revocationDate", Schema.builder()
                                                        .type("string")
                                                        .description("Date and time when the authorization was revoked")
                                                        .build()
                                                )
                                        ))
                                        .build()
                        )
                ))
                .securitySchemes(mapOf(
                        Pair("petstore_auth", OAuth2SecurityScheme(
                                "The oauth security descriptions",
                                OAuthFlows(
                                        null,
                                        null,
                                        ClientCredentialsOAuthFlow(
                                                "",
                                                mapOf(
                                                        Pair("subscribe:auth_revocations", "Scope required for authorization revocation topic")
                                                ),
                                                "https://example.com/api/oauth/dialog"
                                        ),
                                        null
                                ),
                                null
                        ))
                ))
                .build()
    }

}