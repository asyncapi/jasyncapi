package com.asyncapi.v2.model.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;

/**
 * Contact information for the exposed API.
 *
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
    @CheckForNull
    private String name;

    /**
     * The URL pointing to the contact information. MUST be in the format of a URL.
     */
    @CheckForNull
    private String url;

    /**
     * The email address of the contact person/organization. MUST be in the format of an email address.
     */
    @CheckForNull
    private String email;

}
