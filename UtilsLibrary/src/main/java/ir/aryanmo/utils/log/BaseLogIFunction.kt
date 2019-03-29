package ir.aryanmo.utils.log

import ir.aryanmo.utils.Basic
import ir.aryanmo.utils.utils.FLAG

interface BaseLogIFunction : Basic {
    fun logI(s: Any, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logI(appContext, s, logFlag)
    fun logIKeyValue(key: Any, value: Any, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logI(key, value, logFlag)
    fun logI(map: Map<Any, Any>?, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logI(map, logFlag)
    fun logI(map: HashMap<Any, Any>?, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logI(map, logFlag)
    fun logI(strings: List<Any>, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logI(strings, logFlag)
    fun logIGson(json: String, logFlag: String= FLAG) = ir.aryanmo.utils.utils.log.logIGson(json, logFlag)
}
