package com.aryanmo.utils.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v4.content.ContextCompat
import android.text.Spanned
import android.util.TypedValue
import com.aryanmo.utils.R
import com.aryanmo.utils.utils.log.log
import com.aryanmo.utils.utils.log.logError
import java.util.regex.Pattern

private fun Context.getString(s: String, html: Boolean = false): String {
    if (true)
        return s


    var s = s
    val matcher = Pattern.compile("\\{\\{(.+)\\}\\}").matcher(s)
    while (matcher.find()) {
        val matcher2 = Pattern.compile("\\{\\{(\\w+)\\}\\}").matcher(s)
        var text = ""
        log("first")
        while (matcher2.find()) {
            if (text == "") {
                text = this.getString(this.getResId(matcher2.group(1), R.string::class.java))
                continue
            }
            text = applyFilter(text, matcher2.group())
        }
        s = matcher2.replaceFirst(text)
        log("before s -> $s")
        log("after s -> $s")
    }
    log("string -> $s")
    if (html)
        return s
    return s.toHtml().toString()
}

fun Context.getString(s: String): String {
    return this.getString(s, false)
}

fun Context.getString(@StringRes stringIdRes: Int): String {
    return try {
        val s = this.resources.getString(stringIdRes)
        getString(s)
    } catch (e: Exception) {
        logError("getString(Context context, @StringRes int stringIdRes)", e)
        "Error"
    }

}

private fun Context.getResId(resName: String, c: Class<*>): Int {
    return try {
        this.resources.getIdentifier(
            resName,
            c.name.replace(com.aryanmo.utils.R::class.java.toString().replace("class", "").trim { it <= ' ' } + "$",
                ""),
            this.packageName)
    } catch (e: Exception) {
        logError("getResId", e)
        -1
    }

}

fun Context.getStrings(divider: String, @StringRes vararg stringIdRes: Int): String {
    val s = StringBuilder(this.getString(stringIdRes[0]))
    if (stringIdRes.size >= 2) {
        for (i in 1 until stringIdRes.size) {
            s.append(divider).append(this.getString(stringIdRes[i]))
        }
    }
    return this.getStrings(s.toString())
}

fun Context.getFormattedString(@StringRes stringIdRes: Int, vararg args: Any): String {
    return this.getString(String.format(this.getString(stringIdRes), *args))
}

private fun applyFilter(s: String, filter: String): String {
    return when (filter.toLowerCase()) {
        "title", "titlecase", "title-case" -> s.toTitleCase()
        "upper", "uppercase" -> s.toUpperCase()
        "lower", "lowercase" -> s.toLowerCase()
        "b", "bold" -> "<b>$s</b>"
        "i", "italic" -> "<i>$s</i>"
        "s", "line-through" -> "<s>$s</s>"
        "u", "underline" -> "<u>$s</u>"
        "p", "paragraph" -> "<p>$s</p>"
        else -> s
    }
}

//SPANNED

fun Context.getSpanned(s: String): Spanned {
    return this.getString(s, true).toHtml()
}

fun Context.getSpanned(@StringRes stringIdRes: Int): Spanned? {
    return try {
        val s = this.resources.getString(stringIdRes)
        this.getSpanned(s)
    } catch (e: Exception) {
        logError("getString(Context context, @StringRes int stringIdRes)", e)
        null

    }
}

fun Context.getSpanneds(divider: String, @StringRes vararg stringIdRes: Int): Spanned {
    val s = StringBuilder(this.getString(stringIdRes[0]))
    if (stringIdRes.size >= 2) {
        for (i in 1 until stringIdRes.size) {
            s.append(divider).append(this.getString(stringIdRes[i]))
        }
    }
    return this.getSpanned(s.toString())
}

fun Context.getFormattedSpanned(@StringRes stringIdRes: Int, vararg args: Any): Spanned {
    return this.getSpanned(String.format(getString(stringIdRes), *args))
}

//DIMEN
fun getDimen(context: Context, @DimenRes dimenIdRes: Int): Float {
    return context.resources.getDimension(dimenIdRes)
}

//DRAWABLE
fun getDrawable(context: Context, @DrawableRes drawableResId: Int): Drawable? {
    return ContextCompat.getDrawable(context, drawableResId)
}

//COLOR
fun getColor(context: Context, @ColorRes colorIdRes: Int): Int {
    return ContextCompat.getColor(context, colorIdRes)
}

fun getColor(s: String): Int {
    return Color.parseColor(s)
}

fun getColorHex(context: Context, @ColorRes colorRes: Int): Int {
    return getColor(context, colorRes)
}

fun getColorString(context: Context, @ColorRes colorRes: Int): String {
    return getColor(context, colorRes).toString()
}

fun getThemeColor(context: Context, attributeColor: Int): Int {
    val value = TypedValue()
    context.theme.resolveAttribute(attributeColor, value, true)
    return value.data
}

fun getPrimaryColor(context: Context): Int {
    return getThemeColor(context, R.attr.colorPrimary)
}

fun getAccentColor(context: Context): Int {
    return getThemeColor(context, R.attr.colorAccent)
}

