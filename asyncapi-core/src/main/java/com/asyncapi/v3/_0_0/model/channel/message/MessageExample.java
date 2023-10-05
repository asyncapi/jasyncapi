package com.asyncapi.v3._0_0.model.channel.message;

import com.asyncapi.v3.ExtendableObject;
import lombok.*;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Message Example Object represents an example of a {@link Message} Object and MUST contain either headers and/or payload fields.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MessageExample extends ExtendableObject {

    /**
     * The value of this field MUST validate against the {@link Message#getHeaders()} headers field.
     */
    @Nullable
    public Map<String, Object> headers;

    /**
     * The value of this field MUST validate against the Message {@link Message#getPayload()} field.
     */
    @Nullable
    public Map<String, Object> payload;

    /**
     * A machine-friendly name.
     */
    @Nullable
    private String name;

    /**
     * A short summary of what the example is about.
     */
    @Nullable
    private String summary;

}
