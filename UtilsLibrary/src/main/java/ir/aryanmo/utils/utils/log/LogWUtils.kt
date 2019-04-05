package ir.aryanmo.utils.utils.log

import android.content.Context
import ir.aryanmo.utils.utils.FLAG
import java.util.*


fun logW(context: Context?, logMessage: Any, logFlag: String = FLAG) = log(context,logMessage,logFlag, WARN_MODE)
fun logW(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, WARN_MODE)
fun logW(key: Any, value: Any, logFlag: String = FLAG) = log(key,value,logFlag, WARN_MODE)
fun logW(map: Map<Any, Any>?, logFlag: String = FLAG) = log(map, logFlag, WARN_MODE)
fun logW(hashMap: HashMap<Any, Any>?, logFlag: String = FLAG) = log(hashMap,logFlag, WARN_MODE)
fun logW(list: List<Any>, logFlag: String = FLAG) = log(list, logFlag, WARN_MODE)
fun logWGson(json: String, logFlag: String = FLAG)= logGson(json,logFlag, WARN_MODE)
