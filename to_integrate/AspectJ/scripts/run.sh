#!/bin/sh
cd bin || exit 1
# both of the next lines work but the second is better (no agent!)
#java -javaagent:../lib/aspectjweaver.jar -classpath .:../lib/aspectjrt.jar org.meta.aspectj.Main
java -classpath .:../lib/aspectjrt.jar org.meta.aspectj.Main
