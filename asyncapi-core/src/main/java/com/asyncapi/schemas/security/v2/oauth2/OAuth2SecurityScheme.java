package com.asyncapi.schemas.security.v2.oauth2;

import com.asyncapi.schemas.security.v2.SecurityScheme;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * OAuth2 Security Scheme
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#securitySchemeObject">SecurityScheme</a>
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OAuth2SecurityScheme extends SecurityScheme {

    /**
     * REQUIRED.
     * <p>
     * An object containing configuration information for the flow types supported.
     */
    @NotNull
    private OAuthFlows flows = new OAuthFlows();

    @Builder(builderMethodName = "oauth2Builder")
    public OAuth2SecurityScheme(@Nullable String description,
                                @NotNull OAuthFlows flows) {
        super(Type.OAUTH2, description);
        this.flows = flows;
    }

}
