# J2735/2024 POJOs

This is a Java library with the 2024 POJOs.

## Design notes

### Goals

The goal of this library is to be a complete implementation of the J2735/2024 specification in Java.

The design philosophy was to try to keep it simple, but to also be complete and not to arbitrarily remove anything from the standard.

The implementation consists of a set of classes organized into a simple class hierarchy according to ASN.1 type, with Jackson and custom annotations added to facilitate serialization/deserialization.  Generics are used to implement ASN.1's parameterized extensibility mechanism. In most cases there is a one-to-one correspondence between types defined in the ASN.1 specification and the Java classes in this implementation.

### Non Goals

Despite this repository having "pojos" in its name, and documentation referring to the Java classes as "POJOS", it was not a design goal to make the classes conform to certain strict definitions of the term "POJO". For example, in some definitions, POJOs don't derive from base classes, don't have annotations, and don't have any methods other than getters and setters.   The classes in this implementation do have all of those, but a pragmatic approach was taken to try to keep the classes fairly simple. We use the term POJO here in a more colloquial sense to mean that these are reasonably simple Java objects. But "reasonably simple Java objects" is not so useful as a shorthand to say out loud as "POJO" is. Various versions of a more "strict pojo" design were considered and rejected while designing the library.

---
**Some specific notes on a few design choices whose rationale might not be obvious:**

### Parameterized Types

Examples of ASN.1 parameterized types include BSM Part II content, MessageFrames, and regional extensions in many types.

ASN.1 parameterized types are represented in this library by abstract generic Java classes.  This representation was chosen over other alternatives that were considered, such as using abstract (non-generic) classes, because of the expressiveness of being able to write, for example:

```java
MessageFrame<MapData>
MessageFrame<BasicSafetyMessage>
```

which matches the intended meaning of the parameterized types in the ASN.1 specification, which is as a set of various types that plug into a "hole" in another type in a modular and extensible fashion.

In the standard, parameterized types are defined as sets of types linked by an Information Object Class with a type identified by an integer ID.

As a specific example, the regional extensions for Position3D are defined this way in the ASN.1 standard:

```asn1
-- The Information Object class for all regional extensions
REG-EXT-ID-AND-TYPE ::= CLASS {
   &id     RegionId UNIQUE,
   &Type
   } WITH SYNTAX {&Type IDENTIFIED BY &id}

-- A parameterized type for all regional extensions
RegionalExtension {REG-EXT-ID-AND-TYPE : Set} ::= SEQUENCE {
   regionId     REG-EXT-ID-AND-TYPE.&id( {Set} ),
   regExtValue  REG-EXT-ID-AND-TYPE.&Type( {Set}{@regionId} )
   }

-- A specific set of types of the IOC for the Position3D regional extensions
Reg-Position3D            REG-EXT-ID-AND-TYPE ::= { 
   { Position3D-addGrpB IDENTIFIED BY addGrpB} |
   { Position3D-addGrpC IDENTIFIED BY addGrpC} ,
   ... 
   }   
   
```

Due to Java type erasure, the simplest way to write the code for these abstract generic classes sometimes involves the use of raw generic types, so "raw types" warnings can be found in some of the classes.  For an example, see the implementation of SEQUENCE-OF Reg-Position3D in the Position3D class:

```java
public class Position3D extends Asn1Sequence {

 ...
 
  private SequenceOfRegional regional;

  @JsonInclude(Include.NON_NULL)
  @SuppressWarnings("rawtypes")
  public static class SequenceOfRegional extends Asn1SequenceOf<Reg_Position3D> {
    public SequenceOfRegional() {
      super(Reg_Position3D.class, 1L, 4L);
    }
  }

 ...
}
```

### Custom Serializers/Deserializers

The library makes extensive use of custom Jackson serializers/deserializers and annotations. This was necessary to achieve the goal of having POJOs capable of handling both XER and JER in the same classes, while still leveraging Jackson, but does lead to some complexity.

For instance, in some cases when adding a `@JsonDeserialize(using = SomeCustomSerializer.class)` annotation to a base class, it's necessary to add `@JsonDeserialize(using = None.class)` to the implementation classes to prevent an infinite recursion in the deserializer.  

For example, the abstract generic class `Reg_Position3D` is annotated with a custom deserializer:

```java
@JsonDeserialize(using = Reg_Position3DDeserializer.class)
public abstract class Reg_Position3D<TValue> extends RegionalExtension<TValue> {
  ...
}
```

and it's implementations require a "None" annotation:

```java
@JsonRootName("Reg_Position3D")
@JsonDeserialize(using = None.class)
public class Position3D_addGrpBReg_Position3D extends Reg_Position3D<Position3D_addGrpB> {
  ...
}
```

## To build:

From this directory:

```bash
./gradlew clean build
```

## Usage examples:

### Deserialize from XER:

```java
String XML =
    """
        <MessageFrame>
                <messageId>19</messageId>
                <value>
                    <SPAT>
                        <timeStamp>400000</timeStamp>
                        <name>Example Name</name>
                        <intersections>
                            <IntersectionState>
        ...
        """;

XmlMapper xmlMapper = new XmlMapper();
SPATMessageFrame spatMessageFrame = xmlMapper.readValue(xml, SPATMessageFrame.class);
int messageId = spatMessageFrame.getMessageId();
```

### Serialize to JER:

```java
ObjectMapper jsonMapper = new ObjectMapper();
SPATMessageFrame spat = createSpat();
String json = jsonMapper.writeValueAsString(spat);
```

Partial output:

```json
{
  "value": {
    "timeStamp": 400000,
    "name": "Example Name",
    "intersections": [
      {
        "id": {
          "region": 0,
          "id": 12111
        },
        "revision": 0,
        ...
```

## Testing

The [unit tests](src/test/java/us/dot/its/jpo/asn/j2735/r2024) include more complete usage examples.
Most of the tests involve serializing and deserializing an XER or JER example in a round trip and
comparing the result with the original using the [XMLUnit](https://www.xmlunit.org/) and
[JSONUnit](https://github.com/lukas-krecan/JsonUnit) test libraries.

The specification represented by the classes in this library consists of a large number of very
complex data structures. These were tested using generated examples of the serialized XER and JER
messages whose correctness was verified independently of the code being tested. Due to the 
complexity of the standard, it would have been a very laborious and error-prone process to create 
all the sample data needed for a comprehensive test suite by hand. Therefore, we used several 
automated tools to aid in creating and verifying the test messages. Those tools are described here: 
[generate-test-data](../generate-test-data/README.md).

### Gradle

To run the unit tests via Gradle, from this directory issue:

```bash
./gradle clean test
```

then open the `build/reports/tests/test/index.html` file in a browser to view the test results.

The [JaCoCo](https://www.jacoco.org/jacoco/) plugin is used to measure test coverage. After running
the tests, open the `build/reports/jacoco/test/html/index.html` file in a browser to view the
coverage results.

### Maven

To run the unit tests via Maven, from the **root** directory issue:

```bash
./mvnw clean test
```

The coverage report will be available at `target/target/site/jacoco/index/html`.

The individual test results are available in the `target/surefire-reports` directory.

## License

This project is licensed under the Apache 2 License - see the [LICENSE](../LICENSE) file for details.


