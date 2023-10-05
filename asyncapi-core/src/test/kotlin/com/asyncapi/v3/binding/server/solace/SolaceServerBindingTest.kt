package com.asyncapi.v3.binding.server.solace

import com.asyncapi.v3.SerDeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class SolaceServerBindingTest: SerDeTest<SolaceServerBinding>() {

    override fun objectClass() = SolaceServerBinding::class.java

    override fun baseObjectJson() = "/json/v3/binding/server/solace/solaceServerBinding.json"

    override fun extendedObjectJson() = "/json/v3/binding/server/solace/solaceServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/binding/server/solace/solaceServerBinding - wrongly extended.json"

    override fun build(): SolaceServerBinding {
        return SolaceServerBinding.builder()
                .msgVpn("solace.private.net")
                .build()
    }

}