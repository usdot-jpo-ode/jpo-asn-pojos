package asn2pojo.runtime.types;

import asn2pojo.runtime.serialization.SerializationUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Asn1Sequence implements Asn1Type {

    final boolean extensionMarker;

    public Asn1Sequence(boolean hasExtensionMarker) {
        this.extensionMarker = hasExtensionMarker;
    }

    public boolean hasExtensionMarker() {
        return extensionMarker;
    }


    @Override
    public String toString() {
        ObjectMapper mapper = SerializationUtil.jsonMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
            return "";
        }
    }
}
