package us.dot.its.jpo.asn.j2735.r2024.EfcDataDictionary;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import us.dot.its.jpo.asn.j2735.r2024.BaseNamedIntegerTest;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;

public class EfcDataDictionaryNamedIntegerTests {

  @ParameterizedTest
  @MethodSource("namedIntegerTypes")
  public <T extends Asn1Integer> void testType(Class<T> clazz) {
    var test = new BaseNamedIntegerTest<>(clazz);
    Set<String> names = test.names();
    assertThat(names, hasSize(greaterThan(0)));
    Set<Long> values = test.namedValues();
    assertThat(values, hasSize(greaterThan(0)));
    var iter = names.iterator();
    while (iter.hasNext()) {
      String theName = iter.next();
      Optional<T> named = test.named(theName);
      assertTrue(named.isPresent());
      assertTrue(named.get().name().isPresent());
      assertThat(named.get().name().get(), equalTo(theName));
    }


  }

  public static Stream<Arguments> namedIntegerTypes() {
    Class<?>[] classes = {
        ResultOp.class,
        StationType.class,
        DistanceUnit.class,
        Weekday.class,
        TimeUnit.class,
        AccountStatus.class,
        DetectionMode.class,
        DescriptiveCharacteristics.class,
        FutureCharacteristics.class,
        TrailerType.class,
        EngineCharacteristics.class,
        EuroValue.class,
        EmissionUnit.class,
        TyreConfiguration.class,
        CopValue.class
    };
    return Arrays.stream(classes).map(Arguments::of);
  }

}
