<h1 align="center">
  <br>
  <a href="https://asyncapi.org"><img src="./assets/logo.png" alt="AsyncAPI logo" height="80"></a>
</h1>
<h4 align="center">Building the future of event-driven architectures</h4>
<h6 align="center">We're on a mission to standardize message-based communication and increase interoperability of the different systems out there.</h6>

> ⚠️ This project doesn't support AsyncAPI 1.x

This monorepo stores modules, which simplifies interacting with AsyncAPI in `jvm` ecosystem. 

# Index

* [Monorepo structure](#monorepo-structure)
    * [core](#core)
    * [plugin](#plugin)
* [Release](#release)
    * [maven artifacts](#release-maven-artifacts)
    * [gradle artifacts](#release-gradle-artifacts)
        * [relese to maven central](#release-to-maven-central)
        * [release to gradle plugins](#release-to-gradle-plugins)

## Monorepo structure
Currently here it's splitted on two submodules:
* [core](#core)
* [plugin](#plugin)

### core
This submodule stores projection of AsyncAPI specification to java classes. Each class is being properly annotated with `jsr-305` annotations,
which allows to use it in null-safety languages like `kotlin` without extra headache.

```
<dependency>
  <groupId>com.asyncapi</groupId>
  <artifactId>asyncapi-core</artifactId>
  <version>1.0.0-EAP</version>
</dependency>
```

### plugin
This submodule stores plugins, which automatizes work with AsyncAPI specification.

Currently here are three plugins:
* [maven plugin](#maven)
* [gradle plugin](#gradle)
* [IDEA plugin](#idea)

#### maven
Maven plugin helps to generate AsyncAPI specification from hand-crafted AsyncAPI class at choosed build cycle step.

```
<dependency>
  <groupId>com.asyncapi</groupId>
  <artifactId>asyncapi-maven-plugin</artifactId>
  <version>1.0.0-EAP</version>
  <type>maven-plugin</type>
</dependency>
```

**[Source code with description and example](asyncapi-plugin/asyncapi-plugin-maven)**

#### gradle
Gradle plugin helps to generate AsyncAPI specification from hand-crafted AsyncAPI class at choosed build cycle step.

**[Source code with description and example](asyncapi-plugin/asyncapi-plugin-gradle)**

#### IDEA
IDEA plugin simplifies work with AsyncAPI specification not only in Intellij IDEA, but in others IDE from JetBrains

[JetBrains plugin marketplace](https://plugins.jetbrains.com/plugin/15673-asyncapi)

**[Source code with description and example](asyncapi-plugin/asyncapi-plugin-idea)**

## Release

**[Sonatype Instruction with references and clarifications](https://central.sonatype.org/pages/apache-maven.html)**

**⚠️ WARNING: next artifacts MUST always have common version at release. Because of dependency of plugins from core**
* **[asyncapi-core](./asyncapi-core)**
* **[asyncapi-plugin-maven](./asyncapi-plugin/asyncapi-plugin-maven)**
* **[asyncapi-plugin-gradle](./asyncapi-plugin/asyncapi-plugin-gradle)**

### Release maven artifacts:

* Request credentials for one of AsyncAPI's account on [Sonatype's Jira](https://issues.sonatype.org), which is synced 
with [Sonatype's nexus](https://oss.sonatype.org)
* Generate pgp key if it was not generated yet
* Create `/Users/{userName}/.m2/settings.xml`
```xml
<settings>
  <profiles>
    <profile>
      <id>ossrh</id>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <properties>
        <gpg.keyname>GPG key name</gpg.keyname>
        <gpg.executable>gpg</gpg.executable>
        <gpg.passphrase>GPG passphrase for selected key</gpg.passphrase>
        <gpg.homedir>/Users/{userName}/.gnupg</gpg.homedir>
      </properties>
    </profile>
  </profiles>
  <servers>
    <server>
      <id>ossrh</id>
      <username>Jira username</username>
      <password>Jira password</password>
    </server>
  </servers>
</settings>
```

* Choose new release version and set it to root [pom.xml](./pom.xml).

_Example:_
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.asyncapi</groupId>
    <artifactId>asyncapi</artifactId>
    <version>{new release version}</version>

    <!-- Other project properties was omitted. They are located below and won't be updated generally -->

</project>
```

* Don't forget to update parent version in all submodules.
    * [asyncapi-core](./asyncapi-core/pom.xml)
    * [asyncapi-plugin](./asyncapi-plugin/pom.xml)
    * [asyncapi-plugin-core](./asyncapi-plugin/asyncapi-plugin-core/pom.xml)
    * [asyncapi-plugin-maven](./asyncapi-plugin/asyncapi-plugin-maven/pom.xml)

_Example_
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>asyncapi-plugin</artifactId>
        <groupId>com.asyncapi</groupId>
        <version>{new release version}</version>
    </parent>

    <!-- Other project properties was omitted. They are located below and won't be updated generally -->

</project>
```

* Build it, test it and release it to maven central repository
```shell script
➜  async-api git:(1.0.0-EAP) ✗ mvn clean deploy -P release 
```

### Release gradle artifacts:

#### release to maven central
**[gradle gpg instruction](https://docs.gradle.org/current/userguide/signing_plugin.html#signing_plugin)**
<br>
**[sonatype's instruction for deployment releasing](https://central.sonatype.org/pages/releasing-the-deployment.html)**

* Request credentials for one of AsyncAPI's account on [Sonatype's Jira](https://issues.sonatype.org), which is synced 
with [Sonatype's nexus](https://oss.sonatype.org)
* Generate pgp key if it was not generated yet
    * export secret key ring file containing your private key
    ```shell script
      gpg --keyring secring.gpg --export-secret-keys > ~/.gnupg/secring.gpg
    ```
* Create `/Users/{userName}/.gradle/gradle.properties`
```properties
# gpg
signing.keyId={key name}
signing.password={key passphrase}
signing.secretKeyRingFile=/Users/{userName}/.gnupg/secring.gpg

# oss.sonatype.org
ossrhUsername={Jira username}
ossrhPassword={Jira password}
```
* Choose new release version and set it to root [build.gradle.kts](./asyncapi-plugin/asyncapi-plugin-gradle/build.gradle.kts).
_Example_
```kotlin
version = "{new release version}"
```
* Build it, test it and release it to maven central repository
```shell script
➜  asyncapi-plugin-gradle git:(1.0.0-EAP) ✗ ./gradlew publishPluginMavenPublicationToMavenRepository
```
* Go to [stagin repositories](https://oss.sonatype.org/#stagingRepositories) and release it manually
    * Select repository
    * Click `close` and wait some time
    * Click `release`

#### release to gradle plugins

* Request `key` and `secret` for gradle account
* Update `/Users/{userName}/.gradle/gradle.properties` with gradle credential
```properties
gradle.publish.key={key}
gradle.publish.secret={secret}
```
* Release plugin to [gradle plugins](https://plugins.gradle.org/)
```shell script
➜  asyncapi-plugin-gradle git:(1.0.0-EAP) ✗ ./gradlew publishPlugins
```