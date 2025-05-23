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

package us.dot.its.jpo.asn.j2735.r2024.MapData;

import us.dot.its.jpo.asn.runtime.types.Asn1Bitstring;

public class LaneSharing extends Asn1Bitstring {

  public boolean isOverlappingLaneDescriptionProvided() {
    return get(0);
  }

  public void setOverlappingLaneDescriptionProvided(boolean overlappingLaneDescriptionProvided) {
    set(0, overlappingLaneDescriptionProvided);
  }

  public boolean isMultipleLanesTreatedAsOneLane() {
    return get(1);
  }

  public void setMultipleLanesTreatedAsOneLane(boolean multipleLanesTreatedAsOneLane) {
    set(1, multipleLanesTreatedAsOneLane);
  }

  public boolean isOtherNonMotorizedTrafficTypes() {
    return get(2);
  }

  public void setOtherNonMotorizedTrafficTypes(boolean otherNonMotorizedTrafficTypes) {
    set(2, otherNonMotorizedTrafficTypes);
  }

  public boolean isIndividualMotorizedVehicleTraffic() {
    return get(3);
  }

  public void setIndividualMotorizedVehicleTraffic(boolean individualMotorizedVehicleTraffic) {
    set(3, individualMotorizedVehicleTraffic);
  }

  public boolean isBusVehicleTraffic() {
    return get(4);
  }

  public void setBusVehicleTraffic(boolean busVehicleTraffic) {
    set(4, busVehicleTraffic);
  }

  public boolean isTaxiVehicleTraffic() {
    return get(5);
  }

  public void setTaxiVehicleTraffic(boolean taxiVehicleTraffic) {
    set(5, taxiVehicleTraffic);
  }

  public boolean isPedestriansTraffic() {
    return get(6);
  }

  public void setPedestriansTraffic(boolean pedestriansTraffic) {
    set(6, pedestriansTraffic);
  }

  public boolean isCyclistVehicleTraffic() {
    return get(7);
  }

  public void setCyclistVehicleTraffic(boolean cyclistVehicleTraffic) {
    set(7, cyclistVehicleTraffic);
  }

  public boolean isTrackedVehicleTraffic() {
    return get(8);
  }

  public void setTrackedVehicleTraffic(boolean trackedVehicleTraffic) {
    set(8, trackedVehicleTraffic);
  }

  public boolean isReserved() {
    return get(9);
  }

  public void setReserved(boolean reserved) {
    set(9, reserved);
  }

  public LaneSharing() {
    super(
        10,
        false,
        new String[] {
          "overlappingLaneDescriptionProvided",
          "multipleLanesTreatedAsOneLane",
          "otherNonMotorizedTrafficTypes",
          "individualMotorizedVehicleTraffic",
          "busVehicleTraffic",
          "taxiVehicleTraffic",
          "pedestriansTraffic",
          "cyclistVehicleTraffic",
          "trackedVehicleTraffic",
          "reserved"
        });
  }
}
