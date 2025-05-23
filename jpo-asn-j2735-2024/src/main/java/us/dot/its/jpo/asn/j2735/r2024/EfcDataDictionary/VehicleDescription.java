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

package us.dot.its.jpo.asn.j2735.r2024.EfcDataDictionary;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
@Getter
@Setter
public class VehicleDescription extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "vehicleLPNr", optional = true)
  @JsonProperty("vehicleLPNr")
  private Lpn vehicleLPNr;

  @Asn1Property(tag = 1, name = "axles", optional = true)
  @JsonProperty("axles")
  private VehicleAxles axles;

  @Asn1Property(tag = 2, name = "class", optional = true)
  @JsonProperty("class")
  private VehicleClass class_;

  @Asn1Property(tag = 3, name = "dimensions", optional = true)
  @JsonProperty("dimensions")
  private VehicleDimensions dimensions;

  @Asn1Property(tag = 4, name = "specificCharacteristics", optional = true)
  @JsonProperty("specificCharacteristics")
  private VehicleSpecificCharacteristics specificCharacteristics;

  @Asn1Property(tag = 5, name = "ladenWeight", optional = true)
  @JsonProperty("ladenWeight")
  private VehicleWeightLaden ladenWeight;

  @Asn1Property(tag = 6, name = "weightLimits", optional = true)
  @JsonProperty("weightLimits")
  private VehicleWeightLimits weightLimits;

  @Asn1Property(tag = 7, name = "trailerCharacteristics", optional = true)
  @JsonProperty("trailerCharacteristics")
  private TrailerCharacteristics trailerCharacteristics;

  @Asn1Property(tag = 8, name = "vehicleCurrentMaxTrainWeight", optional = true)
  @JsonProperty("vehicleCurrentMaxTrainWeight")
  private VehicleCurrentMaxTrainWeight vehicleCurrentMaxTrainWeight;

  @Asn1Property(tag = 9, name = "actualNumberOfPassengers", optional = true)
  @JsonProperty("actualNumberOfPassengers")
  private ActualNumberOfPassengers actualNumberOfPassengers;

  @Asn1Property(tag = 10, name = "axleWeightLimits", optional = true)
  @JsonProperty("axleWeightLimits")
  private AxleWeightLimits axleWeightLimits;

  @Asn1Property(tag = 11, name = "dieselEmissionValues", optional = true)
  @JsonProperty("dieselEmissionValues")
  private DieselEmissionValues dieselEmissionValues;

  @Asn1Property(tag = 12, name = "driverCharacteristics", optional = true)
  @JsonProperty("driverCharacteristics")
  private DriverCharacteristics driverCharacteristics;

  @Asn1Property(tag = 13, name = "engineDetails", optional = true)
  @JsonProperty("engineDetails")
  private EngineDetails engineDetails;

  @Asn1Property(tag = 14, name = "exhaustEmissionValues", optional = true)
  @JsonProperty("exhaustEmissionValues")
  private ExhaustEmissionValues exhaustEmissionValues;

  @Asn1Property(tag = 15, name = "passengerCapacity", optional = true)
  @JsonProperty("passengerCapacity")
  private PassengerCapacity passengerCapacity;

  @Asn1Property(tag = 16, name = "soundLevel", optional = true)
  @JsonProperty("soundLevel")
  private SoundLevel soundLevel;

  public VehicleDescription() {}

  @Override
  public boolean hasExtensionMarker() {
    return true;
  }
}
