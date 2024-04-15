package com.asyncapi.v3.schema.avro.v1._9_0;

import lombok.*;
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
@Data
@EqualsAndHashCode(callSuper = true)
public class AvroRecord extends Avro {

    public AvroRecord() {
        super(AvroType.RECORD);
    }

    @Builder(builderMethodName = "recordBuilder")
    public AvroRecord(
            @Nullable AvroType type,
            @NotNull  String name,
            @Nullable String namespace,
            @Nullable String doc,
            @Nullable List<@NotNull String> aliases,
            @NotNull  List<@NotNull AvroRecordField> fields
    ) {
        if (AvroType.RECORD.equals(type) || AvroType.ERROR.equals(type)) {
            super.setType(type);
        } else {
            super.setType(AvroType.RECORD);
        }

        this.name      = name;
        this.namespace = namespace;
        this.doc       = doc;
        this.aliases   = aliases;
        this.fields    = fields;
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
    private List<@NotNull AvroRecordField> fields = Collections.emptyList();

    @NotNull
    @Override
    public AvroType getType() {
        return AvroType.RECORD;
    }

    public void setType(@NotNull AvroType type) {
        super.setType(AvroType.RECORD);
    }

}
