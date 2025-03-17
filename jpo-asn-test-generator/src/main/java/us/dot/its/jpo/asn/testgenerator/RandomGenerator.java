package us.dot.its.jpo.asn.testgenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import us.dot.its.jpo.asn.runtime.serialization.SerializationUtil;
import us.dot.its.jpo.asn.runtime.types.Asn1Bitstring;
import us.dot.its.jpo.asn.runtime.types.Asn1Choice;
import us.dot.its.jpo.asn.runtime.types.Asn1Enumerated;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;
import us.dot.its.jpo.asn.runtime.types.Asn1ObjectIdentifier;
import us.dot.its.jpo.asn.runtime.types.Asn1RelativeOID;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;
import us.dot.its.jpo.asn.runtime.types.Asn1SequenceOf;
import us.dot.its.jpo.asn.runtime.types.Asn1Type;
import us.dot.its.jpo.asn.runtime.types.IA5String;

public abstract class RandomGenerator<T extends Asn1Type> {

  protected final String pdu;
  protected final int sequenceOfLimit;

  public RandomGenerator(String pdu, int sequenceOfLimit) {
    this.pdu = pdu;
    this.sequenceOfLimit = sequenceOfLimit;
  }

  protected abstract void populateRandom(T instance);

  protected static <T extends Asn1Type> RandomGenerator<?> getGeneratorForType(final Class<T> type,
      final int limit) {
    final String name = type.getName();
    if (Asn1Integer.class.isAssignableFrom(type)) {
      return new IntegerGenerator(name, limit);
    } else if (Asn1Sequence.class.isAssignableFrom(type)) {
      return new SequenceGenerator(name, limit);
    } else if (Asn1Bitstring.class.isAssignableFrom(type)) {
      return new BitstringGenerator(name, limit);
    } else if (Asn1Enumerated.class.isAssignableFrom(type)) {
      return new EnumeratedGenerator(name, limit);
    } else if (Asn1SequenceOf.class.isAssignableFrom(type)) {
      return new SequenceOfGenerator(name, limit);
    } else if (Asn1Choice.class.isAssignableFrom(type)) {
      return new ChoiceGenerator(name, limit);
    } else if (IA5String.class.isAssignableFrom(type)) {
      return new IA5StringGenerator(name, limit);
    } else if (Asn1ObjectIdentifier.class.isAssignableFrom(type)) {
      return new ObjectIdentifierGenerator(name, limit);
    } else if (Asn1RelativeOID.class.isAssignableFrom(type)) {
      return new RelativeOIDGenerator(name, limit);
    } else {
      System.err.printf("No RandomGenerator found for type %s%n", type.getName());
      return null;
    }
  }

  @SuppressWarnings({"unchecked"})
  protected T construct() {
    try {
      Class<?> clazz = Class.forName(pdu);
      Constructor<?> cons = clazz.getDeclaredConstructor();
      return (T) cons.newInstance();
    } catch (NoSuchMethodException nsme) {
      // There is no constructor, eg. for abstract class
      return null;
    } catch (ClassNotFoundException | InstantiationException |
             IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  public T createRandom() {
    T instance = construct();
    if (instance == null) {
      return null;
    }
    populateRandom(instance);
    return instance;
  }

  public String toXml(T instance) throws JsonProcessingException {
    var mapper = SerializationUtil.xmlMapper();
    return mapper.writeValueAsString(instance);
  }

  public String toJson(T instance) throws JsonProcessingException {
    var mapper = SerializationUtil.jsonMapper();
    return mapper.writeValueAsString(instance);
  }
}
