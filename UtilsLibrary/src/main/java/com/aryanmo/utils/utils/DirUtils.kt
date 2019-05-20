package com.aryanmo.utils.utils

import android.content.Context
import android.os.Environment
import java.io.File

fun getAndroidDataDir(context: Context): String {
    return context.getExternalFilesDir(Environment.getDataDirectory().absolutePath).absolutePath
}

fun getDataDir(context: Context): String{
    return context.filesDir.toString()
}

fun isExistsDir(path: String): Boolean {
    return File(path).exists()
}

fun createDir(path: String): Boolean {
    return File(path).mkdir()
}

fun checkDir(path: String): Boolean {
    if (!isExistsDir(path))
        return createDir(path)
    return true
}