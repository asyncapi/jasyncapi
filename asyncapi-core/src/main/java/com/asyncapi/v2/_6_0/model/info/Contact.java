package com.asyncapi.v2._6_0.model.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * Contact information for the exposed API.
 *
 * @version 2.6.0
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v2.6.0#contactObject">Contact</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    /**
     * The identifying name of the contact person/organization.
     */
    @Nullable
    private String name;

    /**
     * The URL pointing to the contact information. MUST be in the format of a URL.
     */
    @Nullable
    private String url;

    /**
     * The email address of the contact person/organization. MUST be in the format of an email address.
     */
    @Nullable
    private String email;

}
