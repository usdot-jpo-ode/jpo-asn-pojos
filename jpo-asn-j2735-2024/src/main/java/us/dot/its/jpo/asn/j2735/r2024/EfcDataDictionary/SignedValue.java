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

package us.dot.its.jpo.asn.j2735.r2024.EfcDataDictionary;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import us.dot.its.jpo.asn.runtime.annotations.Asn1Property;
import us.dot.its.jpo.asn.runtime.types.Asn1Choice;
import us.dot.its.jpo.asn.runtime.types.Asn1Integer;

@ToString(callSuper = true)
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class SignedValue extends Asn1Choice {

  @Asn1Property(tag = 0, name = "positive")
  @JsonProperty("positive")
  private PositiveInteger positive;

  @Asn1Property(tag = 1, name = "negative")
  @JsonProperty("negative")
  private NegativeInteger negative;

  public SignedValue() {}

  public static class PositiveInteger extends Asn1Integer {
    public PositiveInteger() {
      super(0L, 8388607L);
    }

    @JsonCreator
    public PositiveInteger(long value) {
      this();
      this.setValue(value);
    }
  }

  public static class NegativeInteger extends Asn1Integer {
    public NegativeInteger() {
      super(-8388608L, -1L);
    }

    @JsonCreator
    public NegativeInteger(long value) {
      this();
      this.setValue(value);
    }
  }
}
