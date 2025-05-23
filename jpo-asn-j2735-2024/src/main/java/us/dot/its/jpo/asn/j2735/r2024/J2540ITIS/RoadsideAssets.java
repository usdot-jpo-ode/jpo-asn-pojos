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

public class RoadsideAssets extends Asn1Integer {

  private static final NamedValues namedValues = new NamedValues();

  public RoadsideAssets() {
    super(0L, 65535L);
  }

  @JsonCreator
  public RoadsideAssets(long value) {
    this();
    this.setValue(value);
  }

  private static class NamedValues {
    private final Map<String, Long> nameMap;
    private final Map<Long, String> valueMap;

    public NamedValues() {
      var mapBuilder = new LinkedHashMap<String, Long>();
      mapBuilder.put("none", 10496L);
      mapBuilder.put("light-pole", 10497L);
      mapBuilder.put("utility-pole", 10498L);
      mapBuilder.put("gantry-way", 10499L);
      mapBuilder.put("sign-support", 10500L);
      mapBuilder.put("signal-pole", 10501L);
      mapBuilder.put("signage-public", 10502L);
      mapBuilder.put("signage-private", 10503L);
      mapBuilder.put("overhead-sign", 10568L);
      mapBuilder.put("ground-sign", 10569L);
      mapBuilder.put("cones", 10504L);
      mapBuilder.put("cones-post-type", 10505L);
      mapBuilder.put("cones-glue-post", 10506L);
      mapBuilder.put("cones-other", 10507L);
      mapBuilder.put("barriers", 10508L);
      mapBuilder.put("barrier-Aframe", 10509L);
      mapBuilder.put("barriers-heavy-duty", 10510L);
      mapBuilder.put("barricade-type-III", 10511L);
      mapBuilder.put("barricade-small", 10512L);
      mapBuilder.put("solid-barrier", 10565L);
      mapBuilder.put("moveable-barrier", 10566L);
      mapBuilder.put("barricade-lights", 10513L);
      mapBuilder.put("beacon", 10514L);
      mapBuilder.put("t-stand", 10515L);
      mapBuilder.put("a-stand", 10516L);
      mapBuilder.put("drums", 10517L);
      mapBuilder.put("sand-barrel", 10567L);
      mapBuilder.put("impact-attenuator", 10518L);
      mapBuilder.put("barricade-tape", 10519L);
      mapBuilder.put("safety-fence", 10520L);
      mapBuilder.put("temp-pavement-markings", 10521L);
      mapBuilder.put("speed-bumps", 10522L);
      mapBuilder.put("temp-curbs", 10523L);
      mapBuilder.put("parking-blocks", 10524L);
      mapBuilder.put("signboard-fixed", 10525L);
      mapBuilder.put("signboard-portable", 10526L);
      mapBuilder.put("stripe", 10572L);
      mapBuilder.put("island", 10573L);
      mapBuilder.put("har", 10527L);
      mapBuilder.put("har-AM", 10528L);
      mapBuilder.put("har-FM", 10529L);
      mapBuilder.put("har-DSRC", 10530L);
      mapBuilder.put("traffic-light", 10531L);
      mapBuilder.put("lane-control-signal", 10532L);
      mapBuilder.put("traffic-detector", 10533L);
      mapBuilder.put("vehicle-detector", 10534L);
      mapBuilder.put("system-alarm", 10535L);
      mapBuilder.put("arrow-board", 10536L);
      mapBuilder.put("fixed-VMS", 10537L);
      mapBuilder.put("mobile-VMS", 10538L);
      mapBuilder.put("ramp-control", 10539L);
      mapBuilder.put("gate-control", 10540L);
      mapBuilder.put("temporary-traffic-light", 10541L);
      mapBuilder.put("over-height-warning-system", 10542L);
      mapBuilder.put("over-weight-warning-system", 10543L);
      mapBuilder.put("emergency-telephones", 10544L);
      mapBuilder.put("railroad-crossing-equipment", 10545L);
      mapBuilder.put("tunnel-ventilation", 10546L);
      mapBuilder.put("ccTV", 10547L);
      mapBuilder.put("environmental-sensor", 10548L);
      mapBuilder.put("emergency-signal", 10570L);
      mapBuilder.put("countdown-pedestrian-sign", 10571L);
      mapBuilder.put("switch", 10549L);
      mapBuilder.put("signal", 10550L);
      mapBuilder.put("third-rail", 10551L);
      mapBuilder.put("overhead-power", 10552L);
      mapBuilder.put("concrete-tie", 10553L);
      mapBuilder.put("wooden-tie", 10554L);
      mapBuilder.put("manhole-cover", 10559L);
      mapBuilder.put("culvert", 10560L);
      mapBuilder.put("escalator", 10555L);
      mapBuilder.put("elevator", 10556L);
      mapBuilder.put("snow-poles", 10561L);
      mapBuilder.put("track", 10557L);
      mapBuilder.put("guide-poles", 10562L);
      mapBuilder.put("drawbridge", 10558L);
      mapBuilder.put("expansion-joint", 10563L);
      mapBuilder.put("shifted-plate", 10564L);
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

  public static Optional<RoadsideAssets> named(String name) {
    return Optional.ofNullable(namedValues.nameMap.get(name)).map(RoadsideAssets::new);
  }

  public static Set<String> names() {
    return namedValues.nameMap.keySet();
  }

  public static Set<Long> namedValues() {
    return namedValues.valueMap.keySet();
  }
}
