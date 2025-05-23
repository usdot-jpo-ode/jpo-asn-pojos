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

package us.dot.its.jpo.asn.j2735.r2024.PersonalSafetyMessage2;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import us.dot.its.jpo.asn.j2735.r2024.MessageFrame.MessageFrame;
import us.dot.its.jpo.asn.runtime.serialization.OpenTypeDeserializer;
import us.dot.its.jpo.asn.runtime.serialization.OpenTypeSerializer;

@JsonRootName("MessageFrame")
@JsonDeserialize(using = None.class)
public class PersonalSafetyMessage2MessageFrame extends MessageFrame<PersonalSafetyMessage2> {

  public PersonalSafetyMessage2MessageFrame() {
    super(44, "PersonalSafetyMessage2");
  }

  @Override
  @JsonSerialize(using = PersonalSafetyMessage2MessageFrameValueSerializer.class)
  public PersonalSafetyMessage2 getValue() {
    return super.getValue();
  }

  @Override
  @JsonDeserialize(using = PersonalSafetyMessage2MessageFrameValueDeserializer.class)
  public void setValue(PersonalSafetyMessage2 value) {
    super.setValue(value);
  }

  public static class PersonalSafetyMessage2MessageFrameValueSerializer
      extends OpenTypeSerializer<PersonalSafetyMessage2> {
    public PersonalSafetyMessage2MessageFrameValueSerializer() {
      super(PersonalSafetyMessage2.class, "value", "PersonalSafetyMessage2");
    }
  }

  public static class PersonalSafetyMessage2MessageFrameValueDeserializer
      extends OpenTypeDeserializer<PersonalSafetyMessage2> {
    public PersonalSafetyMessage2MessageFrameValueDeserializer() {
      super(PersonalSafetyMessage2.class, "PersonalSafetyMessage2");
    }
  }
}
