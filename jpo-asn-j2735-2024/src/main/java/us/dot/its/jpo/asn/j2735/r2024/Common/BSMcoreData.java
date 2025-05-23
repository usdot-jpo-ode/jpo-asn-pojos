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
public class BSMcoreData extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "msgCnt")
  @JsonProperty("msgCnt")
  private MsgCount msgCnt;

  @Asn1Property(tag = 1, name = "id")
  @JsonProperty("id")
  private TemporaryID id;

  @Asn1Property(tag = 2, name = "secMark")
  @JsonProperty("secMark")
  private DSecond secMark;

  @Asn1Property(tag = 3, name = "lat")
  @JsonProperty("lat")
  private Latitude lat;

  @Asn1Property(tag = 4, name = "long")
  @JsonProperty("long")
  private Longitude long_;

  @Asn1Property(tag = 5, name = "elev")
  @JsonProperty("elev")
  private Elevation elev;

  @Asn1Property(tag = 6, name = "accuracy")
  @JsonProperty("accuracy")
  private PositionalAccuracy accuracy;

  @Asn1Property(tag = 7, name = "transmission")
  @JsonProperty("transmission")
  private TransmissionState transmission;

  @Asn1Property(tag = 8, name = "speed")
  @JsonProperty("speed")
  private Speed speed;

  @Asn1Property(tag = 9, name = "heading")
  @JsonProperty("heading")
  private Heading heading;

  @Asn1Property(tag = 10, name = "angle")
  @JsonProperty("angle")
  private SteeringWheelAngle angle;

  @Asn1Property(tag = 11, name = "accelSet")
  @JsonProperty("accelSet")
  private AccelerationSet4Way accelSet;

  @Asn1Property(tag = 12, name = "brakes")
  @JsonProperty("brakes")
  private BrakeSystemStatus brakes;

  @Asn1Property(tag = 13, name = "size")
  @JsonProperty("size")
  private VehicleSize size;

  public BSMcoreData() {}
}
