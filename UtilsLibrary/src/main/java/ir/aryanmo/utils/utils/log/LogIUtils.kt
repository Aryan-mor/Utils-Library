package ir.aryanmo.utils.utils.log

import android.content.Context
import ir.aryanmo.utils.utils.FLAG
import java.util.HashMap


fun logI(context: Context?, logMessage: Any, logFlag: String = FLAG) = log(context,logMessage,logFlag, INFO_MODE)
fun logI(logMessage: Any, logFlag: String = FLAG) = log(logMessage, logFlag, INFO_MODE)
fun logI(key: Any, value: Any, logFlag: String = FLAG) = log(key,value,logFlag, INFO_MODE)
fun logI(map: Map<Any, Any>?, logFlag: String = FLAG) = log(map, logFlag, INFO_MODE)
fun logI(hashMap: HashMap<Any, Any>?, logFlag: String = FLAG) = log(hashMap,logFlag, INFO_MODE)
fun logI(list: List<Any>, logFlag: String = FLAG) = log(list, logFlag, INFO_MODE)
fun logIGson(json: String, logFlag: String = FLAG)= logGson(json,logFlag, INFO_MODE)
