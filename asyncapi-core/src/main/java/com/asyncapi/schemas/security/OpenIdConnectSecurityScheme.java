package com.asyncapi.schemas.security;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * OpenID Connect Security Scheme
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#securitySchemeObject">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OpenIdConnectSecurityScheme extends SecurityScheme {

    /**
     * <b>REQUIRED</b>.
     * <p>
     * OpenId Connect URL to discover OAuth2 configuration values. This MUST be in the form of an absolute URL.
     */
    @NotNull
    private String openIdConnectUrl = "";

    /**
     * List of the needed scope names. An empty array means no scopes are needed.
     */
    @Nullable
    private List<String> scopes;

    @Builder(builderMethodName = "openIdBuilder")
    public OpenIdConnectSecurityScheme(@Nullable String description,
                                       @NotNull String openIdConnectUrl,
                                       @Nullable List<String> scopes) {
        super(Type.OPENID_CONNECT, description);
        this.openIdConnectUrl = openIdConnectUrl;
        this.scopes = scopes;
    }

}
