package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic

interface BaseLogIFunction : Basic {
    fun logI(s: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.logI(appContext, s, logFlag)
    fun logI(s: Any) = ir.aryanmo.utils.utils.log.logI(appContext, s)
    fun logIKeyValue(key: Any, value: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.logI(key, value, logFlag)
    fun logIKeyValue(key: Any, value: Any) = ir.aryanmo.utils.utils.log.logI(key, value)
    fun logI(map: Map<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.logI(map, logFlag)
    fun logI(map: Map<Any, Any>?) = ir.aryanmo.utils.utils.log.logI(map)
    fun logI(map: HashMap<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.logI(map, logFlag)
    fun logI(map: HashMap<Any, Any>?) = ir.aryanmo.utils.utils.log.logI(map)
    fun logI(strings: List<Any>, logFlag: String?) = ir.aryanmo.utils.utils.log.logI(strings, logFlag)
    fun logI(strings: List<Any>, logType: Int) = ir.aryanmo.utils.utils.log.logI(strings, logType)
    fun logI(strings: List<Any>) = ir.aryanmo.utils.utils.log.logI(strings)
    fun logIGson(json: String, logFlag: String?) = ir.aryanmo.utils.utils.log.logIGson(json, logFlag)
    fun logIGson(json: String) = ir.aryanmo.utils.utils.log.logIGson(json)
}
