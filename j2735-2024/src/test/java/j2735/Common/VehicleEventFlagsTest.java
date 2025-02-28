package j2735.Common;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class VehicleEventFlagsTest {

  @Test
  public void testGetters() {
    var vef = new VehicleEventFlags();
    vef.fromBinaryString("1111111111111");
    assertThat(vef.isEventHazardLights(), equalTo(true));
    assertThat(vef.isEventStopLineViolation(), equalTo(true));
    assertThat(vef.isEventABSactivated(), equalTo(true));
    assertThat(vef.isEventTractionControlLoss(), equalTo(true));
    assertThat(vef.isEventStabilityControlactivated(), equalTo(true));
    assertThat(vef.isEventHazardousMaterials(), equalTo(true));
    assertThat(vef.isEventReserved1(), equalTo(true));
    assertThat(vef.isEventHardBraking(), equalTo(true));
    assertThat(vef.isEventLightsChanged(), equalTo(true));
    assertThat(vef.isEventWipersChanged(), equalTo(true));
    assertThat(vef.isEventFlatTire(), equalTo(true));
    assertThat(vef.isEventDisabledVehicle(), equalTo(true));
    assertThat(vef.isEventAirBagDeployment(), equalTo(true));
  }

  @Test
  public void testSetters() {
    var vef = new VehicleEventFlags();
    vef.setEventHazardLights(true);
    vef.setEventStopLineViolation(true);
    vef.setEventABSactivated(true);
    vef.setEventTractionControlLoss(true);
    vef.setEventStabilityControlactivated(true);
    vef.setEventHazardousMaterials(true);
    vef.setEventReserved1(true);
    vef.setEventHardBraking(true);
    vef.setEventLightsChanged(true);
    vef.setEventWipersChanged(true);
    vef.setEventFlatTire(true);
    vef.setEventDisabledVehicle(true);
    vef.setEventAirBagDeployment(true);
    assertThat(vef.binaryString(), equalTo("1111111111111"));
  }

  @Disabled("TODO fix this")
  @Test
  public void testJackKnifeExtension() {
    var vef = new VehicleEventFlags();
    vef.fromBinaryString("00000000000001");
    assertThat(vef, hasProperty("eventJackKnife", equalTo(true)));
  }
}
