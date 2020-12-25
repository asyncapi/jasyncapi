package com.asyncapi.plugin.idea.extensions.index

import com.intellij.json.JsonFileType
import com.intellij.util.indexing.*
import com.intellij.util.io.DataExternalizer
import com.intellij.util.io.DataInputOutputUtil
import com.intellij.util.io.EnumeratorStringDescriptor
import com.intellij.util.io.KeyDescriptor
import org.jetbrains.yaml.YAMLFileType
import java.io.DataInput
import java.io.DataOutput

/**
 * I use [Set] because of cases when schema has multiple references to schemas.
 * @author Pavel Bodiachevskii
 */
class AsyncAPISchemaIndex: FileBasedIndexExtension<String, Set<String>>() {

    override fun getName(): ID<String, Set<String>> = asyncapiIndexId

    override fun getIndexer(): DataIndexer<String, Set<String>, FileContent> = AsyncAPISchemaIndexer()

    override fun getKeyDescriptor(): KeyDescriptor<String> = EnumeratorStringDescriptor.INSTANCE

    override fun getVersion(): Int = 1

    override fun getInputFilter(): FileBasedIndex.InputFilter = FileBasedIndex.InputFilter { file -> file.fileType is JsonFileType || file.fileType is YAMLFileType }

    override fun dependsOnFileContent(): Boolean = true

    override fun getValueExternalizer(): DataExternalizer<Set<String>> = object: DataExternalizer<Set<String>> {

        override fun save(out: DataOutput, value: Set<String>?) {
            DataInputOutputUtil.writeINT(out, value!!.size)
            value.forEach { out.writeUTF(it) }
        }

        override fun read(`in`: DataInput): Set<String> {
            val indexedAsyncAPISchemas = mutableSetOf<String>()

            val size = DataInputOutputUtil.readINT(`in`)
            for (i in 0 until size) {
                indexedAsyncAPISchemas.add(`in`.readUTF())
            }

            return indexedAsyncAPISchemas
        }

    }

    companion object {

        @JvmStatic
        val asyncapiIndexId = ID.create<String, Set<String>>("com.asyncapi.schemas")

        @JvmStatic
        val asyncapi = "asyncapi"

        @JvmStatic
        val references = "references"

        @JvmStatic
        val channels = "channels"

        @JvmStatic
        val parameters = "parameters"

        @JvmStatic
        val traits = "traits"

        @JvmStatic
        val messages = "messages"

        @JvmStatic
        val schemas = "schemas"

        @JvmStatic
        val securitySchemes = "securitySchemes"

        @JvmStatic
        val correlationIds = "correlationIds"

        @JvmStatic
        val headers = "headers"

    }

}