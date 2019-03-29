package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic
import ir.aryanmo.utils.utils.FLAG


interface BaseLogWFunction : Basic {
    fun logW(s: Any, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logW(appContext, s, logFlag)
    fun logWKeyValue(key: Any, value: Any, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logW(key, value, logFlag)
    fun logW(map: Map<Any, Any>?, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logW(map, logFlag)
    fun logW(map: HashMap<Any, Any>?, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logW(map, logFlag)
    fun logW(strings: List<Any>, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logW(strings, logFlag)
    fun logWGson(json: String, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logWGson(json, logFlag)
}
