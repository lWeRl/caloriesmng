package org.lwerl.caloriesmng.util;

import org.lwerl.caloriesmng.util.exception.ErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;

public class LoggerWrapper {

    private Logger logger;

    public LoggerWrapper(Logger logger) {
        this.logger = logger;
    }

    public static LoggerWrapper get(Class clazz) {
        return new LoggerWrapper(LoggerFactory.getLogger(clazz));
    }

    public void debug(String msg) {
        logger.debug(msg);
    }

    public void info(String msg, Object... arguments) {
        logger.info(msg, arguments);
    }

    public void warn(String msg) {
        logger.warn(msg);
    }

    public void warn(String msg, Throwable t) {
        logger.warn(msg, t);
    }

    public void error(String msg) {
        logger.error(msg);
    }

    public void error(String msg, Throwable t) {
        logger.error(msg, t);
    }

    public boolean isDebug() {
        return logger.isDebugEnabled();
    }

    public IllegalStateException getIllegalStateException(String msg) {
        return getIllegalStateException(msg, null);
    }

    public IllegalStateException getIllegalStateException(String msg, Throwable e) {
        logger.error(msg, e);
        return new IllegalStateException(msg, e);
    }

    public IllegalArgumentException getIllegalArgumentException(String msg) {
        return getIllegalArgumentException(msg, null);
    }

    public IllegalArgumentException getIllegalArgumentException(String msg, Throwable e) {
        logger.error(msg, e);
        return new IllegalArgumentException(msg, e);
    }

    public UnsupportedOperationException getUnsupportedOperationException(String msg) {
        logger.error(msg);
        return new UnsupportedOperationException(msg);
    }

//    public ValidationException getValidationException(BindingResult result) {
//        logger.error("Validation exception");
//        return new ValidationException(result);
//    }

    public ErrorInfo getErrorInfo(CharSequence requestUrl, Exception e) {
        logger.error("Exception at request " + requestUrl, e);
        return new ErrorInfo(requestUrl, e);
    }
}
