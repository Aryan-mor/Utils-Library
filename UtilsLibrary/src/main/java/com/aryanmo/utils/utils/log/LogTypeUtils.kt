package com.aryanmo.utils.utils.log

import android.content.Context
import com.aryanmo.utils.utils.FLAG
import com.aryanmo.utils.utils.hydrate

fun Any.log(context: Context?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) {
    log(context = context, logMessage = this, logFlag = logFlag, logType = logType)
}

fun Any.log(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) {
    this.log(null, logFlag = logFlag, logType = logType)
}

fun String.logJson(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) {
    this.hydrate(HashMap<Any, Any>()::class.java)?.log(logFlag = logFlag, logType = logType)
}

fun Map<*, *>.log(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) {
    this.forEach {
        log(logMessage = "key -> ${it.key}   |   value -> ${it.value}", logFlag = logFlag, logType = logType)
    }
}

fun List<*>.log(logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) {
    var index = 0
    this.forEach {
        log(logMessage = "index -> ${index++}   |   item -> $it", logFlag = logFlag, logType = logType)
    }
}