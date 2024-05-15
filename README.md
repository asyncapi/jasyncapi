[![AsyncAPI Logo](./assets/logo.png)](https://www.asyncapi.com)

<h4 align="left">Building the future of event-driven architectures</h4>
<h6 align="left">We're on a mission to standardize message-based communication and increase interoperability of the different systems out there.</h6>

[![Version](https://img.shields.io/maven-central/v/com.asyncapi/asyncapi-core?logo=apache-maven)](https://central.sonatype.com/artifact/com.asyncapi/asyncapi-core/1.0.0-RC)

## Overview
JVM-friendly bindings for AsyncAPI. It allows you to read or write specifications for your asynchronous API  through code

Hints:
- If you are working with AsyncAPI specification in JetBrains IDE, check out our [AsyncAPI - IDEA plugin](https://github.com/asyncapi/jasyncapi-idea-plugin)
- If you are working with AsyncAPI specification in VSCode, check out our [AsyncAPI - VSCode plugin](https://github.com/asyncapi/vs-asyncapi-preview)

### Implemented AsyncAPI versions (3/8)

| Version | Implementation status |
|---------|-----------------------|
| 2.0.0   | ✅                     |
| 2.1.0   | ❌                     |
| 2.2.0   | ❌                     |
| 2.3.0   | ❌                     |
| 2.4.0   | ❌                     |
| 2.5.0   | ❌                     |
| 2.6.0   | ✅                     |
| 3.0.0   | ✅                     |

### Implemented AsyncAPI schemas (5/7)

| Protocol                     | Versions                                                    |
|------------------------------|-------------------------------------------------------------|
| AsyncAPI Multi Format Schema | 3.0.0                                                       |
| AsyncAPI Schema              | unified version                                             |
| Avro Schema                  | 1.9.0, 1.9.1, 1.9.2, 1.10.0, 1.10.1, 1.10.2, 1.11.0, 1.11.1 |
| Json Schema                  | Draft-07                                                    |
| OpenAPI Schema               | 3.0.0, 3.0.1, 3.0.2, 3.0.3                                  |
| RAML 1.0 Schema              | ❌                                                           |
| Protocol Buffers             | ❌                                                           |

### Implemented AsyncAPI bindings (19/19)

| Protocol             | Versions                          |
|----------------------|-----------------------------------|
| AMQP                 | 0.1.0, 0.2.0, 0.3.0               |
| AMQP1                | 0.1.0                             |
| Anypoint MQ          | 0.1.0                             |
| Google Cloud Pub/Sub | 0.1.0, 0.2.0                      |
| HTTP                 | 0.1.0, 0.2.0, 0.3.0, 0.4.0, 0.5.0 |
| IBM MQ               | 0.1.0                             |
| JMS                  | 0.0.1                             |
| Apache Kafka         | 0.1.0, 0.3.0, 0.4.0, 0.5.0        |
| Mercure              | 0.1.0                             |
| MQTT                 | 0.1.0, 0.2.0                      |
| MQTT 5               | 0.1.0, 0.2.0                      |
| NATS                 | 0.1.0                             |
| Apache Pulsar        | 0.1.0                             |
| Redis                | 0.1.0                             |
| Amazon SNS           | 0.1.0                             |
| Solace               | 0.1.0, 0.2.0, 0.3.0, 0.4.0        |
| Amazon SQS           | 0.1.0, 0.2.0                      |
| STOMP                | 0.1.0                             |
| WebSockets           | 0.1.0                             |

### Implemented AsyncAPI Security Schemas (12/12)
| Security Schema       | Implementation status |
|-----------------------|-----------------------|
| API Key               | ✅                     |
| Asymmetric Encryption | ✅                     |
| GSS-API               | ✅                     |
| HTTP                  | ✅                     |
| HTTP API Key          | ✅                     |
| OAuth2                | ✅                     |
| OpenID Connect        | ✅                     |
| Plain                 | ✅                     |
| SCRAM-SHA-256         | ✅                     |
| SCRAM-SHA-512         | ✅                     |
| Symmetric Encryption  | ✅                     |
| User Password         | ✅                     |

## Known consumers:
- [Springwolf Core](https://github.com/springwolf/springwolf-core) - Automated documentation for async APIs built with Spring Boot
- [AsyncAPI Quarkus](https://github.com/quarkiverse/quarkus-asyncapi) - Generates AsyncAPIRegistry and configuration classes for Quarkus
- [Specmatic](https://specmatic.in) - Converts AsyncAPI specifications into executable contracts

## Known open specifications to check compatibility with:
- [x] [adeo-kafka-request-reply-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/adeo-kafka-request-reply-asyncapi.yml)
- [x] [anyof-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/anyof-asyncapi.yml)
- [x] [application-headers-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/application-headers-asyncapi.yml)
- [x] [correlation-id-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/correlation-id-asyncapi.yml)
- [x] [gitter-streaming-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/gitter-streaming-asyncapi.yml)
- [x] [kraken-websocket-request-reply-message-filter-in-reply-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/kraken-websocket-request-reply-message-filter-in-reply-asyncapi.yml)
- [x] [kraken-websocket-request-reply-multiple-channels-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/kraken-websocket-request-reply-multiple-channels-asyncapi.yml)
- [x] [mercure-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/mercure-asyncapi.yml)
- [x] [not-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/not-asyncapi.yml)
- [x] [oneof-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/oneof-asyncapi.yml)
- [x] [operation-security-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/operation-security-asyncapi.yml)
- [x] [rpc-client-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/rpc-client-asyncapi.yml)
- [x] [rpc-server-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/rpc-server-asyncapi.yml)
- [x] [simple-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/simple-asyncapi.yml)
- [x] [slack-rtm-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/slack-rtm-asyncapi.yml)
- [x] [streetlights-kafka-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/streetlights-kafka-asyncapi.yml)
- [x] [streetlights-mqtt-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/streetlights-mqtt-asyncapi.yml)
- [x] [streetlights-operation-security-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/streetlights-operation-security-asyncapi.yml)
- [x] [websocket-gemini-asyncapi.yml](https://github.com/asyncapi/spec/blob/master/examples/websocket-gemini-asyncapi.yml)

## Contributors section

### Build

#### Prerequisites
1. JDK 1.8
2. Maven 3+

If you are using SDKMAN! use [env](https://sdkman.io/usage#env) to prepare environment
```shell
sdk env install
```

### Install locally

Each build is GPG signed. To avoid this, and to not configure GPG locally, you can use this command:
```shell
 mvn clean install -Dgpg.skip
```

### Publish new release

#### Prerequisites
1. Request credentials for one of AsyncAPI's account on [Sonatype Jira](https://issues.sonatype.org), which is synced
  with [Sonatype nexus](https://oss.sonatype.org)
2. Generate pgp key if it was not generated yet
3. Create `/Users/{userName}/.m2/settings.xml`

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

Release
```shell
mvn clean deploy -P release 
```

references:
- [Sonatype Instruction with references and clarifications](https://central.sonatype.org/pages/apache-maven.html)
- [Sonatype Instruction for deployment releasing](https://central.sonatype.org/pages/releasing-the-deployment.html)