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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;
import us.dot.its.jpo.asn.runtime.types.IA5String;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
@Getter
@Setter
public class DataParameters extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "processMethod", optional = true)
  @JsonProperty("processMethod")
  private IA5String processMethod;

  @Asn1Property(tag = 1, name = "processAgency", optional = true)
  @JsonProperty("processAgency")
  private IA5String processAgency;

  @Asn1Property(tag = 2, name = "lastCheckedDate", optional = true)
  @JsonProperty("lastCheckedDate")
  private IA5String lastCheckedDate;

  @Asn1Property(tag = 3, name = "geoidUsed", optional = true)
  @JsonProperty("geoidUsed")
  private IA5String geoidUsed;

  public DataParameters() {}

  @Override
  public boolean hasExtensionMarker() {
    return true;
  }
}
