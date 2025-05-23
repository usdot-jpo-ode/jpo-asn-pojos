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

package us.dot.its.jpo.asn.j2735.r2024.TestMessage13;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.JsonDeserializer.None;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import us.dot.its.jpo.asn.j2735.r2024.MessageFrame.MessageFrame;
import us.dot.its.jpo.asn.runtime.serialization.OpenTypeDeserializer;
import us.dot.its.jpo.asn.runtime.serialization.OpenTypeSerializer;

@JsonRootName("MessageFrame")
@JsonDeserialize(using = None.class)
public class TestMessage13MessageFrame extends MessageFrame<TestMessage13> {

  public TestMessage13MessageFrame() {
    super(253, "TestMessage13");
  }

  @Override
  @JsonSerialize(using = TestMessage13MessageFrameValueSerializer.class)
  public TestMessage13 getValue() {
    return super.getValue();
  }

  @Override
  @JsonDeserialize(using = TestMessage13MessageFrameValueDeserializer.class)
  public void setValue(TestMessage13 value) {
    super.setValue(value);
  }

  public static class TestMessage13MessageFrameValueSerializer
      extends OpenTypeSerializer<TestMessage13> {
    public TestMessage13MessageFrameValueSerializer() {
      super(TestMessage13.class, "value", "TestMessage13");
    }
  }

  public static class TestMessage13MessageFrameValueDeserializer
      extends OpenTypeDeserializer<TestMessage13> {
    public TestMessage13MessageFrameValueDeserializer() {
      super(TestMessage13.class, "TestMessage13");
    }
  }
}
