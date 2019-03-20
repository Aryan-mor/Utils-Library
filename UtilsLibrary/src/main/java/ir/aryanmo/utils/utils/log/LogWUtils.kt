package ir.aryanmo.utils.utils.log

import android.content.Context
import java.util.HashMap


fun logW(context: Context?, logMessage: Any, logFlag: String?) = log(context,logMessage,logFlag, WARN_MODE)
fun logW(context: Context?, logMessage: Any) = log(context, logMessage, null, WARN_MODE)
fun logW(logMessage: Any, logFlag: String?) = log(logMessage, logFlag, WARN_MODE)
fun logW(logMessage: Any) = log(logMessage, null, WARN_MODE)
fun logW(key: Any, value: Any, logFlag: String?) = log(key,value,logFlag, WARN_MODE)
fun logW(key: Any, value: Any) = log(key,value, WARN_MODE)
fun logW(map: Map<Any, Any>?, logFlag: String?) = log(map, logFlag, WARN_MODE)
fun logW(map: Map<Any, Any>?) = log(map, null, WARN_MODE)
fun logW(hashMap: HashMap<Any, Any>?, logFlag: String?) = log(hashMap,logFlag, WARN_MODE)
fun logW(hashMap: HashMap<Any, Any>?) = log(hashMap, null, WARN_MODE)
fun logW(list: List<Any>, logFlag: String?) = log(list, logFlag, WARN_MODE)
fun logW(list: List<Any>) = log(list, null, WARN_MODE)
fun logWGson(json: String, logFlag: String?)= logGson(json,logFlag, WARN_MODE)
fun logWGson(json: String)= logGson(json, WARN_MODE)