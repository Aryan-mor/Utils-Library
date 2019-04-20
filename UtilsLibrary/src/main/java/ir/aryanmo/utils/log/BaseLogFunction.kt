package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic
import ir.aryanmo.utils.utils.FLAG
import ir.aryanmo.utils.utils.log.DEFAULT_LOG_MODE


interface BaseLogFunction : Basic, BaseLogDFunction, BaseLogEFunction, BaseLogIFunction, BaseLogVFunction,
    BaseLogWFunction, BaseLogWTFFunction {

    fun log(s: Any, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
        ir.aryanmo.utils.utils.log.log(appContext, s, logFlag, logType)

    fun logKeyValue(key: Any, value: Any, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
        ir.aryanmo.utils.utils.log.log(key, value, logFlag, logType)

    fun log(map: Map<Any, Any>?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
        ir.aryanmo.utils.utils.log.log(map, logFlag, logType)

    fun log(map: HashMap<Any, Any>?, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
        ir.aryanmo.utils.utils.log.log(map, logFlag, logType)

    fun log(strings: List<Any>, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
        ir.aryanmo.utils.utils.log.log(strings, logFlag, logType)

    fun logGson(json: String, logFlag: String = FLAG, logType: Int = DEFAULT_LOG_MODE) =
        ir.aryanmo.utils.utils.log.logGson(json, logFlag, logType)

    fun logError(title: String, message: String = "error message null", logFlag: String = FLAG) =
        ir.aryanmo.utils.utils.log.logError("$TAG::$title", message, logFlag)

    fun logError(title: String, e: Exception, logFlag: String = FLAG) =
        ir.aryanmo.utils.utils.log.logError("$TAG::$title", e, logFlag)

    fun logError(title: String, e: Throwable?, logFlag: String = FLAG) =
        ir.aryanmo.utils.utils.log.logError("$TAG::$title", e, logFlag)


    fun logNullPointerExceptionError(title: String, message: String = "error message null", logFlag: String = FLAG) =
        ir.aryanmo.utils.utils.log.logNullPointerExceptionError("$TAG::$title", message, FLAG)

    fun logNullPointerExceptionError(title: String, e: Exception, logFlag: String = FLAG) =
        ir.aryanmo.utils.utils.log.logNullPointerExceptionError("$TAG::$title", e, logFlag)

}
