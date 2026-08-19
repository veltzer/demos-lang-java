#!/usr/bin/python3

""" Fetch/copy the jar dependencies of this project into static/. """

###########
# imports #
###########
import subprocess # for check_call
import shutil # for rmtree, copyfile
import os.path # for join, split, isfile
import os # for mkdir
import glob # for glob

##############
# parameters #
##############
DO_VERBOSE=False
DO_CLEAN=True
DO_JDIC=False
DO_ECLIPSE=True
DO_JNA=False

# eclipse plugins needed and where they live
ECLIPSE_PLUGINS=[
    'org.eclipse.core.commands',
    'org.eclipse.core.contenttype',
    'org.eclipse.core.filebuffers',
    'org.eclipse.core.jobs',
    'org.eclipse.core.resources',
    'org.eclipse.core.runtime',
    'org.eclipse.debug.core',
    'org.eclipse.e4.ui.workbench3',
    'org.eclipse.equinox.app',
    'org.eclipse.equinox.common',
    'org.eclipse.equinox.preferences',
    'org.eclipse.equinox.registry',
    'org.eclipse.jdt.launching',
    'org.eclipse.jface',
    'org.eclipse.jface.text',
    'org.eclipse.osgi',
    #'org.eclipse.persistence.jpa.equinox.weaving',
    'org.eclipse.swt',
    'org.eclipse.swt.gtk.linux.x86',
    'org.eclipse.text',
    'org.eclipse.ui',
    'org.eclipse.ui.editors',
    'org.eclipse.ui.forms',
    'org.eclipse.ui.ide',
    'org.eclipse.ui.views',
    'org.eclipse.ui.workbench',
    'org.eclipse.ui.workbench.texteditor',
    'org.eclipse.wst.server.core',
]
ECLIPSE_PATH='/home/mark/install/eclipse-jee/plugins'

JNA_FILES=[
    '/usr/share/java/jna.jar',
    '/usr/share/java/jna-platform.jar',
]

#############
# functions #
#############
def file_msg(f):
    """ Report a file about to be created. """
    if DO_VERBOSE:
        print(f'creating file [{f}]')

def clean():
    """ Recreate the static/ folder. """
    shutil.rmtree('static', True)
    os.mkdir('static')

def fetch_jdic():
    """ Download the jdic jar. """
    target='static/jdic.jar'
    if not os.path.isfile(target):
        file_msg(target)
        subprocess.check_call([
            'wget',
            'http://maven.repository.paxle.net/org/jdesktop/jdic/jdic/0.9.5/jdic-0.9.5.jar',
            '-O', target,
        ], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)

def copy_eclipse_jars():
    """ Copy the needed eclipse plugin jars into static/. """
    for x in ECLIPSE_PLUGINS:
        candidates=glob.glob(os.path.join(ECLIPSE_PATH, x+'_*.jar'))
        if len(candidates)<1:
            raise ValueError('too few candidates for '+x)
        filename=candidates[0]
        target=os.path.join('static', os.path.split(filename)[1])
        if not os.path.isfile(target):
            file_msg(target)
            shutil.copyfile(filename, target)

def copy_jna_jars():
    """ Copy the system jna jars into static/. """
    for x in JNA_FILES:
        target=os.path.join('static', os.path.split(x)[1])
        if not os.path.isfile(target):
            file_msg(target)
            shutil.copyfile(x, target)

########
# code #
########
if DO_CLEAN:
    clean()
if DO_JDIC:
    fetch_jdic()
if DO_ECLIPSE:
    copy_eclipse_jars()
if DO_JNA:
    copy_jna_jars()
