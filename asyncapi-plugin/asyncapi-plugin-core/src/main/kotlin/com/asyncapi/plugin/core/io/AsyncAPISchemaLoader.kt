package com.asyncapi.plugin.core.io

import com.asyncapi.plugin.core.generator.exception.AsyncAPISchemaGenerationException
import com.asyncapi.plugin.core.generator.settings.GenerationSettings
import com.asyncapi.plugin.core.generator.settings.GenerationSources
import com.asyncapi.plugin.core.logging.Logger
import com.asyncapi.v2.model.AsyncAPI
import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import org.reflections.util.ConfigurationBuilder
import java.net.URLClassLoader
import kotlin.jvm.Throws

/**
 * Loads classes which extends [com.asyncapi.v2.model.AsyncAPI].
 *
 * @param logger logger to use for logging.
 * @param sources sources to work with.
 *
 * @author Pavel Bodiachevskii
 * @since 1.0.0-RC1
 */
open class AsyncAPISchemaLoader(
        private val logger: Logger,
        private val sources: GenerationSources
) {

    /**
     * Loads classes from provided sources in [GenerationSettings.sources]
     *
     * @throws AsyncAPISchemaGenerationException in case when something went wrong.
     * @return read-only [Set] of [Class]
     */
    @Throws(AsyncAPISchemaGenerationException::class)
    open fun load(): Set<Class<*>> {
        val loadedClasses = loadClasses()
        val loadedClassesFromPackages = loadedClassesFromPackages()

        return loadedClasses + loadedClassesFromPackages
    }

    @Throws(AsyncAPISchemaGenerationException::class)
    protected fun loadClasses(): MutableSet<Class<*>> {
        val classesToLoad = sources.classes
        val loadedClasses = mutableSetOf<Class<*>>()

        logger.info("Searching for schemas...")

        if (classesToLoad.isEmpty()) {
            logger.info("Given classes are empty. No classes found to load.")

            return mutableSetOf()
        }

        logger.info("Loading ${classesToLoad.size} given classes.")

        classesToLoad.forEach { className ->
            logger.info("Loading: $className")
            try {
                loadedClasses.add(sources.classLoader.loadClass(className))
            } catch (classNotFoundException: ClassNotFoundException) {
                throw AsyncAPISchemaGenerationException("Can't load class: $className", classNotFoundException)
            }
        }

        if (loadedClasses.isEmpty()) {
            logger.info("No classes found to load.")
        }

        return loadedClasses
    }

    @Throws(AsyncAPISchemaGenerationException::class)
    protected fun loadedClassesFromPackages(): MutableSet<Class<*>> {
        val packagesToScan = sources.packages
        val loadedClassesFromPackages = mutableSetOf<Class<*>>()

        logger.info("Searching for schemas...")

        if (packagesToScan.isEmpty()) {
            logger.info("Given packages to scan are empty. No classes found to load.")

            return mutableSetOf()
        }

        logger.info("Scanning ${packagesToScan.size} packages.")

        packagesToScan.forEach { packageName ->
            logger.info("Scanning package: $packageName")
            try {
                val reflections = Reflections(ConfigurationBuilder()
                        .forPackages(packageName)
                        .addScanners(SubTypesScanner(false))
                        .addUrls((sources.classLoader as URLClassLoader).urLs.asList())
                        .addClassLoader(sources.classLoader)
                )

                val foundClasses = reflections.getSubTypesOf(AsyncAPI::class.java)
                logger.info("Found: ${foundClasses.size} classes in $packageName")

                loadedClassesFromPackages.addAll(foundClasses)
            } catch (exception: Exception) {
                throw AsyncAPISchemaGenerationException("Can't load classes from: $packageName", exception)
            }
        }

        if (loadedClassesFromPackages.isEmpty()) {
            logger.info("No classes found to load.")
        }

        return loadedClassesFromPackages
    }

}