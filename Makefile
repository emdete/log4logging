#!/usr/bin/env -S make -f
all:
	javac org/apache/logging/log4j/*.java
	jar --create --file log4logging.jar org/apache/logging/log4j/*.class

run: log4logging.jar
	MAINTAINER="M. Dietrich <mdt@emdete.de>" \
	PROJECT="log4logging" \
	VERSION="2.0" \
	ARCH="all" \
	DEPENDS="" \
	PROVIDES="liblog4j2-java" \
	make -f debian.mk

dbg: all
	./deploy.sh

