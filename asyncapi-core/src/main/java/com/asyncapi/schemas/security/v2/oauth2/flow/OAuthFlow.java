package com.asyncapi.schemas.security.v2.oauth2.flow;

import com.asyncapi.schemas.ExtendableObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

/**
 * Configuration details for a supported OAuth Flow
 * <p>
 * This object MAY be extended with <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#specificationExtensions">Specification Extensions</a>.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#oauthFlowObject">OAuth Flow Object</a>
 * @author Pavel Bodiachevskii
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
     * REQUIRED.
     * <p>
     * The available scopes for the OAuth2 security scheme. A map between the scope name and a short description for it.
     */
    @NotNull
    @Builder.Default
    private Map<String, String> scopes = new HashMap<>();

}
