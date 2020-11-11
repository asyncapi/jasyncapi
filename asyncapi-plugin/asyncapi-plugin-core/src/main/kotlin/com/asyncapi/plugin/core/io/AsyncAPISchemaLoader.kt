package com.asyncapi.plugin.core.io

import com.asyncapi.plugin.core.generator.exception.AsyncAPISchemaGenerationException
import com.asyncapi.plugin.core.generator.settings.GenerationSettings
import com.asyncapi.plugin.core.generator.settings.GenerationSources
import com.asyncapi.plugin.core.logging.Logger
import com.asyncapi.v2.model.AsyncAPI
import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import org.reflections.util.ConfigurationBuilder
import org.reflections.util.FilterBuilder
import java.net.URLClassLoader

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
        logger.info("schemas loader: looking for schemas")
        val loadedClasses = loadClasses()
        val loadedClassesFromPackages = loadedClassesFromPackages()

        return loadedClasses + loadedClassesFromPackages
    }

    @Throws(AsyncAPISchemaGenerationException::class)
    protected fun loadClasses(): MutableSet<Class<*>> {
        val classesToLoad = sources.classes
        val loadedClasses = mutableSetOf<Class<*>>()

        logger.info("[classes]: loading...")

        if (classesToLoad.isEmpty()) {
            logger.info("[classes]: nothing to load")

            return mutableSetOf()
        }

        logger.info("[classes]: loading ${classesToLoad.size} classes")

        classesToLoad.forEach { className ->
            logger.info("[classes]: loading $className")
            try {
                loadedClasses.add(sources.classLoader.loadClass(className))
            } catch (classNotFoundException: ClassNotFoundException) {
                logger.error("[classes]: can't load $className - ${classNotFoundException.message}")
                throw AsyncAPISchemaGenerationException("Can't load class: $className", classNotFoundException)
            }
        }

        if (loadedClasses.isEmpty()) {
            logger.info("[classes]: no classes loaded")
        } else {
            logger.info("[classes]: loaded ${loadedClasses.size} classes")
        }

        return loadedClasses
    }

    @Throws(AsyncAPISchemaGenerationException::class)
    protected fun loadedClassesFromPackages(): MutableSet<Class<*>> {
        val packagesToScan = sources.packages
        val loadedClassesFromPackages = mutableSetOf<Class<*>>()

        logger.info("[packages]: searching...")

        if (packagesToScan.isEmpty()) {
            logger.info("[packages]: no classes found to load")

            return mutableSetOf()
        }

        logger.info("[packages]: scanning ${packagesToScan.size} packages")

        packagesToScan.forEach { packageName ->
            logger.info("[packages]: scanning $packageName")
            try {
                val reflections = Reflections(ConfigurationBuilder()
                        .forPackages(packageName)
                        .filterInputsBy(FilterBuilder().includePackage(packageName))
                        .addScanners(SubTypesScanner(false))
                        .addUrls((sources.classLoader as URLClassLoader).urLs.asList())
                        .addClassLoader(sources.classLoader)
                )

                val foundClasses = reflections.getSubTypesOf(AsyncAPI::class.java)
                logger.info("[packages]: found ${foundClasses.size} classes in $packageName")
                foundClasses.map { it.name }.toList().forEach { logger.info(it) }

                loadedClassesFromPackages.addAll(foundClasses)
            } catch (exception: Exception) {
                logger.error("[classes]: can't load classes from $packageName - ${exception.message}")
                throw AsyncAPISchemaGenerationException("Can't load classes from: $packageName", exception)
            }
        }

        if (loadedClassesFromPackages.isEmpty()) {
            logger.info("[packages]: no classes loaded")
        } else {
            logger.info("[packages]: loaded ${loadedClassesFromPackages.size} classes")
        }

        return loadedClassesFromPackages
    }

}