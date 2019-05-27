package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG

fun logWTF(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_DEBUG_MODE)

fun logWTF(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_DEBUG_MODE)

fun Any.logThisWTF(context: Context?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(context = context, logFlag = logFlag, logType = logType)

fun Any.logThisWTF(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)

fun String.logWTFJson(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logJson(logFlag = logFlag, logType = logType)

fun Map<*, *>.logThisWTF(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)

fun List<*>.logThisWTF(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logThis(logFlag = logFlag, logType = logType)