package com.aryanmo.utils.utils

import android.app.Activity
import android.support.design.widget.Snackbar
import android.view.View


fun View.snackbar(
    text: String,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionText: String = "",
    runnable: Runnable? = null
): Snackbar {
    val snackbar = Snackbar.make(this, this.context.gString(text), duration)
    if (runnable != null) {
        snackbar.setAction(this.context.gString( actionText)) {
            runnable.run()
        }
    }
    return snackbar
}

fun Activity.snackbar(
    text: String,
    duration: Int = Snackbar.LENGTH_SHORT,
    actionText: String = "",
    runnable: Runnable? = null
): Snackbar =
    getView(this).snackbar(text, duration, actionText, runnable)


fun View.longSnackbar(
    text: String,
    actionText: String = "",
    runnable: Runnable? = null
) = this.snackbar(text, Snackbar.LENGTH_LONG, actionText, runnable)

fun Activity.longSnackbar(
    text: String,
    actionText: String = "",
    runnable: Runnable? = null
) = this.snackbar(text, Snackbar.LENGTH_LONG, actionText, runnable)

fun View.indefiniteSnackbar(
    text: String,
    actionText: String = "",
    runnable: Runnable? = null
) = this.snackbar(text, Snackbar.LENGTH_INDEFINITE, actionText, runnable)

fun Activity.indefiniteSnackbar(
    text: String,
    actionText: String = "",
    runnable: Runnable? = null
) = this.snackbar(text, Snackbar.LENGTH_INDEFINITE, actionText, runnable)

private fun getView(activity: Activity) = activity.window.decorView.rootView

