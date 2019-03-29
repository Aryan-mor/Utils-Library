package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic
import ir.aryanmo.utils.utils.FLAG


interface BaseLogEFunction : Basic {
    fun logE(s: Any, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logE(appContext, s, logFlag)
    fun logEKeyValue(key: Any, value: Any, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logE(key, value, logFlag)
    fun logE(map: Map<Any, Any>?, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logE(map, logFlag)
    fun logE(map: HashMap<Any, Any>?, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logE(map, logFlag)
    fun logE(strings: List<Any>, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logE(strings, logFlag)
    fun logEGson(json: String, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logEGson(json, logFlag)
}
