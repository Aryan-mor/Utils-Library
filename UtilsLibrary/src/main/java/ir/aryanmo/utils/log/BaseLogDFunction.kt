package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic
import ir.aryanmo.utils.utils.FLAG


interface BaseLogDFunction : Basic {
    fun logD(s: Any, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logD(appContext, s, logFlag)
    fun logDKeyValue(key: Any, value: Any, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logD(key, value, logFlag)
    fun logD(map: Map<Any, Any>?, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logD(map, logFlag)
    fun logD(map: HashMap<Any, Any>?, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logD(map, logFlag)
    fun logD(strings: List<Any>, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logD(strings, logFlag)
    fun logDGson(json: String, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logDGson(json, logFlag)
}
