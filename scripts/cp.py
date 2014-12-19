#!/usr/bin/python3

# create the classpath for this project

import glob # for glob

l=[]
l.extend(glob.glob('lib/*.jar'))
l.extend(glob.glob('static/*.jar'))
l.append('support')

print(':'.join(l))
