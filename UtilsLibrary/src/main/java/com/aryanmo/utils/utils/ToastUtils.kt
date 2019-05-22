package com.aryanmo.utils.utils

import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast


fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT): Toast {
    return Toast.makeText(this, getString(message), duration)
}

fun Context.toast(@StringRes message: Int, duration: Int = Toast.LENGTH_SHORT): Toast {
    return this.toast(getString( message), duration)
}

fun Context.longToast(message: String): Toast {
    return this.toast(message, Toast.LENGTH_LONG)
}

fun Context.longToast(@StringRes message: Int): Toast {
    return this.longToast(getString( message))
}
