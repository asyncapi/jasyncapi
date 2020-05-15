# AsyncAPI for Java - Maven Plugin
---

> ⚠️ This plugin doesn't support AsyncAPI 1.x

Maven plugin for the [java-asyncapi](https://github.com/Pakisan/java-asyncapi) - Integrating AsyncAPI Schema generation in your builds.

## Features
---
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
Parameter | Description | Required | Default
--------- | ----------- | --------- | -------
`classNames`|class names to generate from|`true` if `packageNames` not present|`null`
`packageNames`|package names to generate from|`true` if `classNames` not present|`null`
`schemaFileName`|file name (no extension)|`false`|`asyncapi`
`schemaFileFormat`|file format (`json`, `yaml`)|`false`|`json`
`schemaFilePath`|output path where file(s) are saved|`false`|`generated/asyncapi`
`includeNulls`|include `null` values or not|`false`|`false`
`prettyPrint`|pretty format or not|`false`|`true`
