package com.asyncapi.bindings.mqtt5.v0._2_0.server

import com.asyncapi.v3.SerDeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class MQTT5ServerBindingTest: SerDeTest<MQTT5ServerBinding>() {

    override fun objectClass() = MQTT5ServerBinding::class.java

    override fun baseObjectJson() = "/bindings/mqtt5/server/mqtt5ServerBinding.json"

    override fun extendedObjectJson() = "/bindings/mqtt5/server/mqtt5ServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/mqtt5/server/mqtt5ServerBinding - wrongly extended.json"

    override fun build(): MQTT5ServerBinding {
        return MQTT5ServerBinding.builder()
                .sessionExpiryInterval(60)
                .build()
    }

}