package ir.aryanmo.utils.utils.log

import android.content.Context
import ir.aryanmo.utils.utils.FLAG
import java.util.*


fun logWTF(context: Context?, logMessage: Any, logFlag: String = FLAG) = log(context,logMessage,logFlag, LOG_WTF_MODE)
fun logWTF(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, LOG_WTF_MODE)
fun logWTF(key: Any, value: Any, logFlag: String = FLAG) = log(key,value,logFlag, LOG_WTF_MODE)
fun logWTF(map: Map<Any, Any>?, logFlag: String = FLAG) = log(map, logFlag, LOG_WTF_MODE)
fun logWTF(hashMap: HashMap<Any, Any>?, logFlag: String = FLAG) = log(hashMap,logFlag, LOG_WTF_MODE)
fun logWTF(list: List<Any>, logFlag: String = FLAG) = log(list, logFlag, LOG_WTF_MODE)
fun logWTFGson(json: String, logFlag: String = FLAG)= logGson(json,logFlag, LOG_WTF_MODE)
