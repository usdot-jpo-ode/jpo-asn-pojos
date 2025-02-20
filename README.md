# jpo-asn-pojos
Generated POJOs from ASN SAE and IEEE standards

These are Java codecs for XER and JER ASN.1 encodings.

Folders:

* **asn1jvm-runtime** - Runtime library
* **j2735-2024** - POJOs for the J2735/2024 specification
* **generate-test-data** - Utilities for generating test data and examples of serialized messages.

Prerequisites:

* JDK 21

To build using gradle:
```bash
cd j2735-2024
./gradlew clean build
```

TBD: POMs will be added to make the library buildable via Maven also.