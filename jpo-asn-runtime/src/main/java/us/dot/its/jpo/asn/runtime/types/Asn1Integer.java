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
  protected long value;
  @Getter
  final long lowerBound;
  @Getter
  final long upperBound;

  public Asn1Integer() {
    this(Long.MIN_VALUE, Long.MAX_VALUE);
  }

  @JsonCreator
  public Asn1Integer(long value) {
    this();
    this.value = value;
  }

  public Asn1Integer(long lowerBound, long upperBound) {
    this.lowerBound = lowerBound;
    this.upperBound = upperBound;
  }

  @JsonValue
  public long getValue() {
    return value;
  }

  public int intValue() {
    return (int) value;
  }

  @Override
  public int compareTo(Asn1Integer other) {
    if (other == null) {
      return -1;
    }
    return Long.compare(value, other.value);
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
    return value == that.value;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public String toString() {
    return Long.toString(value);
  }

  public Optional<String> name() {
    return Optional.empty();
  }


}
