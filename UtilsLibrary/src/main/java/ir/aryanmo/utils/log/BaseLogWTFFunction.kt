package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic
import ir.aryanmo.utils.utils.FLAG


interface BaseLogWTFFunction : Basic {
    fun logWTF(s: Any, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logWTF(appContext, s, logFlag)
    fun logWTFKeyValue(key: Any, value: Any, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logWTF(key, value, logFlag)
    fun logWTF(map: Map<Any, Any>?, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logWTF(map, logFlag)
    fun logWTF(map: HashMap<Any, Any>?, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logWTF(map, logFlag)
    fun logWTF(strings: List<Any>, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logWTF(strings, logFlag)
    fun logWTFGson(json: String, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logWTFGson(json, logFlag)
}
