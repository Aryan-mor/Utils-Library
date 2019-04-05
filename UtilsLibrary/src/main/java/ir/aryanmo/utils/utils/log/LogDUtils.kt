package ir.aryanmo.utils.utils.log

import android.content.Context
import ir.aryanmo.utils.utils.FLAG
import java.util.*


fun logD(context: Context?, logMessage: Any, logFlag: String = FLAG) = log(context,logMessage,logFlag, DEBUG_MODE)
fun logD(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, DEBUG_MODE)
fun logD(key: Any, value: Any, logFlag: String = FLAG) = log(key,value,logFlag, DEBUG_MODE)
fun logD(map: Map<Any, Any>?, logFlag: String = FLAG) = log(map, logFlag, DEBUG_MODE)
fun logD(hashMap: HashMap<Any, Any>?, logFlag: String = FLAG) = log(hashMap,logFlag, DEBUG_MODE)
fun logD(list: List<Any>, logFlag: String = FLAG) = log(list, logFlag, DEBUG_MODE)
fun logDGson(json: String, logFlag: String=FLAG)= logGson(json,logFlag, DEBUG_MODE)
