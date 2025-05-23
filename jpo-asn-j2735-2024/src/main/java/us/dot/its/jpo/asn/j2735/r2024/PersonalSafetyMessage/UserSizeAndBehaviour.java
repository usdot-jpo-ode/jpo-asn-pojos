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

package us.dot.its.jpo.asn.j2735.r2024.PersonalSafetyMessage;

import us.dot.its.jpo.asn.runtime.types.Asn1Bitstring;

public class UserSizeAndBehaviour extends Asn1Bitstring {

  public boolean isUnavailable() {
    return get(0);
  }

  public void setUnavailable(boolean unavailable) {
    set(0, unavailable);
  }

  public boolean isSmallStature() {
    return get(1);
  }

  public void setSmallStature(boolean smallStature) {
    set(1, smallStature);
  }

  public boolean isLargeStature() {
    return get(2);
  }

  public void setLargeStature(boolean largeStature) {
    set(2, largeStature);
  }

  public boolean isErraticMoving() {
    return get(3);
  }

  public void setErraticMoving(boolean erraticMoving) {
    set(3, erraticMoving);
  }

  public boolean isSlowMoving() {
    return get(4);
  }

  public void setSlowMoving(boolean slowMoving) {
    set(4, slowMoving);
  }

  public UserSizeAndBehaviour() {
    super(
        5,
        true,
        new String[] {
          "unavailable", "smallStature", "largeStature", "erraticMoving", "slowMoving"
        });
  }
}
