plugins {
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "0.12.0"
    id("org.jetbrains.kotlin.jvm") version "1.3.61"
    `maven-publish`
    signing
}

repositories {
    mavenLocal()
    mavenCentral()
}

group = "com.asyncapi"
version = "1.0.0-EAP-1"

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

    compile("com.asyncapi:asyncapi-plugin-core:1.0.0-EAP-1")

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

/*
    Publishing configuration for: https://plugins.gradle.org
 */

gradlePlugin {
    plugins {
        create("asyncapiPlugin") {
            id = "${project.group}.${rootProject.name}"
            implementationClass = "com.asyncapi.plugin.gradle.AsyncAPIPlugin"
        }
    }
}

pluginBundle {
    website = "https://github.com/asyncapi/jasyncapi"
    vcsUrl = "https://github.com/asyncapi/jasyncapi.git"
    description = "Gradle plugin for AsyncAPI.\nHelps to generate AsyncAPI specification from hand-crafted AsyncAPI class at choosed build cycle step."
    tags = listOf("async-api", "async api", "asyncapi", "java", "kotlin")
    (plugins) {
        "asyncapiPlugin" {
            id = "${project.group}.${rootProject.name}"
            version = "${project.version}"
            displayName = "AsyncAPI gradle plugin"
            description = "Gradle plugin for AsyncAPI. Helps to generate asyncapi schemas from sources"
        }
    }
    mavenCoordinates {
        groupId = "${project.group}"
        artifactId = "${rootProject.name}"
        version = "${project.version}"
    }
}

/*
    Publishing configuration for: central maven repository
 */

java {
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("pluginMaven") {
            groupId = "${project.group}"
            artifactId = "${rootProject.name}"
            version = "${project.version}"

            pom {
                name.set("AsyncAPI Gradle plugin")
                inceptionYear.set("2020")
                url.set("https://github.com/asyncapi/jasyncapi")
                description.set("Gradle plugin for AsyncAPI.\n" +
                        "Helps to generate AsyncAPI specification from hand-crafted AsyncAPI class at choosed build cycle step.")
                organization {
                    name.set("AsyncAPI Initiative")
                    url.set("https://www.asyncapi.com/")
                }
                developers {
                    developer {
                        name.set("Pavel Bodiachevskii")
                        url.set("https://github.com/Pakisan")
                    }
                }
                licenses {
                    license {
                        name.set("Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        distribution.set("repo")
                        comments.set("A business-friendly OSS license")
                    }
                }
                scm {
                    url.set("https://github.com/asyncapi/jasyncapi")
                    connection.set("scm:git:https://github.com/asyncapi/jasyncapi.git")
                    tag.set("HEAD")
                }
                packaging = "jar"
            }
        }
    }
    repositories {
        maven {
            val releasesRepoUrl = uri("https://oss.sonatype.org/service/local/staging/deploy/maven2/")
            val snapshotsRepoUrl = uri("https://oss.sonatype.org/content/repositories/snapshots/")
            url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            credentials {
                username = project.property("ossrhUsername") as String?
                password = project.property("ossrhPassword") as String?
            }
        }
    }
}

signing {
    sign(publishing.publications["pluginMaven"])
}