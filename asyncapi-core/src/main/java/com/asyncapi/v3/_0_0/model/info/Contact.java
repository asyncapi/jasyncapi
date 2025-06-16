package com.asyncapi.v3._0_0.model.info;

import com.asyncapi.lsp.TextDocumentCompletion;
import com.asyncapi.schemas.asyncapi.ExtendableObject;
import lombok.*;
import org.jetbrains.annotations.Nullable;

/**
 * Contact information for the exposed API.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#contactObject">Contact</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Contact extends ExtendableObject {

    /**
     * The identifying name of the contact person/organization.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Name of the contact person/organization\n\n" +
                    "The identifying name of the contact person/organization."
    )
    private String name;

    /**
     * The URL pointing to the contact information. This MUST be in the form of an absolute URL.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "URL to contact information\n\n" +
                    "The URL pointing to the contact information. This MUST be in the form of an absolute URL."
    )
    private String url;

    /**
     * The email address of the contact person/organization. MUST be in the format of an email address.
     */
    @Nullable
    @TextDocumentCompletion(
            detail = "String",
            documentation = "Email address of the contact\n\n" +
                    "The email address of the contact person/organization. MUST be in the format of an email address."
    )
    private String email;

}
