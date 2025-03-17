# J2735/2024 POJOs

This is a Java library with the 2024 POJOs.

To build:

```bash
./gradlew clean build
```
Tools for generating test data are in the
[generate-test-data](../generate-test-data/README.md)
folder.

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

The [unit tests](src/test/java/us/dot/its/jpo/asn/j2735/r2024) include more complete usage examples.  