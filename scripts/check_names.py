#!/usr/bin/python3

""" Check every eclipse .project file names its own folder. """

import glob  # for glob
import os.path  # for split
import xml.etree.ElementTree  # for ElementTree

DEBUG = False

def main():
    """ main entry point """
    for project in glob.glob('projects/*/.project'):
        if DEBUG:
            print('doing', project)
        (path, _folder) = os.path.split(project)
        (_path2, folder2) = os.path.split(path)
        if DEBUG:
            print(folder2)
        document = xml.etree.ElementTree.ElementTree(file=project)
        counter = 0
        for element in document.findall('./name'):
            name = element.text or ""
            if name != folder2:
                raise ValueError(f'bad name for project {project} ({folder2} vs {name})')
            if DEBUG:
                print(name)
            counter += 1
        assert counter == 1

main()
