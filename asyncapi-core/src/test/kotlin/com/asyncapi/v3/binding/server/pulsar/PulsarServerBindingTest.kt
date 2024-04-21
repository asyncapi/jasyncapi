package com.asyncapi.v3.binding.server.pulsar

import com.asyncapi.v3.SerDeTest
import com.asyncapi.bindings.pulsar.v0._1_0.server.PulsarServerBinding

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class PulsarServerBindingTest: SerDeTest<PulsarServerBinding>() {

    override fun objectClass() = PulsarServerBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/server/pulsar/pulsarServerBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/server/pulsar/pulsarServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/server/pulsar/pulsarServerBinding - wrongly extended.json"

    override fun build(): PulsarServerBinding {
        return PulsarServerBinding.builder()
                .tenant("contoso")
                .build()
    }

}