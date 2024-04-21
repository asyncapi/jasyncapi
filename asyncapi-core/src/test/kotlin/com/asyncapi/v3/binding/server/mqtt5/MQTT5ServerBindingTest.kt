package com.asyncapi.v3.binding.server.mqtt5

import com.asyncapi.v3.SerDeTest
import com.asyncapi.bindings.mqtt5.v0._2_0.server.MQTT5ServerBinding

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class MQTT5ServerBindingTest: SerDeTest<MQTT5ServerBinding>() {

    override fun objectClass() = MQTT5ServerBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/server/mqtt5/mqtt5ServerBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/server/mqtt5/mqtt5ServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/server/mqtt5/mqtt5ServerBinding - wrongly extended.json"

    override fun build(): MQTT5ServerBinding {
        return MQTT5ServerBinding.builder()
                .sessionExpiryInterval(60)
                .build()
    }

}