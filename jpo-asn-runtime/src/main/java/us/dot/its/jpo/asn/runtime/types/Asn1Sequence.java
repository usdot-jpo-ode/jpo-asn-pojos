package us.dot.its.jpo.asn.runtime.types;

/**
 * <p>A SEQUENCE can an extension a marker.
 * <p>For example this is a SEQUENCE type with an extension marker (the three dots):</p>
 * <pre>
 *   FruitSalad ::= SEQUENCE {
 *    fruits       Fruits,
 *    servingSize  INTEGER,
 *    ...
 *    }
 * </pre>
 *
 * @return whether the type has an extension marker
 */
public interface Asn1Sequence extends Asn1Type {

}
