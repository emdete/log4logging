package org.apache.logging.log4j;
public class LogManager {
	static class LoggerImpl implements Logger {
		static final java.text.DateFormat DATETIMEFORMAT = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		static { DATETIMEFORMAT.setTimeZone(java.util.TimeZone.getTimeZone("GMT")); }

		String name;

		LoggerImpl(String name) {
			this.name = name;
		}
		public void _log(Level level, String message, Object... params) {
			java.lang.System.out.println(DATETIMEFORMAT.format(new java.util.Date()) +
					' ' + level +
					' ' + name==null?"":name +
					' ' + message); }
		public void log(Level level, String message) { this._log(level, message); }
		public void debug(String message) { this._log(Level.DEBUG, message); }
		public void error(String message) { this._log(Level.ERROR, message); }
		public void fatal(String message) { this._log(Level.FATAL, message); }
		public void info(String message) { this._log(Level.INFO, message); }
		public void trace(String message) { this._log(Level.TRACE, message); }
		public void warn(String message) { this._log(Level.WARN, message); }
		public void log(Level level, String message, Object... params) { this._log(level, message, params); }
		public void debug(String message, Object... params) { this._log(Level.DEBUG, message, params); }
		public void error(String message, Object... params) { this._log(Level.ERROR, message, params); }
		public void fatal(String message, Object... params) { this._log(Level.FATAL, message, params); }
		public void info(String message, Object... params) { this._log(Level.INFO, message, params); }
		public void trace(String message, Object... params) { this._log(Level.TRACE, message, params); }
		public void warn(String message, Object... params) { this._log(Level.WARN, message, params); }
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
