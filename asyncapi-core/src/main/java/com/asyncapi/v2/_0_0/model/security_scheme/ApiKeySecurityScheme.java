package com.asyncapi.v2._0_0.model.security_scheme;

import com.fasterxml.jackson.annotation.JsonProperty;
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
@EqualsAndHashCode(callSuper = false)
public class ApiKeySecurityScheme extends SecurityScheme {

    /**
     * REQUIRED.
     *
     * The location of the API key.
     */
    @NonNull
    @Nonnull
    private ApiKeyLocation in;

    @Builder(builderMethodName = "apiKeySecuritySchemeBuilder")
    public ApiKeySecurityScheme(@Nonnull @NonNull Type type,
                                @Nullable String description,
                                @NonNull @Nonnull ApiKeyLocation in) {
        super(type, description);
        this.in = in;
    }

    public enum ApiKeyLocation {

        @JsonProperty("user")
        USER,
        @JsonProperty("password")
        PASSWORD

    }

}
