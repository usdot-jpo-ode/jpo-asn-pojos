package us.dot.its.jpo.asn.runtime.types;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;

/**
 * Base class for ASN.1 SEQUENCE-OF types.
 * @param <T> The type of items in the SEQUENCE-OF
 */
public abstract class Asn1SequenceOf<T extends Asn1Type>
    extends ArrayList<T>
    implements Asn1Type {

    final Class<T> itemClass;
    final long sizeLowerBound;
    final long sizeUpperBound;

    public Asn1SequenceOf(Class<T> itemClass, long sizeLowerBound, long sizeUpperBound) {
        this.itemClass = itemClass;
        this.sizeLowerBound = sizeLowerBound;
        this.sizeUpperBound = sizeUpperBound;
    }

    @JsonIgnore
    public Class<T> getItemClass() {
        return itemClass;
    }

    @JsonIgnore
    public long getSizeLowerBound() {
        return sizeLowerBound;
    }

    @JsonIgnore
    public long getSizeUpperBound() {
        return sizeUpperBound;
    }

    @SuppressWarnings("unchecked")
    public boolean add(Asn1Type item) {
        return super.add((T)item);
    }
}
