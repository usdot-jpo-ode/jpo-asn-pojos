package asn2pojo.runtime.types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HexFormat;

public class Asn1OctetString implements Asn1Type {

    protected final int minLength;
    protected final int maxLength;

    @JsonIgnore
    protected byte[] octets;

    @JsonValue
    public String getValue() {
        HexFormat hexFormat = HexFormat.of();
        if (octets != null) {
            return hexFormat.formatHex(octets);
        } else {
            return "";
        }
    }

    public void setValue(String value) {
        try {
            this.octets = validate(value);
        } catch (Exception e) {
            throw new IllegalArgumentException(
                    String.format("Hex String '%s' is not valid", value), e);
        }
    }

    @JsonIgnore
    public byte[] getOctets() {
        return octets;
    }

    @JsonIgnore
    public void setOctets(byte[] octets) {
        this.octets = octets;
    }

    /**
     * Default constructor creates octet string with unrestricted length
     */
    public Asn1OctetString() {
        this.minLength = 0;
        this.maxLength = Integer.MAX_VALUE;
    }

    public Asn1OctetString(int minLength, int maxLength) {
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    protected byte[] validate(String aValue) throws Exception {
        if (aValue == null) {
            throw new Exception("hex string is null");
        }
        // Size of hex format string can be 2 * byte size
        boolean validLength = aValue.length() >= 2 * minLength && aValue.length() <= 2 * maxLength;
        if (!validLength) {
            throw new Exception(String.format("Hex string length out of bounds, %s, number of bytes must be between" +
                    " %d and %d", aValue, minLength, maxLength));
        }
        HexFormat hexFormat = HexFormat.of();
        try {
            return hexFormat.parseHex(aValue);
        } catch (IllegalArgumentException e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public String toString() {
        return getValue();
    }

}
