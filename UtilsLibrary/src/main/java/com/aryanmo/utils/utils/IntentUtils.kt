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

fun Context.makeIntent(cls: Class<*>, key: String, value: Any): Intent {
    val intent = this.makeIntent(cls)
    try {
//        when (value) {
//            is String -> intent.putExtra(key, value)
//            is Boolean -> intent.putExtra(key, value)
//            is Int -> intent.putExtra(key, value)
//            is Float -> intent.putExtra(key, value)
//            is Long -> intent.putExtra(key, value)
//            is Double -> intent.putExtra(key, value)
//            is BigInteger -> intent.putExtra(key, value)
//            is Byte -> intent.putExtra(key, value)
//            is Short -> intent.putExtra(key, value)
//            is Char -> intent.putExtra(key, value)
//            is CharSequence -> intent.putExtra(key, value)
//            is Parcelable -> intent.putExtra(key, value)
//            is Serializable -> intent.putExtra(key, value)
//            is BooleanArray -> intent.putExtra(key, value)
//            is ByteArray -> intent.putExtra(key, value)
//            is ShortArray -> intent.putExtra(key, value)
//            is CharArray -> intent.putExtra(key, value)
//            is IntArray -> intent.putExtra(key, value)
//            is LongArray -> intent.putExtra(key, value)
//            is ArrayList<*> -> intent.putExtra(key, value)
//            is Array<*> -> intent.putExtra(key, value)
//            is HashMap<*, *> -> intent.putExtra(key, value)
//            is Map<*, *> -> intent.putExtra(key, HashMap<Any, Any>(value))
//            else -> intent.putExtra(key, value.toJson())
//        }

        intent.putExtra(key, value.toJson())
    } catch (e: Exception) {
        logError("makeIntent(context: Context, cls: Class<*>, key: String, value: Any) put extra failed", e)
    }
    return intent
}

fun Context.makeIntent(cls: KClass<*>, key: String, value: Any): Intent {
    return this.makeIntent(cls.java, key, value)
}

fun Context.makeIntent(activity: Activity, key: String, value: Any): Intent {
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

fun Context.intentTo(cls: Class<*>, key: String, value: Any) {
    return intentTo(makeIntent(cls, key, value))
}

fun Context.intentTo(cls: KClass<*>, key: String, value: Any) {
    return intentTo(cls.java, key, value)
}

fun Context.intentTo(activity: Activity, key: String, value: Any) {
    return intentTo(activity::class.java, key, value)
}

fun Context.makeIntentToPackageSetting(): Intent {
    val intent = Intent()
    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
    val uri = Uri.fromParts("package", this.packageName, null)
    intent.data = uri
    return intent
}

fun Context.intentToPackageSetting() {
    val intent = Intent()
    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
    val uri = Uri.fromParts("package", this.packageName, null)
    intent.data = uri
    intentTo(intent)
}

fun Context.openLink(link: String): Boolean {
    try {
        this.intentTo(Intent(Intent.ACTION_VIEW, Uri.parse(link)))
        return true
    } catch (e: Exception) {
        logError("openLink", e)
        return false
    }
}

fun Context.intentTo(activity: Activity) {
    intentTo(makeIntent(activity))
}

fun <T> Activity.getExtra(key: String, classOf: Class<T>): T? {
    return intent.getStringExtra(key).hydrate(classOf)
}
