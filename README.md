# jpo-asn-pojos

Generated POJOs ("Plain Old Java Objects") from ASN SAE and IEEE standards.

## Background

## Features

These are Java classes for encoding and decoding the ASN.1 XER (XML Encoding Rules) and JER (JSON
Encoding Rules) formats.

## Getting Started

### Prerequisites

* JDK 21 or higher
* Gradle or Maven

### Build

### Run Tests

### Installation

#### Use as a Submodule

##### Gradle

##### Maven

#### Use as a Dependency

##### Gradle

##### Maven

## Usage

## Contributing


Folders:

* [jpo-asn-runtime](jpo-asn-runtime/README.md) - Runtime library.
* [jpo-asn-j2735-2024](jpo-asn-j2735-2024/README.md) - POJOs for the J2735/2024 specification.
* [jpo-asn-test-generator](jpo-asn-test-generator/README.md) - A Java command-line utility for
  generating test XER and JER messages.
* [generate-test-data](generate-test-data/README.md) - Various utilities for generating test data
  and examples of serialized
  messages.

Prerequisites:

* JDK 21

To build using Gradle:

```bash
cd jpo-asn-j2735-2024
./gradlew clean build
```

To build using Maven, from the root directory:

```bash
./mvnw clean package
```

