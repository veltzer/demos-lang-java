#!/usr/bin/env python

""" Compile every Java source under src/ together, reproducing the Makefile's
`javac -Werror -Xlint:all <all sources> -d out/classes`. File arguments are
ignored -- javac is run once over the whole source set (types reference each
other, so a per-file build would not work). """

import glob
import os
import subprocess
import sys

OUT = os.path.join("out", "classes")


def main():
    """ main entry point """
    sources = sorted(glob.glob(os.path.join("src", "**", "*.java"), recursive=True))
    if not sources:
        return
    os.makedirs(OUT, exist_ok=True)
    sys.exit(subprocess.call(
        ["javac", "-Werror", "-Xlint:all"] + sources + ["-d", OUT]))


if __name__ == "__main__":
    main()
