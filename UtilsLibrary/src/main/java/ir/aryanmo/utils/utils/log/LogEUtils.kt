package ir.aryanmo.utils.utils.log

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import ir.aryanmo.utils.utils.FLAG
import ir.aryanmo.utils.utils.getString
import java.util.HashMap

fun logE(context: Context?, logMessage: Any, logFlag: String = FLAG) = log(context,logMessage,logFlag, ERROR_MODE)
fun logE(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, ERROR_MODE)
fun logE(key: Any, value: Any, logFlag: String = FLAG) = log(key,value,logFlag, ERROR_MODE)
fun logE(map: Map<Any, Any>?, logFlag: String = FLAG) = log(map, logFlag, ERROR_MODE)
fun logE(hashMap: HashMap<Any, Any>?, logFlag: String = FLAG) = log(hashMap,logFlag, ERROR_MODE)
fun logE(list: List<Any>, logFlag: String = FLAG) = log(list, logFlag, ERROR_MODE)
fun logEGson(json: String, logFlag: String = FLAG)= logGson(json,logFlag, ERROR_MODE)
