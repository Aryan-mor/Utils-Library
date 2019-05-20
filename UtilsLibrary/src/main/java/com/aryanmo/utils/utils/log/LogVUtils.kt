package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG
import java.util.*

fun logV(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_DEBUG_MODE)

fun logV(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_DEBUG_MODE)

fun Any.logV(context: Context?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(context = context, logFlag = logFlag, logType = logType)

fun Any.logV(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)

fun String.logVJson(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logJson(logFlag = logFlag, logType = logType)

fun Map<*, *>.logV(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)

fun List<*>.logV(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)