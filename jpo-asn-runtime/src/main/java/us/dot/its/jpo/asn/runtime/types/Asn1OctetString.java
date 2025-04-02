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
    protected final int minLength;

    @Getter
    protected final int maxLength;

    @JsonIgnore
    protected byte[] octets;

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
        if (octets != null) {
            return hexFormat.formatHex(octets);
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
        this.octets = hexFormat.parseHex(value.trim());
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

        if (bytes.length < minLength || bytes.length > maxLength) {
            throw new IllegalArgumentException(String.format(
                    "OCTET STRING length (%d bytes) out of bounds - must be between %d and %d bytes",
                    bytes.length, minLength, maxLength));
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
        if (byteLength < minLength || byteLength > maxLength) {
            throw new IllegalArgumentException(String.format(
                    "OCTET STRING length (%d bytes) out of bounds - must be between %d and %d bytes",
                    byteLength, minLength, maxLength));
        }

    }

    @Override
    public String toString() {
        return getValue();
    }

}
