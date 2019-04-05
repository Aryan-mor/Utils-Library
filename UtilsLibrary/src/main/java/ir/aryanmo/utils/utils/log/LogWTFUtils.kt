package ir.aryanmo.utils.utils.log

import android.content.Context
import ir.aryanmo.utils.utils.FLAG
import java.util.*


fun logWTF(context: Context?, logMessage: Any, logFlag: String = FLAG) = log(context,logMessage,logFlag, WTF_MODE)
fun logWTF(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, WTF_MODE)
fun logWTF(key: Any, value: Any, logFlag: String = FLAG) = log(key,value,logFlag, WTF_MODE)
fun logWTF(map: Map<Any, Any>?, logFlag: String = FLAG) = log(map, logFlag, WTF_MODE)
fun logWTF(hashMap: HashMap<Any, Any>?, logFlag: String = FLAG) = log(hashMap,logFlag, WTF_MODE)
fun logWTF(list: List<Any>, logFlag: String = FLAG) = log(list, logFlag, WTF_MODE)
fun logWTFGson(json: String, logFlag: String = FLAG)= logGson(json,logFlag, WTF_MODE)
