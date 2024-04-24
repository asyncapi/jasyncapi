package com.asyncapi.bindings.mqtt.v0._1_0.operation

import com.asyncapi.v3.SerDeTest

class MQTTOperationBindingTest: SerDeTest<MQTTOperationBinding>() {

    override fun objectClass() = MQTTOperationBinding::class.java

    override fun baseObjectJson() = "/bindings/mqtt/operation/mqttOperationBinding.json"

    override fun extendedObjectJson() = "/bindings/mqtt/operation/mqttOperationBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/mqtt/operation/mqttOperationBinding - wrongly extended.json"

    override fun build(): MQTTOperationBinding {
        return MQTTOperationBinding.builder()
                .qos(2)
                .retain(true)
                .build()
    }

}