package com.asyncapi.v2.binding.message.mqtt

import com.asyncapi.v2.SerDeTest
import com.asyncapi.bindings.mqtt.v0._1_0.message.MQTTMessageBinding

class MQTTMessageBindingTest: SerDeTest<MQTTMessageBinding>() {

    override fun objectClass() = MQTTMessageBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/message/mqtt/mqttMessageBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/message/mqtt/mqttMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/message/mqtt/mqttMessageBinding - wrongly extended.json"

    override fun build(): MQTTMessageBinding {
        return MQTTMessageBinding.builder()
                .build()
    }

}