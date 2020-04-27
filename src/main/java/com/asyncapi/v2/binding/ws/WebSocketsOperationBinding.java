package com.asyncapi.v2.binding.ws;

import com.asyncapi.v2.binding.OperationBinding;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 *
 * This class defines how to describe WebSockets operation binding.
 *
 * @author Pavel Bodiachevskii
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class WebSocketsOperationBinding extends OperationBinding {
}
