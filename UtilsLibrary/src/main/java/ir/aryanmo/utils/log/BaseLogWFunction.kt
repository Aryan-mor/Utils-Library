package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic


interface BaseLogWFunction : Basic {
    fun logW(s: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.logW(appContext, s, logFlag)
    fun logW(s: Any) = ir.aryanmo.utils.utils.log.logW(appContext, s)
    fun logWKeyValue(key: Any, value: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.logW(key, value, logFlag)
    fun logWKeyValue(key: Any, value: Any) = ir.aryanmo.utils.utils.log.logW(key, value)
    fun logW(map: Map<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.logW(map, logFlag)
    fun logW(map: Map<Any, Any>?) = ir.aryanmo.utils.utils.log.logW(map)
    fun logW(map: HashMap<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.logW(map, logFlag)
    fun logW(map: HashMap<Any, Any>?) = ir.aryanmo.utils.utils.log.logW(map)
    fun logW(strings: List<Any>, logFlag: String?) = ir.aryanmo.utils.utils.log.logW(strings, logFlag)
    fun logW(strings: List<Any>, logType: Int) = ir.aryanmo.utils.utils.log.logW(strings, logType)
    fun logW(strings: List<Any>) = ir.aryanmo.utils.utils.log.logW(strings)
    fun logWGson(json: String, logFlag: String?) = ir.aryanmo.utils.utils.log.logWGson(json, logFlag)
    fun logWGson(json: String) = ir.aryanmo.utils.utils.log.logWGson(json)
}
