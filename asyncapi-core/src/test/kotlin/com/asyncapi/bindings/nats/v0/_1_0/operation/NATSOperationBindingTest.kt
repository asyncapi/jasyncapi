package com.asyncapi.bindings.nats.v0._1_0.operation

import com.asyncapi.v3.SerDeTest

class NATSOperationBindingTest: SerDeTest<NATSOperationBinding>() {

    override fun objectClass() = NATSOperationBinding::class.java

    override fun baseObjectJson() = "/bindings/nats/operation/natsOperationBinding.json"

    override fun extendedObjectJson() = "/bindings/nats/operation/natsOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/nats/operation/natsOperationBinding - wrongly extended.json"

    override fun build(): NATSOperationBinding {
        return NATSOperationBinding.builder()
                .queue("messages")
                .build()
    }

}