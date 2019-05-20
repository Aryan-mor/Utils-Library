package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG
import java.util.*

fun logE(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_DEBUG_MODE)

fun logE(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_DEBUG_MODE)

fun Any.logE(context: Context?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(context = context, logFlag = logFlag, logType = logType)

fun Any.logE(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)

fun String.logEJson(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logJson(logFlag = logFlag, logType = logType)

fun Map<*, *>.logE(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)

fun List<*>.logE(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)
