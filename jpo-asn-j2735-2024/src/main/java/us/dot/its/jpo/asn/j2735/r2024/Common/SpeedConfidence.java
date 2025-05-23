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

package us.dot.its.jpo.asn.j2735.r2024.Common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import us.dot.its.jpo.asn.runtime.serialization.EnumeratedDeserializer;
import us.dot.its.jpo.asn.runtime.serialization.EnumeratedSerializer;
import us.dot.its.jpo.asn.runtime.types.Asn1Enumerated;

@Getter
@JsonSerialize(using = SpeedConfidence.SpeedConfidenceSerializer.class)
@JsonDeserialize(using = SpeedConfidence.SpeedConfidenceDeserializer.class)
public enum SpeedConfidence implements Asn1Enumerated {
  UNAVAILABLE(0, "unavailable"),
  PREC100MS(1, "prec100ms"),
  PREC10MS(2, "prec10ms"),
  PREC5MS(3, "prec5ms"),
  PREC1MS(4, "prec1ms"),
  PREC0_1MS(5, "prec0-1ms"),
  PREC0_05MS(6, "prec0-05ms"),
  PREC0_01MS(7, "prec0-01ms");

  private final int index;
  private final String name;

  private SpeedConfidence(int index, String name) {
    this.index = index;
    this.name = name;
  }

  public static class SpeedConfidenceSerializer extends EnumeratedSerializer<SpeedConfidence> {
    public SpeedConfidenceSerializer() {
      super(SpeedConfidence.class);
    }
  }

  public static class SpeedConfidenceDeserializer extends EnumeratedDeserializer<SpeedConfidence> {
    public SpeedConfidenceDeserializer() {
      super(SpeedConfidence.class);
    }

    @Override
    protected SpeedConfidence[] listEnumValues() {
      return SpeedConfidence.values();
    }
  }
}
