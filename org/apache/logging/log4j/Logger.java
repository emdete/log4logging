package org.apache.logging.log4j;

public interface Logger {
	void log(Level level, String message);
	void debug(String message);
	void error(String message);
	void fatal(String message);
	void info(String message);
	void trace(String message);
	void warn(String message);
	void log(Level level, String message, Object... params);
	void debug(String message, Object... params);
	void error(String message, Object... params);
	void fatal(String message, Object... params);
	void info(String message, Object... params);
	void trace(String message, Object... params);
	void warn(String message, Object... params);
}
