package com.asyncapi.v2._6_0.model.security_scheme;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#securitySchemeObject">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ApiKeySecurityScheme extends SecurityScheme {

    /**
     * REQUIRED.
     * <p>
     * The location of the API key.
     */
    @Nonnull
    private ApiKeyLocation in;

    @Builder(builderMethodName = "apiKeySecuritySchemeBuilder")
    public ApiKeySecurityScheme(@Nonnull Type type,
                                @Nullable String description,
                                @Nonnull ApiKeyLocation in) {
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
