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

package us.dot.its.jpo.asn.j2735.r2024.ITIS;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import us.dot.its.jpo.asn.runtime.serialization.EnumeratedDeserializer;
import us.dot.its.jpo.asn.runtime.serialization.EnumeratedSerializer;
import us.dot.its.jpo.asn.runtime.types.Asn1Enumerated;

@Getter
@JsonSerialize(using = VehicleGroupAffected.VehicleGroupAffectedSerializer.class)
@JsonDeserialize(using = VehicleGroupAffected.VehicleGroupAffectedDeserializer.class)
public enum VehicleGroupAffected implements Asn1Enumerated {
  ALL_VEHICLES(9217, "all-vehicles"),
  BICYCLES(9218, "bicycles"),
  MOTORCYCLES(9219, "motorcycles"),
  CARS(9220, "cars"),
  LIGHT_VEHICLES(9221, "light-vehicles"),
  CARS_AND_LIGHT_VEHICLES(9222, "cars-and-light-vehicles"),
  CARS_WITH_TRAILERS(9223, "cars-with-trailers"),
  CARS_WITH_RECREATIONAL_TRAILERS(9224, "cars-with-recreational-trailers"),
  VEHICLES_WITH_TRAILERS(9225, "vehicles-with-trailers"),
  HEAVY_VEHICLES(9226, "heavy-vehicles"),
  TRUCKS(9227, "trucks"),
  BUSES(9228, "buses"),
  ARTICULATED_BUSES(9229, "articulated-buses"),
  SCHOOL_BUSES(9230, "school-buses"),
  VEHICLES_WITH_SEMI_TRAILERS(9231, "vehicles-with-semi-trailers"),
  VEHICLES_WITH_DOUBLE_TRAILERS(9232, "vehicles-with-double-trailers"),
  HIGH_PROFILE_VEHICLES(9233, "high-profile-vehicles"),
  WIDE_VEHICLES(9234, "wide-vehicles"),
  LONG_VEHICLES(9235, "long-vehicles"),
  HAZARDOUS_LOADS(9236, "hazardous-loads"),
  EXCEPTIONAL_LOADS(9237, "exceptional-loads"),
  ABNORMAL_LOADS(9238, "abnormal-loads"),
  CONVOYS(9239, "convoys"),
  MAINTENANCE_VEHICLES(9240, "maintenance-vehicles"),
  DELIVERY_VEHICLES(9241, "delivery-vehicles"),
  VEHICLES_WITH_EVEN_NUMBERED_LICENSE_PLATES(9242, "vehicles-with-even-numbered-license-plates"),
  VEHICLES_WITH_ODD_NUMBERED_LICENSE_PLATES(9243, "vehicles-with-odd-numbered-license-plates"),
  VEHICLES_WITH_PARKING_PERMITS(9244, "vehicles-with-parking-permits"),
  VEHICLES_WITH_CATALYTIC_CONVERTERS(9245, "vehicles-with-catalytic-converters"),
  VEHICLES_WITHOUT_CATALYTIC_CONVERTERS(9246, "vehicles-without-catalytic-converters"),
  GAS_POWERED_VEHICLES(9247, "gas-powered-vehicles"),
  DIESEL_POWERED_VEHICLES(9248, "diesel-powered-vehicles"),
  LPG_VEHICLES(9249, "lPG-vehicles"),
  MILITARY_CONVOYS(9250, "military-convoys"),
  MILITARY_VEHICLES(9251, "military-vehicles");

  private final int index;
  private final String name;

  private VehicleGroupAffected(int index, String name) {
    this.index = index;
    this.name = name;
  }

  public static class VehicleGroupAffectedSerializer
      extends EnumeratedSerializer<VehicleGroupAffected> {
    public VehicleGroupAffectedSerializer() {
      super(VehicleGroupAffected.class);
    }
  }

  public static class VehicleGroupAffectedDeserializer
      extends EnumeratedDeserializer<VehicleGroupAffected> {
    public VehicleGroupAffectedDeserializer() {
      super(VehicleGroupAffected.class);
    }

    @Override
    protected VehicleGroupAffected[] listEnumValues() {
      return VehicleGroupAffected.values();
    }
  }
}
