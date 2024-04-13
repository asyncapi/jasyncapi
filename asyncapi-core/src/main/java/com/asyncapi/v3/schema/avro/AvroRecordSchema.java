package com.asyncapi.v3.schema.avro;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

/**
 * Avro Record.
 *
 * @author Pavel Bodiachevskii
 * @version 3.0.0
 * @see <a href="https://avro.apache.org/docs/1.9.0/spec.html#schema_record">Avro Record</a>
 */
public class AvroRecordSchema extends AvroSchema {

    public AvroRecordSchema() {
        super(AvroSchemaType.RECORD);
    }

    /**
     * A JSON string providing the name of the record (required).
     */
    @NotNull
    private String name = "";

    /**
     * A JSON string that qualifies the name.
     */
    @Nullable
    private String namespace;

    /**
     * A JSON string providing documentation to the user of this schema (optional).
     */
    @Nullable
    private String doc;

    /**
     * A JSON array of strings, providing alternate names for this record (optional).
     */
    @Nullable
    private List<@NotNull String> aliases;

    /**
     * A JSON array, listing fields (required).
     */
    @NotNull
    private List<@NotNull AvroRecordFieldSchema> fields = Collections.emptyList();

}
