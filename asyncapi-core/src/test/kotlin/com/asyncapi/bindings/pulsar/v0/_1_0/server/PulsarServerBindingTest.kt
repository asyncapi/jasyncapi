package com.asyncapi.bindings.pulsar.v0._1_0.server

import com.asyncapi.v3.SerDeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class PulsarServerBindingTest: SerDeTest<PulsarServerBinding>() {

    override fun objectClass() = PulsarServerBinding::class.java

    override fun baseObjectJson() = "/bindings/pulsar/server/pulsarServerBinding.json"

    override fun extendedObjectJson() = "/bindings/pulsar/server/pulsarServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/pulsar/server/pulsarServerBinding - wrongly extended.json"

    override fun build(): PulsarServerBinding {
        return PulsarServerBinding.builder()
                .tenant("contoso")
                .build()
    }

}