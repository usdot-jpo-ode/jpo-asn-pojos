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

package us.dot.its.jpo.asn.j2735.r2024.AddGrpB;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import us.dot.its.jpo.asn.j2735.r2024.REGION.Reg_MovementEvent;
import us.dot.its.jpo.asn.runtime.serialization.OpenTypeDeserializer;
import us.dot.its.jpo.asn.runtime.serialization.OpenTypeSerializer;

@JsonRootName("Reg_MovementEvent")
@JsonDeserialize(using = None.class)
public class MovementEvent_addGrpBReg_MovementEvent
    extends Reg_MovementEvent<MovementEvent_addGrpB> {

  public MovementEvent_addGrpBReg_MovementEvent() {
    super(2, "MovementEvent_addGrpB");
  }

  @Override
  @JsonSerialize(using = MovementEvent_addGrpBReg_MovementEventValueSerializer.class)
  public MovementEvent_addGrpB getRegExtValue() {
    return super.getRegExtValue();
  }

  @Override
  @JsonDeserialize(using = MovementEvent_addGrpBReg_MovementEventValueDeserializer.class)
  public void setRegExtValue(MovementEvent_addGrpB value) {
    super.setRegExtValue(value);
  }

  public static class MovementEvent_addGrpBReg_MovementEventValueSerializer
      extends OpenTypeSerializer<MovementEvent_addGrpB> {
    public MovementEvent_addGrpBReg_MovementEventValueSerializer() {
      super(MovementEvent_addGrpB.class, "regExtValue", "MovementEvent_addGrpB");
    }
  }

  public static class MovementEvent_addGrpBReg_MovementEventValueDeserializer
      extends OpenTypeDeserializer<MovementEvent_addGrpB> {
    public MovementEvent_addGrpBReg_MovementEventValueDeserializer() {
      super(MovementEvent_addGrpB.class, "MovementEvent_addGrpB");
    }
  }
}
