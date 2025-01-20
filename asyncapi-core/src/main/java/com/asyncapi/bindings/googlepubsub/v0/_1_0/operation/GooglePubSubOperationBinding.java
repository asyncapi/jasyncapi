package com.asyncapi.bindings.googlepubsub.v0._1_0.operation;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes Google Cloud Pub/Sub operation binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/tree/master/googlepubsub#operation-binding-object">Google Cloud Pub/Sub operation binding</a>
 * @see <a href="https://cloud.google.com/pubsub">Google Cloud Pub/Sub</a>
 * @author Pavel Bodiachevskii
 * @version 0.1.0
 * @since 1.0.0-RC2
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GooglePubSubOperationBinding extends com.asyncapi.bindings.googlepubsub.GooglePubSubOperationBinding {

    @Override
    public String getBindingVersion() {
        return "0.1.0";
    }

    @Override
    public void setBindingVersion(@Nullable String bindingVersion) {
        super.setBindingVersion("0.1.0");
    }

}
