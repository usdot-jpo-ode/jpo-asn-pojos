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

To run tests using Maven, from the root directory:

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

## Optional Custom JSON Format

Note that by default this library uses standard ASN.1 JSON Encoding Rules which produces hex formatted BIT STRING values. A custom Jackson ObjectMapper is provided to be used for cases where having human-readable JSON BIT STRINGs is of paramount importance.

Usage examples:

```java
// Always cache and reuse ObjectMappers
final static ObjectMapper customMapper = new OdeCustomJsonMapper(true);

// Serialize to json with human readable bitstrings
String json = customMapper.writeValueAsString(bitstring);

// Deserialize human readable json with human readable bitstrings
ExampleBitstring deserializedFromCustom = customMapper.readValue(json, ExampleBitstring.class);
```

Note that the JSON format with human-readable BIT STRINGS is non-standard and can considerably increase the verbosity of JSON data. It looks like this:

```json
{
  "from000-0to022-5degrees": true,
  "from022-5to045-0degrees": true,
  "from045-0to067-5degrees": true,
  "from067-5to090-0degrees": true,
  "from090-0to112-5degrees": true,
  "from112-5to135-0degrees": true,
  "from135-0to157-5degrees": true,
  "from157-5to180-0degrees": true,
  "from180-0to202-5degrees": true,
  "from202-5to225-0degrees": true,
  "from225-0to247-5degrees": true,
  "from247-5to270-0degrees": true,
  "from270-0to292-5degrees": true,
  "from292-5to315-0degrees": true,
  "from315-0to337-5degrees": true,
  "from337-5to360-0degrees": true
}
```

## License

This project is licensed under the Apache 2 License - see the [LICENSE](../LICENSE) file for details.
