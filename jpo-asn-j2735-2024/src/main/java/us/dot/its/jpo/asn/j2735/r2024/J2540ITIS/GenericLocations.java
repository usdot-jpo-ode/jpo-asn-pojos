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

public class GenericLocations extends Asn1Integer {

  private static final NamedValues namedValues = new NamedValues();

  public GenericLocations() {
    super(0L, 65535L);
  }

  @JsonCreator
  public GenericLocations(long value) {
    this();
    this.setValue(value);
  }

  private static class NamedValues {
    private final Map<String, Long> nameMap;
    private final Map<Long, String> valueMap;

    public NamedValues() {
      var mapBuilder = new LinkedHashMap<String, Long>();
      mapBuilder.put("on-bridges", 7937L);
      mapBuilder.put("in-tunnels", 7938L);
      mapBuilder.put("entering-or-leaving-tunnels", 7939L);
      mapBuilder.put("on-ramps", 7940L);
      mapBuilder.put("in-road-construction-area", 7941L);
      mapBuilder.put("around-a-curve", 7942L);
      mapBuilder.put("on-curve", 8026L);
      mapBuilder.put("on-tracks", 8009L);
      mapBuilder.put("in-street", 8025L);
      mapBuilder.put("shoulder", 8027L);
      mapBuilder.put("on-minor-roads", 7943L);
      mapBuilder.put("in-the-opposing-lanes", 7944L);
      mapBuilder.put("adjacent-to-roadway", 7945L);
      mapBuilder.put("across-tracks", 8024L);
      mapBuilder.put("on-bend", 7946L);
      mapBuilder.put("intersection", 8032L);
      mapBuilder.put("entire-intersection", 7947L);
      mapBuilder.put("in-the-median", 7948L);
      mapBuilder.put("moved-to-side-of-road", 7949L);
      mapBuilder.put("moved-to-shoulder", 7950L);
      mapBuilder.put("on-the-roadway", 7951L);
      mapBuilder.put("dip", 8010L);
      mapBuilder.put("traffic-circle", 8011L);
      mapBuilder.put("crossover", 8028L);
      mapBuilder.put("cross-road", 8029L);
      mapBuilder.put("side-road", 8030L);
      mapBuilder.put("to", 8014L);
      mapBuilder.put("by", 8015L);
      mapBuilder.put("through", 8016L);
      mapBuilder.put("area-of", 8017L);
      mapBuilder.put("under", 8018L);
      mapBuilder.put("over", 8019L);
      mapBuilder.put("from", 8020L);
      mapBuilder.put("approaching", 8021L);
      mapBuilder.put("entering-at", 8022L);
      mapBuilder.put("exiting-at", 8023L);
      mapBuilder.put("in-shaded-areas", 7952L);
      mapBuilder.put("in-low-lying-areas", 7953L);
      mapBuilder.put("in-the-downtown-area", 7954L);
      mapBuilder.put("in-the-inner-city-area", 7955L);
      mapBuilder.put("in-parts", 7956L);
      mapBuilder.put("in-some-places", 7957L);
      mapBuilder.put("in-the-ditch", 7958L);
      mapBuilder.put("in-the-valley", 7959L);
      mapBuilder.put("on-hill-top", 7960L);
      mapBuilder.put("near-the-foothills", 7961L);
      mapBuilder.put("at-high-altitudes", 7962L);
      mapBuilder.put("near-the-lake", 7963L);
      mapBuilder.put("near-the-shore", 7964L);
      mapBuilder.put("nearby-basin", 8008L);
      mapBuilder.put("over-the-crest-of-a-hill", 7965L);
      mapBuilder.put("other-than-on-the-roadway", 7966L);
      mapBuilder.put("near-the-beach", 7967L);
      mapBuilder.put("near-beach-access-point", 7968L);
      mapBuilder.put("mountain-pass", 8006L);
      mapBuilder.put("lower-level", 7969L);
      mapBuilder.put("upper-level", 7970L);
      mapBuilder.put("coast", 8034L);
      mapBuilder.put("airport", 7971L);
      mapBuilder.put("concourse", 7972L);
      mapBuilder.put("gate", 7973L);
      mapBuilder.put("baggage-claim", 7974L);
      mapBuilder.put("customs-point", 7975L);
      mapBuilder.put("reservation-center", 8007L);
      mapBuilder.put("station", 7976L);
      mapBuilder.put("platform", 7977L);
      mapBuilder.put("dock", 7978L);
      mapBuilder.put("depot", 7979L);
      mapBuilder.put("ev-charging-point", 7980L);
      mapBuilder.put("information-welcome-point", 7981L);
      mapBuilder.put("at-rest-area", 7982L);
      mapBuilder.put("at-service-area", 7983L);
      mapBuilder.put("at-weigh-station", 7984L);
      mapBuilder.put("roadside-park", 8033L);
      mapBuilder.put("picnic-areas", 7985L);
      mapBuilder.put("rest-area", 7986L);
      mapBuilder.put("service-stations", 7987L);
      mapBuilder.put("toilets", 7988L);
      mapBuilder.put("bus-stop", 8031L);
      mapBuilder.put("park-and-ride-lot", 8012L);
      mapBuilder.put("on-the-right", 7989L);
      mapBuilder.put("on-the-left", 7990L);
      mapBuilder.put("in-the-center", 7991L);
      mapBuilder.put("in-the-opposite-direction", 7992L);
      mapBuilder.put("cross-traffic", 7993L);
      mapBuilder.put("northbound-traffic", 7994L);
      mapBuilder.put("eastbound-traffic", 7995L);
      mapBuilder.put("southbound-traffic", 7996L);
      mapBuilder.put("westbound-traffic", 7997L);
      mapBuilder.put("north", 7998L);
      mapBuilder.put("south", 7999L);
      mapBuilder.put("east", 8000L);
      mapBuilder.put("west", 8001L);
      mapBuilder.put("northeast", 8002L);
      mapBuilder.put("northwest", 8003L);
      mapBuilder.put("southeast", 8004L);
      mapBuilder.put("southwest", 8005L);
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

  public static Optional<GenericLocations> named(String name) {
    return Optional.ofNullable(namedValues.nameMap.get(name)).map(GenericLocations::new);
  }

  public static Set<String> names() {
    return namedValues.nameMap.keySet();
  }

  public static Set<Long> namedValues() {
    return namedValues.valueMap.keySet();
  }
}
