#!/usr/bin/python3

import subprocess
import shutil # for rmtree, copyfile
import os.path # for join, split
import os # for mkdir
import glob # for glob

shutil.rmtree('static', True)
os.mkdir('static')

version='3.6.1.v20120521-2329'

subprocess.check_call(['wget','http://maven.repository.paxle.net/org/jdesktop/jdic/jdic/0.9.5/jdic-0.9.5.jar','-O','static/jdic.jar'])

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
	shutil.copyfile(filename,os.path.join('static',os.path.split(filename)[1]))

'''
files=[
	'/usr/share/java/jna.jar',
	'/usr/share/java/jna-platform.jar',
]
for x in files:
	shutil.copyfile(x,os.path.join('static',os.path.split(x)[1]))
'''
