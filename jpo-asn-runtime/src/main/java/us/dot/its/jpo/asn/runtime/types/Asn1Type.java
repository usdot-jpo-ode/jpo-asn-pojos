package us.dot.its.jpo.asn.runtime.types;


/**
 * This is a marker interface.  It is the root of the hierarchy of classes representing
 * ASN.1 types in this package.  Clients can use it to represent any ASN.1 type whose specific
 * subtype is unknown. By default, an Asn1Type is not extensible.
 */
public interface Asn1Type {

    /**
     * Determines whether this ASN.1 type includes an extension marker.
     *
     *  <p>For example this is a SEQUENCE type with an extension marker (the three dots):</p>
     *      * <pre>
     *      *   FruitSalad ::= SEQUENCE {
     *      *    fruits       Fruits,
     *      *    servingSize  INTEGER,
     *      *    ...
     *      *    }
     *      * </pre>
     *      *
     * @return true if the ASN.1 type has an extension marker, false otherwise
     */
    default boolean isExtensible() {
        return false;
    }
}
