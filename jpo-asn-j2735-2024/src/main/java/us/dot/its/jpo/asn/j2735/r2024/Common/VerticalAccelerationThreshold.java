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

package us.dot.its.jpo.asn.j2735.r2024.Common;

import us.dot.its.jpo.asn.runtime.types.Asn1Bitstring;

public class VerticalAccelerationThreshold extends Asn1Bitstring {

  public boolean isNotEquipped() {
    return get(0);
  }

  public void setNotEquipped(boolean notEquipped) {
    set(0, notEquipped);
  }

  public boolean isLeftFront() {
    return get(1);
  }

  public void setLeftFront(boolean leftFront) {
    set(1, leftFront);
  }

  public boolean isLeftRear() {
    return get(2);
  }

  public void setLeftRear(boolean leftRear) {
    set(2, leftRear);
  }

  public boolean isRightFront() {
    return get(3);
  }

  public void setRightFront(boolean rightFront) {
    set(3, rightFront);
  }

  public boolean isRightRear() {
    return get(4);
  }

  public void setRightRear(boolean rightRear) {
    set(4, rightRear);
  }

  public VerticalAccelerationThreshold() {
    super(
        5, false, new String[] {"notEquipped", "leftFront", "leftRear", "rightFront", "rightRear"});
  }
}
