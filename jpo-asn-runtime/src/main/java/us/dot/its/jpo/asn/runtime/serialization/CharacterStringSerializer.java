package us.dot.its.jpo.asn.runtime.serialization;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import us.dot.its.jpo.asn.runtime.types.Asn1CharacterString;

public class CharacterStringSerializer extends StdSerializer<Asn1CharacterString> {

    protected CharacterStringSerializer() {
        super(Asn1CharacterString.class);
    }

    @Override
    public void serialize(Asn1CharacterString asn1CharacterString, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(asn1CharacterString.getValue());
    }
}
