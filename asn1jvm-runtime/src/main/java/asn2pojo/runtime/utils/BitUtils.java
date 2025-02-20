package asn2pojo.runtime.utils;

import java.util.BitSet;
import java.util.List;

public class BitUtils {

    public static void appendBits(List<Boolean> bits, BitSet bitSet) {
        if (!bitSet.isEmpty()) {
            for (int i = 0; i < bitSet.length(); i++) {
                bits.add(bitSet.get(i));
            }
        }
    }

    public static BitSet appendBits(BitSet bits1, BitSet bits2) {
        if (bits1.isEmpty()) return bits2;
        if (bits2.isEmpty()) return bits1;
        int len1 = bits1.length();
        int len2 = bits2.length();
        BitSet result = new BitSet(len1 + len2);
        for (int i = 0; i < len1; i++) {
            result.set(i, bits1.get(i));
        }
        for (int i = len1; i < len1 + len2; i++) {
            result.set(i, bits2.get(i - len1));
        }
        return result;
    }

    public static BitSet getBitSet(List<Boolean> bits) {
        BitSet bitSet = new BitSet(bits.size());
        for (int i = 0; i < bits.size(); i++) {
            bitSet.set(i, bits.get(i));
        }
        return bitSet;
    }

    public static BitSetPair popBits(BitSet bits, int numBits) {
        BitSet bite = new BitSet(numBits);
        for (int i = 0; i < numBits; i++) {
            bite.set(i, bits.get(i));
        }
        int numRemainder = bits.length() - numBits;
        BitSet remainder = new BitSet(numRemainder);
        for (int i = numBits; i < bits.length(); i++) {
            remainder.set(i - numBits, bits.get(i));
        }
        return new BitSetPair(bite, remainder);
    }

    public static byte reverseBits(final byte b) {
        var reversedInt = Integer.reverse((int)b << 24) & 0xff;
        return (byte)reversedInt;
    }

    public static byte[] reverseBits(final byte[] bytes) {
        byte[] reversed = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            reversed[i] = reverseBits(bytes[i]);
        }
        return reversed;
    }

    public static byte unsignedByte(final int i) {
        return (byte)(i & 0xFF);
    }
}

