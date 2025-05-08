package us.dot.its.jpo.asn.runtime.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import java.util.Optional;
import lombok.Getter;
import lombok.Setter;

/**
 * Represents an ASN.1 INTEGER type, and is also used as a base class for INTEGER type assignments
 * with or without size constraints.
 */
public class Asn1Integer implements Asn1Type, Comparable<Asn1Integer> {

  @Setter
  private long value;
  @Getter
  private final long lowerBound;
  @Getter
  private final long upperBound;

  public Asn1Integer() {
    this(Long.MIN_VALUE, Long.MAX_VALUE);
  }

  @JsonCreator
  public Asn1Integer(long value) {
    this();
    this.setValue(value);
  }

  public Asn1Integer(long lowerBound, long upperBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }

  @JsonValue
  public long getValue() {
    return value;
  }

  @Override
  public int compareTo(Asn1Integer other) {
    if (other == null) {
      return -1;
    }
    return Long.compare(getValue(), other.getValue());
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Asn1Integer that = (Asn1Integer) o;
    return getValue() == that.getValue();
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(getValue());
  }

  @Override
  public String toString() {
    return Long.toString(getValue());
  }

  public Optional<String> name() {
    return Optional.empty();
  }


}
