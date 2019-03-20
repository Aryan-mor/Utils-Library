package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic
import ir.aryanmo.utils.utils.log.INFO_MODE


interface BaseLogDFunction : Basic {
    fun logD(s: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.logD(appContext, s, logFlag)
    fun logD(s: Any) = ir.aryanmo.utils.utils.log.logD(appContext, s)
    fun logDKeyValue(key: Any, value: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.logD(key, value, logFlag)
    fun logDKeyValue(key: Any, value: Any) = ir.aryanmo.utils.utils.log.logD(key, value)
    fun logD(map: Map<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.logD(map, logFlag)
    fun logD(map: Map<Any, Any>?) = ir.aryanmo.utils.utils.log.logD(map)
    fun logD(map: HashMap<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.logD(map, logFlag)
    fun logD(map: HashMap<Any, Any>?) = ir.aryanmo.utils.utils.log.logD(map)
    fun logD(strings: List<Any>, logFlag: String?) = ir.aryanmo.utils.utils.log.logD(strings, logFlag)
    fun logD(strings: List<Any>, logType: Int) = ir.aryanmo.utils.utils.log.logD(strings, logType)
    fun logD(strings: List<Any>) = ir.aryanmo.utils.utils.log.logD(strings)
    fun logDGson(json: String, logFlag: String?) = ir.aryanmo.utils.utils.log.logDGson(json, logFlag)
    fun logDGson(json: String) = ir.aryanmo.utils.utils.log.logDGson(json)
}
