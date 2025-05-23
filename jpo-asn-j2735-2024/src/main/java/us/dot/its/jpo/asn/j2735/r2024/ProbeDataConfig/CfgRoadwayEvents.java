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

package us.dot.its.jpo.asn.j2735.r2024.ProbeDataConfig;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.types.Asn1Boolean;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
@Getter
@Setter
public class CfgRoadwayEvents extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "obstacleDetected")
  @JsonProperty("obstacleDetected")
  private Asn1Boolean obstacleDetected;

  @Asn1Property(tag = 1, name = "adverseRoadSurface")
  @JsonProperty("adverseRoadSurface")
  private Asn1Boolean adverseRoadSurface;

  @Asn1Property(tag = 2, name = "trafficSigEncounters", optional = true)
  @JsonProperty("trafficSigEncounters")
  private CfgTrafficSigEncounters trafficSigEncounters;

  @Asn1Property(tag = 3, name = "trfsigLightOut")
  @JsonProperty("trfsigLightOut")
  private Asn1Boolean trfsigLightOut;

  @Asn1Property(tag = 4, name = "trfsigRoadGeoMismatch")
  @JsonProperty("trfsigRoadGeoMismatch")
  private Asn1Boolean trfsigRoadGeoMismatch;

  @Asn1Property(tag = 5, name = "roadSignInfo", optional = true)
  @JsonProperty("roadSignInfo")
  private CfgRoadSignInfo roadSignInfo;

  @Asn1Property(tag = 6, name = "lowLaneMarkReflect", optional = true)
  @JsonProperty("lowLaneMarkReflect")
  private LowLaneMarkReflectInteger lowLaneMarkReflect;

  @Asn1Property(tag = 7, name = "roadsignIncnstncy")
  @JsonProperty("roadsignIncnstncy")
  private Asn1Boolean roadsignIncnstncy;

  @Asn1Property(tag = 8, name = "laneGeoIncnstncy")
  @JsonProperty("laneGeoIncnstncy")
  private Asn1Boolean laneGeoIncnstncy;

  @Asn1Property(tag = 9, name = "incidentDetect")
  @JsonProperty("incidentDetect")
  private Asn1Boolean incidentDetect;

  @Asn1Property(tag = 10, name = "workZoneCharDetect")
  @JsonProperty("workZoneCharDetect")
  private Asn1Boolean workZoneCharDetect;

  @Asn1Property(tag = 11, name = "inclWeatherDetect")
  @JsonProperty("inclWeatherDetect")
  private Asn1Boolean inclWeatherDetect;

  @Asn1Property(tag = 12, name = "railrdCrossActivated")
  @JsonProperty("railrdCrossActivated")
  private Asn1Boolean railrdCrossActivated;

  @Asn1Property(tag = 13, name = "drawBridgeActivated")
  @JsonProperty("drawBridgeActivated")
  private Asn1Boolean drawBridgeActivated;

  public static class LowLaneMarkReflectInteger extends Asn1Integer {
    public LowLaneMarkReflectInteger() {
      super(1L, 100L);
    }

    @JsonCreator
    public LowLaneMarkReflectInteger(long value) {
      this();
      this.setValue(value);
    }
  }

  public CfgRoadwayEvents() {}

  @Override
  public boolean hasExtensionMarker() {
    return true;
  }
}
