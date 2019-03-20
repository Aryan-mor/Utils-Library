package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic
import ir.aryanmo.utils.utils.log.INFO_MODE


interface BaseLogFunction : Basic, BaseLogDFunction, BaseLogEFunction, BaseLogIFunction, BaseLogVFunction, BaseLogWFunction, BaseLogWTFFunction {

    fun log(s: Any, logFlag: String?, logType: Int) = ir.aryanmo.utils.utils.log.log(appContext, s, logFlag, logType)

    fun log(s: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.log(appContext, s, logFlag)

    fun log(s: Any, logType: Int) = ir.aryanmo.utils.utils.log.log(appContext, s, logType)

    fun log(s: Any) = ir.aryanmo.utils.utils.log.log(appContext, s)

    fun logKeyValue(key: Any, value: Any, logFlag: String?, logType: Int) = ir.aryanmo.utils.utils.log.log(key, value, logFlag, logType)

    fun logKeyValue(key: Any, value: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.log(key, value, logFlag)

    fun logKeyValue(key: Any, value: Any, logType: Int) = ir.aryanmo.utils.utils.log.log(key, value, logType)

    fun logKeyValue(key: Any, value: Any) = ir.aryanmo.utils.utils.log.log(key, value)

    fun log(map: Map<Any, Any>?, logFlag: String?, logType: Int) = ir.aryanmo.utils.utils.log.log(map, logFlag, logType)

    fun log(map: Map<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.log(map, logFlag)

    fun log(map: Map<Any, Any>?, logType: Int) = ir.aryanmo.utils.utils.log.log(map, logType)

    fun log(map: Map<Any, Any>?) = ir.aryanmo.utils.utils.log.log(map)

    fun log(map: HashMap<Any, Any>?, logFlag: String?, logType: Int) = ir.aryanmo.utils.utils.log.log(map, logFlag, logType)

    fun log(map: HashMap<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.log(map, logFlag)

    fun log(map: HashMap<Any, Any>?, logType: Int) = ir.aryanmo.utils.utils.log.log(map, logType)

    fun log(map: HashMap<Any, Any>?) = ir.aryanmo.utils.utils.log.log(map)

    fun log(strings: List<Any>, logFlag: String?, logType: Int) = ir.aryanmo.utils.utils.log.log(strings, logFlag, logType)

    fun log(strings: List<Any>, logFlag: String?) = ir.aryanmo.utils.utils.log.log(strings, logFlag)

    fun log(strings: List<Any>, logType: Int) = ir.aryanmo.utils.utils.log.log(strings, logType)

    fun log(strings: List<Any>) = ir.aryanmo.utils.utils.log.log(strings)

    fun logGson(json: String, logFlag: String?, logType: Int) = ir.aryanmo.utils.utils.log.logGson(json, logFlag, logType)

    fun logGson(json: String, logFlag: String?) = ir.aryanmo.utils.utils.log.logGson(json, logFlag)

    fun logGson(json: String, logType: Int) = ir.aryanmo.utils.utils.log.logGson(json, logType)

    fun logGson(json: String) = ir.aryanmo.utils.utils.log.logGson(json)

    fun logError(title: String, e: Exception, logFlag: String?) = ir.aryanmo.utils.utils.log.logError("$activityName::$title", e, logFlag)

    fun logError(title: String, e: Exception) = logError(title, e, null)

    fun logInfo(message: Any) = log(message, INFO_MODE)

    fun logInfo(message: Any, logFlag: String) = log(message, logFlag)
}
