package com.asyncapi.v3.schema.avro.v1._9_0;

import com.asyncapi.v3.schema.avro.v1._9_0.jackson.AvroTypeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Avro Union.
 * <p>
 * Unions, as mentioned above, are represented using JSON arrays.
 * <p>
 * For example, ["null", "string"] declares a schema which may be either a null or string.
 * <p>
 * <p>
 * Note that when a default value is specified for a record field whose type is a union,
 * the type of the default value must match the first element of the union.
 * <p>
 * Thus, for unions containing "null", the "null" is usually listed first,
 * since the default value of such unions is typically null.
 * <p>
 * <p>
 * Unions may not contain more than one schema with the same type, except for the named types record, fixed and enum.
 * <p>
 * For example, unions containing two array types or two map types are not permitted, but two types with different names are permitted.
 * <p>
 * (Names permit efficient resolution when reading and writing unions.)
 * <p>
 * Unions may not immediately contain other unions.
 *
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#Unions">Unions</a>
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#schema_record">Record</a>
 */
@JsonDeserialize(contentUsing = AvroTypeDeserializer.class)
public class AvroUnion extends LinkedList<Object> {

    public AvroUnion() {
        super();
    }

    public AvroUnion(@NotNull Object ...variant) {
        super();
        addAll(Arrays.asList(variant));
    }

    public AvroUnion(@NotNull Object variantA, @NotNull Object variantB) {
        super();
        add(0, variantA);
        add(1, variantB);
    }

}