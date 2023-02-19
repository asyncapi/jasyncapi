package com.asyncapi.v2._6_0.model.channel.message;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import java.util.Map;

/**
 * Message Example Object represents an example of a {@link com.asyncapi.v2._6_0.model.channel.message.Message} Object and MUST contain either headers and/or payload fields.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MessageExample {

    /**
     * The value of this field MUST validate against the {@link com.asyncapi.v2._6_0.model.channel.message.Message#getHeaders()} field.
     */
    @CheckForNull
    public Map<String, Object> headers;

    /**
     * The value of this field MUST validate against the Message {@link com.asyncapi.v2._6_0.model.channel.message.Message#getPayload()} field.
     */
    @CheckForNull
    private Object payload;

    /**
     * A machine-friendly name.
     */
    @CheckForNull
    private String name;

    /**
     * A short summary of what the example is about.
     */
    @CheckForNull
    private String summary;

}
