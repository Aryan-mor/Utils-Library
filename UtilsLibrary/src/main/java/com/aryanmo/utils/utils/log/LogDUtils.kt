package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG


fun logD(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_DEBUG_MODE)

fun logD(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_DEBUG_MODE)

fun Any.logD(context: Context?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(context = context, logFlag = logFlag, logType = logType)

fun Any.logD(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)

fun String.logDJson(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logJson(logFlag = logFlag, logType = logType)

fun Map<*, *>.logD(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)

fun List<*>.logD(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)
