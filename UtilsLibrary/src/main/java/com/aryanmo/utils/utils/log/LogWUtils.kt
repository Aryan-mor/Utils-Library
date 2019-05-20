package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG
import java.util.*

fun logW(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_DEBUG_MODE)

fun logW(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_DEBUG_MODE)

fun Any.logW(context: Context?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(context = context, logFlag = logFlag, logType = logType)

fun Any.logW(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)

fun String.logWJson(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logJson(logFlag = logFlag, logType = logType)

fun Map<*, *>.logW(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)

fun List<*>.logW(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)