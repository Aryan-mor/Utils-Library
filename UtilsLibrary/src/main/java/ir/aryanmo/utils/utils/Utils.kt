package ir.aryanmo.utils.utils


import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.text.Html
import android.text.Spanned
import android.view.View
import android.view.inputmethod.InputMethodManager

import java.util.HashMap

import android.content.res.Resources
import android.os.Build
import android.util.TypedValue
import android.os.VibrationEffect
import android.os.Vibrator
import ir.aryanmo.utils.R
import ir.aryanmo.utils.utils.log.logError
import ir.aryanmo.utils.utils.log.logNullPointerExceptionError


val sdkApiLevel: Int
    get() = android.os.Build.VERSION.SDK_INT

fun getVersionCode(activity: Activity): Int {
    try {
        val pInfo = activity.packageManager.getPackageInfo(activity.packageName, 0)
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

fun getVersionName(activity: Activity): String {
    try {
        val pInfo = activity.packageManager.getPackageInfo(activity.packageName, 0)
        return pInfo.versionName
    } catch (e: Exception) {
        logError("getVersionCode", e)
        return ""
    }

}

fun getAppInfo(activity: Activity): HashMap<String, String> {
    try {
        val hashMap = HashMap<String, String>()
        hashMap["os"] = "Android"
        hashMap["android_sdk_api_level"] = sdkApiLevel.toString()
        hashMap["version"] = getVersionCode(activity).toString()
        return hashMap
    } catch (e: Exception) {
        logError("getAppInfo", e)
        return HashMap()
    }

}

fun openLink(activity: Activity, link: String): Boolean {
    try {
        intentTo(activity, Intent(Intent.ACTION_VIEW, Uri.parse(link)))
        return true
    } catch (e: Exception) {
        logError("openLink", e)
        return false
    }

}

fun closeApp(activity: Activity) {
    try {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        activity.startActivity(intent)
        activity.finish()
        System.exit(0)
    } catch (e: Exception) {
        logError("closeApp", e)
        closeApp()
    }

}

fun closeApp() {
    try {
        val intent = Intent(Intent.ACTION_MAIN)
        intent.addCategory(Intent.CATEGORY_HOME)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        System.exit(0)
    } catch (e: Exception) {
        logError("closeApp", e)
    }

}

fun restartApp(activity: Activity) {
    val intent = activity.baseContext.packageManager
            .getLaunchIntentForPackage(activity.baseContext.packageName)
    intent!!.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
    activity.startActivity(intent)
}

fun getHtml(html: String): Spanned {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
    } else {
        Html.fromHtml(html)
    }
}

fun delay(activity: Activity, duration: Int, runnable: Runnable?) {
    Thread(Runnable {
        try {
            Thread.sleep(duration.toLong())
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        if (runnable != null)
            activity.runOnUiThread(runnable)
    }).start()
}

fun dpTOInt(context: Context, f: Float): Int {
    val scale = context.resources.displayMetrics.density
    return (f * scale + 0.5f).toInt()
}

fun dpToPx(dp: Float, resources: Resources): Int {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics).toInt()
}

fun dpToFloat(dp: Float, resources: Resources): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
}

fun hideSoftKeyboard(activity: Activity) {
    try {
        val view = activity.currentFocus ?: return
        hideSoftKeyboard(activity, view)
    } catch (e: Exception) {
        logError("hideSoftKeyboard", e)
    }

}

fun hideSoftKeyboard(activity: Activity, view: View) {
    try {
        val imm = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.applicationWindowToken, 0)
    } catch (n: NullPointerException) {
        logNullPointerExceptionError("Util::hideSoftKeyboard", n)
    } catch (e: Exception) {
        logError("hideSoftKeyboard", e)
    }

}

//Device
fun isXLargeScreen(context: Context): Boolean {
    return context.resources.getBoolean(R.bool.isXLargeScreen)
}

fun isLargeScreen(context: Context): Boolean {
    return context.resources.getBoolean(R.bool.isLargeScreen)
}

fun isNormalScreen(context: Context): Boolean {
    return !(isXLargeScreen(context) || isLargeScreen(context) || isSmallScreen(context))
}

fun isSmallScreen(context: Context): Boolean {
    return context.resources.getBoolean(ir.aryanmo.utils.R.bool.isSmallScreen)
}

fun isPortrait(context: Context): Boolean {
    return context.resources.getBoolean(ir.aryanmo.utils.R.bool.isPortrait)
}

fun isLandscape(context: Context): Boolean {
    return !isPortrait(context)
}

//Vibrate
@SuppressLint("MissingPermission")
fun vibrate(activity: Activity, vibrationEffect: VibrationEffect): Vibrator? {
    return try {
        val v = activity.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?
        if (!hasVibrationPermission(activity))
            throw Exception("Permission denied")

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
fun vibrate(activity: Activity, milliseconds: Long, amplitude: Int): Vibrator {
    val v = activity.getSystemService(Context.VIBRATOR_SERVICE) as Vibrator?

    if (!hasVibrationPermission(activity))
        throw Exception("Permission denied")

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        v!!.vibrate(VibrationEffect.createOneShot(milliseconds, amplitude))
    } else {
        v!!.vibrate(milliseconds)
    }
    return v
}
