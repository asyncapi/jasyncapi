<h1 align="center">
  <br>
  <a href="https://asyncapi.org"><img src="../../assets/logo.png" alt="AsyncAPI logo" height="80"></a>
</h1>
<h4 align="center">Building the future of event-driven architectures</h4>
<h6 align="center">We're on a mission to standardize message-based communication and increase interoperability of the different systems out there.</h6>

> ⚠️ This plugin doesn't support AsyncAPI 1.x

Maven plugin helps to generate AsyncAPI specification from hand-crafted AsyncAPI class at choosed build cycle step.

## Features

- Generate AsyncAPI schema(s) for one or multiple Java classes.
- Generate AsyncAPI schemas for all classes in one or multiple packages.
- Generaty AsyncAPI schema in `json`, `yaml` format

## Usage

### Plugin definition 
```xml
<plugin>
    <groupId>com.asyncapi</groupId>
    <artifactId>asyncapi-maven-plugin</artifactId>
    <configuration>
        <classNames>com.asyncapi.plugin.maven.asyncapi.streetlights.StreetlightsAsyncAPI</classNames>
    </configuration>
</plugin>
```

### Parameters
**[parameters description](../asyncapi-plugin-core)**

### Schema definition example

* [AsyncAPI class extending](#asyncapi-class-extending)
* [Annotations](#annotations)

#### AsyncAPI class extending
```java
public class StreetlightsAsyncAPI extends AsyncAPI {

    @Nonnull
    @Override
    public String getAsyncapi() {
        return "2.0.0";
    }

    @NotNull
    @Override
    public Info getInfo() {
        return Info.builder()
                .title("Streetlights API")
                .version("1.0.0")
                .description("The Smartylighting Streetlights API allows you to remotely manage the city lights.\n" +
                        "\n" +
                        "    ### Check out its awesome features:\n" +
                        "\n" +
                        "    * Turn a specific streetlight on/off \uD83C\uDF03\n" +
                        "    * Dim a specific streetlight \uD83D\uDE0E\n" +
                        "    * Receive real-time information about environmental lighting conditions \uD83D\uDCC8")
                .license(License.builder()
                        .name("Apache 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0")
                        .build()
                )
                .build();
    }

    @CheckForNull
    @Override
    public Map<String, Server> getServers() {
        Map<String, ServerVariable> serverVariables = new HashMap<>();
        serverVariables.put("port", ServerVariable.builder()
                .description("Secure connection (TLS) is available through port 8883.")
                .defaultValue("1883")
                .enumValue(Arrays.asList("1883", "8883"))
                .build()
        );

        Map<String, Server> servers = new HashMap<>();
        servers.put("production", Server.builder()
                .url("api.streetlights.smartylighting.com:{port}")
                .protocol("mqtt")
                .description("Test broker")
                .variables(serverVariables)
                .security(Arrays.asList(
                        Collections.unmodifiableMap(Stream.of(
                                new AbstractMap.SimpleEntry<String, List<String>>("apiKey", Collections.emptyList()))
                                .collect(Collectors.toMap( it -> it.getKey(), it -> it.getValue()))
                        ),
                        Collections.unmodifiableMap(Stream.of(
                                new AbstractMap.SimpleEntry<String, List<String>>("supportedOauthFlows", Arrays.asList(
                                        "streetlights:on",
                                        "streetlights:off",
                                        "streetlights:dim"
                                )))
                                .collect(Collectors.toMap( it -> it.getKey(), it -> it.getValue()))
                        ),
                        Collections.unmodifiableMap(Stream.of(
                                new AbstractMap.SimpleEntry<String, List<String>>("openIdConnectWellKnown", Collections.emptyList()))
                                .collect(Collectors.toMap( it -> it.getKey(), it -> it.getValue()))
                        )
                ))
                .build()
        );

        return servers;
    }

    @CheckForNull
    @Override
    public String getDefaultContentType() {
        return "application/json";
    }

    @Nonnull
    @Override
    public Map<String, ChannelItem> getChannels() {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("streetlightId", new Reference("#/components/parameters/streetlightId"));

        Map<String, ChannelItem> channels = new HashMap<>();
        channels.put("smartylighting/streetlights/1/0/event/{streetlightId}/lighting/measured", ChannelItem.builder()
                .description("The topic on which measured values may be produced and consumed.")
                .parameters(parameters)
                .subscribe(Operation.builder()
                        .summary("Receive information about environmental lighting conditions of a particular streetlight.")
                        .operationId("receiveLightMeasurement")
                        .traits(Collections.singletonList(new Reference("#/components/operationTraits/kafka")))
                        .message(new Reference("#/components/messages/lightMeasured"))
                        .build()
                )
                .build()
        );

        channels.put("smartylighting/streetlights/1/0/action/{streetlightId}/turn/on", ChannelItem.builder()
                .parameters(parameters)
                .publish(Operation.builder()
                        .operationId("turnOn")
                        .traits(Collections.singletonList(new Reference("#/components/operationTraits/kafka")))
                        .message(new Reference("#/components/messages/turnOnOff"))
                        .build()
                )
                .build()
        );

        channels.put("smartylighting/streetlights/1/0/action/{streetlightId}/dim", ChannelItem.builder()
                .parameters(parameters)
                .publish(Operation.builder()
                        .operationId("dimLight")
                        .traits(Collections.singletonList(new Reference("#/components/operationTraits/kafka")))
                        .message(new Reference("#/components/messages/dimLight"))
                        .build()
                )
                .build());

        return channels;
    }

    @CheckForNull
    @Override
    public Components getComponents() {
        Map<String, Object> messages = new HashMap<>();
        messages.put("lightMeasured", Message.builder()
                .name("lightMeasured")
                .title("Light measured")
                .summary("Inform about environmental lighting conditions for a particular streetlight.")
                .contentType("application/json")
                .traits(Collections.singletonList(new Reference("#/components/messageTraits/commonHeaders")))
                .payload(new Reference("#/components/schemas/lightMeasuredPayload"))
                .build()
        );
        messages.put("turnOnOff", Message.builder()
                .name("turnOnOff")
                .title("Turn on/off")
                .summary("Command a particular streetlight to turn the lights on or off.")
                .traits(Collections.singletonList(new Reference("#/components/messageTraits/commonHeaders")))
                .payload(new Reference("#/components/schemas/turnOnOffPayload"))
                .build()
        );
        messages.put("dimLight", Message.builder()
                .name("dimLight")
                .title("Dim light")
                .summary("Command a particular streetlight to dim the lights.")
                .traits(Collections.singletonList(new Reference("#/components/messageTraits/commonHeaders")))
                .payload(new Reference("#/components/schemas/dimLightPayload"))
                .build()
        );

        return Components.builder()
                .messages(messages)
                .schemas(getSchemas())
                .securitySchemes(getSecuritySchemes())
                .parameters(getParameters())
                .messageTraits(getMessageTraits())
                .operationTraits(getOperationTraits())
                .build();
    }

    private Map<String, Object> getSchemas() {
        Map<String, Object> schemas = new HashMap<>();

        // lightMeasuredPayload
        Map<String, Schema> lightMeasuredPayloadProperties = new HashMap<>();
        lightMeasuredPayloadProperties.put("lumens", Schema.builder()
                .type(Type.INTEGER)
                .minimum(0)
                .description("Light intensity measured in lumens.")
                .build()
        );
        lightMeasuredPayloadProperties.put("sentAt", Schema.builder()
                .ref("#/components/schemas/sentAt")
                .build()
        );

        schemas.put("lightMeasuredPayload", Schema.builder()
                .type(Type.OBJECT)
                .properties(lightMeasuredPayloadProperties)
                .build()
        );

        // turnOnOffPayload
        Map<String, Schema> turnOnOffPayloadProperties = new HashMap<>();
        lightMeasuredPayloadProperties.put("command", Schema.builder()
                .type(Type.STRING)
                .enumValues(Arrays.asList("on", "off"))
                .description("Whether to turn on or off the light.")
                .build()
        );
        turnOnOffPayloadProperties.put("sentAt", Schema.builder()
                .ref("#/components/schemas/sentAt")
                .build()
        );

        schemas.put("turnOnOffPayload", Schema.builder()
                .type(Type.OBJECT)
                .properties(turnOnOffPayloadProperties)
                .build()
        );

        // dimLightPayload
        Map<String, Schema> dimLightPayloadProperties = new HashMap<>();
        dimLightPayloadProperties.put("command", Schema.builder()
                .type(Type.INTEGER)
                .minimum(0)
                .maximum(100)
                .build()
        );
        dimLightPayloadProperties.put("sentAt", Schema.builder()
                .ref("#/components/schemas/sentAt")
                .build()
        );

        schemas.put("dimLightPayload", Schema.builder()
                .type(Type.OBJECT)
                .properties(dimLightPayloadProperties)
                .build()
        );

        // sentAt
        schemas.put("sentAt", Schema.builder()
                .type(Type.STRING)
                .format("date-time")
                .description("Date and time when the message was sent.")
                .build()
        );

        return schemas;
    }

    private Map<String, Object> getSecuritySchemes() {
        Map<String, Object> securitySchemes = new HashMap<>();
        securitySchemes.put("apiKey", ApiKeySecurityScheme.apiKeySecuritySchemeBuilder()
                .type(SecurityScheme.Type.API_KEY)
                .in(ApiKeySecurityScheme.ApiKeyLocation.USER)
                .description("Provide your API key as the user and leave the password empty.")
                .build()
        );
        securitySchemes.put("supportedOauthFlows", OAuth2SecurityScheme.oauth2SecuritySchemeBuilder()
                .type(SecurityScheme.Type.OAUTH2)
                .flows(OAuthFlows.builder()
                        .implicit(ImplicitOAuthFlow.implicitOAuthFlowBuilder()
                                .authorizationUrl("https://authserver.example/auth")
                                .scopes(Collections.unmodifiableMap(Stream.of(
                                        new AbstractMap.SimpleEntry<>("streetlights:on", "Ability to switch lights on"),
                                        new AbstractMap.SimpleEntry<>("streetlights:off", "Ability to switch lights off"),
                                        new AbstractMap.SimpleEntry<>("streetlights:dim", "Ability to dim the lights"))
                                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)))
                                )
                                .build()
                        )
                        .password(PasswordOAuthFlow.passwordOAuthFlowBuilder()
                                .tokenUrl("https://authserver.example/token")
                                .scopes(Collections.unmodifiableMap(Stream.of(
                                        new AbstractMap.SimpleEntry<>("streetlights:on", "Ability to switch lights on"),
                                        new AbstractMap.SimpleEntry<>("streetlights:off", "Ability to switch lights off"),
                                        new AbstractMap.SimpleEntry<>("streetlights:dim", "Ability to dim the lights"))
                                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)))
                                )
                                .build()
                        )
                        .clientCredentials(ClientCredentialsOAuthFlow.clientCredentialsOAuthFlowBuilder()
                                .tokenUrl("https://authserver.example/token")
                                .scopes(Collections.unmodifiableMap(Stream.of(
                                        new AbstractMap.SimpleEntry<>("streetlights:on", "Ability to switch lights on"),
                                        new AbstractMap.SimpleEntry<>("streetlights:off", "Ability to switch lights off"),
                                        new AbstractMap.SimpleEntry<>("streetlights:dim", "Ability to dim the lights"))
                                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)))
                                )
                                .build()
                        )
                        .authorizationCode(AuthorizationCodeOAuthFlow.authorizationCodeOAuthFlowBuilder()
                                .authorizationUrl("https://authserver.example/auth")
                                .tokenUrl("https://authserver.example/token")
                                .refreshUrl("https://authserver.example/refresh")
                                .scopes(Collections.unmodifiableMap(Stream.of(
                                        new AbstractMap.SimpleEntry<>("streetlights:on", "Ability to switch lights on"),
                                        new AbstractMap.SimpleEntry<>("streetlights:off", "Ability to switch lights off"),
                                        new AbstractMap.SimpleEntry<>("streetlights:dim", "Ability to dim the lights"))
                                        .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)))
                                )
                                .build()
                        )
                        .build())
                .build()
        );
        securitySchemes.put("openIdConnectWellKnown", OpenIdConnectSecurityScheme.openIdConnectSecurityScheme()
                .type(SecurityScheme.Type.OPENID_CONNECT)
                .openIdConnectUrl("https://authserver.example/.well-known")
                .build()
        );

        return securitySchemes;
    }

    private Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("streetlightId", Parameter.builder()
                .description("The ID of the streetlight.")
                .schema(Schema.builder()
                        .type(Type.STRING)
                        .build()
                )
                .build()
        );

        return parameters;
    }

    private Map<String, MessageTrait> getMessageTraits() {
        Map<String, MessageTrait> messageTraits = new HashMap<>();

        Map<String, Schema> commonHeadersProperties = new HashMap<>();
        commonHeadersProperties.put("my-app-header", Schema.builder()
                .type(Type.INTEGER)
                .minimum(0)
                .maximum(100)
                .build()
        );

        messageTraits.put("commonHeaders", MessageTrait.builder()
                .headers(Schema.builder()
                        .type(Type.OBJECT)
                        .properties(commonHeadersProperties)
                        .build()
                )
                .build()
        );

        return messageTraits;
    }

    private Map<String, OperationTrait> getOperationTraits() {
        Map<String, OperationTrait> operationTraits = new HashMap<>();

        Map<String, OperationBinding> bindigs = new HashMap<>();
        bindigs.put("kafka", KafkaOperationBinding.builder()
                .clientId("my-app-id")
                .build()
        );

        operationTraits.put("kafka", OperationTrait.builder()
                .bindings(bindigs)
                .build()
        );

        return operationTraits;
    }

}
```

#### Annotations
Right now manual definition is the only way. Annotations with reflection for their handling will appear soon.