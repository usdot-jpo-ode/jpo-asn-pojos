package us.dot.its.jpo.asn.testgenerator;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import us.dot.its.jpo.asn.runtime.serialization.SerializationUtil;
import us.dot.its.jpo.asn.runtime.types.Asn1Bitstring;
import us.dot.its.jpo.asn.runtime.types.Asn1Enumerated;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;
import us.dot.its.jpo.asn.runtime.types.Asn1Type;

public abstract class RandomGenerator<T extends Asn1Type> {
  protected final String pdu;

  public RandomGenerator(String pdu) {
    this.pdu = pdu;
  }

  protected abstract void populateRandom(T instance);

  protected static <T extends Asn1Type> RandomGenerator<?> getGeneratorForType(Class<T> type) {
    final String name = type.getName();
    if (Asn1Integer.class.isAssignableFrom(type)) {
      return new IntegerGenerator(name);
    } else if (Asn1Sequence.class.isAssignableFrom(type)) {
      return new SequenceGenerator(name);
    } else if (Asn1Bitstring.class.isAssignableFrom(type)) {
      return new BitstringGenerator(name);
    } else if (Asn1Enumerated.class.isAssignableFrom(type)) {
      return new EnumeratedGenerator(name);
    } else {
      return null;
    }
  }

  @SuppressWarnings({"unchecked"})
  protected T construct() {
    try {
      Class<?> clazz = Class.forName(pdu);
      Constructor<?> cons = clazz.getDeclaredConstructor();
      return (T) cons.newInstance();
    } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException |
             IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  public T createRandom() {
    T instance = construct();
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
