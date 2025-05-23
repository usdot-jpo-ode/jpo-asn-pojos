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
public class CfgCommSysPerfEvents extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "j2945-1ChanBusyThresh", optional = true)
  @JsonProperty("j2945-1ChanBusyThresh")
  private J2945_1ChanBusyThreshInteger j2945_1ChanBusyThresh;

  @Asn1Property(tag = 1, name = "rfDataRsuInfo", optional = true)
  @JsonProperty("rfDataRsuInfo")
  private Asn1Boolean rfDataRsuInfo;

  @Asn1Property(tag = 2, name = "numRsusObservedThresh", optional = true)
  @JsonProperty("numRsusObservedThresh")
  private NumRsusObservedThreshInteger numRsusObservedThresh;

  @Asn1Property(tag = 3, name = "rfV2xJamDetectThresh", optional = true)
  @JsonProperty("rfV2xJamDetectThresh")
  private RfV2xJamDetectThreshInteger rfV2xJamDetectThresh;

  @Asn1Property(tag = 4, name = "j2945-1VehDensThresh", optional = true)
  @JsonProperty("j2945-1VehDensThresh")
  private J2945_1VehDensThreshInteger j2945_1VehDensThresh;

  @Asn1Property(tag = 5, name = "j2945-1CqiBelowThresh", optional = true)
  @JsonProperty("j2945-1CqiBelowThresh")
  private J2945_1CqiBelowThreshInteger j2945_1CqiBelowThresh;

  @Asn1Property(tag = 6, name = "j2945-1TrackErrorThresh", optional = true)
  @JsonProperty("j2945-1TrackErrorThresh")
  private J2945_1TrackErrorThreshInteger j2945_1TrackErrorThresh;

  @Asn1Property(tag = 7, name = "gnssHdopExceedsThresh", optional = true)
  @JsonProperty("gnssHdopExceedsThresh")
  private GnssHdopExceedsThreshInteger gnssHdopExceedsThresh;

  @Asn1Property(tag = 8, name = "gnssSatsBelowThresh", optional = true)
  @JsonProperty("gnssSatsBelowThresh")
  private GnssSatsBelowThreshInteger gnssSatsBelowThresh;

  @Asn1Property(tag = 9, name = "gnssJammingDetect", optional = true)
  @JsonProperty("gnssJammingDetect")
  private Asn1Boolean gnssJammingDetect;

  public static class J2945_1ChanBusyThreshInteger extends Asn1Integer {
    public J2945_1ChanBusyThreshInteger() {
      super(1L, 100L);
    }

    @JsonCreator
    public J2945_1ChanBusyThreshInteger(long value) {
      this();
      this.setValue(value);
    }
  }

  public static class NumRsusObservedThreshInteger extends Asn1Integer {
    public NumRsusObservedThreshInteger() {
      super(1L, 254L);
    }

    @JsonCreator
    public NumRsusObservedThreshInteger(long value) {
      this();
      this.setValue(value);
    }
  }

  public static class RfV2xJamDetectThreshInteger extends Asn1Integer {
    public RfV2xJamDetectThreshInteger() {
      super(1L, 140L);
    }

    @JsonCreator
    public RfV2xJamDetectThreshInteger(long value) {
      this();
      this.setValue(value);
    }
  }

  public static class J2945_1VehDensThreshInteger extends Asn1Integer {
    public J2945_1VehDensThreshInteger() {
      super(1L, 255L);
    }

    @JsonCreator
    public J2945_1VehDensThreshInteger(long value) {
      this();
      this.setValue(value);
    }
  }

  public static class J2945_1CqiBelowThreshInteger extends Asn1Integer {
    public J2945_1CqiBelowThreshInteger() {
      super(1L, 100L);
    }

    @JsonCreator
    public J2945_1CqiBelowThreshInteger(long value) {
      this();
      this.setValue(value);
    }
  }

  public static class J2945_1TrackErrorThreshInteger extends Asn1Integer {
    public J2945_1TrackErrorThreshInteger() {
      super(1L, 100L);
    }

    @JsonCreator
    public J2945_1TrackErrorThreshInteger(long value) {
      this();
      this.setValue(value);
    }
  }

  public static class GnssHdopExceedsThreshInteger extends Asn1Integer {
    public GnssHdopExceedsThreshInteger() {
      super(1L, 20L);
    }

    @JsonCreator
    public GnssHdopExceedsThreshInteger(long value) {
      this();
      this.setValue(value);
    }
  }

  public static class GnssSatsBelowThreshInteger extends Asn1Integer {
    public GnssSatsBelowThreshInteger() {
      super(1L, 20L);
    }

    @JsonCreator
    public GnssSatsBelowThreshInteger(long value) {
      this();
      this.setValue(value);
    }
  }

  public CfgCommSysPerfEvents() {}

  @Override
  public boolean hasExtensionMarker() {
    return true;
  }
}
