package com.asyncapi.v2.binding.operation.mqtt

import com.asyncapi.v2.SerDeTest

class MQTTOperationBindingTest: SerDeTest<MQTTOperationBinding>() {

    override fun objectClass() = MQTTOperationBinding::class.java

    override fun baseObjectJson() = "/json/binding/operation/mqtt/mqttOperationBinding.json"

    override fun extendedObjectJson() = "/json/binding/operation/mqtt/mqttOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/binding/operation/mqtt/mqttOperationBinding - wrongly extended.json"

    override fun build(): MQTTOperationBinding {
        return MQTTOperationBinding.builder()
                .qos(2)
                .retain(true)
                .build()
    }

}