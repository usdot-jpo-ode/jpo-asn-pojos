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

package us.dot.its.jpo.asn.j2735.r2024.CooperativeControlMessage;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import us.dot.its.jpo.asn.runtime.serialization.EnumeratedDeserializer;
import us.dot.its.jpo.asn.runtime.serialization.EnumeratedSerializer;
import us.dot.its.jpo.asn.runtime.types.Asn1Enumerated;

@Getter
@JsonSerialize(using = LongitudinalControlState.LongitudinalControlStateSerializer.class)
@JsonDeserialize(using = LongitudinalControlState.LongitudinalControlStateDeserializer.class)
public enum LongitudinalControlState implements Asn1Enumerated {
  UNAVAILABLE(0, "unavailable"),
  MANUAL(1, "manual"),
  CC(2, "cc"),
  ACC(3, "acc"),
  CACCONE(4, "caccOne"),
  CACCMULTIPLE(5, "caccMultiple"),
  SENSORAUTO(6, "sensorAuto"),
  FUSEDAUTO(7, "fusedAuto"),
  MANUALOVER(8, "manualOver");

  private final int index;
  private final String name;

  private LongitudinalControlState(int index, String name) {
    this.index = index;
    this.name = name;
  }

  public static class LongitudinalControlStateSerializer
      extends EnumeratedSerializer<LongitudinalControlState> {
    public LongitudinalControlStateSerializer() {
      super(LongitudinalControlState.class);
    }
  }

  public static class LongitudinalControlStateDeserializer
      extends EnumeratedDeserializer<LongitudinalControlState> {
    public LongitudinalControlStateDeserializer() {
      super(LongitudinalControlState.class);
    }

    @Override
    protected LongitudinalControlState[] listEnumValues() {
      return LongitudinalControlState.values();
    }
  }
}
