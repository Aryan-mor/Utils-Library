package ir.aryanmo.utils.utils

import android.content.Context
import android.content.res.Resources

var FLAG = "Util"

fun setFlag(flag: String) {
    FLAG = flag
}

fun getResources(context: Context): Resources {
    return context.resources
}