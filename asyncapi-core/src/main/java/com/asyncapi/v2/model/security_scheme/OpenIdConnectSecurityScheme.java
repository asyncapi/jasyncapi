package com.asyncapi.v2.model.security_scheme;

import lombok.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @version 2.0.0
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#a-name-securityschemeobject-a-security-scheme-object">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OpenIdConnectSecurityScheme extends SecurityScheme {

    /**
     * REQUIRED.
     *
     * OpenId Connect URL to discover OAuth2 configuration values. This MUST be in the form of a URL.
     */
    @NonNull
    @Nonnull
    private String openIdConnectUrl;

    @Builder(builderMethodName = "openIdConnectSecurityScheme")
    public OpenIdConnectSecurityScheme(@Nonnull @NonNull Type type,
                                       @Nullable String description,
                                       @NonNull @Nonnull String openIdConnectUrl) {
        super(type, description);
        this.openIdConnectUrl = openIdConnectUrl;
    }

}
