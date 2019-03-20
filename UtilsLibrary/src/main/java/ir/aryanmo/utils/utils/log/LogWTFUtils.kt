package ir.aryanmo.utils.utils.log

import android.content.Context
import java.util.HashMap


fun logWTF(context: Context?, logMessage: Any, logFlag: String?) = log(context,logMessage,logFlag, WTF_MODE)
fun logWTF(context: Context?, logMessage: Any) = log(context, logMessage, null, WTF_MODE)
fun logWTF(logMessage: Any, logFlag: String?) = log(logMessage, logFlag, WTF_MODE)
fun logWTF(logMessage: Any) = log(logMessage, null, WTF_MODE)
fun logWTF(key: Any, value: Any, logFlag: String?) = log(key,value,logFlag, WTF_MODE)
fun logWTF(key: Any, value: Any) = log(key,value, WTF_MODE)
fun logWTF(map: Map<Any, Any>?, logFlag: String?) = log(map, logFlag, WTF_MODE)
fun logWTF(map: Map<Any, Any>?) = log(map, null, WTF_MODE)
fun logWTF(hashMap: HashMap<Any, Any>?, logFlag: String?) = log(hashMap,logFlag, WTF_MODE)
fun logWTF(hashMap: HashMap<Any, Any>?) = log(hashMap, null, WTF_MODE)
fun logWTF(list: List<Any>, logFlag: String?) = log(list, logFlag, WTF_MODE)
fun logWTF(list: List<Any>) = log(list, null, WTF_MODE)
fun logWTFGson(json: String, logFlag: String?)= logGson(json,logFlag, WTF_MODE)
fun logWTFGson(json: String)= logGson(json, WTF_MODE)