package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic


interface BaseLogVFunction : Basic {
    fun logV(s: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.logV(appContext, s, logFlag)
    fun logV(s: Any) = ir.aryanmo.utils.utils.log.logV(appContext, s)
    fun logVKeyValue(key: Any, value: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.logV(key, value, logFlag)
    fun logVKeyValue(key: Any, value: Any) = ir.aryanmo.utils.utils.log.logV(key, value)
    fun logV(map: Map<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.logV(map, logFlag)
    fun logV(map: Map<Any, Any>?) = ir.aryanmo.utils.utils.log.logV(map)
    fun logV(map: HashMap<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.logV(map, logFlag)
    fun logV(map: HashMap<Any, Any>?) = ir.aryanmo.utils.utils.log.logV(map)
    fun logV(strings: List<Any>, logFlag: String?) = ir.aryanmo.utils.utils.log.logV(strings, logFlag)
    fun logV(strings: List<Any>, logType: Int) = ir.aryanmo.utils.utils.log.logV(strings, logType)
    fun logV(strings: List<Any>) = ir.aryanmo.utils.utils.log.logV(strings)
    fun logVGson(json: String, logFlag: String?) = ir.aryanmo.utils.utils.log.logVGson(json, logFlag)
    fun logVGson(json: String) = ir.aryanmo.utils.utils.log.logVGson(json)
}
