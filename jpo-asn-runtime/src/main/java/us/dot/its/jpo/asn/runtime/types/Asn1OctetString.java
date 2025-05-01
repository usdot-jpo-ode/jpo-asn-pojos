package us.dot.its.jpo.asn.runtime.types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.HexFormat;
import lombok.Getter;

/**
 * Represents an ASN.1 OCTET STRING type, which is an ordered sequence of zero or more octets,
 * each octet being 8 bits. This class serves as the base for OCTET STRING type assignments.
 * In ASN.1, OCTET STRING can have size constraints which are represented by minLength and maxLength.
 */
public class Asn1OctetString implements Asn1Type {

    @Getter
    private final int minLength;

    @Getter
    private final int maxLength;

    @JsonIgnore
    private byte[] octets;

    /**
     * Default constructor creates octet string with unrestricted length
     */
    public Asn1OctetString() {
        this(0, Integer.MAX_VALUE);
    }

    public Asn1OctetString(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    /**
     * Returns the hexadecimal string representation of this OCTET STRING.
     *
     * @return Uppercase hexadecimal string representing the octets, or empty string if null
     */
    @JsonValue
    public String getValue() {
        HexFormat hexFormat = HexFormat.of().withUpperCase();
        if (getOctets() != null) {
            return hexFormat.formatHex(getOctets());
        } else {
            return "";
        }
    }

    /**
     * Sets the value of this OCTET STRING from a hexadecimal string.
     *
     * @param value Hexadecimal string representation of the OCTET STRING
     * @throws IllegalArgumentException if the input is not a valid hex string or violates size constraints
     */
    public void setValue(String value) {
        validate(value);
        HexFormat hexFormat = HexFormat.of();
        this.setOctets(hexFormat.parseHex(value.trim()));
    }

    /**
     * Gets the raw byte array representation of this OCTET STRING.
     *
     * @return The byte array containing the OCTET STRING value
     */
    @JsonIgnore
    public byte[] getOctets() {
        return octets;
    }

    /**
     * Sets the OCTET STRING value from a byte array.
     *
     * @param octets The byte array containing the OCTET STRING value
     * @throws IllegalArgumentException if the value violates size constraints
     */
    @JsonIgnore
    public void setOctets(byte[] octets) {
        if (octets != null) {
            validateOctetLength(octets);
            this.octets = Arrays.copyOf(octets, octets.length);
        } else {
            this.octets = null;
        }
    }

    /**
     * Validates that a byte array meets length constraints.
     *
     * @param bytes The byte array to validate
     * @throws IllegalArgumentException if the array violates size constraints
     */
    protected void validateOctetLength(byte[] bytes) {
        if (bytes == null) {
            throw new IllegalArgumentException("Byte array cannot be null");
        }

        if (bytes.length < getMinLength() || bytes.length > getMaxLength()) {
            throw new IllegalArgumentException(String.format(
                    "OCTET STRING length (%d bytes) out of bounds - must be between %d and %d bytes",
                    bytes.length, getMinLength(), getMaxLength()));
        }
    }

    /**
     * Validates that a hex string is properly formatted and meets length constraints.
     *
     * @param hexString The hex string to validate
     * @throws IllegalArgumentException if the string is invalid or violates constraints
     */
    protected void validate(String hexString) {
        if (hexString == null) {
            throw new IllegalArgumentException("Hex string cannot be null");
        }

        var trimmedLength = hexString.trim().length();
        // Check if length is even (each byte needs two hex chars)
        if (trimmedLength % 2 != 0) {
            throw new IllegalArgumentException("Hex string must have an even number of characters");
        }

        int byteLength = trimmedLength / 2;

        // Size of hex format string can be 2 * byte size
        if (byteLength < getMinLength() || byteLength > getMaxLength()) {
            throw new IllegalArgumentException(String.format(
                    "OCTET STRING length (%d bytes) out of bounds - must be between %d and %d bytes",
                    byteLength, getMinLength(), getMaxLength()));
        }

    }

    @Override
    public String toString() {
        return getValue();
    }

}
