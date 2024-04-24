package com.asyncapi.bindings.mqtt.v0._1_0.server

import com.asyncapi.v3.SerDeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class MQTTServerBindingTest: SerDeTest<MQTTServerBinding>() {

    override fun objectClass() = MQTTServerBinding::class.java

    override fun baseObjectJson() = "/bindings/mqtt/server/mqttServerBinding.json"

    override fun extendedObjectJson() = "/bindings/mqtt/server/mqttServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/mqtt/server/mqttServerBinding - wrongly extended.json"

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