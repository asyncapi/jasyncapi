package com.asyncapi.bindings.mqtt.v0._1_0.operation

import com.asyncapi.v3.SerDeTest

class MQTTOperationBindingTest: SerDeTest<MQTTOperationBinding>() {

    override fun objectClass() = MQTTOperationBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/operation/mqtt/mqttOperationBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/operation/mqtt/mqttOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/operation/mqtt/mqttOperationBinding - wrongly extended.json"

    override fun build(): MQTTOperationBinding {
        return MQTTOperationBinding.builder()
                .qos(2)
                .retain(true)
                .build()
    }

}