/*==============================================================================
 *
 * This source file was generated by a tool.
 * Beware manual edits might be overwritten in future releases.
 * asn1jvm v1.0-SNAPSHOT
 *
 *------------------------------------------------------------------------------
 * Copyright 2024 USDOT
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *============================================================================*/

package us.dot.its.jpo.asn.j2735.r2024.J2540ITIS;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;

public class Temperature extends Asn1Integer {

  private static final NamedValues namedValues = new NamedValues();

  public Temperature() {
    super(0L, 65535L);
  }

  @JsonCreator
  public Temperature(long value) {
    this();
    this.setValue(value);
  }

  private static class NamedValues {
    private final Map<String, Long> nameMap;
    private final Map<Long, String> valueMap;

    public NamedValues() {
      var mapBuilder = new LinkedHashMap<String, Long>();
      mapBuilder.put("maximum-temperature", 5633L);
      mapBuilder.put("temperature", 5634L);
      mapBuilder.put("minimum-temperature", 5635L);
      mapBuilder.put("current-temperature", 5636L);
      mapBuilder.put("heat-index", 5637L);
      mapBuilder.put("extreme-heat", 5638L);
      mapBuilder.put("hot", 5639L);
      mapBuilder.put("hotter", 5640L);
      mapBuilder.put("heat", 5641L);
      mapBuilder.put("warmer", 5642L);
      mapBuilder.put("warm", 5643L);
      mapBuilder.put("mild", 5644L);
      mapBuilder.put("cool", 5645L);
      mapBuilder.put("cooler", 5646L);
      mapBuilder.put("cold", 5647L);
      mapBuilder.put("colder", 5648L);
      mapBuilder.put("very-cold", 5649L);
      mapBuilder.put("extreme-cold", 5650L);
      mapBuilder.put("wind-chill", 5651L);
      mapBuilder.put("dewpoint", 5652L);
      mapBuilder.put("relative-humidity", 5653L);
      mapBuilder.put("temperatures-close-to-the-seasonal-norm", 5758L);
      mapBuilder.put("less-extreme-temperatures", 5759L);
      nameMap = Collections.unmodifiableMap(mapBuilder);
      final var valueMapBuilder = new LinkedHashMap<Long, String>();
      mapBuilder.forEach((k, v) -> valueMapBuilder.put(v, k));
      valueMap = Collections.unmodifiableMap(valueMapBuilder);
    }
  }

  @Override
  public Optional<String> name() {
    return Optional.ofNullable(namedValues.valueMap.get(getValue()));
  }

  public static Optional<Temperature> named(String name) {
    return Optional.ofNullable(namedValues.nameMap.get(name)).map(Temperature::new);
  }

  public static Set<String> names() {
    return namedValues.nameMap.keySet();
  }

  public static Set<Long> namedValues() {
    return namedValues.valueMap.keySet();
  }
}
