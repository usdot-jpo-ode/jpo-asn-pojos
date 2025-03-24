package us.dot.its.jpo.asn.runtime.types;

/**
 * Record that can be used to hold the value and metadata of named field in an ASN.1 SEQUENCE or
 * CHOICE type.
 * @param name Name of the field
 * @param value Value of the field
 * @param optional Whether the field is marked OPTIONAL
 * @param tag The tag indicating the order to serialize the field in
 * @param type The class of the field
 */
public record Asn1Field(
        String name,
        Asn1Type value,
        boolean optional,
        int tag,
        Class<? extends Asn1Type> type) {
}
