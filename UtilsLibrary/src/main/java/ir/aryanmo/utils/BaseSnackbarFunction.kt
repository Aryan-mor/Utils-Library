package ir.aryanmo.utils

import android.app.Activity
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View

interface BaseSnackbarFunction : Basic {

    fun snackbar(v: View, text: String, duration: Int, actionText: String?, runnable: Runnable?): Snackbar = ir.aryanmo.utils.utils.snackbar(v, text, duration, actionText, runnable)

    fun snackbar(activity: Activity, text: String, duration: Int, actionText: String?, runnable: Runnable?): Snackbar = ir.aryanmo.utils.utils.snackbar(activity, text, duration, actionText, runnable)

    fun snackbar(v: View, text: String, duration: Int, @StringRes actionText: Int, runnable: Runnable?): Snackbar = ir.aryanmo.utils.utils.snackbar(v, text, duration, actionText, runnable)

    fun snackbar(activity: Activity, text: String, duration: Int, @StringRes actionText: Int, runnable: Runnable?): Snackbar = ir.aryanmo.utils.utils.snackbar(activity, text, duration, actionText, runnable)

    fun snackbar(text: String, duration: Int, actionText: String?, runnable: Runnable?): Snackbar = ir.aryanmo.utils.utils.snackbar(appActivity!!, text, duration, actionText, runnable)

    fun snackbar(text: String, duration: Int, @StringRes actionText: Int, runnable: Runnable?): Snackbar = ir.aryanmo.utils.utils.snackbar(appActivity!!, text, duration, actionText, runnable)

    fun snackbar(v: View, @StringRes text: Int, duration: Int, actionText: String?, runnable: Runnable?): Snackbar = ir.aryanmo.utils.utils.snackbar(v, text, duration, actionText, runnable)

    fun snackbar(activity: Activity, @StringRes text: Int, duration: Int, actionText: String?, runnable: Runnable?): Snackbar = ir.aryanmo.utils.utils.snackbar(activity, text, duration, actionText, runnable)

    fun snackbar(@StringRes text: Int, duration: Int, actionText: String?, runnable: Runnable?): Snackbar = ir.aryanmo.utils.utils.snackbar(appActivity!!, text, duration, actionText, runnable)

    fun snackbar(v: View, @StringRes text: Int, duration: Int,  @StringRes actionText: Int, runnable: Runnable?): Snackbar = ir.aryanmo.utils.utils.snackbar(v, text, duration, actionText, runnable)

    fun snackbar(activity: Activity, @StringRes text: Int, duration: Int,  @StringRes actionText: Int, runnable: Runnable?): Snackbar = ir.aryanmo.utils.utils.snackbar(activity, text, duration, actionText, runnable)

    fun snackbar(@StringRes text: Int, duration: Int,  @StringRes actionText: Int, runnable: Runnable?): Snackbar = ir.aryanmo.utils.utils.snackbar(appActivity!!, text, duration, actionText, runnable)

    fun snackbar(v: View, text: String, duration: Int): Snackbar = ir.aryanmo.utils.utils.snackbar(v, text, duration)

    fun snackbar(v: View, @StringRes text: Int, duration: Int): Snackbar = ir.aryanmo.utils.utils.snackbar(v, text, duration)

    fun snackbar(activity: Activity, text: String, duration: Int): Snackbar = ir.aryanmo.utils.utils.snackbar(activity, text, duration)

    fun snackbar(activity: Activity, @StringRes text: Int, duration: Int): Snackbar = ir.aryanmo.utils.utils.snackbar(activity, text, duration)

    fun snackbar(text: String, duration: Int): Snackbar = snackbar(appActivity!!, text, duration)

    fun snackbar(@StringRes text: Int, duration: Int): Snackbar = snackbar(appActivity!!, text, duration)

    fun snackbar(v: View, text: String): Snackbar = shortSnackbar(v, text)

    fun snackbar(v: View, @StringRes text: Int): Snackbar = shortSnackbar(v, text)

    fun snackbar(activity: Activity, text: String): Snackbar = shortSnackbar(activity, text)

    fun snackbar(activity: Activity, text: Int): Snackbar = shortSnackbar(activity, text)

    fun snackbar(text: String): Snackbar = shortSnackbar(appActivity!!, text)

    fun snackbar(text: Int): Snackbar = shortSnackbar(appActivity!!, text)

    fun shortSnackbar(v: View, text: String): Snackbar = ir.aryanmo.utils.utils.shortSnackbar(v, text)

    fun shortSnackbar(v: View, @StringRes text: Int): Snackbar = ir.aryanmo.utils.utils.shortSnackbar(v, text)

    fun shortSnackbar(activity: Activity, text: String): Snackbar = ir.aryanmo.utils.utils.shortSnackbar(activity, text)

    fun shortSnackbar(activity: Activity, @StringRes text: Int): Snackbar = ir.aryanmo.utils.utils.shortSnackbar(activity, text)

    fun shortSnackbar(text: String): Snackbar = shortSnackbar(appActivity!!, text)

    fun shortSnackbar(@StringRes text: Int): Snackbar = shortSnackbar(appActivity!!, text)

    fun longSnackbar(v: View, text: String): Snackbar = ir.aryanmo.utils.utils.longSnackbar(v, text)

    fun longSnackbar(v: View, @StringRes text: Int): Snackbar = ir.aryanmo.utils.utils.longSnackbar(v, text)

    fun longSnackbar(activity: Activity, text: String): Snackbar = ir.aryanmo.utils.utils.longSnackbar(activity, text)

    fun longSnackbar(activity: Activity, @StringRes text: Int): Snackbar = ir.aryanmo.utils.utils.longSnackbar(activity, text)

    fun longSnackbar(text: String): Snackbar = longSnackbar(appActivity!!,text)

    fun longSnackbar(@StringRes text: Int): Snackbar = longSnackbar(appActivity!!,text)

    fun indefiniteSnackbar(v: View, text: String): Snackbar = ir.aryanmo.utils.utils.indefiniteSnackbar(v, text)

    fun indefiniteSnackbar(v: View, @StringRes text: Int): Snackbar = ir.aryanmo.utils.utils.indefiniteSnackbar(v, text)

    fun indefiniteSnackbar(activity: Activity, text: String): Snackbar = ir.aryanmo.utils.utils.indefiniteSnackbar(activity, text)

    fun indefiniteSnackbar(activity: Activity, @StringRes text: Int): Snackbar = ir.aryanmo.utils.utils.indefiniteSnackbar(activity, text)

    fun indefiniteSnackbar(text: String): Snackbar = indefiniteSnackbar(appActivity!!, text)

    fun indefiniteSnackbar(@StringRes text: Int): Snackbar = indefiniteSnackbar(appActivity!!, text)

}