package us.dot.its.jpo.asn.runtime.types;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import us.dot.its.jpo.asn.runtime.serialization.SerializationUtil;

@Slf4j
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
            log.error(e.getMessage());
            return "";
        }
    }
}
