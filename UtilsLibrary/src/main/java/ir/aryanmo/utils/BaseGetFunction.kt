package ir.aryanmo.utils

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.text.Html
import android.text.Spanned

interface BaseGetFunction : Basic {
    //STRING

    fun gString(s: String): String {
        return ir.aryanmo.utils.utils.getString(appContext!!, s)
    }

    fun gString(@StringRes stringIdRes: Int): String {
        return ir.aryanmo.utils.utils.getString(appContext!!, stringIdRes)
    }

    fun gStrings(divider: String, @StringRes vararg stringIdRes: Int): String {
        return ir.aryanmo.utils.utils.getStrings(appContext!!, divider, *stringIdRes)
    }


    fun getFormattedString(@StringRes stringIdRes: Int, vararg args: Any): String {
        return ir.aryanmo.utils.utils.getFormattedString(appContext!!, stringIdRes, *args)
    }


    //SPANNED

    fun getSpanned(context: Context, s: String): Spanned {
        return ir.aryanmo.utils.utils.getSpanned(context,s)
    }

    fun getSpanned(context: Context, @StringRes stringIdRes: Int): Spanned? {
        return ir.aryanmo.utils.utils.getSpanned(context,stringIdRes)
    }

    fun getSpanneds(context: Context, divider: String, @StringRes vararg stringIdRes: Int): Spanned {
        return ir.aryanmo.utils.utils.getSpanneds(context,divider,*stringIdRes)
    }

    fun getFormattedSpanned(context: Context, @StringRes stringIdRes: Int, vararg args: Any): Spanned {
        return ir.aryanmo.utils.utils.getFormattedSpanned(context,stringIdRes,args)
    }


    fun getHtml(html: String): Spanned {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) Html.fromHtml(html, Html.FROM_HTML_MODE_COMPACT) else Html.fromHtml(html)
    }
    //DIMEN
    fun gDimen(@DimenRes dimenIdRes: Int): Float {
        return ir.aryanmo.utils.utils.getDimen(appContext!!, dimenIdRes)
    }

    //DRAWABLE
    fun gDrawable(@DrawableRes drawableResId: Int): Drawable? {
        return ir.aryanmo.utils.utils.getDrawable(appContext!!, drawableResId)
    }

    //COLOR
    fun gColor(@ColorRes colorIdRes: Int): Int {
        return ir.aryanmo.utils.utils.getColor(appContext!!, colorIdRes)
    }

    fun gColor(s: String): Int {
        return ir.aryanmo.utils.utils.getColor(s)

    }

    fun gColorHex(@ColorRes colorRes: Int): Int {
        return ir.aryanmo.utils.utils.getColor(appContext!!, colorRes)
    }

    fun gColorString(@ColorRes colorRes: Int): String {
        return ir.aryanmo.utils.utils.getColorString(appContext!!, colorRes)

    }

    //File
    fun gMimeType(uri: String): String? {
        //TODO:Remove Function and create single file
        return ir.aryanmo.utils.utils.getMimeType(uri)
    }

    fun gFileType(uri: String): String? {
        //TODO:Remove Function and create single file
        return ir.aryanmo.utils.utils.getFileType(uri)
    }

    //OTHER

}
