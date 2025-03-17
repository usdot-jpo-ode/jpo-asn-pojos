# jpo-asn-pojos

Generated POJOs from ASN SAE and IEEE standards

These are Java codecs for XER and JER ASN.1 encodings.

Folders:

* **jp-asn-asn1jvm-runtime** - Runtime library.
* **jpo-asn-j2735-2024** - POJOs for the J2735/2024 specification.
* **jpo-asn-test-generator** - A Java command-line utility for generating test XER and JER messages.
* **generate-test-data** - Various utilities for generating test data and examples of serialized
  messages.

Prerequisites:

* JDK 21

To build using gradle:

```bash
cd jpo-asn-j2735-2024
./gradlew clean build
```

To build using maven, from the root directory:

```bash
./mvnw clean package
```

