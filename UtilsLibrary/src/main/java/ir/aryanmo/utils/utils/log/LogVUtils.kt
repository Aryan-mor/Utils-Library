package ir.aryanmo.utils.utils.log

import android.content.Context
import java.util.HashMap


fun logV(context: Context?, logMessage: Any, logFlag: String?) = log(context,logMessage,logFlag, VERBOSE_MODE)
fun logV(context: Context?, logMessage: Any) = log(context, logMessage, null, VERBOSE_MODE)
fun logV(logMessage: Any, logFlag: String?) = log(logMessage, logFlag, VERBOSE_MODE)
fun logV(logMessage: Any) = log(logMessage, null, VERBOSE_MODE)
fun logV(key: Any, value: Any, logFlag: String?) = log(key,value,logFlag, VERBOSE_MODE)
fun logV(key: Any, value: Any) = log(key,value, VERBOSE_MODE)
fun logV(map: Map<Any, Any>?, logFlag: String?) = log(map, logFlag, VERBOSE_MODE)
fun logV(map: Map<Any, Any>?) = log(map, null, VERBOSE_MODE)
fun logV(hashMap: HashMap<Any, Any>?, logFlag: String?) = log(hashMap,logFlag, VERBOSE_MODE)
fun logV(hashMap: HashMap<Any, Any>?) = log(hashMap, null, VERBOSE_MODE)
fun logV(list: List<Any>, logFlag: String?) = log(list, logFlag, VERBOSE_MODE)
fun logV(list: List<Any>) = log(list, null, VERBOSE_MODE)
fun logVGson(json: String, logFlag: String?)= logGson(json,logFlag, VERBOSE_MODE)
fun logVGson(json: String)= logGson(json, VERBOSE_MODE)