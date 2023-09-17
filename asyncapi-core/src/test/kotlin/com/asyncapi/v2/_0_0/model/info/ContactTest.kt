package com.asyncapi.v2._0_0.model.info

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class ContactTest: SerDeTest<Contact>() {

    override fun objectClass() = Contact::class.java

    override fun baseObjectJson() = "/json/2.0.0/model/info/contact.json"

    override fun extendedObjectJson() = "/json/2.0.0/model/info/contact - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.0.0/model/info/contact - wrongly extended.json"

    override fun build(): Contact {
        return Contact(
                "AsyncApi",
                "https://www.asyncapi.com",
                "java@asyncapi.com"
        )
    }

}
