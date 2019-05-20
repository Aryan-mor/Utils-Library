package com.aryanmo.utils.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Parcelable
import android.provider.Settings
import com.aryanmo.utils.utils.log.logError
import java.io.Serializable
import java.math.BigInteger
import kotlin.reflect.KClass

fun Context.makeIntent(cls: Class<*>): Intent {
    return Intent(this, cls)
}

fun Context.makeIntent(cls: KClass<*>): Intent {
    return this.makeIntent(cls.java)
}

fun Context.makeIntent(activity: Activity): Intent {
    return this.makeIntent(activity::class.java)
}

fun Context.makeIntent(cls: Class<*>, key: Any, value: Any): Intent {
    val intent = this.makeIntent(cls)
    try {
        when (value) {
            is String -> intent.putExtra(key.toString(), value)
            is Boolean -> intent.putExtra(key.toString(), value)
            is Int -> intent.putExtra(key.toString(), value)
            is Float -> intent.putExtra(key.toString(), value)
            is Long -> intent.putExtra(key.toString(), value)
            is Double -> intent.putExtra(key.toString(), value)
            is BigInteger -> intent.putExtra(key.toString(), value)
            is Byte -> intent.putExtra(key.toString(), value)
            is Short -> intent.putExtra(key.toString(), value)
            is Char -> intent.putExtra(key.toString(), value)
            is CharSequence -> intent.putExtra(key.toString(), value)
            is Parcelable -> intent.putExtra(key.toString(), value)
            is Serializable -> intent.putExtra(key.toString(), value)
            is BooleanArray -> intent.putExtra(key.toString(), value)
            is ByteArray -> intent.putExtra(key.toString(), value)
            is ShortArray -> intent.putExtra(key.toString(), value)
            is CharArray -> intent.putExtra(key.toString(), value)
            is IntArray -> intent.putExtra(key.toString(), value)
            is LongArray -> intent.putExtra(key.toString(), value)
            is ArrayList<*> -> intent.putExtra(key.toString(), value)
            is Array<*> -> intent.putExtra(key.toString(), value)
            is HashMap<*, *> -> intent.putExtra(key.toString(), value)
            is Map<*, *> -> intent.putExtra(key.toString(), HashMap<Any, Any>(value))
            else -> intent.putExtra(key.toString(), value.toString())
        }
    } catch (e: Exception) {
        logError("makeIntent(context: Context, cls: Class<*>, key: Any, value: Any) put extra failed", e)
    }
    return intent
}

fun Context.makeIntent(cls: KClass<*>, key: Any, value: Any): Intent {
    return this.makeIntent(cls.java, key, value)
}

fun Context.makeIntent(activity: Activity, key: Any, value: Any): Intent {
    return this.makeIntent(activity::class.java, key, value)
}
fun Context.intentTo(intent: Intent) {
    return this.startActivity(intent)
}

fun Context.intentTo(cls: Class<*>) {
    return intentTo(this.makeIntent(cls))
}

fun Context.intentTo(cls: KClass<*>) {
    return intentTo(cls.java)
}

fun Context.intentTo(cls: Class<*>, key: Any, value: Any) {
    return intentTo(makeIntent(cls, key, value))
}

fun Context.intentTo(cls: KClass<*>, key: Any, value: Any) {
    return intentTo(cls.java, key, value)
}

fun Context.intentTo(activity: Activity, key: Any, value: Any) {
    return intentTo(activity::class.java, key, value)
}


fun Context.makeIntentToPackageSetting(): Intent {
    val intent = Intent()
    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
    val uri = Uri.fromParts("package", this.packageName, null)
    intent.data = uri
    return intent
}

fun Context.intentTo(activity: Activity) {
    intentTo(makeIntent(activity))
}
