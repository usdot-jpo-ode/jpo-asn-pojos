package us.dot.its.jpo.asn.runtime.types;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Represents an ASN.1 IA5String type, and can be extended to represent an IA5String type with
 * length constraints.
 * <p>This is a 7-bit encoding that is similar to ASCII defined in ITU-T X.680.
 */
public class IA5String extends Asn1CharacterString {

    /**
     * Constructor with length constraints to be used in derived types
     * @param minLength The minimum length of strings of the derived type
     * @param maxLength The maximum length of strings of the derived type
     */
    public IA5String(int minLength, int maxLength) {
        super(minLength, maxLength, 7);
    }

    /**
     * Default constructor creates a string with unrestricted length
     */
    @JsonCreator
    public IA5String(String value) {
        this(0, Integer.MAX_VALUE);
        this.setValue(value);
    }

}
