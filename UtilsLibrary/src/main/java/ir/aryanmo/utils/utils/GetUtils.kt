package ir.aryanmo.utils.utils

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

import java.util.regex.Pattern

import ir.aryanmo.utils.R
import ir.aryanmo.utils.utils.log.logError

private fun getString(context: Context, s: String, html: Boolean): String {
        var s = s
        val matcher = Pattern.compile("\\{\\{(.+)\\}\\}").matcher(s)
        while (matcher.find()) {
            val matcher2 = Pattern.compile("\\w+").matcher(matcher.group(1))
            var text = ""
            while (matcher2.find()) {
                if (text == "") {
                    text = getString(context, getResId(context, matcher2.group(), R.string::class.java))
                    continue
                }
                text = applyFilter(text, matcher2.group())
            }
            s = matcher.replaceFirst(text)
        }
        if (html)
            return s
        return getHtml(s).toString()
    }

    fun getString(context: Context, s: String): String {
        return getString(context, s, false)
    }

    fun getString(context: Context, @StringRes stringIdRes: Int): String {
        return try {
            val s = getResources(context).getString(stringIdRes)
            getString(context, s)
        } catch (e: Exception) {
            logError("getString(Context context, @StringRes int stringIdRes)", e)
            "Error"
        }

    }

    private fun getResId(context: Context, resName: String, c: Class<*>): Int {
        return try {
            context.resources.getIdentifier(resName, c.name.replace(ir.aryanmo.utils.R::class.java.toString().replace("class", "").trim { it <= ' ' } + "$", ""), context.packageName)
        } catch (e: Exception) {
            logError("getResId", e)
            -1
        }

    }

    fun getStrings(context: Context, divider: String, @StringRes vararg stringIdRes: Int): String {
        val s = StringBuilder(getString(context, stringIdRes[0]))
        if (stringIdRes.size >= 2) {
            for (i in 1 until stringIdRes.size) {
                s.append(divider).append(getString(context, stringIdRes[i]))
            }
        }
        return getStrings(context, s.toString())
    }

    fun getFormattedString(context: Context, @StringRes stringIdRes: Int, vararg args: Any): String {
        return getString(context, String.format(getString(context, stringIdRes), *args))
    }

    private fun applyFilter(s: String, filter: String): String {
        return when (filter.toLowerCase()) {
            "title", "titlecase", "title-case" -> toTitleCase(s)
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

    fun getSpanned(context: Context, s: String): Spanned {
        return getHtml(getString(context, s, true))
    }

    fun getSpanned(context: Context, @StringRes stringIdRes: Int): Spanned? {
        return try {
            val s = getResources(context).getString(stringIdRes)
            getSpanned(context, s)
        } catch (e: Exception) {
            logError("getString(Context context, @StringRes int stringIdRes)", e)
            null

        }
    }

    fun getSpanneds(context: Context, divider: String, @StringRes vararg stringIdRes: Int): Spanned {
        val s = StringBuilder(getString(context, stringIdRes[0]))
        if (stringIdRes.size >= 2) {
            for (i in 1 until stringIdRes.size) {
                s.append(divider).append(getString(context, stringIdRes[i]))
            }
        }
        return getSpanned(context, s.toString())
    }

    fun getFormattedSpanned(context: Context, @StringRes stringIdRes: Int, vararg args: Any): Spanned {
        return getSpanned(context, String.format(getString(context, stringIdRes), *args))
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

