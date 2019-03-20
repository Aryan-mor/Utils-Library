package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic


interface BaseLogWTFFunction : Basic {
    fun logWTF(s: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.logWTF(appContext, s, logFlag)
    fun logWTF(s: Any) = ir.aryanmo.utils.utils.log.logWTF(appContext, s)
    fun logWTFKeyValue(key: Any, value: Any, logFlag: String?) = ir.aryanmo.utils.utils.log.logWTF(key, value, logFlag)
    fun logWTFKeyValue(key: Any, value: Any) = ir.aryanmo.utils.utils.log.logWTF(key, value)
    fun logWTF(map: Map<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.logWTF(map, logFlag)
    fun logWTF(map: Map<Any, Any>?) = ir.aryanmo.utils.utils.log.logWTF(map)
    fun logWTF(map: HashMap<Any, Any>?, logFlag: String?) = ir.aryanmo.utils.utils.log.logWTF(map, logFlag)
    fun logWTF(map: HashMap<Any, Any>?) = ir.aryanmo.utils.utils.log.logWTF(map)
    fun logWTF(strings: List<Any>, logFlag: String?) = ir.aryanmo.utils.utils.log.logWTF(strings, logFlag)
    fun logWTF(strings: List<Any>, logType: Int) = ir.aryanmo.utils.utils.log.logWTF(strings, logType)
    fun logWTF(strings: List<Any>) = ir.aryanmo.utils.utils.log.logWTF(strings)
    fun logWTFGson(json: String, logFlag: String?) = ir.aryanmo.utils.utils.log.logWTFGson(json, logFlag)
    fun logWTFGson(json: String) = ir.aryanmo.utils.utils.log.logWTFGson(json)
}
