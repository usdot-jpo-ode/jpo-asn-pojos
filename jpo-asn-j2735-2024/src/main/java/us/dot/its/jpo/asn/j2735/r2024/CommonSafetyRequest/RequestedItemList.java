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

package us.dot.its.jpo.asn.j2735.r2024.CommonSafetyRequest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import us.dot.its.jpo.asn.runtime.serialization.SequenceOfEnumeratedDeserializer;
import us.dot.its.jpo.asn.runtime.serialization.SequenceOfEnumeratedSerializer;
import us.dot.its.jpo.asn.runtime.types.Asn1SequenceOf;

@JsonInclude(Include.NON_NULL)
public class RequestedItemList extends Asn1SequenceOf<RequestedItem> {

  public RequestedItemList() {
    super(RequestedItem.class, 1L, 32L);
  }

  public static class RequestedItemListSerializer
      extends SequenceOfEnumeratedSerializer<RequestedItem, RequestedItemList> {
    public RequestedItemListSerializer() {
      super(RequestedItem.class, RequestedItemList.class);
    }
  }

  public static class RequestedItemListDeserializer
      extends SequenceOfEnumeratedDeserializer<RequestedItem, RequestedItemList> {
    public RequestedItemListDeserializer() {
      super(RequestedItemList.class, RequestedItem.class);
    }

    @Override
    protected RequestedItem[] listEnumValues() {
      return RequestedItem.values();
    }

    @Override
    protected RequestedItemList construct() {
      return new RequestedItemList();
    }
  }
}
