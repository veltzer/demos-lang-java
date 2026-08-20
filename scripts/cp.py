#!/usr/bin/python3

""" Create the classpath for this project. """

import glob  # for glob

PARTS = []
PARTS.extend(glob.glob('lib/*.jar'))
PARTS.extend(glob.glob('static/*.jar'))
PARTS.append('support')

print(':'.join(PARTS))
