# JSON Schema Generator

Command line tool that uses a custom module for the victools json schema generator to create JSON schemas from the pojos.

## Build

```bash
./gradlew shadowJar
```

## Usage

```bash
cd build/libs
java -jar schemagen-cli.jar -m <module> -p <pdu> -o <output-fiile>
```

## Batch Schema Generation

To generate schemas for multiple PDUs at once, you can use the [provided script](./batch_gen_schemas.sh):

```bash
./batch_gen_schemas.sh
```

This script will generate JSON schemas for the following messages:

- Generic `MessageFrame`
- BasicSafetyMessage
- PersonalSafetyMessage
- SignalRequestMessage
- SignalStatusMessage
- SignalPhaseAndTimingMessage
- MapData
- SensorDataSharingMessage
- RTCMCorrections
- RoadSafetyMessage

The generated schemas will be placed in the `schemas` directory.

### MessageFrame Schema Regeneration

Typed `MessageFrame` schemas (e.g. `BasicSafetyMessageMessageFrame.schema.json`) are committed in [src/main/resources/schemas/](src/main/resources/schemas/). To regenerate all of them:

```bash
./batch_gen_schemas.sh --message-frames
```

This will:

1. Generate all PDU schemas into the `schemas/` directory
2. Copy the generic `MessageFrame` schema from `schemas/` into `src/main/resources/schemas/MessageFrame/`
3. Generate typed MessageFrame schemas via the CLI for all committed message types

Previously, generating a schema directly from a typed MessageFrame class described only the PDU wrapper, such as `{ "BasicSafetyMessage": ... }`. The sequence handler inspected declared fields and missed the inherited `messageId` and `value` envelope. The serialized JSON and committed schemas already included that envelope; regenerating a typed schema required manually extracting a branch from the generic MessageFrame schema.

`Asn1Module` now generates the complete envelope for typed MessageFrame classes. A shared helper builds the open-type PDU wrapper inside `value`. Generic MessageFrame `oneOf` branches invoke the sequence value handler directly, which uses the same helper, because each branch already supplies `messageId` and `value`. Callers do not need an envelope flag, and typed frames nested in ordinary sequences retain their complete envelope.

To regenerate a single typed schema:

```bash
java -jar build/libs/schemagen-cli.jar \
  -m BasicSafetyMessage -p BasicSafetyMessageMessageFrame \
  -o src/main/resources/schemas/BasicSafetyMessage/BasicSafetyMessageMessageFrame.schema.json
```
