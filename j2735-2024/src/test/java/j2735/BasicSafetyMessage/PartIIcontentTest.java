package j2735.BasicSafetyMessage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import j2735.Common.VehicleSafetyExtensionsBSMpartIIExtension;
import org.junit.jupiter.api.Test;

public class PartIIcontentTest {

  @Test
  public void getNameTest() {
    var sve = new SpecialVehicleExtensionsBSMpartIIExtension();
    assertThat(sve.getName(), equalTo("SpecialVehicleExtensions"));
    var supve = new SupplementalVehicleExtensionsBSMpartIIExtension();
    assertThat(supve.getName(), equalTo("SupplementalVehicleExtensions"));
    var vse = new VehicleSafetyExtensionsBSMpartIIExtension();
    assertThat(vse.getName(), equalTo("VehicleSafetyExtensions"));

  }

}
