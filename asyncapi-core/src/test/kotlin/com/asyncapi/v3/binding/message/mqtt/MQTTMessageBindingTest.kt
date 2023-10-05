package com.asyncapi.v3.binding.message.mqtt

import com.asyncapi.v3.SerDeTest

class MQTTMessageBindingTest: SerDeTest<MQTTMessageBinding>() {

    override fun objectClass() = MQTTMessageBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/message/mqtt/mqttMessageBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/message/mqtt/mqttMessageBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/message/mqtt/mqttMessageBinding - wrongly extended.json"

    override fun build(): MQTTMessageBinding {
        return MQTTMessageBinding.builder()
                .build()
    }

}