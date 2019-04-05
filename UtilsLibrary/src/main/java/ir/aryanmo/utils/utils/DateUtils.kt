package ir.aryanmo.utils.utils

import android.util.Log
import ir.aryanmo.utils.utils.utilsClass.Date
import java.text.DateFormatSymbols

val liveTimeStamp: Long
    get() = Date().timestamp

val monthsNames: Array<String>
    get() = DateFormatSymbols().shortMonths

fun diffDay(startDate: Date, endDate: Date): Int {
    return (endDate.timeInMillis - startDate.timeInMillis).toInt() / (24 * 60 * 60 * 1000)
}

fun getMonthName(monthNum: Int): String {
    try {
        return monthsNames[monthNum - 1]
    } catch (e: Exception) {
        Log.e("UtilsLibrary", "DateUtils::getMonthName  ||  error -> ${e.message})")
        return ""
    }

}


