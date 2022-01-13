package org.apache.logging.log4j;

public class LogManager {
	static class LoggerImpl implements Logger {
		static final java.text.DateFormat DATETIMEFORMAT = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		static { DATETIMEFORMAT.setTimeZone(java.util.TimeZone.getTimeZone("GMT")); }

		String name;

		LoggerImpl(String name) {
			this.name = name;
		}
		public void _log(final Level level, final String message, final Object... params) {
			if (level.intLevel <= Level.DEBUG.intLevel) {
				java.lang.System.out.println(DATETIMEFORMAT.format(new java.util.Date()) +
					" [" + (name==null?"main":name) + "] " + level + ' ' + message);
				// TODO params
			}
		}
		public void log(final Level level, final String message) { this._log(level, message); }
		public void debug(final String message) { this._log(Level.DEBUG, message); }
		public void error(final String message) { this._log(Level.ERROR, message); }
		public void fatal(final String message) { this._log(Level.FATAL, message); }
		public void info(final String message) { this._log(Level.INFO, message); }
		public void trace(final String message) { this._log(Level.TRACE, message); }
		public void warn(final String message) { this._log(Level.WARN, message); }
		public void log(final Level level, final String message, final Object... params) { this._log(level, message, params); }
		public void debug(final String message, final Object... params) { this._log(Level.DEBUG, message, params); }
		public void error(final String message, final Object... params) { this._log(Level.ERROR, message, params); }
		public void fatal(final String message, final Object... params) { this._log(Level.FATAL, message, params); }
		public void info(final String message, final Object... params) { this._log(Level.INFO, message, params); }
		public void trace(final String message, final Object... params) { this._log(Level.TRACE, message, params); }
		public void warn(final String message, final Object... params) { this._log(Level.WARN, message, params); }
		public void warn(final String message, final Throwable throwable) {this._log(Level.WARN, message, throwable); }
		public void error(final String message, final Throwable throwable) {this._log(Level.WARN, message, throwable); }
	}
	public static Logger getRootLogger() {
		return new LoggerImpl(null);
	}
	public static Logger getLogger() {
		return new LoggerImpl(null);
	}
	public static Logger getLogger(final String name) {
		return new LoggerImpl(name);
	}
}
