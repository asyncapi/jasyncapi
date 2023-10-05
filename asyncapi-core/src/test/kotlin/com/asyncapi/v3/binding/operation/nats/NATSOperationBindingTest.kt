package com.asyncapi.v3.binding.operation.nats

import com.asyncapi.v3.SerDeTest

class NATSOperationBindingTest: SerDeTest<NATSOperationBinding>() {

    override fun objectClass() = NATSOperationBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/operation/nats/natsOperationBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/operation/nats/natsOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/operation/nats/natsOperationBinding - wrongly extended.json"

    override fun build(): NATSOperationBinding {
        return NATSOperationBinding.builder()
                .queue("messages")
                .build()
    }

}