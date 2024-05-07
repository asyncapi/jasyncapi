package com.asyncapi.schemas.security.v2;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * API Key Security Scheme
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#securitySchemeObject">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ApiKeySecurityScheme extends SecurityScheme {

    /**
     * REQUIRED.
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
