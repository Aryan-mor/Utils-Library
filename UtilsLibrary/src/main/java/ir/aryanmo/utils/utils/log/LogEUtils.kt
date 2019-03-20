package ir.aryanmo.utils.utils.log

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import ir.aryanmo.utils.utils.FLAG
import ir.aryanmo.utils.utils.getString
import java.util.HashMap

fun logE(context: Context?, logMessage: Any, logFlag: String?) = log(context,logMessage,logFlag, ERROR_MODE)
fun logE(context: Context?, logMessage: Any) = log(context, logMessage, null, ERROR_MODE)
fun logE(logMessage: Any, logFlag: String?) = log(logMessage, logFlag, ERROR_MODE)
fun logE(logMessage: Any) = log(logMessage, null, ERROR_MODE)
fun logE(key: Any, value: Any, logFlag: String?) = log(key,value,logFlag, ERROR_MODE)
fun logE(key: Any, value: Any) = log(key,value, ERROR_MODE)
fun logE(map: Map<Any, Any>?, logFlag: String?) = log(map, logFlag, ERROR_MODE)
fun logE(map: Map<Any, Any>?) = log(map, null, ERROR_MODE)
fun logE(hashMap: HashMap<Any, Any>?, logFlag: String?) = log(hashMap,logFlag, ERROR_MODE)
fun logE(hashMap: HashMap<Any, Any>?) = log(hashMap, null, ERROR_MODE)
fun logE(list: List<Any>, logFlag: String?) = log(list, logFlag, ERROR_MODE)
fun logE(list: List<Any>) = log(list, null, ERROR_MODE)
fun logEGson(json: String, logFlag: String?)= logGson(json,logFlag, ERROR_MODE)
fun logEGson(json: String)= logGson(json, ERROR_MODE)