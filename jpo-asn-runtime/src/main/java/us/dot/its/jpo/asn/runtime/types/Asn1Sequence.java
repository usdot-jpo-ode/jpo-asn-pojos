package us.dot.its.jpo.asn.runtime.types;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public abstract class Asn1Sequence implements Asn1Type {

    final boolean extensionMarker;

    public Asn1Sequence(boolean hasExtensionMarker) {
        this.extensionMarker = hasExtensionMarker;
    }

    public boolean hasExtensionMarker() {
        return extensionMarker;
    }


}
