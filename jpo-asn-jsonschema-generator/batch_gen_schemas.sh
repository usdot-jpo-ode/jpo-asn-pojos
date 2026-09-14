#!/bin/bash

set -euo pipefail

usage() {
    cat <<EOF
Usage: $0 [OPTIONS]

Generate JSON schemas from ASN.1 POJOs.

Options:
  --message-frames    Also generate typed MessageFrame schemas to src/main/resources/schemas/
  -h, --help          Show this help message

By default, PDU schemas are generated into the schemas/ directory.
With --message-frames, typed MessageFrame schemas are generated via the CLI
and written to src/main/resources/schemas/ for all committed message types.
EOF
}

GENERATE_MESSAGE_FRAMES=false

while [[ $# -gt 0 ]]; do
    case $1 in
        --message-frames)
            GENERATE_MESSAGE_FRAMES=true
            shift
            ;;
        -h|--help)
            usage
            exit 0
            ;;
        *)
            echo "Unknown option: $1" >&2
            usage
            exit 1
            ;;
    esac
done

# Create output directory if it doesn't exist
mkdir -p schemas

# Check if the JAR file exists
JAR_FILE="build/libs/schemagen-cli.jar"
if [ ! -f "$JAR_FILE" ]; then
    echo "Error: JAR file not found at $JAR_FILE"
    echo "Please build the project first using: ./gradlew build"
    exit 1
fi

# List of PDUs and their corresponding modules to generate schemas for
# Format: "PDU_NAME:MODULE_NAME"
PDUS=(
    "MessageFrame:MessageFrame"
    "BasicSafetyMessage:BasicSafetyMessage"
    "PersonalSafetyMessage:PersonalSafetyMessage"
    "SignalRequestMessage:SignalRequestMessage"
    "SignalStatusMessage:SignalStatusMessage"
    "SPAT:SPAT"
    "MapData:MapData"
    "SensorDataSharingMessage:SensorDataSharingMessage"
    "RTCMcorrections:RTCMcorrections"
    "RoadSafetyMessage:RoadSafetyMessage"
)

# Typed MessageFrame classes committed in src/main/resources/schemas/
# Format: "MESSAGE_FRAME_CLASS:MODULE_NAME"
MESSAGE_FRAMES=(
    "BasicSafetyMessageMessageFrame:BasicSafetyMessage"
    "MapDataMessageFrame:MapData"
    "PersonalSafetyMessageMessageFrame:PersonalSafetyMessage"
    "RoadSafetyMessageMessageFrame:RoadSafetyMessage"
    "RTCMcorrectionsMessageFrame:RTCMcorrections"
    "SensorDataSharingMessageMessageFrame:SensorDataSharingMessage"
    "SignalRequestMessageMessageFrame:SignalRequestMessage"
    "SignalStatusMessageMessageFrame:SignalStatusMessage"
    "SPATMessageFrame:SPAT"
    "TravelerInformationMessageFrame:TravelerInformation"
)

generate_schema() {
    local module="$1"
    local pdu="$2"
    local output="$3"
    echo "Generating schema for $pdu (module: $module)..."
    mkdir -p "$(dirname "$output")"
    java -jar build/libs/schemagen-cli.jar -m "$module" -p "$pdu" -o "$output"
}

# Generate schema for each PDU
for pdu_entry in "${PDUS[@]}"; do
    IFS=':' read -r pdu module <<< "$pdu_entry"
    generate_schema "$module" "$pdu" "schemas/${module}/${pdu}.schema.json"
done

echo "PDU schema generation complete!"

if [ "$GENERATE_MESSAGE_FRAMES" = true ]; then
    echo ""
    echo "Generating typed MessageFrame schemas..."

    RESOURCES_SCHEMAS_DIR="src/main/resources/schemas"

    generate_schema "MessageFrame" "MessageFrame" \
        "${RESOURCES_SCHEMAS_DIR}/MessageFrame/MessageFrame.schema.json"

    for mf_entry in "${MESSAGE_FRAMES[@]}"; do
        IFS=':' read -r message_frame module <<< "$mf_entry"
        generate_schema "$module" "$message_frame" \
            "${RESOURCES_SCHEMAS_DIR}/${module}/${message_frame}.schema.json"
    done

    echo "MessageFrame schema generation complete!"
fi
