#!/bin/bash
export DEST="./.exvim.GridWorld"
export TOOLS="/Users/eleven/exvim//vimfiles/tools/"
export TMP="${DEST}/_symbols"
export TARGET="${DEST}/symbols"
sh ${TOOLS}/shell/bash/update-symbols.sh
