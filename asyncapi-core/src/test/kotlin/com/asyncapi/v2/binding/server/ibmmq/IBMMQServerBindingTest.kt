package com.asyncapi.v2.binding.server.ibmmq

import com.asyncapi.v2.SerDeTest

/**
 * @version 2.6.0
 * @author Pavel Bodiachevskii
 */
class IBMMQServerBindingTest: SerDeTest<IBMMQServerBinding>() {

    override fun objectClass() = IBMMQServerBinding::class.java

    override fun baseObjectJson() = "/json/v2/binding/server/ibmmq/ibmmqServerBinding.json"

    override fun extendedObjectJson() = "/json/v2/binding/server/ibmmq/ibmmqServerBinding - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v2/binding/server/ibmmq/ibmmqServerBinding - wrongly extended.json"

    override fun build(): IBMMQServerBinding {
        return IBMMQServerBinding.builder()
                .groupId("PRODCLSTR1")
                .cipherSpec("ANY_TLS12_OR_HIGHER")
                .build()
    }

}