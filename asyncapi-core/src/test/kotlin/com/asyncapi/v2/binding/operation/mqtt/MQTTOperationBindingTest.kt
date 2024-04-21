package com.asyncapi.v2.binding.operation.mqtt

import com.asyncapi.v2.SerDeTest
import com.asyncapi.bindings.mqtt.v0._1_0.operation.MQTTOperationBinding

class MQTTOperationBindingTest: SerDeTest<MQTTOperationBinding>() {

    override fun objectClass() = MQTTOperationBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/operation/mqtt/mqttOperationBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/operation/mqtt/mqttOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/operation/mqtt/mqttOperationBinding - wrongly extended.json"

    override fun build(): MQTTOperationBinding {
        return MQTTOperationBinding.builder()
                .qos(2)
                .retain(true)
                .build()
    }

}