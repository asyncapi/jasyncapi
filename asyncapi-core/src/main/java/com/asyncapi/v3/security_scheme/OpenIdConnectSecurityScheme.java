package com.asyncapi.v3.security_scheme;

import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#securitySchemeObject">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OpenIdConnectSecurityScheme extends SecurityScheme {

    /**
     * REQUIRED.
     * <p>
     * OpenId Connect URL to discover OAuth2 configuration values. This MUST be in the form of a URL.
     */
    @NotNull
    private String openIdConnectUrl = "";

    /**
     * List of the needed scope names.
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
