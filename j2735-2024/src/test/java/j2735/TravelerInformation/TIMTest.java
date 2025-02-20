package j2735.TravelerInformation;

import j2735.BaseSerializeTest;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TIMTest extends BaseSerializeTest<TravelerInformation> {

    public TIMTest() {
        super(TravelerInformation.class);
    }

    @Test
    public void xmlDeserialize_generatedXml() throws IOException {
        TravelerInformation tim = fromXml(loadResource("/TravelerInformation.xml"));
        assertThat(tim, notNullValue());

        String json = toJson(tim);
        System.out.println(json);
    }


    

    @Test
    public void xmlDeserialize_generatedXmlWithComputedLanes() throws IOException {
        TravelerInformation tim = fromXml(loadResource("/TravelerInformationWithComputedLanes.xml"));
        assertThat(tim, notNullValue());
    }
}
