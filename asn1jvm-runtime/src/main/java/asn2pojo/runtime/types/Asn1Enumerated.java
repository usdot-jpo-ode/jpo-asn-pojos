package asn2pojo.runtime.types;



public interface Asn1Enumerated extends Asn1Type {
    int getIndex();
    String getName();
    boolean hasExtensionMarker();
    int maxIndex();



}
