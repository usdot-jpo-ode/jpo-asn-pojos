# Generating test data for J2735/2024

We have 2 open-source tools for generating message examples that were generated using mature,
third-pary ASN.1 compilers:

* asn1c converters
* Erlang OTP converters

## asn1c Converters

This directory contains two converters created with the [VLM asn1c](https://github.com/vlm/asn1c)
compiler (using the [usdot fork](https://github.com/usdot-fhwa-stol/usdot-asn1c) of the
[mouse07410 fork](https://github.com/mouse07410/asn1c)). These are command line tools that work in
WSL/Ubuntu.

### converter-junktest

Compiled with the "JUNKTEST" flag that allows generating random data.  
Uses the `asn_random_fill` api function. It was compiled with the -no-gen-JER and -no-gen-UPER,
-no-gen-APER,
because it wouldn't compile with JER, and following the recommendation in the asn1c
`asn1c-usage.pdf`which says:
> For best results the code should be generated without -no-gen-PER option to asn1c.
> Making PER constraints code available in runtime will make asn_random_fill explore
> the edges of PER-visible constraints and sometimes break out of extensible contstraints’
> ranges

This converter generates BASIC XER. For message frames that contain octet strings, the hex strings
need to have
spaces removed to be consistent with Canonical XER which the ODE and asn1jvm runtime expect.

This tool tends to generate a lot of very random junk, especially for large messages that contain
character string, octet string, or bitstring types. It does not respect the size constraint of
bitstrings.
It often fails with large messages, but often will generate something if you keep trying.

#### Usage Examples

To list all available messages:

```bash
./converter-junktest -p list
```

To generate an example of the new BSM Part III extension:

```bash
./converter-junktest -p TravelerDataFrameNewPartIIIContent -R 1024 > TravelerDataFrameNewPartIIIContent-1.xml
```

To generate a SensorDataSharingMessage (this segfaults about half the time):

```bash
./converter-junktest -p SensorDataSharingMessage -R 2048 > sdsm1.xml
```

### converter-all

Compiled with all encodings. This can be used to convert between UPER, BASIC XER, and JER.

This converter uses BASIC XER. For message frames that contain octet strings, the hex strings need
to have
spaces removed to be consistent with Canonical XER which the ODE and asn1jvm runtime expect.

Example. To convert the above SDSM XER to JER:

```bash
./converter-all -p SensorDataSharingMessage -ixer -ojer sdsm1.xml > sdsm1.json
```

### converter-debug

Compiled with verbose debug output enabled, and CANONICAL XML support.

Can be used to convert between UPER, CANONICAL XER, and JER, and to diagnose issues where the asn1c
converters are unable to process a message.

This converter consumes and produces **CANONICAL** XER which is the same dialect of XER that the ODE
and asn1jvm POJOs expect. It is characterized by octet strings with no spaces between the bytes,
and compact XML with no line breaks or indentation.

Usage example to convert a BSM MessageFrame from a file containing UPER-encoded binary to XER and
JER:

```bash
./converter-debug -p MessageFrame -iuper -oxer bsm_mf_noext_01.bin > bsm_mf.xml
./converter-debug -p MessageFrame -iuper -ojer bsm_mf_noext_01.bin > bsm_mf.json
```

## Erlang converter

See:

https://github.com/iyourshaw/j2735-erlang

The Erlang converter's random asn.1 generator has it's own quirks, the main one being that
if messages contain open types, it fills them with random junk that needs to be removed
to get a valid message. It is capable of producing UPER and JER, but not XER.
It respects bitstring sizes, and is better able to generate large messages than asn1c.

It can be run using the dev container in that repo.

Example, generate a random RoadSafetyMessage and save to a file:

```erlang
% Create a random message
{ok, Rsm} = asn1ct:value('RoadSafetyMessage', 'RoadSafetyMessage').

% Save the Erlang term to a file
file:write_file("../examples/rsm.src", io_lib:format("~p.~n", [Rsm])).
```

Manually edit, replacing the Regional Extension open types like:

```erlang
[{'RegionalExtension',107,<<"\n\topen_type">>},
{'RegionalExtension',71,<<"\n\topen_type">>},
{'RegionalExtension',41,<<"\n\topen_type">>}]
```

with `asn1_NOVALUE`

Reload the edited erlang term and convert to UPER and JER and save to a file:

```erlang
% Reload the Erlang term
{ok, [RsmReload]} = file:consult("../examples/rsm.src").

% Convert to UPER
{ok, RsmUper} = 'RoadSafetyMessage':encode('RoadSafetyMessage', RsmReload).

% Save UPER to file
file:write_file("rsm.bin", RsmUper).

% Convert to JER
{ok, RsmJer} = 'RoadSafetyMessage':jer_encode('RoadSafetyMessage', RsmReload).

% Save JER to file
file:write_file("rsm.json", RsmJer).
```







