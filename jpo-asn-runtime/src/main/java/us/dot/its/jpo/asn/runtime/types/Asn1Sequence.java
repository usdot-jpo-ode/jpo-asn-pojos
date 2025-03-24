package us.dot.its.jpo.asn.runtime.types;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Base class for ASN.1 SEQUENCE types.
 */
@Slf4j
@ToString
public abstract class Asn1Sequence implements Asn1Type {

    final boolean extensionMarker;

    public Asn1Sequence(boolean hasExtensionMarker) {
        this.extensionMarker = hasExtensionMarker;
    }

    /**
     * <p>Indicates whether the SEQUENCE has an extension a marker.
     * <p>For example this is a SEQUENCE type with an extension marker (the three dots):</p>
     * <pre>
     *   FruitSalad ::= SEQUENCE {
     *    fruits       Fruits,
     *    servingSize  INTEGER,
     *    ...
     *    }
     * </pre>
     * @return whether the type has an extension marker
     */
    public boolean hasExtensionMarker() {
        return extensionMarker;
    }


}
