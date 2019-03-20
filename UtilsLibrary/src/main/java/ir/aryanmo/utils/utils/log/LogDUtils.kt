package ir.aryanmo.utils.utils.log

import android.content.Context
import java.util.HashMap


fun logD(context: Context?, logMessage: Any, logFlag: String?) = log(context,logMessage,logFlag, DEBUG_MODE)
fun logD(context: Context?, logMessage: Any) = log(context, logMessage, null, DEBUG_MODE)
fun logD(logMessage: Any, logFlag: String?) = log(logMessage, logFlag, DEBUG_MODE)
fun logD(logMessage: Any) = log(logMessage, null, DEBUG_MODE)
fun logD(key: Any, value: Any, logFlag: String?) = log(key,value,logFlag, DEBUG_MODE)
fun logD(key: Any, value: Any) = log(key,value, DEBUG_MODE)
fun logD(map: Map<Any, Any>?, logFlag: String?) = log(map, logFlag, DEBUG_MODE)
fun logD(map: Map<Any, Any>?) = log(map, null, DEBUG_MODE)
fun logD(hashMap: HashMap<Any, Any>?, logFlag: String?) = log(hashMap,logFlag, DEBUG_MODE)
fun logD(hashMap: HashMap<Any, Any>?) = log(hashMap, null, DEBUG_MODE)
fun logD(list: List<Any>, logFlag: String?) = log(list, logFlag, DEBUG_MODE)
fun logD(list: List<Any>) = log(list, null, DEBUG_MODE)
fun logDGson(json: String, logFlag: String?)= logGson(json,logFlag, DEBUG_MODE)
fun logDGson(json: String)= logGson(json, DEBUG_MODE)