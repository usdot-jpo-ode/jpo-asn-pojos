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

public class TransitOperations extends Asn1Integer {

  private static final NamedValues namedValues = new NamedValues();

  public TransitOperations() {
    super(0L, 65535L);
  }

  @JsonCreator
  public TransitOperations(long value) {
    this();
    this.setValue(value);
  }

  private static class NamedValues {
    private final Map<String, Long> nameMap;
    private final Map<Long, String> valueMap;

    public NamedValues() {
      var mapBuilder = new LinkedHashMap<String, Long>();
      mapBuilder.put("unknown-transit-problem", 10753L);
      mapBuilder.put("sleeping-customer", 10754L);
      mapBuilder.put("assault-on-passenger", 10755L);
      mapBuilder.put("assault-on-employee", 10756L);
      mapBuilder.put("broken-seat", 10757L);
      mapBuilder.put("bus-alarm", 10758L);
      mapBuilder.put("crime-or-drug-deal", 10759L);
      mapBuilder.put("eating-on-board", 10760L);
      mapBuilder.put("equipment-problem-with-air-conditioning", 10761L);
      mapBuilder.put("equipment-problem-with-air-system", 10762L);
      mapBuilder.put("equipment-problem-with-brakes", 10763L);
      mapBuilder.put("equipment-problem-with-chassis-or-suspension", 10764L);
      mapBuilder.put("equipment-problem-with-cooling-system", 10765L);
      mapBuilder.put("equipment-problem-with-doors", 10766L);
      mapBuilder.put("equipment-problem-with-electrical", 10767L);
      mapBuilder.put("equipment-problem-with-engine", 10768L);
      mapBuilder.put("equipment-problem-with-exterior-or-body", 10769L);
      mapBuilder.put("equipment-problem-with-fare-collection", 10770L);
      mapBuilder.put("equipment-problem-with-fuel-or-exhaust", 10771L);
      mapBuilder.put("equipment-problem-with-horn", 10772L);
      mapBuilder.put("equipment-problem-with-interior", 10773L);
      mapBuilder.put("equipment-problem-with-liftkneeling", 10774L);
      mapBuilder.put("equipment-problem-with-lights", 10775L);
      mapBuilder.put("equipment-problem-with-lubrication", 10776L);
      mapBuilder.put("equipment-problem-with-radio-or-communication", 10777L);
      mapBuilder.put("equipment-problem-with-signs", 10778L);
      mapBuilder.put("equipment-problem-with-steering", 10779L);
      mapBuilder.put("equipment-problem-with-tires", 10780L);
      mapBuilder.put("equipment-problem-with-transmission", 10781L);
      mapBuilder.put("equipment-problem-with-unknown-alarm", 10782L);
      mapBuilder.put("equipment-problem-with-wipers", 10783L);
      mapBuilder.put("fare-dispute-expired-pass", 10784L);
      mapBuilder.put("fare-dispute-expired-transfer", 10785L);
      mapBuilder.put("fare-dispute-expired-upgrade", 10786L);
      mapBuilder.put("fare-dispute-other", 10787L);
      mapBuilder.put("fare-dispute-refuses-to-pay", 10788L);
      mapBuilder.put("lift-passenger-cycle-completed", 10789L);
      mapBuilder.put("lift-passenger-ready-to-alight", 10790L);
      mapBuilder.put("lift-passenger-ready-to-board", 10791L);
      mapBuilder.put("lost-article", 10792L);
      mapBuilder.put("objects-thrown", 10793L);
      mapBuilder.put("passenger-accident-alighting", 10794L);
      mapBuilder.put("passenger-accident-boarding", 10795L);
      mapBuilder.put("passenger-accident-fallen-on-board", 10796L);
      mapBuilder.put("passenger-load", 10797L);
      mapBuilder.put("passenger-accident-other", 10798L);
      mapBuilder.put("passenger-sick-or-injured", 10799L);
      mapBuilder.put("right-of-way", 10800L);
      mapBuilder.put("theft", 10801L);
      mapBuilder.put("theft-of-service", 10802L);
      mapBuilder.put("waiting-to-get-relief-for-schedule-break", 10803L);
      mapBuilder.put("waiting-to-get-relief-after-run-is-finished", 10804L);
      mapBuilder.put("waiting-to-provide-relief", 10805L);
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

  public static Optional<TransitOperations> named(String name) {
    return Optional.ofNullable(namedValues.nameMap.get(name)).map(TransitOperations::new);
  }

  public static Set<String> names() {
    return namedValues.nameMap.keySet();
  }

  public static Set<Long> namedValues() {
    return namedValues.valueMap.keySet();
  }
}
