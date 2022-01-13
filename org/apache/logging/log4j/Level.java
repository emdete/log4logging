package org.apache.logging.log4j;

public enum Level {
	OFF(0),
	FATAL(100),
	ERROR(200),
	WARN(300),
	INFO(400),
	DEBUG(500),
	TRACE(600),
	ALL(Integer.MAX_VALUE);

	final int intLevel;

	Level(final int val) {
		intLevel = val;
	}
}
