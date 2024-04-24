package com.asyncapi.bindings.mqtt.v0._1_0.message

import com.asyncapi.v3.SerDeTest

class MQTTMessageBindingTest: SerDeTest<MQTTMessageBinding>() {

    override fun objectClass() = MQTTMessageBinding::class.java

    override fun baseObjectJson() = "/bindings/mqtt/message/mqttMessageBinding.json"

    override fun extendedObjectJson() = "/bindings/mqtt/message/mqttMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/mqtt/message/mqttMessageBinding - wrongly extended.json"

    override fun build(): MQTTMessageBinding {
        return MQTTMessageBinding.builder()
                .build()
    }

}