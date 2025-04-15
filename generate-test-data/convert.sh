#!/usr/bin/env bash

set -x

BASEDIR=./examples/2024/$2

./converter-new-jer -p $1 -iuper -oxer $BASEDIR/$3.bin > $BASEDIR/$3_rt.xml
./converter-new-jer -p $1 -iuper -ojer $BASEDIR/$3.bin > $BASEDIR/$3_rt.json
