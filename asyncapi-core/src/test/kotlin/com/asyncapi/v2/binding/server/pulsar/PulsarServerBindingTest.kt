package com.asyncapi.v2.binding.server.pulsar

import com.asyncapi.v2.SerDeTest

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class PulsarServerBindingTest: SerDeTest<PulsarServerBinding>() {

    override fun objectClass() = PulsarServerBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/server/pulsar/pulsarServerBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/server/pulsar/pulsarServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/server/pulsar/pulsarServerBinding - wrongly extended.json"

    override fun build(): PulsarServerBinding {
        return PulsarServerBinding.builder()
                .tenant("contoso")
                .build()
    }

}