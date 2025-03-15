package us.dot.its.jpo.asn.runtime.types;


import com.fasterxml.jackson.annotation.JsonValue;



public abstract class Asn1CharacterString implements Asn1Type {

    protected final int minLength;
    protected final int maxLength;
    protected final int bitsPerCharacter;
    protected String value;

    public Asn1CharacterString(int minLength, int maxLength, int bitsPerCharacter) {
        this.minLength = minLength;
        this.maxLength = maxLength;
        this.bitsPerCharacter = bitsPerCharacter;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        if (!validate(value)) {
            throw new IllegalArgumentException(
                    String.format("String '%s' has invalid length. Must be between %d and %d",
                        value, minLength, maxLength));
        }
        this.value = value;
    }

    protected boolean validate(String aValue) {
        if (aValue == null) return true;
        return aValue.length() >= minLength && aValue.length() <= maxLength;
    }

    @Override
    public String toString() {
        return value;
    }

}
