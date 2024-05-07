package com.asyncapi.schemas.security.v3.oauth2.flow;

import com.asyncapi.schemas.ExtendableObject;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration details for a supported OAuth Flow
 * <p>
 * This object MAY be extended with {@link ExtendableObject}.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#oauthFlowObject">OAuth Flow</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#specificationExtensions">Specification Extensions</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OAuthFlow extends ExtendableObject {

    /**
     * The URL to be used for obtaining refresh tokens. This MUST be in the form of an absolute URL.
     */
    @Nullable
    @Builder.Default
    private String refreshUrl = "";

    /**
     * <b>REQUIRED</b>.
     * <p>
     * The available scopes for the OAuth2 security scheme. A map between the scope name and a short description for it.
     */
    @NotNull
    @Builder.Default
    private Map<String, String> availableScopes = new HashMap<>();

}
