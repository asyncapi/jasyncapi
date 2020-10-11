package com.asyncapi.plugin.core.io

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

object FileSystem {

    const val defaultPath = "asyncapi-schemas"

        fun save(name: String, content: String, path: String) {
        val dirPath = if (path.isBlank()) {
            Paths.get(defaultPath)
        } else {
            Paths.get(path)
        }

        File(Files.createDirectories(dirPath).toFile(), name).writeText(content, Charsets.UTF_8)
    }

}