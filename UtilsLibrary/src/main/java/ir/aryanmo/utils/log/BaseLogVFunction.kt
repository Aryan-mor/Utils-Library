package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic
import ir.aryanmo.utils.utils.FLAG


interface BaseLogVFunction : Basic {
    fun logV(s: Any, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logV(appContext, s, logFlag)
    fun logVKeyValue(key: Any, value: Any, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logV(key, value, logFlag)
    fun logV(map: Map<Any, Any>?, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logV(map, logFlag)
    fun logV(map: HashMap<Any, Any>?, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logV(map, logFlag)
    fun logV(strings: List<Any>, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logV(strings, logFlag)
    fun logVGson(json: String, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logVGson(json, logFlag)
}
