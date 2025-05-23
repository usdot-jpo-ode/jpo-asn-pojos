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

import us.dot.its.jpo.asn.runtime.types.Asn1Bitstring;

public class VehicleEventFlags extends Asn1Bitstring {

  public boolean isEventHazardLights() {
    return get(0);
  }

  public void setEventHazardLights(boolean eventHazardLights) {
    set(0, eventHazardLights);
  }

  public boolean isEventStopLineViolation() {
    return get(1);
  }

  public void setEventStopLineViolation(boolean eventStopLineViolation) {
    set(1, eventStopLineViolation);
  }

  public boolean isEventABSactivated() {
    return get(2);
  }

  public void setEventABSactivated(boolean eventABSactivated) {
    set(2, eventABSactivated);
  }

  public boolean isEventTractionControlLoss() {
    return get(3);
  }

  public void setEventTractionControlLoss(boolean eventTractionControlLoss) {
    set(3, eventTractionControlLoss);
  }

  public boolean isEventStabilityControlactivated() {
    return get(4);
  }

  public void setEventStabilityControlactivated(boolean eventStabilityControlactivated) {
    set(4, eventStabilityControlactivated);
  }

  public boolean isEventHazardousMaterials() {
    return get(5);
  }

  public void setEventHazardousMaterials(boolean eventHazardousMaterials) {
    set(5, eventHazardousMaterials);
  }

  public boolean isEventReserved1() {
    return get(6);
  }

  public void setEventReserved1(boolean eventReserved1) {
    set(6, eventReserved1);
  }

  public boolean isEventHardBraking() {
    return get(7);
  }

  public void setEventHardBraking(boolean eventHardBraking) {
    set(7, eventHardBraking);
  }

  public boolean isEventLightsChanged() {
    return get(8);
  }

  public void setEventLightsChanged(boolean eventLightsChanged) {
    set(8, eventLightsChanged);
  }

  public boolean isEventWipersChanged() {
    return get(9);
  }

  public void setEventWipersChanged(boolean eventWipersChanged) {
    set(9, eventWipersChanged);
  }

  public boolean isEventFlatTire() {
    return get(10);
  }

  public void setEventFlatTire(boolean eventFlatTire) {
    set(10, eventFlatTire);
  }

  public boolean isEventDisabledVehicle() {
    return get(11);
  }

  public void setEventDisabledVehicle(boolean eventDisabledVehicle) {
    set(11, eventDisabledVehicle);
  }

  public boolean isEventAirBagDeployment() {
    return get(12);
  }

  public void setEventAirBagDeployment(boolean eventAirBagDeployment) {
    set(12, eventAirBagDeployment);
  }

  public void setEventJackKnife(boolean eventJackKnife) {
    set(13, eventJackKnife);
  }

  public boolean isEventJackKnife() {
    return get(13);
  }

  public VehicleEventFlags() {
    super(
        13,
        true,
        new String[] {
          "eventHazardLights",
          "eventStopLineViolation",
          "eventABSactivated",
          "eventTractionControlLoss",
          "eventStabilityControlactivated",
          "eventHazardousMaterials",
          "eventReserved1",
          "eventHardBraking",
          "eventLightsChanged",
          "eventWipersChanged",
          "eventFlatTire",
          "eventDisabledVehicle",
          "eventAirBagDeployment",
          "eventJackKnife"
        });
  }
}
