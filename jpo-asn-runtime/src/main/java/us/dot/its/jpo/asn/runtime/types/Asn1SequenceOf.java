package us.dot.its.jpo.asn.runtime.types;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * Base class for ASN.1 SEQUENCE-OF types.
 * <p>
 * In ASN.1 notation, a SEQUENCE OF represents an ordered collection of elements all of the same type.
 * Unlike a basic SEQUENCE which contains named elements of potentially different types, a SEQUENCE OF
 * is more analogous to an array or list in traditional programming languages.
 * <p>
 * This implementation extends {@link ArrayList} to provide the ordered collection behavior while
 * adding ASN.1-specific constraints:
 * <ul>
 *   <li>Type safety - ensures all elements are of the specified ASN.1 type</li>
 *   <li>Size constraints - enforces minimum and maximum size bounds defined in the ASN.1 specification</li>
 *   <li>Runtime type information - maintains knowledge of the element type for encoding/decoding</li>
 * </ul>
 * <p>
 * Example ASN.1 definition:
 * <pre>
 * VehicleList ::= SEQUENCE OF Vehicle
 * </pre>
 * would be represented as a subclass of Asn1SequenceOf&lt;Vehicle&gt;.
 *
 * @param <T> The type of items in the SEQUENCE OF, must extend {@link Asn1Type}
 *
 * @see Asn1Type The base interface for all ASN.1 types
 * @see Asn1Sequence For representing ASN.1 SEQUENCE types with named fields
 */
public abstract class Asn1SequenceOf<T extends Asn1Type> implements Asn1Type, List<T> {

    final Class<T> itemClass;
    /** The minimum number of elements required (inclusive) */
    final long sizeLowerBound;
    /** The maximum number of elements allowed (inclusive), or -1 for unbounded */
    final long sizeUpperBound;
    final ArrayList<T> elements;

    /**
     * Constructs a new ASN.1 SEQUENCE OF with the specified element type and size constraints.
     *
     * @param sizeLowerBound The minimum number of elements required (inclusive)
     * @param sizeUpperBound The maximum number of elements allowed (inclusive), or -1 for unbounded
     */
    protected Asn1SequenceOf(Class<T> itemClass, long sizeLowerBound, long sizeUpperBound) {
        this.itemClass = itemClass;
        this.sizeLowerBound = sizeLowerBound;
        this.sizeUpperBound = sizeUpperBound;
        this.elements = new ArrayList<>();
    }

    @JsonIgnore
    public Class<T> getItemClass() {
        return itemClass;
    }

    /**
     * Returns the minimum number of elements required by this SEQUENCE OF.
     *
     * @return The minimum size constraint (inclusive)
     */
    @JsonIgnore
    public long getSizeLowerBound() {
        return sizeLowerBound;
    }

    /**
     * Returns the maximum number of elements allowed by this SEQUENCE OF.
     *
     * @return The maximum size constraint (inclusive), or -1 if unbounded
     */
    @JsonIgnore
    public long getSizeUpperBound() {
        return sizeUpperBound;
    }

    /**
     * Adds an ASN.1 type element to this sequence after casting to the appropriate type.
     * This method is useful for generic ASN.1 processing frameworks.
     *
     * @param item The ASN.1 type element to add
     * @return {@code true} if the element was added successfully
     * @throws ClassCastException if the element is not of the correct type for this sequence
     */
    @SuppressWarnings("unchecked")
    public boolean add(Asn1Type item) {
        return this.elements.add((T) item);
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return this.elements.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return this.elements.iterator();
    }

    @Override
    public Object[] toArray() {
        return this.elements.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return this.elements.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return this.elements.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return this.elements.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return this.elements.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return this.elements.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return this.elements.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return this.elements.retainAll(c);
    }

    @Override
    public void replaceAll(UnaryOperator<T> operator) {
        this.elements.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super T> c) {
        this.elements.sort(c);
    }

    @Override
    public void clear() {
        this.elements.clear();
    }

    @Override
    public T get(int index) {
        return this.elements.get(index);
    }

    @Override
    public T set(int index, T element) {
        return this.elements.set(index, element);
    }

    @Override
    public void add(int index, T element) {
        this.elements.add(index, element);
    }

    @Override
    public T remove(int index) {
        return this.elements.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return this.elements.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return this.elements.lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        return this.elements.listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return this.elements.listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return this.elements.subList(fromIndex, toIndex);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        this.elements.forEach(action);
    }

    @Override
    public Spliterator<T> spliterator() {
        return this.elements.spliterator();
    }

    @Override
    public void addFirst(T t) {
        this.elements.addFirst(t);
    }

    @Override
    public void addLast(T t) {
        this.elements.addLast(t);
    }

    @Override
    public T getFirst() {
        return this.elements.getFirst();
    }

    @Override
    public T getLast() {
        return this.elements.getLast();
    }

    @Override
    public T removeFirst() {
        return this.elements.removeFirst();
    }

    @Override
    public T removeLast() {
        return this.elements.removeLast();
    }

    @Override
    public List<T> reversed() {
        return this.elements.reversed();
    }
}