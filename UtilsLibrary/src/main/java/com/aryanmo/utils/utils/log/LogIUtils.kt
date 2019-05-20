package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG
import java.util.*


fun logI(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_DEBUG_MODE)

fun logI(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_DEBUG_MODE)

fun Any.logI(context: Context?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(context = context, logFlag = logFlag, logType = logType)

fun Any.logI(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)

fun String.logIJson(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.logJson(logFlag = logFlag, logType = logType)

fun Map<*, *>.logI(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)

fun List<*>.logI(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
    this.log(logFlag = logFlag, logType = logType)