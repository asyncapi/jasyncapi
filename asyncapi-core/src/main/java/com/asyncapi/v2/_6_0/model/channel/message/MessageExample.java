package com.asyncapi.v2._6_0.model.channel.message;

import com.asyncapi.schemas.ExtendableObject;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

/**
 * Message Example Object represents an example of a {@link com.asyncapi.v2._6_0.model.channel.message.Message} Object and MUST contain either headers and/or payload fields.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MessageExample extends ExtendableObject {

    /**
     * The value of this field MUST validate against the {@link com.asyncapi.v2._6_0.model.channel.message.Message} headers field.
     */
    @Nullable
    public Map<String, Object> headers;

    /**
     * The value of this field MUST validate against the Message {@link com.asyncapi.v2._6_0.model.channel.message.Message#getPayload()} field.
     */
    @Nullable
    private Object payload;

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
