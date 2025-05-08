#!/usr/bin/env bash

#
# Script to test "round-tripping" XER and JER messages through the asn1c codec.
# Accepts an XER and JER file, convets them to UPER, and converts the UPER back
# to XER and JER.  Outputs UPER, roundtrip XER, JER and diff files.
#
# Requires:
#
# - Linux command line (tested with WSL/Ubuntu on Windows)
#
# Example usage:
#
# 1. Generate SPAT messages with the Java tool:
#
#   java -jar testgen-cli.jar -m SPAT -p SPAT -x spat.xml -j spat.json
#
# 2. Round trip them through asn1c with this script:
#
#   ./roundtrip.sh SPAT spat
#

set -x

./converter-new-jer -p $1 -ixer -ouper $2.xml > $2_xml_rt.bin
./converter-new-jer -p $1 -ijer -ouper $2.json > $2_json_rt.bin
./converter-new-jer -p $1 -iuper -oxer $2_xml_rt.bin > ${2}_rt.xml
./converter-new-jer -p $1 -iuper -ojer $2_json_rt.bin > ${2}_rt.json
diff $2.xml ${2}_rt.xml > ${2}_xml_diff.txt
diff $2.json ${2}_rt.json > ${2}_json_diff.txt
