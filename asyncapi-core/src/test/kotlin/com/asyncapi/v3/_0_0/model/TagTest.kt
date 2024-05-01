package com.asyncapi.v3._0_0.model

import com.asyncapi.schemas.Reference
import com.asyncapi.v3.SerDeTest

/**
 * @author Pavel Bodiachevskii
 */
class TagTestWithReferenceToExternalDocs: SerDeTest<Tag>() {

    override fun objectClass() = Tag::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/tag with reference to externalDocs.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/tag with reference to externalDocs - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/tag with reference to externalDocs - wrongly extended.json"

    override fun build(): Tag {
        return Tag(
                "user",
                "User-related messages",
            Reference("#/components/external-doc")
        )
    }

}

/**
 * @author Pavel Bodiachevskii
 */
class TagTest: SerDeTest<Tag>() {

    override fun objectClass() = Tag::class.java

    override fun baseObjectJson() = "/json/v3/3.0.0/model/tag.json"

    override fun extendedObjectJson() = "/json/v3/3.0.0/model/tag - extended.json"

    override fun wronglyExtendedObjectJson() = "/json/v3/3.0.0/model/tag - wrongly extended.json"

    override fun build(): Tag {
        return Tag(
                "user",
                "User-related messages",
                ExternalDocumentationTest().build()
        )
    }

}
