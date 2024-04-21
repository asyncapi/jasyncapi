package com.asyncapi.v2.binding.server.mqtt

import com.asyncapi.v2.SerDeTest
import com.asyncapi.bindings.mqtt.v0._1_0.server.MQTTServerBinding
import com.asyncapi.bindings.mqtt.v0._1_0.server.MQTTServerLastWillConfiguration

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class MQTTServerBindingTest: SerDeTest<MQTTServerBinding>() {

    override fun objectClass() = MQTTServerBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/server/mqtt/mqttServerBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/server/mqtt/mqttServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/server/mqtt/mqttServerBinding - wrongly extended.json"

    override fun build(): MQTTServerBinding {
        return MQTTServerBinding.builder()
                .clientId("guest")
                .cleanSession(true)
                .lastWill(MQTTServerLastWillConfiguration(
                        "/last-wills",
                        2,
                        "Guest gone offline.",
                        false
                ))
                .keepAlive(60)
                .build()
    }

}