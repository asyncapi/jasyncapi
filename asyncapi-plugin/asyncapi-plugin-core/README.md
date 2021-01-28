<h1 align="center">
  <br>
  <a href="https://asyncapi.org"><img src="./assets/logo.png" alt="AsyncAPI logo" height="80"></a>
</h1>
<h4 align="center">Building the future of event-driven architectures</h4>
<h6 align="center">We're on a mission to standardize message-based communication and increase interoperability of the different systems out there.</h6>

> ⚠️ This project doesn't support AsyncAPI 1.x

This module stores common logic for next plugins:
* [Gradle](../asyncapi-plugin-gradle)
* [Maven](../asyncapi-plugin-maven)

## Usage

### Parameters

Parameter | Description | Required | Default
--------- | ----------- | --------- | -------
`classNames`|class names to generate from|`true` if `packageNames` not present|`empty`
`packageNames`|package names to generate from|`true` if `classNames` not present|`empty`
`schemaFileName`|file name (no extension)|`false`|`asyncapi`
`schemaFileFormat`|file format (`json`, `yaml`)|`false`|`json`
`schemaFilePath`|output path where file(s) are saved|`false`|`generated/asyncapi`
`includeNulls`|include `null` values or not|`false`|`false`
`prettyPrint`|pretty format or not|`false`|`true`
`classPath`|class path to work with when reflection works|`true`|`empty`