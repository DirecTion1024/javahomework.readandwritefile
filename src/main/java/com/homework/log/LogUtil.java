package com.homework.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * LogBack封装类
 * @author tqjiang
 *
 */
public class LogUtil {
	 // loggerName
    private final static String debugLogger = "DebugLog";
    private final static String infoLogger = "InfoLog";
    private final static String warnLogger = "WarnLog";
    private final static String errorLogger = "ErrorLog";
    private final static String traceLogger="TraceLog";

    /**
     * 记录Trace日志
     * @param format
     * @param args
     */
    public static void logTrace(String format,Object...args){
    	 try
         {
             Logger logger = LoggerFactory.getLogger(traceLogger);
             logger.trace(format, args);
         }
         catch (Exception ex)
         {
         }
    }
    /**
     * 记录debug日志
     * 
     * @param format
     *            日志格式
     * @param args
     *            日志参数
     */
    public static void logDebug(String format, Object... args)
    {
        try
        {
            Logger logger = LoggerFactory.getLogger(debugLogger);
            logger.debug(format, args);
        }
        catch (Exception ex)
        {
        }
    }
    /**
     * 记录info日志
     * 
     * @param format
     *            日志格式
     * @param args
     *            日志参数
     */
    public static void logInfo(String format, Object... args)
    {
        try
        {
            Logger logger = LoggerFactory.getLogger(infoLogger);
            logger.info(format, args);
        }
        catch (Exception ex)
        {
        }
    }
    /**
     * 记录warn日志
     * 
     * @param format
     *            日志格式
     * @param args
     *            日志参数
     */
    public static void logWarn(String format, Object... args)
    {
        try
        {
            Logger logger = LoggerFactory.getLogger(warnLogger);
            logger.warn(format, args);
        }
        catch (Exception ex)
        {
        }
    }
    /**
     * 记录error日志
     * 
     * @param format
     *            日志格式
     * @param args
     *            日志参数
     */
    public static void logError(String format, Object... args)
    {
        try
        {
            Logger logger = LoggerFactory.getLogger(errorLogger);
            logger.error(format, args);
        }
        catch (Exception ex)
        {
        }
    }
}
