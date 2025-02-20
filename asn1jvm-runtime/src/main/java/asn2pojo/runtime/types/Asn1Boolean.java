package asn2pojo.runtime.types;

import asn2pojo.runtime.serialization.BooleanDeserializer;
import asn2pojo.runtime.serialization.BooleanSerializer;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


import java.util.Objects;



@JsonSerialize(using = BooleanSerializer.class)
@JsonDeserialize(using = BooleanDeserializer.class)
public class Asn1Boolean implements Asn1Type {

    public Asn1Boolean() {}

    @JsonCreator
    public Asn1Boolean(boolean value) {
        this.value = value;
    }

    private boolean value;

    @JsonValue
    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Asn1Boolean that = (Asn1Boolean) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return Boolean.toString(value);
    }


}
