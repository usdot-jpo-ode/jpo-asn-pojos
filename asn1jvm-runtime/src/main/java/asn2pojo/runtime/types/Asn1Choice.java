package asn2pojo.runtime.types;

import asn2pojo.runtime.serialization.SerializationUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class Asn1Choice implements Asn1Type {

    final boolean hasExtensionMarker;

    public Asn1Choice(boolean hasExtensionMarker) {
        this.hasExtensionMarker = hasExtensionMarker;
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
