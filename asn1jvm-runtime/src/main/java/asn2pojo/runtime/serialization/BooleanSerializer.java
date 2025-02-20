package asn2pojo.runtime.serialization;

import asn2pojo.runtime.types.Asn1Boolean;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.fasterxml.jackson.dataformat.xml.ser.XmlSerializerProvider;

import java.io.IOException;

public class BooleanSerializer extends StdSerializer<Asn1Boolean> {

    protected BooleanSerializer() {
        super(Asn1Boolean.class);
    }

    @Override
    public void serialize(Asn1Boolean asn1Boolean, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        if (serializerProvider instanceof XmlSerializerProvider) {
            // XER uses <true/> and <false/> for booleans
            jsonGenerator.writeStartObject();
            jsonGenerator.writeRaw(String.format("<%s/>", asn1Boolean.getValue()));
            jsonGenerator.writeEndObject();
        } else {
            // JER
            jsonGenerator.writeBoolean(asn1Boolean.getValue());
        }
    }
}
