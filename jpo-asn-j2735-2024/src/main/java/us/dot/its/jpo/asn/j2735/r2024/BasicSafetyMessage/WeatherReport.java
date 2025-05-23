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
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import us.dot.its.jpo.asn.j2735.r2024.Common.CoefficientOfFriction;
import us.dot.its.jpo.asn.j2735.r2024.NTCIP.EssMobileFriction;
import us.dot.its.jpo.asn.j2735.r2024.NTCIP.EssPrecipRate;
import us.dot.its.jpo.asn.j2735.r2024.NTCIP.EssPrecipSituation;
import us.dot.its.jpo.asn.j2735.r2024.NTCIP.EssPrecipYesNo;
import us.dot.its.jpo.asn.j2735.r2024.NTCIP.EssSolarRadiation;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
@Getter
@Setter
public class WeatherReport extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "isRaining")
  @JsonProperty("isRaining")
  private EssPrecipYesNo isRaining;

  @Asn1Property(tag = 1, name = "rainRate", optional = true)
  @JsonProperty("rainRate")
  private EssPrecipRate rainRate;

  @Asn1Property(tag = 2, name = "precipSituation", optional = true)
  @JsonProperty("precipSituation")
  private EssPrecipSituation precipSituation;

  @Asn1Property(tag = 3, name = "solarRadiation", optional = true)
  @JsonProperty("solarRadiation")
  private EssSolarRadiation solarRadiation;

  @Asn1Property(tag = 4, name = "friction", optional = true)
  @JsonProperty("friction")
  private EssMobileFriction friction;

  @Asn1Property(tag = 5, name = "roadFriction", optional = true)
  @JsonProperty("roadFriction")
  private CoefficientOfFriction roadFriction;

  public WeatherReport() {}

  @Override
  public boolean hasExtensionMarker() {
    return true;
  }
}
