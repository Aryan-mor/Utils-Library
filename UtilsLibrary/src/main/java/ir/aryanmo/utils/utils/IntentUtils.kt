package ir.aryanmo.utils.utils

import android.content.Context
import android.content.Intent
import android.os.Parcelable
import android.support.v7.app.AppCompatActivity
import ir.aryanmo.utils.utils.log.logError
import java.io.Serializable
import java.lang.Exception
import java.math.BigInteger
import kotlin.reflect.KClass

    fun makeIntent(context: Context, cls: Class<*>): Intent {
        return Intent(context, cls)
    }

    fun makeIntent(context: Context, cls: KClass<*>): Intent {
        return makeIntent(context, cls.java)
    }

    fun makeIntent(context: Context, activity: AppCompatActivity): Intent {
        return makeIntent(context, activity::class.java)
    }

    fun makeIntent(context: Context, cls: Class<*>, key: Any, value: Any): Intent {

        val intent = makeIntent(context, cls)
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

    fun makeIntent(context: Context, cls: KClass<*>, key: Any, value: Any): Intent {
        return makeIntent(context, cls.java, key, value)
    }

    fun makeIntent(context: Context, activity: AppCompatActivity, key: Any, value: Any): Intent {
        return makeIntent(context, activity::class.java, key, value)
    }

    fun intentTo(context: Context, cls: Class<*>) {
        return intentTo(context, makeIntent(context, cls))
    }

    fun intentTo(context: Context, cls: KClass<*>) {
        return intentTo(context, cls.java)
    }

    fun intentTo(context: Context, activity: AppCompatActivity) {
        return intentTo(context, activity::class.java)
    }

    fun intentTo(context: Context, cls: Class<*>, key: Any, value: Any) {
        return intentTo(context, makeIntent(context, cls, key, value))
    }

    fun intentTo(context: Context, cls: KClass<*>, key: Any, value: Any) {
        return intentTo(context,cls.java,key,value)
    }

    fun intentTo(context: Context, activity: AppCompatActivity, key: Any, value: Any) {
        return intentTo(context,activity::class.java,key, value)
    }

    fun intentTo(context: Context, intent: Intent) {
        return context.startActivity(intent)
    }

