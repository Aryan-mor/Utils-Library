package ir.aryanmo.utils.utils.utilsClass

import android.util.Log
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.TimeZone


class Date {
    private var timeZoneId: String? = null
    var timestamp: Long = 0
    private var format = "yyyy-MM-dd HH:mm"

    val timezone: TimeZone
        get() = TimeZone.getTimeZone(timeZoneId)

    val timeInMillis: Long
        get() {
            val calendar = Calendar.getInstance()
            calendar.time = java.util.Date(timestamp)
            return calendar.timeInMillis
        }

    private val date: java.util.Date
        get() = java.util.Date(timestamp)

    private val calendar: Calendar
        get() {
            val calendar = Calendar.getInstance(timezone)
            calendar.time = date
            return calendar
        }

    val dateOnly: Date
        get() = Date(toString(), "yyyy-MM-dd")

    val timeOnly: Date
        get() = Date(hour.toString() + ":" + minute + ":" + second, "HH:mm:ss")

    val year: Int
        get() = calendar.get(Calendar.YEAR)

    val month: Int
        get() = calendar.get(Calendar.MONTH) + 1

    val monthName: String
        get() {
            try {
                val cal = Calendar.getInstance()
                cal.time = java.util.Date(timestamp)
                return SimpleDateFormat("MMMM").format(cal.time)
            } catch (e: Exception) {
                logError("getMonthName", e)
                return ""
            }

        }

    val daysOfMonth: Int
        get() {
            val calendar = Calendar.getInstance()
            calendar.set(year, month - 1, 15)
            return calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        }

    val day: Int
        get() = calendar.get(Calendar.DAY_OF_MONTH)

    val dayName: String
        get() {
            try {
                val cal = Calendar.getInstance()
                cal.time = java.util.Date(timestamp)
                return SimpleDateFormat("EEEE").format(cal.time)
            } catch (e: Exception) {
                logError("getDayName", e)
                return ""
            }

        }

    val hour: Int
        get() = calendar.get(Calendar.HOUR_OF_DAY)

    val minute: Int
        get() = calendar.get(Calendar.MINUTE)

    val second: Int
        get() = calendar.get(Calendar.SECOND)

    val isDate: Boolean
        get() = year != 0 && month + 1 != 0 && day != 0

    val isTime: Boolean
        get() = hour != -1 || minute != -1

    val isDateTime: Boolean
        get() = isDate && isTime

    constructor() {
        init(java.util.Date().time, TimeZone.getDefault())
    }

    constructor(date: String) {
        init(stringToTimestamp(date, format), TimeZone.getDefault())
    }

    constructor(date: String, format: String) {
        this.format = format
        init(stringToTimestamp(date, format), TimeZone.getDefault())
    }

    constructor(date: String, format: String, timeZone: TimeZone) {
        this.format = format
        init(stringToTimestamp(date, format, timeZone), timeZone)
    }

    constructor(timestamp: Long) {
        init(timestamp, TimeZone.getDefault())
    }

    constructor(timestamp: Long, timeZone: TimeZone) {
        init(timestamp, timeZone)
    }

    constructor(timestamp: Long, format: String) {
        this.format = format
        init(timestamp, TimeZone.getDefault())
    }

    constructor(timestamp: Long, format: String, timeZone: TimeZone) {
        this.format = format
        init(timestamp, timeZone)
    }

    private fun init(timestamp: Long, timeZone: TimeZone) {
        try {
            this.timeZoneId = timeZone.id
            this.timestamp = timestamp

        } catch (e: Exception) {
            logError("Date(java.util.Date date, String format)", e)
        }

    }

    fun setTimeZone(timeZone: TimeZone) {
        setTimeZone(timeZone.id)
    }

    fun setTimeZone(timeZoneId: String) {

        val calendar = calendar
        this.timeZoneId = timeZoneId
        calendar.timeZone = timezone
        timestamp = calendar.time.time
    }

    //Functions
    override fun toString(): String {
        try {
            return format(format)
        } catch (e: Exception) {
            logError("Date::toString", e)
            return ""
        }

    }


    fun format(format: String): String {
        return format(format, getTimeZone())
    }
    
    fun getTimeZone() :TimeZone{
        return TimeZone.getTimeZone(timeZoneId)
    }

    fun format(format: String, timezone: TimeZone): String {
        return try {
            val calendar = Calendar.getInstance(timezone)
            calendar.time = date
            calendar.timeZone = timezone
            val simpleDateFormat = SimpleDateFormat(format)
            simpleDateFormat.timeZone = timezone
            simpleDateFormat.format(calendar.time)
        } catch (e: Exception) {
            logError("format(String format, TimeZone timeZone)", e)
            ""
        }

    }

    fun changeTimezone(timeZone: TimeZone): Date {
        return Date(format(getFormat(), timeZone), getFormat())
    }

    fun toDateTimeString(timeZone: TimeZone): String {
        return format(format, timeZone)
    }

    fun toUTC(): Date {
        setTimeZone(TimeZone.getTimeZone("UTC"))
        return this
    }

    fun toLocal(): Date {
        setTimeZone(TimeZone.getDefault())
        return this
    }

    private fun stringToTimestamp(date: String, dateFormat: String, timeZone: TimeZone = TimeZone.getDefault()): Long {
        try {
            val formatter = SimpleDateFormat(dateFormat)
            formatter.timeZone = timeZone
            return formatter.parse(date).time
        } catch (e: Exception) {
            logError("stringToTimestamp", e)
            return 0
        }

    }

    fun addMonth(month: Int): Date {
        val cal = Calendar.getInstance(timezone)
        cal.add(Calendar.MONTH, month)
        return Date(cal.time.time, getFormat())
    }

    fun subMonth(month: Int): Date {
        val cal = Calendar.getInstance(timezone)
        cal.add(Calendar.MONTH, month)
        return Date(cal.time.time, getFormat())
    }

    fun addWeek(week: Int): Date {
        return Date(timestamp + 86400000 * (7 * week), getFormat())
    }

    fun subWeek(week: Int): Date {
        return Date(timestamp - 86400000 * (7 * week), getFormat())
    }

    fun addDay(day: Int): Date {
        return Date(timestamp + 86400000 * day, getFormat())
    }

    fun addDay(day: Int, format: String): Date {
        return Date(timestamp + 86400000 * day, format)
    }

    fun subDay(day: Int): Date {
        return Date(timestamp - 86400000 * day, getFormat())
    }

    fun addHour(hour: Int): Date {
        return Date(timestamp + 3600000 * hour, getFormat())
    }

    fun subHour(hour: Int): Date {
        return Date(timestamp - 3600000 * hour, getFormat())
    }

    fun addMinute(minute: Int): Date {
        return Date(timestamp + 60000 * minute, getFormat())
    }

    fun subMinute(minute: Int): Date {
        return Date(timestamp - 60000 * minute, getFormat())
    }

    //Getter And Setter
    fun setFormat(format: String): Date {
        this.format = format
        return this
    }

    fun getFormat(): String {
        return format
    }

    fun hasDateTime(): Boolean {
        return isDate || isTime
    }

    private fun logError(s: String, e: Exception) {
        Log.e("UtilsLibrary","Date::$s  ||  error -> ${e.message})")

    }


    companion object {
        private var format = "yyyy-MM-dd HH:mm"

        fun fromUTC(date: String): Date {
            return Date(date, format, TimeZone.getTimeZone("UTC"))
        }

        fun fromUTC(date: String, format: String): Date {
            return Date(date, format, TimeZone.getTimeZone("UTC"))
        }

        fun fromLocal(date: String, format: String): Date {
            return Date(date, format, TimeZone.getDefault())
        }
    }


}
