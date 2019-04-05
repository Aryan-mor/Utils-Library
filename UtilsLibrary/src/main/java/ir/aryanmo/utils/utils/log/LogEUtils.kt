package ir.aryanmo.utils.utils.log

import android.content.Context
import ir.aryanmo.utils.utils.FLAG
import java.util.*

fun logE(context: Context?, logMessage: Any, logFlag: String = FLAG) = log(context,logMessage,logFlag, LOG_ERROR_MODE)
fun logE(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_ERROR_MODE)
fun logE(key: Any, value: Any, logFlag: String = FLAG) = log(key,value,logFlag, LOG_ERROR_MODE)
fun logE(map: Map<Any, Any>?, logFlag: String = FLAG) = log(map, logFlag, LOG_ERROR_MODE)
fun logE(hashMap: HashMap<Any, Any>?, logFlag: String = FLAG) = log(hashMap,logFlag, LOG_ERROR_MODE)
fun logE(list: List<Any>, logFlag: String = FLAG) = log(list, logFlag, LOG_ERROR_MODE)
fun logEGson(json: String, logFlag: String = FLAG)= logGson(json,logFlag, LOG_ERROR_MODE)
