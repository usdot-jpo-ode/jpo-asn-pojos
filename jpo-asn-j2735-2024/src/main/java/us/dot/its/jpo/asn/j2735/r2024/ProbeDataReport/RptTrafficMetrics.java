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

package us.dot.its.jpo.asn.j2735.r2024.ProbeDataReport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.types.Asn1Choice;
import us.dot.its.jpo.asn.runtime.types.Asn1Null;

@ToString(callSuper = true)
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class RptTrafficMetrics extends Asn1Choice {

  @Asn1Property(tag = 0, name = "trfsigApproachDelay")
  @JsonProperty("trfsigApproachDelay")
  private Asn1Null trfsigApproachDelay;

  @Asn1Property(tag = 1, name = "trfsigApproachSpeed")
  @JsonProperty("trfsigApproachSpeed")
  private Asn1Null trfsigApproachSpeed;

  @Asn1Property(tag = 2, name = "trfsigArrivalGreen")
  @JsonProperty("trfsigArrivalGreen")
  private Asn1Null trfsigArrivalGreen;

  @Asn1Property(tag = 3, name = "trfsigArrivalRed")
  @JsonProperty("trfsigArrivalRed")
  private Asn1Null trfsigArrivalRed;

  @Asn1Property(tag = 4, name = "trfsigPedDelay")
  @JsonProperty("trfsigPedDelay")
  private Asn1Null trfsigPedDelay;

  @Asn1Property(tag = 5, name = "trfsigSpatMismatch")
  @JsonProperty("trfsigSpatMismatch")
  private Asn1Null trfsigSpatMismatch;

  @Asn1Property(tag = 6, name = "trfsigSpatTimingError")
  @JsonProperty("trfsigSpatTimingError")
  private Asn1Null trfsigSpatTimingError;

  public RptTrafficMetrics() {}

  @Override
  public boolean hasExtensionMarker() {
    return true;
  }
}
