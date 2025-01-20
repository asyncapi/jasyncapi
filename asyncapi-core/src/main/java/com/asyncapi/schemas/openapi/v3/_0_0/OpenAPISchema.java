package com.asyncapi.schemas.openapi.v3._0_0;

import com.asyncapi.schemas.openapi.v3._0_0.properties.Discriminator;
import com.asyncapi.schemas.openapi.v3._0_0.properties.Extensions;
import com.asyncapi.schemas.openapi.v3._0_0.properties.ExternalDocumentation;
import com.asyncapi.schemas.openapi.v3._0_0.properties.XML;
import com.asyncapi.schemas.serde.openapi.OpenAPISchemaAdditionalPropertiesDeserializer;
import com.asyncapi.schemas.serde.openapi.OpenAPISchemaAnyValueDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * The Schema Object allows the definition of input and output data types.
 * <p>
 * These types can be objects, but also primitives and arrays.
 * <p>
 * This object is an extended subset of the <a href="http://json-schema.org/">JSON Schema Specification Wright Draft 00</a>.
 * <p>
 * For more information about the properties, see <a href="https://tools.ietf.org/html/draft-wright-json-schema-00">JSON Schema Core</a> and <a href="https://tools.ietf.org/html/draft-wright-json-schema-validation-00">JSON Schema Validation</a>.
 * Unless stated otherwise, the property definitions follow the JSON Schema.
 *
 * @see <a href="https://github.com/OAI/OpenAPI-Specification/blob/3.0.1/versions/3.0.0.md#schemaObject">Schema Object</a>
 * @see <a href="https://github.com/swagger-api/swagger-core/blob/v2.1.13/modules/swagger-models/src/main/java/io/swagger/v3/oas/models/media/Schema.java">Schema</a>
 *
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OpenAPISchema extends Extensions {

    /**
     * Schema name.
     */
    @JsonProperty("name")
    public String name;

    /**
     * The value of these keyword <b>MUST</b> be a string.
     * <p>
     * This keywords can be used to decorate a user interface with information about the data produced by this user
     * interface.
     * <p>
     * A title will preferably be short
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.10.1">"title" and "description"</a>
     */
    @Nullable
    @JsonProperty("title")
    public String title;

    /**
     * Use the multipleOf keyword to specify that a number must be the multiple of another number:
     * <pre>{@code
     * type: integer
     * multipleOf: 10
     * }</pre>
     *
     * The example above matches 10, 20, 30, 0, -10, -20, and so on.
     * <p>
     * multipleOf may be used with floating-point numbers, but in practice this can be unreliable due to the limited precision or floating point math.
     * <pre>{@code
     * type: number
     * multipleOf: 2.5
     * }</pre>
     *
     * The value of multipleOf <b>MUST</b> be a positive number, that is, you cannot use multipleOf: -5.
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#multipleOf">multipleOf</a>
     */
    @Nullable
    @JsonProperty("multipleOf")
    public BigDecimal multipleOf;

    /**
     * Use the {@link #minimum} and {@link #maximum} keywords to specify the range of possible values:
     * <pre>{@code
     * type: integer
     * minimum: 1
     * maximum: 20
     * }</pre>
     *
     * By default, the minimum and maximum values are included in the range, that is:
     * <pre>{@code
     * minimum ≤ value ≤ maximum
     * }</pre>
     *
     * To exclude the boundary values, specify {@link #exclusiveMinimum}: true and {@link #exclusiveMaximum}: true.
     * <pre>{@code
     * exclusiveMinimum: true
     * exclusiveMaximum: true
     * }</pre>
     * For example, you can define a floating-point number range as 0–50 and exclude the 0 value:
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#range">range</a>
     */
    @Nullable
    @JsonProperty("maximum")
    public BigDecimal maximum;

    /**
     * The word “exclusive” in {@link #exclusiveMinimum} and {@link #exclusiveMaximum} means the corresponding boundary is excluded:
     * <table caption="exclusive description">
     *     <tr>
     *         <th>Keyword</th>
     *         <th>Description</th>
     *     </tr>
     *     <tr>
     *         <td>exclusiveMinimum: false or not included</td>
     *         <td>value ≥ minimum</td>
     *     </tr>
     *     <tr>
     *         <td>exclusiveMinimum: true</td>
     *         <td>value &gt; minimum</td>
     *     </tr>
     *     <tr>
     *         <td>exclusiveMaximum: false or not included</td>
     *         <td>value ≤ maximum</td>
     *     </tr>
     *     <tr>
     *         <td>exclusiveMaximum: true</td>
     *         <td>value &lt; maximum</td>
     *     </tr>
     * </table>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#range">range</a>
     */
    @Nullable
    @JsonProperty("exclusiveMaximum")
    public Boolean exclusiveMaximum;

    /**
     * Use the {@link #minimum} and {@link #maximum} keywords to specify the range of possible values:
     * <pre>{@code
     * type: integer
     * minimum: 1
     * maximum: 20
     * }</pre>
     *
     * By default, the minimum and maximum values are included in the range, that is:
     * <pre>{@code
     * minimum ≤ value ≤ maximum
     * }</pre>
     *
     * To exclude the boundary values, specify {@link #exclusiveMinimum}: true and {@link #exclusiveMaximum}: true.
     * <pre>{@code
     * exclusiveMinimum: true
     * exclusiveMaximum: true
     * }</pre>
     * For example, you can define a floating-point number range as 0–50 and exclude the 0 value:
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#range">range</a>
     */
    @Nullable
    @JsonProperty("minimum")
    public BigDecimal minimum;

    /**
     * The word “exclusive” in {@link #exclusiveMinimum} and {@link #exclusiveMaximum} means the corresponding boundary is excluded:
     * <table caption="exclusive description">
     *     <tr>
     *         <th>Keyword</th>
     *         <th>Description</th>
     *     </tr>
     *     <tr>
     *         <td>exclusiveMinimum: false or not included</td>
     *         <td>value ≥ minimum</td>
     *     </tr>
     *     <tr>
     *         <td>exclusiveMinimum: true</td>
     *         <td>value &gt; minimum</td>
     *     </tr>
     *     <tr>
     *         <td>exclusiveMaximum: false or not included</td>
     *         <td>value ≤ maximum</td>
     *     </tr>
     *     <tr>
     *         <td>exclusiveMaximum: true</td>
     *         <td>value &lt; maximum</td>
     *     </tr>
     * </table>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#range">range</a>
     */
    @Nullable
    @JsonProperty("exclusiveMinimum")
    public Boolean exclusiveMinimum;

    /**
     * String length can be restricted using {@link #minLength} and {@link #maxLength}:
     *
     * <pre>{@code
     * type: string
     * minLength: 3
     * maxLength: 20
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#string">string</a>
     */
    @Nullable
    @JsonProperty("maxLength")
    public Integer maxLength;

    /**
     * String length can be restricted using {@link #minLength} and {@link #maxLength}:
     *
     * <pre>{@code
     * type: string
     * minLength: 3
     * maxLength: 20
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#string">string</a>
     */
    @Nullable
    @JsonProperty("minLength")
    public Integer minLength;

    /**
     * The pattern keyword lets you define a regular expression template for the string value.
     * <p>
     * Only the values that match this template will be accepted. The regular expression syntax used is
     * from JavaScript (more specifically, <a href="https://www.ecma-international.org/ecma-262/5.1/#sec-15.10.1">ECMA 262</a>).
     * <p>
     * Regular expressions are case-sensitive, that is, [a-z] and [A-Z] are different expressions.
     * <p>
     * For example, the following pattern matches a Social Security Number (SSN) in the 123-45-6789 format:
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#pattern">pattern</a>
     */
    @Nullable
    @JsonProperty("pattern")
    public String pattern;

    /**
     * You can define the minimum and maximum length of an array like so:
     * <pre>{@code
     * type: array
     * items:
     *   type: integer
     * minItems: 1
     * maxItems: 10
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#array-length">array length</a>
     */
    @Nullable
    @JsonProperty("maxItems")
    public Integer maxItems;

    /**
     * You can define the minimum and maximum length of an array like so:
     * <pre>{@code
     * type: array
     * items:
     *   type: integer
     * minItems: 1
     * maxItems: 10
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#array-length">array length</a>
     */
    @Nullable
    @JsonProperty("minItems")
    public Integer minItems;

    /**
     * You can use uniqueItems: true to specify that all items in the array must be unique:
     * <pre>{@code
     * type: array
     * items:
     *   type: integer
     * uniqueItems: true
     * # [1, 2, 3] – valid
     * # [1, 1, 3] – not valid
     * # [ ] – valid
     * }</pre>
     */
    @Nullable
    @JsonProperty("uniqueItems")
    public Boolean uniqueItems;

    /**
     * The {@link #minProperties} and {@link #maxProperties} keywords let you restrict the number of properties allowed in an object.
     * This can be useful when using {@link #additionalProperties} or free-form objects.
     *
     * <pre>{@code
     * type: object
     * minProperties: 2
     * maxProperties: 10
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#property-count">property count</a>
     */
    @Nullable
    @JsonProperty("maxProperties")
    public Integer maxProperties;

    /**
     * The {@link #minProperties} and {@link #maxProperties} keywords let you restrict the number of properties allowed in an object.
     * This can be useful when using {@link #additionalProperties} or free-form objects.
     *
     * <pre>{@code
     * type: object
     * minProperties: 2
     * maxProperties: 10
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#property-count">property count</a>
     */
    @Nullable
    @JsonProperty("minProperties")
    public Integer minProperties;

    /**
     * By default, all object properties are optional. You can specify the required properties in the required list:
     * <pre>{@code
     * type: object
     * properties:
     *   id:
     *     type: integer
     *   username:
     *     type: string
     *   name:
     *     type: string
     * required:
     *   - id
     *   - username
     * }</pre>
     *
     * Note that required is an object-level attribute, not a property attribute:
     * <pre>{@code
     * type: object
     * properties:
     *   id:
     *     type: integer
     *     required: true  # Wrong!
     * required:           # Correct
     *   - id
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#required">required</a>
     */
    @Nullable
    @JsonProperty("required")
    public List<String> required;

    /**
     * The data type of a schema is defined by the type keyword, for example, type: string.
     * <p>
     * OpenAPI defines the following basic types:
     * <ul>
     *     <li>string (this includes dates and files)</li>
     *     <li>number</li>
     *     <li>integer</li>
     *     <li>boolean</li>
     *     <li>array</li>
     *     <li>object</li>
     * </ul>
     *
     * These types exist in most programming languages, though they may go by different names.
     * Using these types, you can describe any data structures.
     * <p>
     * Note that there is no null type; instead, the {@link #nullable} attribute is used as a modifier of the base type.
     * <p>
     * Additional type-specific keywords can be used to refine the data type, for example,
     * limit the string length or specify an enum of possible values.
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#type">type</a>
     */
    @Nullable
    @JsonProperty("type")
    public String type;

    /**
     * OpenAPI lets you combine and extend model definitions using the allOf keyword.
     * allOf takes an array of object definitions that are used for independent validation but together compose a single object.
     * <p>
     * Still, it does not imply a hierarchy between the models. For that purpose, you should include the {@link #discriminator}.
     * <p>
     * To be valid against allOf, the data provided by the client must be valid against all of the given subschemas.
     * In the following example, allOf acts as a tool for combining schemas used in specific cases with the general one.
     * <p>
     * For more clearness, {@link #oneOf} is also used with a {@link #discriminator}.
     *
     * <pre>{@code
     * components:
     *   schemas:
     *     Pet:
     *       type: object
     *       required:
     *         - pet_type
     *       properties:
     *         pet_type:
     *           type: string
     *       discriminator:
     *         propertyName: pet_type
     *     Dog:     # "Dog" is a value for the pet_type property (the discriminator value)
     *       allOf: # Combines the main `Pet` schema with `Dog`-specific properties
     *         - $ref: '#/components/schemas/Pet'
     *         - type: object
     *           # all other properties specific to a `Dog`
     *           properties:
     *             bark:
     *               type: boolean
     *             breed:
     *               type: string
     *               enum: [Dingo, Husky, Retriever, Shepherd]
     *     Cat:     # "Cat" is a value for the pet_type property (the discriminator value)
     *       allOf: # Combines the main `Pet` schema with `Cat`-specific properties
     *         - $ref: '#/components/schemas/Pet'
     *         - type: object
     *           # all other properties specific to a `Cat`
     *           properties:
     *             hunts:
     *               type: boolean
     *             age:
     *               type: integer
     * }</pre>
     *
     * As you can see, this example validates the request body content to make sure it includes all the information
     * needed to update a pet item with the PUT operation.
     * <p>
     * It requires user to specify which type of the item should be updated, and validates against the specified schema according to their choice.
     * Note the inline or referenced schema must be a schema object, not a standard JSON schema.
     * <p>
     * For that example, all of the following request bodies are valid:
     * <pre>{@code
     * {
     *   "pet_type": "Cat",
     *   "age": 3
     * }
     * }</pre>
     * <pre>{@code
     * {
     *   "pet_type": "Dog",
     *   "bark": true
     * }
     * }</pre>
     * <pre>{@code
     * {
     *   "pet_type": "Dog",
     *   "bark": false,
     *   "breed": "Dingo"
     * }
     * }</pre>
     *
     * The following request bodies are not valid:
     * <pre>{@code
     * {
     *   "age": 3        # Does not include the pet_type property
     * }
     * }</pre>
     * <pre>{@code
     * {
     *   "pet_type": "Cat",
     *   "bark": true    # The `Cat` schema does not have the `bark` property
     * }
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/oneof-anyof-allof-not/">oneOf, anyOf, allOf, not</a>
     */
    @Nullable
    @JsonProperty("allOf")
    public List<OpenAPISchema> allOf;

    /**
     * Use the anyOf keyword to validate the data against any amount of the given subschemas.
     * That is, the data may be valid against one or more subschemas at the same time.
     *
     * <pre>{@code
     * paths:
     *   /pets:
     *     patch:
     *       requestBody:
     *         content:
     *           application/json:
     *             schema:
     *               anyOf:
     *                 - $ref: '#/components/schemas/PetByAge'
     *                 - $ref: '#/components/schemas/PetByType'
     *       responses:
     *         '200':
     *           description: Updated
     * components:
     *   schemas:
     *     PetByAge:
     *       type: object
     *       properties:
     *         age:
     *           type: integer
     *         nickname:
     *           type: string
     *       required:
     *         - age
     *
     *     PetByType:
     *       type: object
     *       properties:
     *         pet_type:
     *           type: string
     *           enum: [Cat, Dog]
     *         hunts:
     *           type: boolean
     *       required:
     *         - pet_type
     * }</pre>
     *
     * Note the inline or referenced schema must be a schema object, not a standard JSON schema. With this example,
     * the following JSON request bodies are <b>valid</b>:
     * <pre>{@code
     * {
     *   "age": 1
     * }
     * }</pre>
     * <pre>{@code
     * {
     *   "pet_type": "Cat",
     *   "hunts": true
     * }
     * }</pre>
     * <pre>{@code
     * {
     *   "nickname": "Fido",
     *   "pet_type": "Dog",
     *   "age": 4
     * }
     * }</pre>
     *
     * The following example is <b>not valid</b>, because it does not contain any of the required properties for both of the schemas:
     * <pre>{@code
     * {
     *   "nickname": "Mr. Paws",
     *   "hunts": false
     * }
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/oneof-anyof-allof-not/">oneOf, anyOf, allOf, not</a>
     */
    @Nullable
    @JsonProperty("anyOf")
    public List<OpenAPISchema> anyOf;

    /**
     * oneOf matches exactly one subschema, and {@link #anyOf} can match one or more subschemas.
     * <p>
     * To better understand the difference, use the {@link #anyOf} example but replace anyOf with oneOf.
     * When using oneOf, the following request body is not valid because it matches both schemas and not just one:
     * <pre>{@code
     * {
     *   "nickname": "Fido",
     *   "pet_type": "Dog",
     *   "age": 4
     * }
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/oneof-anyof-allof-not/">oneOf, anyOf, allOf, not</a>
     */
    @Nullable
    @JsonProperty("oneOf")
    public List<OpenAPISchema> oneOf;

    /**
     * The not keyword does not exactly combine schemas, but as all of the keywords mentioned above it
     * helps you to modify your schemas and make them more specific.
     *
     * <pre>{@code
     * paths:
     *   /pets:
     *     patch:
     *       requestBody:
     *         content:
     *           application/json:
     *             schema:
     *               $ref: '#/components/schemas/PetByType'
     *       responses:
     *         '200':
     *           description: Updated
     * components:
     *   schemas:
     *     PetByType:
     *       type: object
     *       properties:
     *         pet_type:
     *           not:
     *             type: integer
     *       required:
     *         - pet_type
     * }</pre>
     *
     * In this example, user should specify the pet_type value of any type except integer
     * (that is, it should be an array, boolean, number, object, or string). The following request body is <b>valid</b>:
     * <pre>{@code
     * {
     *   "pet_type": "Cat"
     * }
     * }</pre>
     *
     * And the following is <b>not valid</b>:
     * <pre>{@code
     * {
     *   "pet_type": 11
     * }
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/oneof-anyof-allof-not/">oneOf, anyOf, allOf, not</a>
     */
    @Nullable
    @JsonProperty("not")
    public OpenAPISchema not;

    /**
     * The properties keyword is used to define the object properties – you need to list the property names and specify a schema for each property.
     * <pre>{@code
     * type: object
     * properties:
     *   id:
     *     type: integer
     *   name:
     *     type: string
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#object">Objects</a>
     */
    @Nullable
    @JsonProperty("properties")
    public Map<String, OpenAPISchema> properties;

    /**
     * The value can be a boolean (true or false) or an {@link OpenAPISchema}.
     * <pre>{@code
     * type: object
     * additionalProperties: true
     * }</pre>
     * <pre>{@code
     * type: object
     * additionalProperties: {}
     * }</pre>
     *
     */
    @Nullable
    @JsonProperty("additionalProperties")
    @JsonDeserialize(using = OpenAPISchemaAdditionalPropertiesDeserializer.class)
    public Object additionalProperties;

    /**
     * The value of these keyword <b>MUST</b> be a string.
     * <p>
     * This keywords can be used to decorate a user interface with information about the data produced by this user
     * interface.
     * <p>
     * A description will provide explanation about the purpose of the instance described by this schema.
     *
     * @see <a href="https://json-schema.org/draft-07/json-schema-validation#rfc.section.10.1">"title" and "description"</a>
     */
    @Nullable
    @JsonProperty("description")
    public String description;

    /**
     * Format modifier serves as a hint at the contents and format of the string.
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#string">string</a>
     */
    @Nullable
    @JsonProperty("format")
    public String format;

    /**
     * Reference to OpenAPI Schema definition.
     */
    @Nullable
    @JsonProperty("$ref")
    public String ref;

    /**
     * OpenAPI 3.0 does not have an explicit null type as in JSON Schema, but you can use nullable: true to specify that the value may be null.
     * Note that null is different from an empty string "".
     * <pre>{@code
     * # Correct
     * type: integer
     * nullable: true
     * # Incorrect
     * type: null
     * # Incorrect as well
     * type:
     *   - integer
     *   - null
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#null">null</a>
     */
    @Nullable
    @JsonProperty("nullable")
    public Boolean nullable;

    /**
     * You can use the {@link #readOnly} and {@link #writeOnly} keywords to mark specific properties as read-only or write-only.
     * <p>
     * This is useful, for example, when GET returns more properties than used in POST – you can use the same schema in
     * both GET and POST and mark the extra properties as readOnly.
     * <p>
     * {@link #readOnly} properties are included in responses but not in requests, and {@link #writeOnly} properties may be sent in requests but not in responses.
     * <pre>{@code
     * type: object
     * properties:
     *   id:
     *     # Returned by GET, not used in POST/PUT/PATCH
     *     type: integer
     *     readOnly: true
     *   username:
     *     type: string
     *   password:
     *     # Used in POST/PUT/PATCH, not returned by GET
     *     type: string
     *     writeOnly: true
     * }</pre>
     *
     * If a {@link #readOnly} or {@link #writeOnly} property is included in the required list,
     * required affects just the relevant scope – responses only or requests only.
     * <p>
     * That is, read-only required properties apply to responses only, and write-only required properties – to requests only.
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#readonly-writeonly">Read-Only and Write-Only Properties</a>
     */
    @Nullable
    @JsonProperty("readOnly")
    public Boolean readOnly;

    /**
     * You can use the {@link #readOnly} and {@link #writeOnly} keywords to mark specific properties as read-only or write-only.
     * <p>
     * This is useful, for example, when GET returns more properties than used in POST – you can use the same schema in
     * both GET and POST and mark the extra properties as readOnly.
     * <p>
     * {@link #readOnly} properties are included in responses but not in requests, and {@link #writeOnly} properties may be sent in requests but not in responses.
     * <pre>{@code
     * type: object
     * properties:
     *   id:
     *     # Returned by GET, not used in POST/PUT/PATCH
     *     type: integer
     *     readOnly: true
     *   username:
     *     type: string
     *   password:
     *     # Used in POST/PUT/PATCH, not returned by GET
     *     type: string
     *     writeOnly: true
     * }</pre>
     *
     * If a {@link #readOnly} or {@link #writeOnly} property is included in the required list,
     * required affects just the relevant scope – responses only or requests only.
     * <p>
     * That is, read-only required properties apply to responses only, and write-only required properties – to requests only.
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/data-types/#readonly-writeonly">Read-Only and Write-Only Properties</a>
     */
    @Nullable
    @JsonProperty("writeOnly")
    public Boolean writeOnly;

    /**
     * You can add examples to parameters, properties and objects to make OpenAPI specification of your web service clearer.
     * Examples can be read by tools and libraries that process your API in some way.
     * <p>
     * For example, an API mocking tool can use sample values to generate mock requests.
     * You can specify examples for objects, individual properties and operation parameters
     * <pre>{@code
     * parameters:
     *   - in: query
     *     name: status
     *     schema:
     *       type: string
     *       enum: [approved, pending, closed, new]
     *       example: approved     # Example of a parameter value
     * }</pre>
     * <pre>{@code
     * parameters:
     *   - in: query
     *     name: limit
     *     schema:
     *       type: integer
     *       maximum: 50
     *     example:
     *       zero:         # Distinct name
     *         value: 0    # Example value
     *         summary: A sample limit value  # Optional description
     * }</pre>
     */
    @Nullable
    @JsonProperty("example")
    @JsonDeserialize(using = OpenAPISchemaAnyValueDeserializer.class)
    public Object example;

    /**
     * External resource for extended documentation
     */
    @Nullable
    @JsonProperty("externalDocs")
    public ExternalDocumentation externalDocs;

    /**
     * You can mark OpenAPI Schema as deprecated, by setting deprecated: true
     */
    @Nullable
    @JsonProperty("deprecated")
    public Boolean deprecated;

    /**
     * In your API specification, you can describe data in both XML and JSON formats as they are easily interchangeable.
     * <p>
     * For example, the following declaration —
     * <pre>{@code
     * components:
     *   schemas:
     *     book:
     *       type: object
     *       properties:
     *         id:
     *           type: integer
     *         title:
     *           type: string
     *         author:
     *           type: string
     * }</pre>
     *
     * — is represented in the following way in JSON and XML:
     * <br>
     * <b>JSON</b>
     * <pre>{@code
     * {
     *   "id": 0,
     *   "title": "string",
     *   "author": "string"
     * }
     * }</pre>
     *
     * <b>XML</b>
     * <pre>{@code
     * <book>
     *   <id>0</id>
     *   <title>string</title>
     *   <author>string</author>
     * </book>
     * }</pre>
     *
     * As you can see, in XML representation, the object name serves as a parent element and properties are translated to child elements.
     * <p>
     * The OpenAPI 3 format offers a special xml object to help you fine-tune representation of XML data.
     * You can use this object to transform some properties to attributes rather than elements, to change element names,
     * to add namespaces and to control transformations of array items.
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/representing-xml/">Representing XML</a>
     */
    @Nullable
    @JsonProperty("xml")
    public XML xml;

    /**
     * You can use the enum keyword to specify possible values of a request parameter or a model property.
     * <p>
     * For example, the sort parameter in GET /items?sort=[asc|desc] can be described as:
     * <pre>{@code
     * paths:
     *   /items:
     *     get:
     *       parameters:
     *         - in: query
     *           name: sort
     *           description: Sort order
     *           schema:
     *             type: string
     *             enum: [asc, desc]
     * }</pre>
     *
     * A nullable enum can be defined as follows:
     * <pre>{@code
     * type: string
     * nullable: true  # <---
     * enum:
     *   - asc
     *   - desc
     *   - null        # <--- without quotes, i.e. null not "null"
     * }</pre>
     *
     * @see <a href="https://swagger.io/docs/specification/data-models/enums/">Enums</a>
     */
    @Nullable
    @JsonProperty("enum")
    @JsonDeserialize(contentUsing = OpenAPISchemaAnyValueDeserializer.class)
    public List<Object> enumValue;

    /**
     * Default value.
     */
    @Nullable
    @JsonProperty("default")
    @JsonDeserialize(using = OpenAPISchemaAnyValueDeserializer.class)
    public Object defaultValue;

    /**
     * {@link Discriminator}
     */
    @Nullable
    @JsonProperty("discriminator")
    public Discriminator discriminator;

}
