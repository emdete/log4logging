#!/usr/bin/env -S make -f
all:
	javac org/apache/logging/log4j/*.java
	jar --create --file log4logging.jar org/apache/logging/log4j/*.class

run:

dbg: all
	./deploy.sh

