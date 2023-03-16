package com.asyncapi.v2._6_0.model

import com.asyncapi.v2.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class TagTest: SerDeTest<Tag>() {

    override fun objectClass() = Tag::class.java

    override fun baseObjectJson() = "/json/2.6.0/model/tag.json"

    override fun extendedObjectJson() = "/json/2.6.0/model/tag - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/2.6.0/model/tag - wrongly extended.json"

    override fun build(): Tag {
        return Tag(
                "user",
                "User-related messages",
                ExternalDocumentationTest().build()
        )
    }

}
