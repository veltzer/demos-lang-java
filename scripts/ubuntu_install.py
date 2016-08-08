#!/usr/bin/python3

'''
this script will install all the required packages that you need on
ubuntu to compile and work with this package.
'''

import subprocess # for check_call

do_oracle=True
do_templar=True

# the application -> packages that I need are:
# jvisualvm -> visualvm
# jmap -> openjdk-6-jdk
# jhat -> openjdk-6-jdk
# jconsole -> openjdk-6-jdk

packs=[
	# jdks and jres
	'openjdk-8-jre',
	'openjdk-8-jdk',
	'openjdk-8-doc',
	'openjdk-9-jre',
	'openjdk-9-jdk',
	'openjdk-9-doc',
	# default jdk, jre
	'default-jre',
	'default-jre-headless',
	'default-jdk',
	'default-jdk-doc',
	# libraries
	'libjna-java',
	# tools
	'visualvm',
	'ivy',
	'ivy-doc',
	'ant',
	'ant-doc',
	'ant-optional',
	'ant-contrib',

	# maven stuff
	'maven',

	# groovy stuff
	'groovy',
	'groovy-doc',

	# development environments
	'netbeans',
	'eclipse-cdt',
	'eclipse-emf',
	'eclipse-wtp',
	'eclipse-jdt',
	'eclipse-egit',
	'eclipse-mylyn',
	'eclipse-gef',
	'eclipse-rcp',
	'eclipse-xsd',

]

if do_templar:
	packs.extend([
		# for my make helper
		'templar',
	])

if do_oracle:
	packs.extend([
		'oracle-java6-installer',
		'oracle-java7-installer',
		'oracle-java8-installer',
	])

args=['sudo','apt-get','install','--assume-yes']
args.extend(packs)
try:
	subprocess.check_call(args)
except:
	pass
