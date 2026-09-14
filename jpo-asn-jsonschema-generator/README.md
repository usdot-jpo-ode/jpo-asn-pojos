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

Typed `MessageFrame` schemas (e.g. `BasicSafetyMessageMessageFrame.schema.json`) are committed in [src/main/resources/schemas/](src/main/resources/schemas/). To regenerate all of them from the generic `MessageFrame` schema:

```bash
./batch_gen_schemas.sh --message-frames
```

This will:

1. Generate all PDU schemas (including the generic `MessageFrame` schema)
2. Copy `MessageFrame.schema.json` to `src/main/resources/schemas/MessageFrame/`
3. Extract typed MessageFrame schemas for all committed message types

The extraction logic is in [extract_message_frame_schemas.py](./extract_message_frame_schemas.py).
