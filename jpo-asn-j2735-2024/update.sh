#!/usr/bin/env bash
#
# This script is to be used during the PR review process to pull in any changes from a complete
# branch into the branch under review containing a subset of the generated classes, in the event the
# classes need to be regenerated.  It pulls in updates for all classes that already exist in this
# branch from the complete branch.
#
# Prerequisites:
#   Git Bash shell
#

# echo on
set -x

# Recursive glob
shopt -s globstar

BRANCH=j2735-2024-part-9
PACKAGE=src/main/java

echo "Checkout files from $BRANCH"

for FILENAME in "${PACKAGE}"/**/*.java; do
  git checkout "$BRANCH" "$FILENAME"
done