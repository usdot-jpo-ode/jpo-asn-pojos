package us.dot.its.jpo.asn.runtime.types;


/**
 * Interface to be implemented by all classes for ASN.1 ENUMERATED types.
 */
public interface Asn1Enumerated extends Asn1Type {
    int getIndex();
    String getName();
}
