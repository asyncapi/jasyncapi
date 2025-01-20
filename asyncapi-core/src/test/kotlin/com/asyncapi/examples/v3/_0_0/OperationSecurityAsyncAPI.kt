package com.asyncapi.examples.v3._0_0

import com.asyncapi.schemas.asyncapi.Reference
import com.asyncapi.bindings.http.v0._3_0.operation.HTTPOperationBinding
import com.asyncapi.bindings.http.v0._3_0.operation.HTTPOperationMethod
import com.asyncapi.v3._0_0.model.channel.Channel
import com.asyncapi.v3._0_0.model.channel.message.Message
import com.asyncapi.v3._0_0.model.component.Components
import com.asyncapi.v3._0_0.model.info.Info
import com.asyncapi.v3._0_0.model.operation.Operation
import com.asyncapi.v3._0_0.model.operation.OperationAction
import com.asyncapi.schemas.asyncapi.AsyncAPISchema
import com.asyncapi.schemas.asyncapi.security.v3.oauth2.OAuth2SecurityScheme
import com.asyncapi.schemas.asyncapi.security.v3.oauth2.OAuthFlows
import com.asyncapi.schemas.asyncapi.security.v3.oauth2.flow.ClientCredentialsOAuthFlow

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
                                        Pair("message",
                                            Reference("#/components/messages/message")
                                        )
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
                                                    Pair(
                                                        "subscribe:auth_revocations",
                                                        "Scope required for authorization revocation topic"
                                                    )
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
                                        .headers(
                                            AsyncAPISchema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("X-SIGNATURE", AsyncAPISchema.builder()
                                                                .description("ECC message signature")
                                                                .type("string")
                                                                .build()
                                                        ),
                                                        Pair("Content-Type", AsyncAPISchema.builder()
                                                                .type("string")
                                                                .enumValue(listOf(
                                                                        "application/json"
                                                                ))
                                                                .build()
                                                        )
                                                ))
                                                .build())
                                        .payload(
                                            AsyncAPISchema.builder()
                                                .type("object")
                                                .properties(mapOf(
                                                        Pair("metadata", AsyncAPISchema.builder().ref("#/components/schemas/MetaData").build()),
                                                        Pair("notification", AsyncAPISchema.builder().ref("#/components/schemas/Notification").build())
                                                ))
                                                .build())
                                        .build()
                        )
                ))
                .schemas(mapOf(
                        Pair("MetaData",
                                AsyncAPISchema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("topic", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("Topic subscribed to.")
                                                        .build()
                                                ),
                                                Pair("schemaVersion", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("The schema for this topic.")
                                                        .build()
                                                ),
                                                Pair("deprecated", AsyncAPISchema.builder()
                                                        .type("boolean")
                                                        .description("If this is a deprecated schema or topic.")
                                                        .defaultValue("false")
                                                        .build()
                                                )
                                        ))
                                        .build()
                        ),
                        Pair("Notification",
                                AsyncAPISchema.builder()
                                        .type("object")
                                        .properties(mapOf(
                                                Pair("notificationId", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("The notification Id.")
                                                        .build()
                                                ),
                                                Pair("eventDate", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("The event date associated with this notification in UTC.")
                                                        .build()
                                                ),
                                                Pair("publishDate", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("The message publish date in UTC.")
                                                        .build()
                                                ),
                                                Pair("publishAttemptCount", AsyncAPISchema.builder()
                                                        .type("integer")
                                                        .description("The number of attempts made to publish this message.")
                                                        .build()
                                                ),
                                                Pair("data", AsyncAPISchema.builder()
                                                        .ref("#/components/schemas/AuthorizationRevocationData")
                                                        .build()
                                                )
                                        ))
                                        .build()
                        ),
                        Pair("AuthorizationRevocationData",
                                AsyncAPISchema.builder()
                                        .type("object")
                                        .description("The Authorization Revocation payload.")
                                        .properties(mapOf(
                                                Pair("username", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("The username for the user.")
                                                        .build()
                                                ),
                                                Pair("userId", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("The immutable public userId for the user")
                                                        .build()
                                                ),
                                                Pair("eiasToken", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("The legacy eiasToken specific to the user")
                                                        .build()
                                                ),
                                                Pair("revokeReason", AsyncAPISchema.builder()
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
                                                Pair("revocationDate", AsyncAPISchema.builder()
                                                        .type("string")
                                                        .description("Date and time when the authorization was revoked")
                                                        .build()
                                                )
                                        ))
                                        .build()
                        )
                ))
                .securitySchemes(mapOf(
                        Pair("petstore_auth",
                            OAuth2SecurityScheme(
                                "The oauth security descriptions",
                                OAuthFlows(
                                    null,
                                    null,
                                    ClientCredentialsOAuthFlow(
                                        "",
                                        mapOf(
                                            Pair(
                                                "subscribe:auth_revocations",
                                                "Scope required for authorization revocation topic"
                                            )
                                        ),
                                        "https://example.com/api/oauth/dialog"
                                    ),
                                    null
                                ),
                                null
                            )
                        )
                ))
                .build()
    }

}