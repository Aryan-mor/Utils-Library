package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG

fun logWTF(context: Context?, logMessage: Any, logFlag: String = FLAG) =
    log(context, logMessage, logFlag, LOG_WTF_MODE)

fun logWTF(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_WTF_MODE)

fun Any.logThisWTF(context: Context?, logFlag: String = FLAG) =
    this.logThis(context = context, logFlag = logFlag, logType = LOG_WTF_MODE)

fun Any.logThisWTF(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_WTF_MODE)

fun String.logWTFJson(logFlag: String = FLAG) =
    this.logJson(logFlag = logFlag, logType = LOG_WTF_MODE)

fun Map<*, *>.logThisWTF(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_WTF_MODE)

fun List<*>.logThisWTF(logFlag: String = FLAG) =
    this.logThis(logFlag = logFlag, logType = LOG_WTF_MODE)