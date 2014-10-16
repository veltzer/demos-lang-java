#!/usr/bin/python3

# this script will install all the required packages that you need on
# ubuntu to compile and work with this package.

import subprocess # for check_call

do_oracle=True

# the application -> packages that I need are:
# jvisualvm -> visualvm
# jmap -> openjdk-6-jdk
# jhat -> openjdk-6-jdk
# jconsole -> openjdk-6-jdk

packs=[
	# jdks and jres
	'openjdk-6-jre',
	'openjdk-6-jdk',
	'openjdk-6-doc',
	'openjdk-7-jre',
	'openjdk-7-jdk',
	'openjdk-7-doc',
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
	'maven2',

	# groovy stuff
	'groovy',
	'groovy-doc',
]

if do_oracle:
	packs.extend([
		'oracle-java6-installer',
		'oracle-java7-installer',
		'oracle-java8-installer',
	])

args=['sudo','apt-get','install','--assume-yes']
args.extend(packs)
subprocess.check_call(args)
