package com.aryanmo.utils.utils

import android.content.Context
import android.content.res.Resources

var FLAG = "Util"

fun setFlag(flag: String) {
    FLAG = flag
}

fun Context.getResources(): Resources {
    return this.resources
}