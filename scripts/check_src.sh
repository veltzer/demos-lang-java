#!/bin/bash

# check that every project under 'projects' has an 'src' subfolder

for x in projects/*; do if [[ ! -d $x/src ]]; then exit 1; fi; done
