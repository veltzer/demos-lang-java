#!/bin/bash

# before running this script make sure that you have eclipse installed
# in ~/install/eclipse-XXX (may be soft link).
# in this project we really need jee or maybe even rcp
VERSION=jee
#VERSION=java
#VERSION=rcp
if test -d ~/workspace-$VERSION -a -f ~/install/eclipse-$VERSION/eclipse; then
	~/install/eclipse-$VERSION/eclipse -data ~/workspace-$VERSION 2> /dev/null 1> /dev/null &
else
	echo "you have a problem with the version [$VERSION]..."
fi
