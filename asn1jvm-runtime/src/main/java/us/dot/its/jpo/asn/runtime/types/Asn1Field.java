package us.dot.its.jpo.asn.runtime.types;

public record Asn1Field(
        String name,
        Asn1Type value,
        boolean optional,
        int tag,
        Class<? extends Asn1Type> type) {
}
