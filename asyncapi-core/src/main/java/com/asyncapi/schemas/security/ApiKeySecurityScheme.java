package com.asyncapi.schemas.security;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * API Key Security Scheme
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#securitySchemeObject">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ApiKeySecurityScheme extends SecurityScheme {

    /**
     * <b>REQUIRED</b>.
     * <p>
     * The location of the API key.
     */
    @NotNull
    private ApiKeyLocation in = ApiKeyLocation.USER;

    @Builder(builderMethodName = "apiKeyBuilder")
    public ApiKeySecurityScheme(@Nullable String description,
                                @NotNull ApiKeyLocation in) {
        super(Type.API_KEY, description);
        this.in = in;
    }

    public enum ApiKeyLocation {

        @JsonProperty("user")
        USER,
        @JsonProperty("password")
        PASSWORD

    }

}
