[![AsyncAPI Logo](../assets/logo.png)](https://www.asyncapi.com)

<h4 align="left">Building the future of event-driven architectures</h4>
<h6 align="left">We're on a mission to standardize message-based communication and increase interoperability of the different systems out there.</h6>

This submodule stores projection of AsyncAPI specification to java classes. Each class is being properly annotated with `jsr-305` annotations,
which allows to use it in null-safety languages like `kotlin` without extra headache.

```
<dependency>
  <groupId>com.asyncapi</groupId>
  <artifactId>asyncapi-core</artifactId>
  <version>1.0.0-RC2</version>
</dependency>
```

## Usages:

### Working with AsyncAPI Specification from Java/Kotlin code:
For manual working with AsyncAPI specification from java/kotlin code:

```kotlin
var asyncApi = objectMapper.readValue(model, AsyncAPI::class.java)
```