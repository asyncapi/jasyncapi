package com.asyncapi.bindings.ibmmq.v0._1_0.server

import com.asyncapi.v3.SerDeTest

/**
 * @version 3.0.0
 * @author Pavel Bodiachevskii
 */
class IBMMQServerBindingTest: SerDeTest<IBMMQServerBinding>() {

    override fun objectClass() = IBMMQServerBinding::class.java

    override fun baseObjectJson() = "/bindings/ibmmq/server/ibmmqServerBinding.json"

    override fun extendedObjectJson() = "/bindings/ibmmq/server/ibmmqServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/bindings/ibmmq/server/ibmmqServerBinding - wrongly extended.json"

    override fun build(): IBMMQServerBinding {
        return IBMMQServerBinding.builder()
                .groupId("PRODCLSTR1")
                .cipherSpec("ANY_TLS12_OR_HIGHER")
                .build()
    }

}