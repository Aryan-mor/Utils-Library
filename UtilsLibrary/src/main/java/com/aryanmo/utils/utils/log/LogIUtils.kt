package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG


fun logI(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_INFO_MODE)

fun logI(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_INFO_MODE)

fun Any.logThisI(context: Context?, logFlag: String = FLAG) =
    this.logThis(context = context, logFlag = logFlag, logType = LOG_INFO_MODE)

fun Any.logThisI(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_INFO_MODE)

fun String.logIJson(logFlag: String = FLAG) =
    this.logJson(logFlag = logFlag, logType = LOG_INFO_MODE)

fun Map<*, *>.logThisI(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_INFO_MODE)

fun List<*>.logThisI(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_INFO_MODE)