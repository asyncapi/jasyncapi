package com.asyncapi.v2.binding.server.mqtt5

import com.asyncapi.v2.SerDeTest

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class MQTT5ServerBindingTest: SerDeTest<MQTT5ServerBinding>() {

    override fun objectClass() = MQTT5ServerBinding::class.java

    override fun baseObjectJson() = "/json/binding/server/mqtt5/mqtt5ServerBinding.json"

    override fun extendedObjectJson() = "/json/binding/server/mqtt5/mqtt5ServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/binding/server/mqtt5/mqtt5ServerBinding - wrongly extended.json"

    override fun build(): MQTT5ServerBinding {
        return MQTT5ServerBinding.builder()
                .sessionExpiryInterval(60)
                .build()
    }

}