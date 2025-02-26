#!/usr/bin/env bash

set -x

./converter-all -dd -p BasicSafetyMessage -iuper -oxer $1.bin > $1.xml
./converter-all -dd -p BasicSafetyMessage -iuper -ojer $1.bin > $1.json
