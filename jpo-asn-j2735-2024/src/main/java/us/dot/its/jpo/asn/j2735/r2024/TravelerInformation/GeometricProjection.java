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

package us.dot.its.jpo.asn.j2735.r2024.TravelerInformation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import us.dot.its.jpo.asn.j2735.r2024.Common.Extent;
import us.dot.its.jpo.asn.j2735.r2024.Common.HeadingSlice;
import us.dot.its.jpo.asn.j2735.r2024.Common.LaneWidth;
import us.dot.its.jpo.asn.j2735.r2024.REGION.Reg_GeometricProjection;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.types.Asn1Sequence;
import us.dot.its.jpo.asn.runtime.types.Asn1SequenceOf;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString(callSuper = true)
@Getter
@Setter
public class GeometricProjection extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "direction")
  @JsonProperty("direction")
  private HeadingSlice direction;

  @Asn1Property(tag = 1, name = "extent", optional = true)
  @JsonProperty("extent")
  private Extent extent;

  @Asn1Property(tag = 2, name = "laneWidth", optional = true)
  @JsonProperty("laneWidth")
  private LaneWidth laneWidth;

  @Asn1Property(tag = 3, name = "circle")
  @JsonProperty("circle")
  private Circle circle;

  @Asn1Property(tag = 4, name = "regional", optional = true)
  @JsonProperty("regional")
  @JacksonXmlElementWrapper(localName = "regional")
  @JacksonXmlProperty(localName = "Reg-GeometricProjection")
  private SequenceOfRegional regional;

  @JsonInclude(Include.NON_NULL)
  @java.lang.SuppressWarnings("rawtypes")
  public static class SequenceOfRegional extends Asn1SequenceOf<Reg_GeometricProjection> {
    public SequenceOfRegional() {
      super(Reg_GeometricProjection.class, 1L, 4L);
    }
  }

  public GeometricProjection() {}

  @Override
  public boolean hasExtensionMarker() {
    return true;
  }
}
