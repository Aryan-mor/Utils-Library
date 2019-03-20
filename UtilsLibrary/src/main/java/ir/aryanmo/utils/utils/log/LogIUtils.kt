package ir.aryanmo.utils.utils.log

import android.content.Context
import java.util.HashMap


fun logI(context: Context?, logMessage: Any, logFlag: String?) = log(context,logMessage,logFlag, INFO_MODE)
fun logI(context: Context?, logMessage: Any) = log(context, logMessage, null, INFO_MODE)
fun logI(logMessage: Any, logFlag: String?) = log(logMessage, logFlag, INFO_MODE)
fun logI(logMessage: Any) = log(logMessage, null, INFO_MODE)
fun logI(key: Any, value: Any, logFlag: String?) = log(key,value,logFlag, INFO_MODE)
fun logI(key: Any, value: Any) = log(key,value, INFO_MODE)
fun logI(map: Map<Any, Any>?, logFlag: String?) = log(map, logFlag, INFO_MODE)
fun logI(map: Map<Any, Any>?) = log(map, null, INFO_MODE)
fun logI(hashMap: HashMap<Any, Any>?, logFlag: String?) = log(hashMap,logFlag, INFO_MODE)
fun logI(hashMap: HashMap<Any, Any>?) = log(hashMap, null, INFO_MODE)
fun logI(list: List<Any>, logFlag: String?) = log(list, logFlag, INFO_MODE)
fun logI(list: List<Any>) = log(list, null, INFO_MODE)
fun logIGson(json: String, logFlag: String?)= logGson(json,logFlag, INFO_MODE)
fun logIGson(json: String)= logGson(json, INFO_MODE)