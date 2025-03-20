# J2735/2024 POJOs

This is a Java library with the 2024 POJOs.

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
messages and verifying their correctness independent of the code being tested. Due to the complexity
of the standard, it would have been a very laborious and error-prone process to create all the 
sample data needed for a comprehensive test suite by hand. Therefore, we used several automated 
tools to aid in creating and verifying the test messages. Those tools are described here: 
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



