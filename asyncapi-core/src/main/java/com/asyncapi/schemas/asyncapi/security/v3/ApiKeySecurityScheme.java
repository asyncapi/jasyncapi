package com.asyncapi.schemas.asyncapi.security.v3;

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
