# Test Generator

This is a Java command line utility for generating test messages in XER and JER format.

## Prerequisites

* Java 21

## Build

```bash
cd jpo-asn-test-generator
./gradlew clean build
```

Then the executable named `testgen-cli.jar` will be available in the `build/libs` directory.

## Usage

```
Usage: testgen-cli [-rhV] -m=<module> -p=<pdu> [-xp=<excludePdus>]...
                   [-s=<sequenceOfLimit>] [-x=<xerOutputFile>]
                   [-j=<jerOutputFile>]
  -m, --module=<module>   REQUIRED. ASN.1 Module name.  For example: MapData,
                            Common.
  -p, --pdu=<pdu>         REQUIRED. Protocol Data Unit (PDU).  Name of the
                            class to generate an example of.For example:
                            MapData, BSMCoreData.
  -xp, --exclude-pdus=<excludePdus>
                          Module.PDUs to exclude from sequences (class name eg.
                            'MapData.PreemptPriorityList',  'REGION.
                            Reg_MovementEvent')
  -s, --sequence-of-limit=<sequenceOfLimit>
                          Limit the number of items in SEQUENCE-OF types. Must
                            be at least 2.
  -x, --xer-output-file=<xerOutputFile>
                          Output file path for the XER file.
  -j, --jer-output-file=<jerOutputFile>
                          Output file path for the JER file.
  -r, --regional          Include fields named 'regional' and other regional
                            extensions. Omitted by default if this flag is not
                            present.
  -h, --help              Show this help message and exit.
  -V, --version           Print version information and exit.

```

### Usage Examples

Generate a MovementEvent and display the output XER and JER on stdout:

```bash
java -jar testgen-cli.jar -m SPAT -p MovementEvent
```

Generate a SPAT message, and save the XER and JER to files:

```bash
java -jar testgen-cli.jar -m SPAT -p SPAT -x spat.xml -j spat.json
```



