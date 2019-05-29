package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG

fun logV(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_VERBOSE_MODE)

fun logV(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_VERBOSE_MODE)

fun Any.logThisV(context: Context?, logFlag: String = FLAG) =
    this.logThis(context = context, logFlag = logFlag, logType = LOG_VERBOSE_MODE)

fun Any.logThisV(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_VERBOSE_MODE)

fun String.logVJson(logFlag: String = FLAG) =
    this.logJson(logFlag = logFlag, logType = LOG_VERBOSE_MODE)

fun Map<*, *>.logThisV(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_VERBOSE_MODE)

fun List<*>.logThisV(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_VERBOSE_MODE)