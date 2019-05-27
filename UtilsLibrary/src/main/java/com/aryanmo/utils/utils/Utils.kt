package com.aryanmo.utils.utils


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.text.Html
import android.text.Spanned
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.aryanmo.utils.R
import com.aryanmo.utils.utils.log.logError
import com.aryanmo.utils.utils.log.logNullPointerExceptionError
import java.util.*


val sdkApiLevel: Int
    get() = android.os.Build.VERSION.SDK_INT

fun Activity.getVersionCode(): Int {
    try {
        val pInfo = this.packageManager.getPackageInfo(this.packageName, 0)
        return if (android.os.Build.VERSION.SDK_INT >= 28) {
            pInfo.longVersionCode.toInt()
        } else {
            pInfo.versionCode
        }
    } catch (e: Exception) {
        logError("getVersionCode", e)
    }

    return -1
}

fun Activity.getVersionName(): String {
    try {
        val pInfo = this.packageManager.getPackageInfo(this.packageName, 0)
        return pInfo.versionName
    } catch (e: Exception) {
        logError("getVersionCode", e)
        return ""
    }

}

fun Activity.getAppInfo(): HashMap<String, String> {
    try {
        val hashMap = HashMap<String, String>()
        hashMap["os"] = "android"
        hashMap["android_sdk_api_level"] = sdkApiLevel.toString()
        hashMap["version"] = this.getVersionCode().toString()
        return hashMap
    } catch (e: Exception) {
        logError("getAppInfo", e)
        return HashMap()
    }

}

fun Activity.openLink(link: String): Boolean {
    try {
        this.intentTo(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
        return true
    } catch (e: Exception) {
        logError("openLink", e)
        return false
    }
}

fun Activity.closeApp() {
    try {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        this.startActivity(intent)
        this.finish()
        System.exit(0)
    } catch (e: Exception) {
        logError("closeApp", e)
        closeApp()
    }

}

private fun closeApp() {
    try {
        System.exit(0)
    } catch (e: Exception) {
        logError("closeApp", e)
    }

}

fun Activity.restartApp() {
    val intent = this.baseContext.packageManager
        .getLaunchIntentForPackage(this.baseContext.packageName)
    intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    this.startActivity(intent)
}

fun String.toHtml(): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(this)
    }
}

@Deprecated(
    "function change to Activity.delayOnUiThread(duration: Int){}",
    ReplaceWith("Activity.delayOnUiThread(duration: Int){}")
)
fun Activity.delayOnUiThread(duration: Int, runnable: Runnable? = null) {
    this.delayOnUiThread(duration) {
        runnable?.run()
    }
}

fun Activity.delayOnUiThread(duration: Int, runnable: () -> Unit) {
    Thread(Runnable {
        try {
            Thread.sleep(duration.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        runnable()
    }).start()
}

fun Activity.delayOnUiThread(duration: Int) {
    this.delayOnUiThread(duration) {
    }
}

fun delay(duration: Long) {
    Thread(Runnable {
        try {
            Thread.sleep(duration)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    })
}

fun Context.dpTOInt(f: Float): Int {
    val scale = this.resources.displayMetrics.density
    return (f * scale + 0.5f).toInt()
}

fun Context.dpToPx(dp: Float): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, this.resources.displayMetrics).toInt()
}

fun Context.dpToFloat(dp: Float): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
}

fun Activity.hideSoftKeyboard() {
    try {
        val view = currentFocus ?: return
        this.hideSoftKeyboard(view)
    } catch (e: Exception) {
        logError("hideSoftKeyboard", e)
    }

}

fun Activity.hideSoftKeyboard(view: View) {
    try {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.applicationWindowToken, 0)
    } catch (n: NullPointerException) {
        logNullPointerExceptionError("Util::hideSoftKeyboard", n)
    } catch (e: Exception) {
        logError("hideSoftKeyboard", e)
    }

}

//Device
fun Context.isXLargeScreen(): Boolean {
    return resources.getBoolean(R.bool.isXLargeScreen)
}

fun Context.isLargeScreen(): Boolean {
    return resources.getBoolean(R.bool.isLargeScreen)
}

fun Context.isNormalScreen(): Boolean {
    return !(isXLargeScreen() || isLargeScreen() || isSmallScreen())
}

fun Context.isSmallScreen(): Boolean {
    return resources.getBoolean(com.aryanmo.utils.R.bool.isSmallScreen)
}

fun Context.isPortrait(): Boolean {
    return resources.getBoolean(com.aryanmo.utils.R.bool.isPortrait)
}

fun Context.isLandscape(): Boolean {
    return !isPortrait()
}

fun isRTL(): Boolean {
    return isRTL(Locale.getDefault())
}

fun isRTL(locale: Locale): Boolean {
    val directionality = Character.getDirectionality(locale.displayName[0]).toInt()
    return directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT.toInt() || directionality == Character.DIRECTIONALITY_RIGHT_TO_LEFT_ARABIC.toInt()
}

fun isLtr(): Boolean {
    return !isLtr(Locale.getDefault())
}

fun isLtr(locale: Locale): Boolean {
    return !isRTL(locale)
}

//Vibrate
@SuppressLint("MissingPermission")
fun Activity.vibrate(vibrationEffect: VibrationEffect): Vibrator? {
    return try {
        val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v!!.vibrate(vibrationEffect)
        } else {
            v!!.vibrate(100)
        }
        v
    } catch (e: Exception) {
        logError("vibrate", e)
        null
    }
}

@SuppressLint("MissingPermission")
fun Activity.vibrate(milliseconds: Long, amplitude: Int): Vibrator {
    val v = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        v!!.vibrate(VibrationEffect.createOneShot(milliseconds, amplitude))
    } else {
        v!!.vibrate(milliseconds)
    }
    return v
}
