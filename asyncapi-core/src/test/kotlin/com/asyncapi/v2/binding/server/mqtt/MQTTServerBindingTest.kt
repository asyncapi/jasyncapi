package com.asyncapi.v2.binding.server.mqtt

import com.asyncapi.v2.SerDeTest

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class MQTTServerBindingTest: SerDeTest<MQTTServerBinding>() {

    override fun objectClass() = MQTTServerBinding::class.java

    override fun baseObjectJson() = "/json/2.6.0/binding/server/mqtt/mqttServerBinding.json"

    override fun extendedObjectJson() = "/json/2.6.0/binding/server/mqtt/mqttServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/binding/server/mqtt/mqttServerBinding - wrongly extended.json"

    override fun build(): MQTTServerBinding {
        return MQTTServerBinding.builder()
                .clientId("guest")
                .cleanSession(true)
                .lastWill(MQTTServerBinding.LastWillConfiguration(
                        "/last-wills",
                        2,
                        "Guest gone offline.",
                        false
                ))
                .keepAlive(60)
                .build()
    }

}