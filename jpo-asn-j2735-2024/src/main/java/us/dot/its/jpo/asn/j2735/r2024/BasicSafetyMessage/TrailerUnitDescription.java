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

package us.dot.its.jpo.asn.j2735.r2024.BasicSafetyMessage;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import us.dot.its.jpo.asn.j2735.r2024.Common.BumperHeights;
import us.dot.its.jpo.asn.j2735.r2024.Common.Node_XY_24b;
import us.dot.its.jpo.asn.j2735.r2024.Common.Offset_B12;
import us.dot.its.jpo.asn.j2735.r2024.Common.VehicleHeight;
import us.dot.its.jpo.asn.j2735.r2024.Common.VehicleLength;
import us.dot.its.jpo.asn.j2735.r2024.Common.VehicleWidth;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
@Getter
@Setter
public class TrailerUnitDescription extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "isDolly")
  @JsonProperty("isDolly")
  private IsDolly isDolly;

  @Asn1Property(tag = 1, name = "width")
  @JsonProperty("width")
  private VehicleWidth width;

  @Asn1Property(tag = 2, name = "length")
  @JsonProperty("length")
  private VehicleLength length;

  @Asn1Property(tag = 3, name = "height", optional = true)
  @JsonProperty("height")
  private VehicleHeight height;

  @Asn1Property(tag = 4, name = "mass", optional = true)
  @JsonProperty("mass")
  private TrailerMass mass;

  @Asn1Property(tag = 5, name = "bumperHeights", optional = true)
  @JsonProperty("bumperHeights")
  private BumperHeights bumperHeights;

  @Asn1Property(tag = 6, name = "centerOfGravity", optional = true)
  @JsonProperty("centerOfGravity")
  private VehicleHeight centerOfGravity;

  @Asn1Property(tag = 7, name = "frontPivot")
  @JsonProperty("frontPivot")
  private PivotPointDescription frontPivot;

  @Asn1Property(tag = 8, name = "rearPivot", optional = true)
  @JsonProperty("rearPivot")
  private PivotPointDescription rearPivot;

  @Asn1Property(tag = 9, name = "rearWheelOffset", optional = true)
  @JsonProperty("rearWheelOffset")
  private Offset_B12 rearWheelOffset;

  @Asn1Property(tag = 10, name = "positionOffset")
  @JsonProperty("positionOffset")
  private Node_XY_24b positionOffset;

  @Asn1Property(tag = 11, name = "elevationOffset", optional = true)
  @JsonProperty("elevationOffset")
  private VertOffset_B07 elevationOffset;

  @Asn1Property(tag = 12, name = "crumbData", optional = true)
  @JsonProperty("crumbData")
  @JacksonXmlElementWrapper(localName = "crumbData")
  @JacksonXmlProperty(localName = "TrailerHistoryPoint")
  private TrailerHistoryPointList crumbData;

  public TrailerUnitDescription() {}

  @Override
  public boolean hasExtensionMarker() {
    return true;
  }
}
