package asn2pojo.runtime.types;

import asn2pojo.runtime.serialization.BitstringSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.BitSet;
import java.util.HexFormat;

import static asn2pojo.runtime.utils.BitUtils.reverseBits;

@JsonSerialize(using = BitstringSerializer.class)
public abstract class Asn1Bitstring implements Asn1Type {

    final BitSet bits;
    final int size;
    final boolean hasExtensionMarker;
    final String[] names;

    public Asn1Bitstring(int size, boolean hasExtensionMarker, String[] names) {
        this.size = size;
        this.hasExtensionMarker = hasExtensionMarker;
        this.bits = new BitSet(size);
        this.names = names;
    }

    public int size() {
        return size;
    }

    public boolean hasExtensionMarker() {
        return hasExtensionMarker;
    }

    public boolean get(int bitIndex) {
        return bits.get(bitIndex);
    }

    public void set(int bitIndex, boolean value) {
        bits.set(bitIndex, value);
    }

    public String binaryString() {
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) {
            chars[i] = get(i) ? '1' : '0';
        }
        return new String(chars);
    }

    public String hexString() {
        HexFormat hex = HexFormat.of();
        int expectedNumBytes = size() % 8;
        byte[] bytes = bits.toByteArray();
        if (bytes.length < expectedNumBytes) {
            // Pad with 0's to get expected number of bytes
            byte[] paddedBytes = new byte[expectedNumBytes];

        }
        return hex.formatHex(reverseBits(bits.toByteArray()));
    }

    public void fromBinaryString(String str) {
        if (str == null) {
            bits.clear();
            return;
        }
        char[] chars = str.toCharArray();
        if (chars.length < size) {
            throw new IllegalArgumentException("Not enough characters in string " + str);
        }
        for (int i = 0; i < size; i++) {
            char c = chars[i];
            set(i, c == '1');
        }
    }

    public void fromHexString(String str) {
        System.out.println(str);
        if (str == null) {
            bits.clear();
            return;
        }
        HexFormat hex = HexFormat.of();
        byte[] bytes = reverseBits(hex.parseHex(str));
        System.out.println(bytes.length);
        BitSet newBits = BitSet.valueOf(bytes);
        System.out.println(newBits);
//        if (newBits.length() != size) {
//            throw new IllegalArgumentException("Wrong number of bits in " + str);
//        }
        bits.clear();
        bits.or(newBits);
        System.out.println(binaryString());
    }

    public String name(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException(String.format("Index %s out of range %s-%s", index, 0, size()));
        }
        return names[index];
    }

    @Override
    public int hashCode() {
        return bits.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Asn1Bitstring bitstring) {
            return bits.equals(bitstring.bits);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return binaryString();
    }


}
