package com.asyncapi.v2.model.schema;

import com.asyncapi.v2.model.ExternalDocumentation;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.annotation.CheckForNull;
import java.util.List;
import java.util.Map;

// TODO: Finish. Not all properties are present.
// TODO: Write tests

/**
 *
 * @see <a href="https://json-schema.org/draft/2019-09/json-schema-validation.html">Json Schema Validation</a>
 * @see <a href="https://www.asyncapi.com/docs/specifications/2.0.0/#a-name-schemaobject-a-schema-object">AnyncAPI Schema Object</a>
 * @author Pavel Bodiachevskii
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schema {

    /*
         Validation Keywords for Any Instance Type
     */

    /**
     * The value of this keyword MUST be either a string or an array. If it is an array, elements of the array MUST
     * be strings and MUST be unique.
     *
     * String values MUST be one of the six primitive types ("null", "boolean", "object", "array", "number",
     * or "string"), or "integer" which matches any number with a zero fractional part.
     *
     * An instance validates if and only if the instance is in any of the sets listed for this keyword.
     */
    public Type type;

    /**
     * The value of this keyword MUST be an array. This array SHOULD have at least one element. Elements in the
     * array SHOULD be unique.
     *
     * An instance validates successfully against this keyword if its value is equal to one of the elements in
     * this keyword's array value.
     *
     * Elements in the array might be of any type, including null.
     */
    @JsonProperty("enum")
    public List<Object> enumValues;

    /**
     * The value of this keyword MAY be of any type, including null.
     *
     * Use of this keyword is functionally equivalent to an "enum" with a single value.
     *
     * An instance validates successfully against this keyword if its value is equal to the value of the keyword.
     */
    @JsonProperty("const")
    public Object constValue;

    /*
        Validation Keywords for Numeric Instances (number and integer)
     */

    /**
     * The value of "multipleOf" MUST be a number, strictly greater than 0.
     *
     * A numeric instance is valid only if division by this keyword's value results in an integer.
     */
    @CheckForNull
    public Integer multipleOf;

    /**
     * The value of "maximum" MUST be a number, representing an inclusive upper limit for a numeric instance.
     *
     * If the instance is a number, then this keyword validates only if the instance is less than or exactly equal to "maximum".
     */
    @CheckForNull
    public Integer maximum;

    /**
     * The value of "exclusiveMaximum" MUST be number, representing an exclusive upper limit for a numeric instance.
     *
     * If the instance is a number, then the instance is valid only if it has a value strictly less than (not equal to) "exclusiveMaximum".
     */
    @CheckForNull
    public Integer exclusiveMaximum;

    /**
     * The value of "minimum" MUST be a number, representing an inclusive lower limit for a numeric instance.
     *
     * If the instance is a number, then this keyword validates only if the instance is greater than or exactly equal to "minimum".
     */
    @CheckForNull
    public Integer minimum;

    /**
     * The value of "exclusiveMinimum" MUST be number, representing an exclusive lower limit for a numeric instance.
     *
     * If the instance is a number, then the instance is valid only if it has a value strictly greater than (not equal to) "exclusiveMinimum".
     */
    @CheckForNull
    public Integer exclusiveMinimum;

    /*
        Validation Keywords for Strings
     */

    /**
     * The value of this keyword MUST be a non-negative integer.
     *
     * A string instance is valid against this keyword if its length is less than, or equal to, the value of this keyword.
     *
     * The length of a string instance is defined as the number of its characters as defined by RFC 8259.
     */
    @CheckForNull
    public Integer maxLength;

    /**
     * The value of this keyword MUST be a non-negative integer.
     *
     * A string instance is valid against this keyword if its length is greater than, or equal to, the value of this keyword.
     *
     * The length of a string instance is defined as the number of its characters as defined by RFC 8259.
     *
     * Omitting this keyword has the same behavior as a value of 0.
     */
    @CheckForNull
    public Integer minLength;

    /**
     * The value of this keyword MUST be a string. This string SHOULD be a valid regular expression, according to the
     * ECMA 262 regular expression dialect.
     *
     * A string instance is considered valid if the regular expression matches the instance successfully.
     * Recall: regular expressions are not implicitly anchored.
     */
    @CheckForNull
    public String pattern;

    /*
        Validation Keywords for Arrays
     */

    /**
     * The value of this keyword MUST be a non-negative integer.
     *
     * An array instance is valid against "maxItems" if its size is less than, or equal to, the value of this keyword.
     */
    @CheckForNull
    public Integer maxItems;

    /**
     * The value of this keyword MUST be a non-negative integer.
     *
     * An array instance is valid against "minItems" if its size is greater than, or equal to, the value of this keyword.
     *
     * Omitting this keyword has the same behavior as a value of 0.
     */
    @CheckForNull
    public Integer minItems;

    /**
     * The value of this keyword MUST be a boolean.
     *
     * If this keyword has boolean value false, the instance validates successfully. If it has boolean value true, the instance validates successfully if all of its elements are unique.
     *
     * Omitting this keyword has the same behavior as a value of false.
     */
    @CheckForNull
    public Boolean uniqueItems;

    /**
     * The value of this keyword MUST be a non-negative integer.
     *
     * An array instance is valid against "maxContains" if the number of elements that are valid against the schema for "contains" is less than, or equal to, the value of this keyword.
     *
     * If "contains" is not present within the same schema object, then this keyword has no effect.
     */
    @CheckForNull
    public Integer maxContains;

    /**
     * The value of this keyword MUST be a non-negative integer.
     *
     * An array instance is valid against "minContains" if the number of elements that are valid against the schema for "contains" is greater than, or equal to, the value of this keyword.
     *
     * A value of 0 is allowed, but is only useful for setting a range of occurrences from 0 to the value of "maxContains". A value of 0 with no "maxContains" causes "contains" to always pass validation.
     *
     * If "contains" is not present within the same schema object, then this keyword has no effect.
     *
     * Omitting this keyword has the same behavior as a value of 1.
     */
    @CheckForNull
    public Integer minContains;

    /*
        Validation Keywords for Objects
     */

    /**
     * The value of this keyword MUST be a non-negative integer.
     *
     * An object instance is valid against "maxProperties" if its number of properties is less than, or equal to, the value of this keyword.
     */
    @CheckForNull
    public Integer maxProperties;

    /**
     * The value of this keyword MUST be a non-negative integer.
     *
     * An object instance is valid against "minProperties" if its number of properties is greater than, or equal to, the value of this keyword.
     *
     * Omitting this keyword has the same behavior as a value of 0.
     */
    @CheckForNull
    private Integer minProperties;

    /**
     * The value of this keyword MUST be an array. Elements of this array, if any, MUST be strings, and MUST be unique.
     *
     * An object instance is valid against this keyword if every item in the array is the name of a property in the instance.
     *
     * Omitting this keyword has the same behavior as an empty array.
     */
    @CheckForNull
    private List<String> required;

    /**
     * The value of this keyword MUST be an object. Properties in this object, if any, MUST be arrays. Elements in each array, if any, MUST be strings, and MUST be unique.
     *
     * This keyword specifies properties that are required if a specific other property is present. Their requirement is dependent on the presence of the other property.
     *
     * Validation succeeds if, for each name that appears in both the instance and as a name within this keyword's value, every item in the corresponding array is also the name of a property in the instance.
     *
     * Omitting this keyword has the same behavior as an empty object.
     */
    @CheckForNull
    private Object dependentRequired;

    /*
        TODO: https://json-schema.org/draft/2019-09/json-schema-validation.html#format
     */

    @CheckForNull
    private Object format;

    /*
        TODO: https://json-schema.org/draft/2019-09/json-schema-validation.html#content
     */

    @CheckForNull
    private Object content;

    /**
     * The value of both of these keywords MUST be a string.
     *
     * Both of these keywords can be used to decorate a user interface with information about the data produced by this user interface. A title will preferably be short, whereas a description will provide explanation about the purpose of the instance described by this schema.
     */
    @CheckForNull
    private String title;

    /**
     * The value of both of these keywords MUST be a string.
     *
     * Both of these keywords can be used to decorate a user interface with information about the data produced by this user interface. A title will preferably be short, whereas a description will provide explanation about the purpose of the instance described by this schema.
     */
    @CheckForNull
    private String description;

    /**
     * There are no restrictions placed on the value of this keyword. When multiple occurrences of this keyword are applicable to a single sub-instance, implementations SHOULD remove duplicates.
     *
     * This keyword can be used to supply a default JSON value associated with a particular schema. It is RECOMMENDED that a default value be valid against the associated schema.
     */
    @CheckForNull
    @JsonProperty("default")
    private Object defaultValue;

    /**
     * The value of this keyword MUST be a boolean. When multiple occurrences of this keyword are applicable to a single sub-instance, applications SHOULD consider the instance location to be deprecated if any occurrence specifies a true value.
     *
     * If "deprecated" has a value of boolean true, it indicates that applications SHOULD refrain from usage of the declared property. It MAY mean the property is going to be removed in the future.
     *
     * A root schema containing "deprecated" with a value of true indicates that the entire resource being described MAY be removed in the future.
     *
     * When the "deprecated" keyword is applied to an item in an array by means of "items", if "items" is a single schema, the deprecation relates to the whole array, while if "items" is an array of schemas, the deprecation relates to the corrosponding item according to the subschemas position.
     *
     * Omitting this keyword has the same behavior as a value of false.
     */
    @CheckForNull
    private Boolean deprecated;

    /**
     * The value of these keywords MUST be a boolean. When multiple occurrences of these keywords are applicable to a single sub-instance, the resulting behavior SHOULD be as for a true value if any occurrence specifies a true value, and SHOULD be as for a false value otherwise.
     *
     * If "readOnly" has a value of boolean true, it indicates that the value of the instance is managed exclusively by the owning authority, and attempts by an application to modify the value of this property are expected to be ignored or rejected by that owning authority.
     *
     * An instance document that is marked as "readOnly for the entire document MAY be ignored if sent to the owning authority, or MAY result in an error, at the authority's discretion.
     *
     * If "writeOnly" has a value of boolean true, it indicates that the value is never present when the instance is retrieved from the owning authority. It can be present when sent to the owning authority to update or create the document (or the resource it represents), but it will not be included in any updated or newly created version of the instance.
     *
     * An instance document that is marked as "writeOnly" for the entire document MAY be returned as a blank document of some sort, or MAY produce an error upon retrieval, or have the retrieval request ignored, at the authority's discretion.
     *
     * For example, "readOnly" would be used to mark a database-generated serial number as read-only, while "writeOnly" would be used to mark a password input field.
     *
     * These keywords can be used to assist in user interface instance generation. In particular, an application MAY choose to use a widget that hides input values as they are typed for write-only fields.
     *
     * Omitting these keywords has the same behavior as values of false.
     */
    @CheckForNull
    private Boolean readOnly;

    /**
     * The value of these keywords MUST be a boolean. When multiple occurrences of these keywords are applicable to a single sub-instance, the resulting behavior SHOULD be as for a true value if any occurrence specifies a true value, and SHOULD be as for a false value otherwise.
     *
     * If "readOnly" has a value of boolean true, it indicates that the value of the instance is managed exclusively by the owning authority, and attempts by an application to modify the value of this property are expected to be ignored or rejected by that owning authority.
     *
     * An instance document that is marked as "readOnly for the entire document MAY be ignored if sent to the owning authority, or MAY result in an error, at the authority's discretion.
     *
     * If "writeOnly" has a value of boolean true, it indicates that the value is never present when the instance is retrieved from the owning authority. It can be present when sent to the owning authority to update or create the document (or the resource it represents), but it will not be included in any updated or newly created version of the instance.
     *
     * An instance document that is marked as "writeOnly" for the entire document MAY be returned as a blank document of some sort, or MAY produce an error upon retrieval, or have the retrieval request ignored, at the authority's discretion.
     *
     * For example, "readOnly" would be used to mark a database-generated serial number as read-only, while "writeOnly" would be used to mark a password input field.
     *
     * These keywords can be used to assist in user interface instance generation. In particular, an application MAY choose to use a widget that hides input values as they are typed for write-only fields.
     *
     * Omitting these keywords has the same behavior as values of false.
     */
    @CheckForNull
    private Boolean writeOnly;

    /**
     * The value of this keyword MUST be an array. There are no restrictions placed on the values within the array. When multiple occurrences of this keyword are applicable to a single sub-instance, implementations MUST provide a flat array of all values rather than an array of arrays.
     *
     * This keyword can be used to provide sample JSON values associated with a particular schema, for the purpose of illustrating usage. It is RECOMMENDED that these values be valid against the associated schema.
     *
     * Implementations MAY use the value(s) of "default", if present, as an additional example. If "examples" is absent, "default" MAY still be used in this manner.
     */
    @CheckForNull
    private List<Object> examples;

    /*
        TODO: https://json-schema.org/draft/2019-09/json-schema-validation.html#security
     */

    @CheckForNull
    private Map<String, Schema> properties;

    @CheckForNull
    @JsonProperty("$ref")
    private String ref;

    /*
        AsyncAPI fixed fields
     */

    /**
     * Adds support for polymorphism. The discriminator is the schema property name that is used to differentiate
     * between other schema that inherit this schema. The property name used MUST be defined at this schema and
     * it MUST be in the required property list. When used, the value MUST be the name of this schema or any schema
     * that inherits it. See Composition and Inheritance for more details.
     */
    @CheckForNull
    private String discriminator;

    /**
     * Additional external documentation for this schema.
     */
    @CheckForNull
    private ExternalDocumentation externalDocs;

}
