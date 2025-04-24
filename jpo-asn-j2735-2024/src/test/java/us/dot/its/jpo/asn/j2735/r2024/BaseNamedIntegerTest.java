package us.dot.its.jpo.asn.j2735.r2024;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.InvocationTargetException;
import java.util.Optional;
import java.util.Set;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;

/**
 * Base class for tests for Asn1Integer types with named values
 * @param <T> The Asn1Integer type
 */
public class BaseNamedIntegerTest<T extends Asn1Integer> {

  public BaseNamedIntegerTest(Class<T> clazz) {
    this.clazz = clazz;
  }

  protected final Class<T> clazz;


  private String className() {
    return clazz.getName();
  }

  public void nameTest(final long value, final String expectName) {
    T msg = construct(value);
    assertTrue(msg.name().isPresent(), className() + ": name not present");
    assertThat(className() + ": unexpected name", msg.name().get(), equalTo(expectName));
  }

  public void namedTest(final String name, final long expectValue) {
    Optional<T> msg = named(name);
    assertTrue(msg.isPresent(), className() + ": named not present");
    assertThat(className() + ": unexpected value", msg.get().getValue(), equalTo(expectValue));
  }

  public void namesTest(final String... expectNames) {
    Set<String> nameSet = names();
    for (String expectName : expectNames) {
      assertThat(className() + ": missing name", nameSet, hasItem(expectName));
    }
  }

  public void namedValuesTest(final Long... expectValues) {
    Set<Long> valueSet = namedValues();
    for (Long expectValue : expectValues) {
      assertThat(className() + ": missing value", valueSet, hasItem(expectValue));
    }
  }


  /**
   * Construct an instance of the class with value
   * @param value Value
   * @return Constructed instance
   */
  protected T construct(long value) {
    try {
      var cons = clazz.getConstructor(Long.TYPE);
      return cons.newInstance(value);
    } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
             InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Invoke the static 'named' method on the class
   * @param name Name argument
   * @return result of T.named(name)
   */
  @SuppressWarnings({"unchecked"})
  public Optional<T> named(String name) {
    try {
      var namedMethod = clazz.getMethod("named", String.class);
      return (Optional<T>)namedMethod.invoke(null, name);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Invoke the static 'names' method on the class
   * @return result of T.names()
   */
  @SuppressWarnings({"unchecked"})
  public Set<String> names() {
    try {
      var namesMethod = clazz.getMethod("names");
      return (Set<String>)namesMethod.invoke(null);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Invoke the static 'namedValues' method on the class
   * @return result of T.namedValues()
   */
  @SuppressWarnings({"unchecked"})
  public Set<Long> namedValues() {
    try {
      var namedValuesMethod = clazz.getMethod("namedValues");
      return (Set<Long>)namedValuesMethod.invoke(null);
    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }



}
