package com.asyncapi.v2.binding.server.solace

import com.asyncapi.v2.SerDeTest
import com.asyncapi.bindings.solace.v0._3_0.server.SolaceServerBinding

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class SolaceServerBindingTest: SerDeTest<SolaceServerBinding>() {

    override fun objectClass() = SolaceServerBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/server/solace/solaceServerBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/server/solace/solaceServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/server/solace/solaceServerBinding - wrongly extended.json"

    override fun build(): SolaceServerBinding {
        return SolaceServerBinding.builder()
                .msgVpn("solace.private.net")
                .build()
    }

}