#!/usr/bin/python3

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
do_verbose=False
do_clean=True
do_jdic=True
do_eclipse=True
do_jna=False

#############
# functions #
#############
def file_msg(f):
	if do_verbose:
		print('creating file [{0}]'.format(f))

########
# code #
########
if do_clean:
	shutil.rmtree('static', True)
	os.mkdir('static')

# jdic jar

if do_jdic:
	target='static/jdic.jar'
	if not os.path.isfile(target):
		file_msg(target)
		subprocess.check_call(['wget','http://maven.repository.paxle.net/org/jdesktop/jdic/jdic/0.9.5/jdic-0.9.5.jar','-O',target], stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)

# eclipse jars

if do_eclipse:
	l=[
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

	epath='/home/mark/install/eclipse-jee/plugins'
	for x in l:
		candidates=glob.glob(os.path.join(epath,x+'_*.jar'))
		if len(candidates)<1:
			raise ValueError('too few candidates for '+x)
		'''
		if len(candidates)>1:
			raise ValueError('too many candidates for '+x+str(candidates))
		'''
		filename=candidates[0]
		target=os.path.join('static',os.path.split(filename)[1])
		if not os.path.isfile(target):
			file_msg(target)
			shutil.copyfile(filename, target)

if do_jna:
	files=[
		'/usr/share/java/jna.jar',
		'/usr/share/java/jna-platform.jar',
	]
	for x in files:
		target=os.path.join('static',os.path.split(x)[1])
		if not os.path.isfile(target):
			file_msg(target)
			shutil.copyfile(x,os.path.join('static',os.path.split(x)[1]))
