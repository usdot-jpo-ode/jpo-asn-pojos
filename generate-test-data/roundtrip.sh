#!/usr/bin/env bash

set -x

./converter-new-jer -p $1 -ixer -ouper $2.xml > $2.bin
./converter-new-jer -p $1 -iuper -oxer $2.bin > ${2}_rt.xml
./converter-new-jer -p $1 -iuper -ojer $2.bin > ${2}_rt.json
