package ir.aryanmo.utils.utils

import android.app.Activity
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.view.View


fun snackbar(v: View, text: String, duration: Int, actionText: String?, runnable: Runnable?): Snackbar {
        val snackbar = Snackbar.make(v, getString(v.context, text), duration)
        if (runnable != null) {
            snackbar.setAction(getString(v.context, actionText!!)) {
                runnable.run()
            }
        }
        return snackbar
    }

    fun snackbar(activity: Activity, text: String, duration: Int, actionText: String?, runnable: Runnable?): Snackbar = snackbar(getView(activity), text, duration, actionText, runnable)

    fun snackbar(v: View, text: String, duration: Int, @StringRes actionText: Int, runnable: Runnable?): Snackbar = snackbar(v, text, duration, getString(v.context, actionText), runnable)

    fun snackbar(activity: Activity, text: String, duration: Int, @StringRes actionText: Int, runnable: Runnable?): Snackbar = snackbar(getView(activity), text, duration, actionText, runnable)

    fun snackbar(v: View, @StringRes text: Int, duration: Int, actionText: String?, runnable: Runnable?): Snackbar = snackbar(v, getString(v.context, text), duration, actionText, runnable)

    fun snackbar(activity: Activity, @StringRes text: Int, duration: Int, actionText: String?, runnable: Runnable?): Snackbar = snackbar(getView(activity), text, duration, actionText, runnable)

    fun snackbar(v: View, @StringRes text: Int, duration: Int, @StringRes actionText: Int, runnable: Runnable?): Snackbar = snackbar(v, getString(v.context, text), duration, actionText, runnable)

    fun snackbar(activity: Activity, @StringRes text: Int, duration: Int, @StringRes actionText: Int, runnable: Runnable?): Snackbar = snackbar(getView(activity), text, duration, actionText, runnable)

    fun snackbar(v: View, text: String, duration: Int): Snackbar = snackbar(v, text, duration, null, null)

    fun snackbar(v: View, @StringRes text: Int, duration: Int): Snackbar = snackbar(v, text, duration, null, null)

    fun snackbar(activity: Activity, text: String, duration: Int): Snackbar = snackbar(getView(activity), text, duration)

    fun snackbar(activity: Activity, @StringRes text: Int, duration: Int): Snackbar = snackbar(getView(activity), text, duration)

    fun snackbar(v: View, text: String): Snackbar = shortSnackbar(v, text)

    fun snackbar(v: View, @StringRes text: Int): Snackbar = shortSnackbar(v, text)

    fun snackbar(activity: Activity, text: String): Snackbar = shortSnackbar(activity, text)

    fun snackbar(activity: Activity, text: Int): Snackbar = shortSnackbar(activity, text)

    fun shortSnackbar(v: View, text: String): Snackbar = snackbar(v, text, Snackbar.LENGTH_SHORT, null, null)

    fun shortSnackbar(v: View, @StringRes text: Int): Snackbar = snackbar(v, text, Snackbar.LENGTH_SHORT, null, null)

    fun shortSnackbar(activity: Activity, text: String): Snackbar = shortSnackbar(getView(activity), text)

    fun shortSnackbar(activity: Activity, @StringRes text: Int): Snackbar = shortSnackbar(getView(activity), text)

    fun longSnackbar(v: View, text: String): Snackbar = snackbar(v, text, Snackbar.LENGTH_LONG, null, null)

    fun longSnackbar(v: View, @StringRes text: Int): Snackbar = snackbar(v, text, Snackbar.LENGTH_LONG, null, null)

    fun longSnackbar(activity: Activity, text: String): Snackbar = longSnackbar(getView(activity), text)

    fun longSnackbar(activity: Activity, @StringRes text: Int): Snackbar = longSnackbar(getView(activity), text)

    fun indefiniteSnackbar(v: View, text: String): Snackbar = snackbar(v, text, Snackbar.LENGTH_INDEFINITE, null, null)

    fun indefiniteSnackbar(v: View, @StringRes text: Int): Snackbar = snackbar(v, text, Snackbar.LENGTH_INDEFINITE, null, null)

    fun indefiniteSnackbar(activity: Activity, text: String): Snackbar = indefiniteSnackbar(getView(activity), text)

    fun indefiniteSnackbar(activity: Activity, @StringRes text: Int): Snackbar = indefiniteSnackbar(getView(activity), text)

    private fun getView(activity: Activity) = activity.window.decorView.rootView

