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
import us.dot.its.jpo.asn.j2735.r2024.Common.BasicVehicleClass;
import us.dot.its.jpo.asn.j2735.r2024.Common.SchoolBusJ2945Slash1C;
import us.dot.its.jpo.asn.j2735.r2024.Common.TrailersJ2945Slash1B;
import us.dot.its.jpo.asn.j2735.r2024.Common.VehicleClassification;
import us.dot.its.jpo.asn.j2735.r2024.ProbeDataReport.RptVehicleClass;
import us.dot.its.jpo.asn.j2735.r2024.REGION.Reg_SupplementalVehicleExtensions;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;
import us.dot.its.jpo.asn.runtime.types.Asn1SequenceOf;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
@Getter
@Setter
public class SupplementalVehicleExtensions extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "classification", optional = true)
  @JsonProperty("classification")
  private BasicVehicleClass classification;

  @Asn1Property(tag = 1, name = "classDetails", optional = true)
  @JsonProperty("classDetails")
  private VehicleClassification classDetails;

  @Asn1Property(tag = 2, name = "vehicleData", optional = true)
  @JsonProperty("vehicleData")
  private VehicleData vehicleData;

  @Asn1Property(tag = 3, name = "doNotUse1", optional = true)
  @JsonProperty("doNotUse1")
  private WeatherReport doNotUse1;

  @Asn1Property(tag = 4, name = "doNotUse2", optional = true)
  @JsonProperty("doNotUse2")
  private WeatherProbe doNotUse2;

  @Asn1Property(tag = 5, name = "doNotUse3", optional = true)
  @JsonProperty("doNotUse3")
  private ObstacleDetection doNotUse3;

  @Asn1Property(tag = 6, name = "status", optional = true)
  @JsonProperty("status")
  private DisabledVehicle status;

  @Asn1Property(tag = 7, name = "doNotUse4", optional = true)
  @JsonProperty("doNotUse4")
  private SpeedProfile doNotUse4;

  @Asn1Property(tag = 8, name = "doNotUse5", optional = true)
  @JsonProperty("doNotUse5")
  private RTCMPackage doNotUse5;

  @Asn1Property(tag = 9, name = "regional", optional = true)
  @JsonProperty("regional")
  @JacksonXmlElementWrapper(localName = "regional")
  @JacksonXmlProperty(localName = "Reg-SupplementalVehicleExtensions")
  private SequenceOfRegional regional;

  @Asn1Property(tag = 10, name = "fhwaVehicleClass", extension = true)
  @JsonProperty("fhwaVehicleClass")
  private RptVehicleClass fhwaVehicleClass;

  @Asn1Property(tag = 11, name = "trailers", optional = true, extension = true)
  @JsonProperty("trailers")
  @JacksonXmlElementWrapper(localName = "trailers")
  @JacksonXmlProperty(localName = "TrailerUnitDescJ2945Slash1B")
  private TrailersJ2945Slash1B trailers;

  @Asn1Property(tag = 12, name = "schoolBus", optional = true, extension = true)
  @JsonProperty("schoolBus")
  private SchoolBusJ2945Slash1C schoolBus;

  @JsonInclude(Include.NON_NULL)
  @java.lang.SuppressWarnings("rawtypes")
  public static class SequenceOfRegional extends Asn1SequenceOf<Reg_SupplementalVehicleExtensions> {
    public SequenceOfRegional() {
      super(Reg_SupplementalVehicleExtensions.class, 1L, 4L);
    }
  }

  public SupplementalVehicleExtensions() {}

  @Override
  public boolean hasExtensionMarker() {
    return true;
  }
}
