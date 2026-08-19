#!/usr/bin/python3

"""
This script will remove all jars from .classpath files and will plant new
ones according to jars in lib.

Deliberately disabled: running it exits with the message below. The logic is
kept in plant() for reference only and is never called.
"""

import glob # for glob
import sys # for exit
import xml.dom.minidom # for parse

ADD_JARS=False

def iterate_children(parent):
    """ Yield the direct children of a DOM node. """
    child = parent.firstChild
    while child is not None:
        yield child
        child = child.nextSibling

def plant():
    """ Rewrite every projects/*/.classpath (kept for reference, not called). """
    jar_list=glob.glob('lib/*.jar')
    jar_list.extend(glob.glob('static/*.jar'))
    for filename in glob.glob('projects/*/.classpath'):
        document = xml.dom.minidom.parse(filename)
        # remove all classpathentry elements with attribute kind=lib
        for node in document.getElementsByTagName('classpathentry'):
            if node.getAttribute('kind')=='lib':
                node.parentNode.removeChild(node)
        # add all the jars
        if ADD_JARS:
            for jar in jar_list:
                e=document.createElementNS(None,'classpathentry')
                e.setAttribute('kind','lib')
                e.setAttribute('path','../../'+jar)
                document.firstChild.appendChild(e)
        # remove white space
        remove_list=[]
        for child in iterate_children(document.firstChild):
            if child.nodeType==child.TEXT_NODE:
                if child.nodeValue.strip()=="":
                    remove_list.append(child)
        for node in remove_list:
            node.parentNode.removeChild(node)
        # write the output file
        with open(filename, "w", encoding="utf-8") as f:
            f.write(document.toprettyxml(indent="\t"))

sys.exit("you really should use eclipse variables and not this script")
