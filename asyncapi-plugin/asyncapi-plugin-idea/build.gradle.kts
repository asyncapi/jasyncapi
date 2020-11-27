plugins {
    id("org.jetbrains.intellij") version "0.6.4"
    java
    kotlin("jvm") version "1.4.10"
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
        </ul>
    """.trimIndent())
}