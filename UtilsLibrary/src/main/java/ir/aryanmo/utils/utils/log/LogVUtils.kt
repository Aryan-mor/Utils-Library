package ir.aryanmo.utils.utils.log

import android.content.Context
import ir.aryanmo.utils.utils.FLAG
import java.util.*


fun logV(context: Context?, logMessage: Any, logFlag: String = FLAG) = log(context,logMessage,logFlag, LOG_VERBOSE_MODE)
fun logV(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_VERBOSE_MODE)
fun logV(key: Any, value: Any, logFlag: String = FLAG) = log(key,value,logFlag, LOG_VERBOSE_MODE)
fun logV(map: Map<Any, Any>?, logFlag: String = FLAG) = log(map, logFlag, LOG_VERBOSE_MODE)
fun logV(hashMap: HashMap<Any, Any>?, logFlag: String = FLAG) = log(hashMap,logFlag, LOG_VERBOSE_MODE)
fun logV(list: List<Any>, logFlag: String = FLAG) = log(list, logFlag, LOG_VERBOSE_MODE)
fun logVGson(json: String, logFlag: String = FLAG)= logGson(json,logFlag, LOG_VERBOSE_MODE)
