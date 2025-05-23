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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import us.dot.its.jpo.asn.j2735.r2024.Common.Acceleration;
import us.dot.its.jpo.asn.j2735.r2024.Common.Speed;
import us.dot.its.jpo.asn.j2735.r2024.Common.TemporaryID;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
@Getter
@Setter
public class HeavyTruckCCMExtensions extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "longCntrlState")
  @JsonProperty("longCntrlState")
  private LongitudinalControlState longCntrlState;

  @Asn1Property(tag = 1, name = "targetId", optional = true)
  @JsonProperty("targetId")
  private TemporaryID targetId;

  @Asn1Property(tag = 2, name = "roadGrade", optional = true)
  @JsonProperty("roadGrade")
  private RoadGrade roadGrade;

  @Asn1Property(tag = 3, name = "brakePedalPos", optional = true)
  @JsonProperty("brakePedalPos")
  private BrakePedalPosition brakePedalPos;

  @Asn1Property(tag = 4, name = "accelPedalPos", optional = true)
  @JsonProperty("accelPedalPos")
  private AcceleratorPedalPosition accelPedalPos;

  @Asn1Property(tag = 5, name = "desiredSpeed", optional = true)
  @JsonProperty("desiredSpeed")
  private Speed desiredSpeed;

  @Asn1Property(tag = 6, name = "desiredAccel", optional = true)
  @JsonProperty("desiredAccel")
  private Acceleration desiredAccel;

  @Asn1Property(tag = 7, name = "desiredTorque", optional = true)
  @JsonProperty("desiredTorque")
  private Torque desiredTorque;

  @Asn1Property(tag = 8, name = "desiredTmRetarderTorque", optional = true)
  @JsonProperty("desiredTmRetarderTorque")
  private Torque desiredTmRetarderTorque;

  @Asn1Property(tag = 9, name = "desiredEngRetarderTorque", optional = true)
  @JsonProperty("desiredEngRetarderTorque")
  private Torque desiredEngRetarderTorque;

  @Asn1Property(tag = 10, name = "axesMvmt", optional = true)
  @JsonProperty("axesMvmt")
  private AxesMovement axesMvmt;

  @Asn1Property(tag = 11, name = "separationDist", optional = true)
  @JsonProperty("separationDist")
  private SeparationDistance separationDist;

  @Asn1Property(tag = 12, name = "totalMass", optional = true)
  @JsonProperty("totalMass")
  private TotalMass totalMass;

  @Asn1Property(tag = 13, name = "maxAvailAccel", optional = true)
  @JsonProperty("maxAvailAccel")
  private MaxAvailableAcceleration maxAvailAccel;

  @Asn1Property(tag = 14, name = "maxAvailDecel", optional = true)
  @JsonProperty("maxAvailDecel")
  private MaxAvailableDeceleration maxAvailDecel;

  @Asn1Property(tag = 15, name = "ccmFaultMode", optional = true)
  @JsonProperty("ccmFaultMode")
  private CCMFaultMode ccmFaultMode;

  @Asn1Property(tag = 16, name = "maneuverID", optional = true)
  @JsonProperty("maneuverID")
  private ManeuverID maneuverID;

  @Asn1Property(tag = 17, name = "frontCutIn", optional = true)
  @JsonProperty("frontCutIn")
  private FrontCutIn frontCutIn;

  public HeavyTruckCCMExtensions() {}

  @Override
  public boolean hasExtensionMarker() {
    return true;
  }
}
