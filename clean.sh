#!/usr/bin/env bash

set -e

infile=$1
outfile=$2

# Find the first line which is of the form 
#    s2 -> s1 [label="3 / "];
# which means that this is a line with an input and no output
# get its target
s0=`grep '/ "' $infile | head -1 | sed "s/.*-> \(.*\) \[.*/\1/"`

# Remove all lines into s0 that do not contain error or start
awk '!'"/-> ${s0} / || /error/ || /__start/" $infile > $outfile

# If found s0 is not s0 then remove it's definition
# if it is s0 the start arrow still points to it
if [[ "$s0" != "s0" ]]; then
  awk '!'"/${s0} \[shape/" $outfile > temp.dot
  mv temp.dot $outfile
fi

# Give the arrows pointing to the error state pretty names
sed -i "s/-> ${s0} \(.*\)error_\([0-9]*\);/-> error_\2 \1/" $outfile
