#!/usr/bin/env python3

"""
This script reads an Eclipse .classpath file, finds all lib entries
in it and outputs the classpath in various forms needed for various
tools.

TODO
- Use a more robust XML parsing method if the .classpath file structure is complex.
"""

import sys
import os
import xml.etree.ElementTree as ET


def main():
    """ main code """
    if len(sys.argv) != 2:
        print("Usage: python script.py [base_jars|jnlp|jars|classpath]")
        sys.exit(1)

    command = sys.argv[1]
    # Parse the .classpath XML file
    tree = ET.parse('.classpath')
    root = tree.getroot()

    # Find all 'classpathentry' elements with kind="lib"
    lib_entries = [entry.get('path') for entry in root.findall(".//classpathentry[@kind='lib']")]

    result = []
    for entry in lib_entries:
        if command == "base_jars":
            result.append(os.path.splitext(os.path.basename(entry))[0])
        elif command == "jnlp":
            result.append(f'<jar href="{os.path.basename(entry)}"/>')
        elif command == "classpath":
            result.append(entry)
        elif command == "jars":
            result.append(entry)

    if command in ["jars", "base_jars"]:
        print(" ".join(result))
    elif command == "classpath":
        print(":".join(result))
    elif command == "jnlp":
        print("\n".join(result))

if __name__ == "__main__":
    main()
