# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.0.0-RC2] - TBA

### Changed

- All schemas now are located in `schemas` package
- All bindings now are located in `bindings` package
- Bindings structure was changed. Each binding now holds `channel`, `server`, `message`, `operation` inside package
- Bindings now are common for v2 and v3 versions

## [1.0.0-RC] - 2024-04-20

### Added

- OpenAPI Schema: 3.0.0, 3.0.1, 3.0.2, 3.0.3
- Avro Schema: 1.9.0, 1.9.1, 1.9.2, 1.10.0, 1.10.1, 1.10.2, 1.11.0, 1.11.1
- JsonSchema: Draft-07

### Changed

- MultiFormatSchema can hold AsyncAPI, OpenAPI, Avro and Json Schemas
- Schema was divided to AsyncAPISchema and JsonSchema

## [1.0.0-EAP-3] - 2024-03-10

Kudos to:
- https://github.com/jaydeepk
- https://github.com/ctasada
- https://github.com/guillaumelamirand
- https://github.com/ivanalayan15
- https://github.com/Crain-32
- https://github.com/wrwks
- https://github.com/dennis-brinley

### Added

- AsyncAPI 3.0.0

### Changed

- Reference was moved from `com.asyncapi.v2._6_0.model` to `com.asyncapi.v2`
- 2.0.0:
  - `Schema.multipleOf` type was changed to `Number`
- 2.6.0:
  - Specification:
    - `AsyncAPI.servers` now can hold server objects and references
    - `AsyncAPI.info` now has default value - empty Info object
    - `AsyncAPI.channels` now has default value - empty map
    - `Info.title` now has default value - empty string
    - `Info.version` now has default value - empty string
    - `License.name` now has default value - empty string
    - `Server.url` now has default value - empty string
    - `Server.protocol` now has default value - empty string
    - `Tag.name` now has default value - empty string
    - `CorrelationId.location` now has default value - empty string
    - `OneOfMessages.oneOf` now has default value - empty list
  - Bindings:
    - AMQP:
      - `AMQPChannelBinding.is` now `is required` and type was changed from `string` to `AMQPChannelType` enum and has default value - `routingKey`
      - AMQP `ExchangeProperties` was extracted and renamed to `AMQPChannelExchangeProperties`
      - AMQP `QueueProperties` was extracted and renamed to `AMQPChannelQueueProperties`
    - Anypoint MQ:
      - `AnypointMQChannelBinding.destinationType` was changed from `string` to `AnypointMQChannelDestinationType` with next default value - `queue`
    - Google Pub/Sub:
      - channels:
        - `GooglePubSubChannelBinding.topic` now has default value - empty string
        - `GooglePubSubChannelBinding.messageStoragePolicy` was extracted and renamed to `GooglePubSubChannelMessageStoragePolicy`
        - `GooglePubSubChannelBinding.schemaSettings` was extracted and renamed to `GooglePubSubChannelSchemaSettings`
        - `GooglePubSubChannelBinding.schemaSettings` now has default value - `GooglePubSubChannelSchemaSettings()`
      - messages:
        - `GooglePubSubMessageBinding.schema` was extracted and renamed to `GooglePubSubMessageSchemaDefinition`
    - IBM MQ:
      - channels:
        - `IBMMQChannelBinding.destinationType` type was changed to `IBMMQChannelDestinationType`
        - `IBMMQChannelBinding.destinationType` now has default value - `topic`
        - `IBMMQChannelBinding.queue` was extracted and renamed to `IBMMQChannelQueueProperties`
        - `IBMMQChannelBinding.topic` was extracted and renamed to `IBMMQChannelTopicProperties`
        - `IBMMQChannelBinding.topic` was extracted and renamed to `IBMMQChannelTopicProperties`
      - messages:
        - `IBMMQMessageBinding.type` type was changed to `IBMMQMessageType`
        - `IBMMQMessageBinding.type` now has default value - `string`
        - `IBMMQMessageBinding.expiry` now has default value - `0`
    - Kafka:
      - channels:
        - `KafkaChannelBinding.topicConfiguration` was extracted and renamed to `KafkaChannelTopicConfiguration`
      - messages:
        - `KafkaMessageBinding.key` type was changed to `Schema`
        - `KafkaMessageBinding.schemaIdLocation` type was changed to `KafkaMessageSchemaIdLocation`
      - operations:
        - `KafkaOperationBinding.groupId` type was changed to `Schema`
        - `KafkaOperationBinding.clientId` type was changed to `Schema`
    - Pulsar:
      - `PulsarChannelBinding.namespace` now has default value - empty string
      - `PulsarChannelBinding.persistence` type was changed to `PulsarChannelPersistence`
      - `PulsarChannelBinding.persistence` now has default value - `persistent`
      - `PulsarChannelBinding.retention` was extracted and renamed to `PulsarChannelRetentionDefinition`
    - WebSocket:
      - `WebSocketsChannelBinding.method` type was changed to `WebSocketsChannelMethod`
      - `WebSocketsChannelBinding.query` type was changed to `Schema`
      - `WebSocketsChannelBinding.headers` type was changed to `Schema`
    - Anypoint MQ:
      - `AnypointMQMessageBinding.headers` type was changed to `Schema`
    - HTTP:
      - messages:
        - `HTTPMessageBinding.headers` type was changed to `Schema`
      - operations:
        - `HTTPOperationBinding.type` type was changed to `HTTPOperationType`
        - `HTTPOperationBinding.type` now has default value - `request`
        - `HTTPOperationBinding.method` type was changed to `HTTPOperationMethod`
        - `HTTPOperationBinding.query` type was changed to `Schema`
    - Solace:
      - operations:
        - `SolaceOperationBinding.destinations` type was changed to `List<SolaceOperationDestination>`
        - `SolaceDestination` was extracted end renamed to `SolaceOperationDestination`
        - `SolaceQueue` was renamed to `SolaceOperationQueue`
        - `SolaceTopic` was renamed to `SolaceOperationTopic`
    - MQTT:
      - servers:
        - `LastWillConfiguration` was renamed to `MQTTServerLastWillConfiguration`

### Fixed

- Compiling warnings - https://github.com/asyncapi/jasyncapi/pull/152
- Array schema is not being parsed correctly - https://github.com/asyncapi/jasyncapi/pull/159

## [1.0.0-EAP-2] - 2023-03-16

https://github.com/asyncapi/jasyncapi/pull/137

### Added

- AsyncAPI 2.6.0
- New Bindings
- New Security Schemes
- Specification components now can be extended with `x-*`

### Changed

- Bindings now are common for `2.6.0` and `2.0.0`
- Schema now is common for `2.6.0` and `2.0.0`
- Security Scheme now is common for `2.6.0` and `2.0.0`
- `Schema.additionalProperties` now can be `boolean` or `Schema`
- Schema.minimum, Schema.exclusiveMinimum, Schema.maximum, Schema.exclusiveMaximum now are BigDecimal:
  - https://github.com/asyncapi/jasyncapi/issues/97
  - https://github.com/asyncapi/jasyncapi/issues/96

### Fixed

- Specification components doesn't overrides given ObjectMapper - https://github.com/asyncapi/jasyncapi/issues/128
- 2.0.0 - typo in Components serverBindings: ServerBinding instead of ServerBindingsDeserializer
- 2.0.0 - fixed typo in ServerVariable field name - example was renamed to examples
- Error while parsing of specifications when Reference was recognized as Schema

## [1.0.0-EAP-1] - 2021-03-08

https://github.com/asyncapi/jasyncapi/pull/35

### Changed

- `com.asyncapi.v2.schema.Schema` field `enumValues` was renamed to `enumValue`
- `com.asyncapi.v2.model.schema.Type` was changed to class
- Updated description of `examples` for `com.asyncapi.v2.model.channel.message.Message`

## [1.0.0-EAP] - 2021-02-08

Initial release of AsyncAPI 2.0.0

https://github.com/asyncapi/jasyncapi/pull/31

### Added

- AsyncAPI 2.0.0