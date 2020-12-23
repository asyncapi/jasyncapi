plugins {
    id("org.jetbrains.intellij") version "0.6.5"
    java
    kotlin("jvm") version "1.4.21"
}

group = "com.asyncapi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")
}

// See https://github.com/JetBrains/gradle-intellij-plugin/
intellij {
    version = "2020.2.3"
    setPlugins("yaml")
}
tasks.getByName<org.jetbrains.intellij.tasks.PatchPluginXmlTask>("patchPluginXml") {
    changeNotes("""
        <ul>
            <li>Recognition of AsyncAPI schemas.</li>
            <li>AsyncAPI schema example creation from <code>file -> new -> AsyncAPI</code> schema</li>
            <li>AsyncAPI schema inspection and validation using AsyncAPI JSON Schema</li>
            <li>Local references resolving with auto-completion in AsyncAPI schema (json)</li>
            <li>File references resolving with auto-completion in AsyncAPI schema (json)</li>
            <li>Local references resolving with auto-completion in AsyncAPI schema (yaml)</li>
            <li>File references resolving with auto-completion in AsyncAPI schema (yaml)</li>
        </ul>
    """.trimIndent())
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}