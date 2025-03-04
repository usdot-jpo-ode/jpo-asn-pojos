package asn2pojo.runtime.types;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Character range = 0..127, UPER encoded with 7 bits per character
 * Ref: ITU-T X.691 (02/2021) Section 30
 */
public class IA5String extends Asn1CharacterString {

    public IA5String(int minLength, int maxLength) {
        super(minLength, maxLength, 7);
    }

    @JsonCreator
    public IA5String(String value) {
        this(0, Integer.MAX_VALUE);
        this.value = value;
    }

}
