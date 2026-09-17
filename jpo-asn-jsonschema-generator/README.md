# JSON Schema Generator

Command line tool that uses a custom module for the victools json schema generator to create JSON schemas from the pojos.

## Build

```bash
./gradlew build
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

Typed MessageFrame classes use custom Jackson serializers that omit the `messageId`/`value` envelope from the default schema output. The generator's `Asn1Module` special-cases these classes to emit the full wire-format envelope.
