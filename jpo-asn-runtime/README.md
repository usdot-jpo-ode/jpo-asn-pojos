# jpo-asn-runtime

This module contains base classes and serializers/deserialiers for ASN.1 types in Java.  

## Package Structure

* `types` - Interfaces and base classes for ASN.1 Types
* `annotations` - Custom Annotations for ASN.1 classes
* `serialization` - Serializers/Deserializers for XER and JER.
* `utils` - Utilities used by the other classes.

## Getting Started

### Prerequisites

* JDK 21 or higher
* Gradle or Maven

### Build

To build the project using Gradle, from this directory:

```bash
./gradlew clean build
```

To build the project using Maven, from the root directory:

```bash
./mvnw -pl jpo-asn-runtime -am clean package
```

### Run Tests

To run tests using Gradle, from this directory:

```bash
./gradlew clean test
```

To run tests using Maven, drom the root directory:

```bash
./mvnw -pl jpo-asn-runtime -am clean test
```

## Usage

### Create Annotated POJOs

**Examples**

An ASN.1 IA5String type with length constraints:
```java
public class AString extends IA5String {

  public AString() {
    super(1, 255);
  }

  public AString(String value) {
    this();
    this.value = value;
  }
}
```

An ASN.1 INTEGER type with value constraints:
```java
@JsonDeserialize(using = AInteger.AIntegerDeserializer.class)
public class AInteger extends Asn1Integer {

  public AInteger() {
    super(0L, 100L);
  }

  @JsonCreator
  public AInteger(long value) {
    this();
    this.value = value;
  }

  public static class AIntegerDeserializer extends IntegerDeserializer<AInteger> {
    public AIntegerDeserializer() {
      super(AInteger.class);
    }

    @Override
    protected AInteger construct() {
      return new AInteger();
    }
  }

}
```

An ASN.1 SEQUENCE type:
```java
@Getter
@Setter
@ToString(callSuper = true)
public class ASequence extends Asn1Sequence {

  @Asn1Property(tag = 0, name = "a-int")
  @JsonProperty("a-int")
  private AInteger aInt;
  @Asn1Property(tag = 1, name = "a-str")
  @JsonProperty("a-str")
  private AString aStr;

  public ASequence() {
    super(false);
  }
}
```


### Serialize to XER

```java
ASequence aSequence = ...
XmlMapper xmlMapper = SerializationUtil.xmlMapper();
String xml = xmlMapper.writeValueAsString(aSequence);
```

### Serialize to JER

```java
ObjectMapper jsonMapper = SerializationUtil.jsonMapper();
String json = jsonMapper.writeValueAsString(aSequence);
```

### Deserialize from XER

```java
ASequence aSequence = xmlMapper.readValue(xml, ASequence.class);
```

### Deserialize from JER

```java
ASequence aSequence = jsonMapper.readValue(json, ASequence.class);
```

## License

This project is licensed under the Apache 2 License - see the [LICENSE](../LICENSE) file for details.
