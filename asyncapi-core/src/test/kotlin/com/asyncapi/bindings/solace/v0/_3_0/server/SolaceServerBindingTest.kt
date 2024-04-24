package com.asyncapi.bindings.solace.v0._3_0.server

import com.asyncapi.v3.SerDeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class SolaceServerBindingTest: SerDeTest<SolaceServerBinding>() {

    override fun objectClass() = SolaceServerBinding::class.java

    override fun baseObjectJson() = "/bindings/solace/server/solaceServerBinding.json"

    override fun extendedObjectJson() = "/bindings/solace/server/solaceServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/solace/server/solaceServerBinding - wrongly extended.json"

    override fun build(): SolaceServerBinding {
        return SolaceServerBinding.builder()
                .msgVpn("solace.private.net")
                .build()
    }

}