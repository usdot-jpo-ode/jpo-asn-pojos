package us.dot.its.jpo.asn.runtime.types;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public abstract class Asn1Choice implements Asn1Type {

    final boolean hasExtensionMarker;

    public Asn1Choice(boolean hasExtensionMarker) {
        this.hasExtensionMarker = hasExtensionMarker;
    }

}
