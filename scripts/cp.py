#!/usr/bin/python3

# create the classpath for this project

import glob # for glob

l=glob.glob('lib/*.jar')
l.append('support')

print(':'.join(l))
