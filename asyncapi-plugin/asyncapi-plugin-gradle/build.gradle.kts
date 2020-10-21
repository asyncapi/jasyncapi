plugins {
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "0.10.1"
    id("org.jetbrains.kotlin.jvm") version "1.3.61"
}

repositories {
    mavenLocal()
    mavenCentral()
}


dependencies {
    val reflectionsVersion = "0.9.12"
    val jacksonVersion = "2.10.3"

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    compile(gradleApi())
    compile("org.reflections:reflections:$reflectionsVersion")
    compile("com.fasterxml.jackson.core:jackson-databind:$jacksonVersion")
    compile("com.fasterxml.jackson.core:jackson-annotations:$jacksonVersion")
    compile("com.fasterxml.jackson.core:jackson-core:$jacksonVersion")
    compile("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:$jacksonVersion")

    compile("com.asyncapi:asyncapi-plugin-core:1.0.0-RC1")

    testCompile("org.jetbrains.kotlin:kotlin-test:1.3.71")
    testCompile("org.junit.jupiter:junit-jupiter-engine:5.6.1")
    testCompile("org.junit.jupiter:junit-jupiter-api:5.6.1")
    testCompile("org.junit.jupiter:junit-jupiter-params:5.6.1")
}

tasks {
    test {
        useJUnitPlatform()
    }
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}

pluginBundle {
    website = "https://github.com/Pakisan/java-asyncapi"
    vcsUrl = "https://github.com/Pakisan/java-asyncapi.git"
    tags = listOf("async-api", "async api", "asyncapi", "java", "kotlin")
}

gradlePlugin {
    plugins {
        create("asyncapiPlugin") {
            id = "com.asyncapi.asyncapi-gradle-plugin"
            displayName = "AsyncAPI gradle plugin"
            description = "Gradle plugin for AsyncAPI. Helps to generate asyncapi schemas from sources"
            implementationClass = "com.asyncapi.plugin.gradle.AsyncAPIPlugin"
        }
    }
}