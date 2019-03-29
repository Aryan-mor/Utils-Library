package ir.aryanmo.utils.utils.log

import android.content.Context
import ir.aryanmo.utils.utils.FLAG
import java.util.HashMap


fun logV(context: Context?, logMessage: Any, logFlag: String = FLAG) = log(context,logMessage,logFlag, VERBOSE_MODE)
fun logV(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, VERBOSE_MODE)
fun logV(key: Any, value: Any, logFlag: String = FLAG) = log(key,value,logFlag, VERBOSE_MODE)
fun logV(map: Map<Any, Any>?, logFlag: String = FLAG) = log(map, logFlag, VERBOSE_MODE)
fun logV(hashMap: HashMap<Any, Any>?, logFlag: String = FLAG) = log(hashMap,logFlag, VERBOSE_MODE)
fun logV(list: List<Any>, logFlag: String = FLAG) = log(list, logFlag, VERBOSE_MODE)
fun logVGson(json: String, logFlag: String = FLAG)= logGson(json,logFlag, VERBOSE_MODE)
