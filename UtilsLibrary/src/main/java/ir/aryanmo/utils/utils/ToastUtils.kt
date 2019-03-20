package ir.aryanmo.utils.utils

import android.content.Context
import android.support.annotation.StringRes
import android.widget.Toast


    fun toast(context: Context, message: String, duration: Int): Toast {
        return Toast.makeText(context, getString(context, message), duration)
    }

    fun toast(context: Context, @StringRes message: Int, duration: Int): Toast {
        return toast(context,getString(context, message), duration)
    }

    fun shortToast(context: Context, message: String): Toast {
        return toast(context, message, Toast.LENGTH_SHORT)
    }

    fun shortToast(context: Context, @StringRes message: Int): Toast {
        return shortToast(context,getString(context, message))
    }

    fun longToast(context: Context, message: String): Toast {
        return toast(context, message, Toast.LENGTH_LONG)
    }

    fun longToast(context: Context, @StringRes message: Int): Toast {
        return longToast(context,getString(context, message))
    }
