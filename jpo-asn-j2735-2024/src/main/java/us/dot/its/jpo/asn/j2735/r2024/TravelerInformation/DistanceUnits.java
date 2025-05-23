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

package us.dot.its.jpo.asn.j2735.r2024.TravelerInformation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import us.dot.its.jpo.asn.runtime.serialization.EnumeratedDeserializer;
import us.dot.its.jpo.asn.runtime.serialization.EnumeratedSerializer;
import us.dot.its.jpo.asn.runtime.types.Asn1Enumerated;

@Getter
@JsonSerialize(using = DistanceUnits.DistanceUnitsSerializer.class)
@JsonDeserialize(using = DistanceUnits.DistanceUnitsDeserializer.class)
public enum DistanceUnits implements Asn1Enumerated {
  CENTIMETER(0, "centimeter"),
  CM2_5(1, "cm2-5"),
  DECIMETER(2, "decimeter"),
  METER(3, "meter"),
  KILOMETER(4, "kilometer"),
  FOOT(5, "foot"),
  YARD(6, "yard"),
  MILE(7, "mile");

  private final int index;
  private final String name;

  private DistanceUnits(int index, String name) {
    this.index = index;
    this.name = name;
  }

  public static class DistanceUnitsSerializer extends EnumeratedSerializer<DistanceUnits> {
    public DistanceUnitsSerializer() {
      super(DistanceUnits.class);
    }
  }

  public static class DistanceUnitsDeserializer extends EnumeratedDeserializer<DistanceUnits> {
    public DistanceUnitsDeserializer() {
      super(DistanceUnits.class);
    }

    @Override
    protected DistanceUnits[] listEnumValues() {
      return DistanceUnits.values();
    }
  }
}
