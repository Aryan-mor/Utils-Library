package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic


interface BaseLogEFunction : Basic {
    fun logE(s: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.logE(appContext, s, logFlag)
    fun logE(s: Any) = ir.aryanmo.utils.utils.log.logE(appContext, s)
    fun logEKeyValue(key: Any, value: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.logE(key, value, logFlag)
    fun logEKeyValue(key: Any, value: Any) = ir.aryanmo.utils.utils.log.logE(key, value)
    fun logE(map: Map<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.logE(map, logFlag)
    fun logE(map: Map<Any, Any>?) = ir.aryanmo.utils.utils.log.logE(map)
    fun logE(map: HashMap<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.logE(map, logFlag)
    fun logE(map: HashMap<Any, Any>?) = ir.aryanmo.utils.utils.log.logE(map)
    fun logE(strings: List<Any>, logFlag: String?) = ir.aryanmo.utils.utils.log.logE(strings, logFlag)
    fun logE(strings: List<Any>, logType: Int) = ir.aryanmo.utils.utils.log.logE(strings, logType)
    fun logE(strings: List<Any>) = ir.aryanmo.utils.utils.log.logE(strings)
    fun logEGson(json: String, logFlag: String?) = ir.aryanmo.utils.utils.log.logEGson(json, logFlag)
    fun logEGson(json: String) = ir.aryanmo.utils.utils.log.logEGson(json)
}
