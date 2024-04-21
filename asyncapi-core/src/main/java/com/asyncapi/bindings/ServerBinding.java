package com.asyncapi.bindings;

import com.asyncapi.ExtendableObject;
import lombok.EqualsAndHashCode;

/**
 * Describes protocol-specific definition for a server.
 * <p>
 * This object MAY be extended with {@link ExtendableObject}.
 *
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#specificationExtensions">Specification Extensions</a>
 * @see <a href="https://www.asyncapi.com/docs/reference/specification/v3.0.0#serverBindingsObject">Server Binding</a>
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@EqualsAndHashCode(callSuper = true)
public class ServerBinding extends ExtendableObject {
}
