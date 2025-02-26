#!/usr/bin/env bash

set -x

BASEDIR=./examples/2024/bsm
./converter-all -dd -p BasicSafetyMessage -iuper -oxer $BASEDIR/$1.bin > $BASEDIR/$1.xml
./converter-all -dd -p BasicSafetyMessage -iuper -ojer $BASEDIR/$1.bin > $BASEDIR/$1.json
