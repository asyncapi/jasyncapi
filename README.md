<h1 align="center">
  <br>
  <a href="https://asyncapi.org"><img src="./assets/logo.png" alt="AsyncAPI logo" height="80"></a>
</h1>
<h4 align="center">Building the future of event-driven architectures</h4>
<h6 align="center">We're on a mission to standardize message-based communication and increase interoperability of the different systems out there.</h6>

> ⚠️ This project doesn't support AsyncAPI 1.x

This monorepo stores modules, which simplifies interacting with AsyncAPI in `jvm` ecosystem. 

# Monorepo structure
Currently here it's splitted on two submodules:
* [core](#core)
* [plugin](#plugin)

## core
This submodule stores projection of AsyncAPI specification to java classes. Each class is being properly annotated with `jsr-305` annotations,
which allows to use it in null-safety languages like `kotlin` without extra headache.

```
<dependency>
  <groupId>com.asyncapi</groupId>
  <artifactId>asyncapi-core</artifactId>
  <version>1.0.0-EAP</version>
</dependency>
```

## plugin
This submodule stores plugins, which automatizes work with AsyncAPI specification.

Currently here are three plugins:
* [maven plugin](#maven)
* [gradle plugin](#gradle)
* [IDEA plugin](#idea)

### maven
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

### gradle
Gradle plugin helps to generate AsyncAPI specification from hand-crafted AsyncAPI class at choosed build cycle step.

**[Source code with description and example](asyncapi-plugin/asyncapi-plugin-gradle)**

### IDEA
IDEA plugin simplifies work with AsyncAPI specification not only in Intellij IDEA, but in others IDE from JetBrains

[JetBrains plugin marketplace](https://plugins.jetbrains.com/plugin/15673-asyncapi)

**[Source code with description and example](asyncapi-plugin/asyncapi-plugin-idea)**