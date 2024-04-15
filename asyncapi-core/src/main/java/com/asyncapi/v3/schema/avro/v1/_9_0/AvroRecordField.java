package com.asyncapi.v3.schema.avro.v1._9_0;

import com.asyncapi.v3.schema.avro.v1._9_0.jackson.AvroTypeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Avro Record Field.
 *
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#schema_record">Avro Record</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AvroRecordField extends AvroMetadata {

    public AvroRecordField() {
        this.type = AvroType.RECORD;
    }

    @Builder
    public AvroRecordField(
            @NotNull Object type,
            @NotNull String name,
            @Nullable Order order,
            @Nullable String doc,
            @Nullable List<@NotNull String> aliases,
            @Nullable Object defaultValue,
            @Nullable Map<String, Object> metadata
    ) {
        this.type = type;
        this.name = name;
        this.order = order == null ? Order.ASCENDING : order ;
        this.doc = doc;
        this.aliases = aliases;
        this.defaultValue = defaultValue;
        this.metadata = metadata;
    }

    /**
     * Field type.
     */
    @NotNull
    @JsonProperty("type")
    @JsonDeserialize(using = AvroTypeDeserializer.class)
    private Object type;

    /**
     * A JSON string providing the name of the record (required).
     */
    @NotNull
    @JsonProperty("name")
    private String name = "";

    /**
     * Specifies how this field impacts sort ordering of this record (optional).
     */
    @Nullable
    @JsonProperty("order")
    private Order order = Order.ASCENDING;

    @NotNull
    public Order getOrder() {
        if (order == null) {
            setOrder(Order.ASCENDING);
        }

        return order;
    }

    public void setOrder(@NotNull Order order) {
        this.order = order;
    }

    /**
     * A JSON string providing documentation to the user of this schema (optional).
     */
    @Nullable
    @JsonProperty("doc")
    private String doc;

    /**
     * A JSON array of strings, providing alternate names for this record (optional).
     */
    @Nullable
    @JsonProperty("aliases")
    private List<@NotNull String> aliases;

    /**
     * A default value for this field, used when reading instances that lack this field (optional).
     * <p>
     * Permitted values depend on the field's schema type, according to the table below.
     * <p>
     * Default values for union fields correspond to the first schema in the union.
     * <p>
     * Default values for bytes and fixed fields are JSON strings, where Unicode code points 0-255 are mapped to unsigned 8-bit byte values 0-255.
     *
     * <pre>
     * <table>
     *   <tr>
     *     <th>avro type</th>
     *     <th>json type</th>
     *     <th>example</th>
     *   </tr>
     *   <tr>
     *     <td>null</td>
     *     <td>null</td>
     *     <td>null</td>
     *   </tr>
     *   <tr>
     *     <td>boolean</td>
     *     <td>boolean</td>
     *     <td>true</td>
     *   </tr>
     *   <tr>
     *     <td>int, long</td>
     *     <td>integer</td>
     *     <td>1</td>
     *   </tr>
     *   <tr>
     *     <td>float, double</td>
     *     <td>number</td>
     *     <td>1.1</td>
     *   </tr>
     *   <tr>
     *     <td>bytes</td>
     *     <td>string</td>
     *     <td>"\u00FF"</td>
     *   </tr>
     *   <tr>
     *     <td>string</td>
     *     <td>string</td>
     *     <td>"foo"</td>
     *   </tr>
     *   <tr>
     *     <td>record</td>
     *     <td>object</td>
     *     <td>{"a": 1}</td>
     *   </tr>
     *   <tr>
     *     <td>enum</td>
     *     <td>string</td>
     *     <td>"FOO"</td>
     *   </tr>
     *   <tr>
     *     <td>array</td>
     *     <td>array</td>
     *     <td>[1]</td>
     *   </tr>
     *   <tr>
     *     <td>map</td>
     *     <td>object</td>
     *     <td>{"a": 1}</td>
     *   </tr>
     *   <tr>
     *     <td>fixed</td>
     *     <td>string</td>
     *     <td>"\u00ff"</td>
     *   </tr>
     * </table>
     * </pre>
     */
    @Nullable
    @JsonProperty("default")
    private Object defaultValue;

    /**
     * Specifies how this field impacts sort ordering of this record.
     * <p>
     * Valid values are "ascending" (the default), "descending", or "ignore".
     * <p>
     * For more details on how this is used, see the the sort order section.
     *
     * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#order">Order</a>
     */
    public enum Order {

        @JsonProperty("ascending")
        ASCENDING,

        @JsonProperty("descending")
        DESCENDING,

        @JsonProperty("ignore")
        IGNORE

    }

}
