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

package us.dot.its.jpo.asn.j2735.r2024.TollAdvertisementMessage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import us.dot.its.jpo.asn.j2735.r2024.EfcDataDictionary.PaymentFee;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.serialization.EnumeratedDeserializer;
import us.dot.its.jpo.asn.runtime.serialization.EnumeratedSerializer;
import us.dot.its.jpo.asn.runtime.types.Asn1Enumerated;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
@Getter
@Setter
public class PerAxleWeightCharges extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "totalWeightLimit")
  @JsonProperty("totalWeightLimit")
  private TotalWeightLimitInteger totalWeightLimit;

  @Asn1Property(tag = 1, name = "maxLadenWeightOnAxle")
  @JsonProperty("maxLadenWeightOnAxle")
  private MaxLadenWeightOnAxleInteger maxLadenWeightOnAxle;

  @Asn1Property(tag = 2, name = "weightLimitUnits")
  @JsonProperty("weightLimitUnits")
  private EnumeratedWeightLimitUnits weightLimitUnits;

  @Asn1Property(tag = 3, name = "axleWeightCharge")
  @JsonProperty("axleWeightCharge")
  private PaymentFee axleWeightCharge;

  public static class TotalWeightLimitInteger extends Asn1Integer {
    public TotalWeightLimitInteger() {
      super(0L, 16777215L);
    }

    @JsonCreator
    public TotalWeightLimitInteger(long value) {
      this();
      this.setValue(value);
    }
  }

  public static class MaxLadenWeightOnAxleInteger extends Asn1Integer {
    public MaxLadenWeightOnAxleInteger() {
      super(0L, 65535L);
    }

    @JsonCreator
    public MaxLadenWeightOnAxleInteger(long value) {
      this();
      this.setValue(value);
    }
  }

  @Getter
  @JsonSerialize(using = EnumeratedWeightLimitUnitsSerializer.class)
  @JsonDeserialize(using = EnumeratedWeightLimitUnitsDeserializer.class)
  public enum EnumeratedWeightLimitUnits implements Asn1Enumerated {
    POUNDS(0, "pounds"),
    KILOGRAMS(1, "kilograms");

    private final int index;
    private final String name;

    private EnumeratedWeightLimitUnits(int index, String name) {
      this.index = index;
      this.name = name;
    }
  }

  public static class EnumeratedWeightLimitUnitsSerializer
      extends EnumeratedSerializer<EnumeratedWeightLimitUnits> {
    public EnumeratedWeightLimitUnitsSerializer() {
      super(EnumeratedWeightLimitUnits.class);
    }
  }

  public static class EnumeratedWeightLimitUnitsDeserializer
      extends EnumeratedDeserializer<EnumeratedWeightLimitUnits> {
    public EnumeratedWeightLimitUnitsDeserializer() {
      super(EnumeratedWeightLimitUnits.class);
    }

    @Override
    protected EnumeratedWeightLimitUnits[] listEnumValues() {
      return EnumeratedWeightLimitUnits.values();
    }
  }

  public PerAxleWeightCharges() {}

  @Override
  public boolean hasExtensionMarker() {
    return true;
  }
}
