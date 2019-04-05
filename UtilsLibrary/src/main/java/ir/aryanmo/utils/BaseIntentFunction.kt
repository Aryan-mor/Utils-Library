package ir.aryanmo.utils

import android.app.Activity
import android.content.Intent
import kotlin.reflect.KClass

interface BaseIntentFunction : Basic {

    fun makeIntent(cls: Class<*>): Intent {
        return ir.aryanmo.utils.utils.makeIntent(appContext!!, cls)
    }

    fun makeIntent(cls: KClass<*>): Intent {
        return ir.aryanmo.utils.utils.makeIntent(appContext!!, cls)
    }

    fun makeIntent(activity: Activity): Intent {
        return ir.aryanmo.utils.utils.makeIntent(appContext!!, activity)
    }

    fun makeIntent(cls: Class<*>, key: Any, value: Any): Intent {
        return ir.aryanmo.utils.utils.makeIntent(appContext!!, cls, key, value)
    }

    fun makeIntent(cls: KClass<*>, key: Any, value: Any): Intent {
        return ir.aryanmo.utils.utils.makeIntent(appContext!!, cls, key, value)
    }

    fun makeIntent(activity: Activity, key: Any, value: Any): Intent {
        return ir.aryanmo.utils.utils.makeIntent(appContext!!, activity, key, value)
    }

    fun intentTo(cls: Class<*>) {
        return ir.aryanmo.utils.utils.intentTo(appContext!!, cls)
    }

    fun intentTo(cls: KClass<*>) {
        return ir.aryanmo.utils.utils.intentTo(appContext!!, cls)
    }

    fun intentTo(activity: Activity) {
        return ir.aryanmo.utils.utils.intentTo(appContext!!, activity)
    }

    fun intentTo(cls: Class<*>, key: Any, value: Any) {
        return ir.aryanmo.utils.utils.intentTo(appContext!!, cls, key, value)
    }

    fun intentTo(cls: KClass<*>, key: Any, value: Any) {
        return ir.aryanmo.utils.utils.intentTo(appContext!!, cls, key, value)
    }

    fun intentTo(activity: Activity, key: Any, value: Any) {
        return ir.aryanmo.utils.utils.intentTo(appContext!!, activity, key, value)
    }

    fun intentTo(intent: Intent) {
        return ir.aryanmo.utils.utils.intentTo(appContext!!, intent)
    }


    fun makeIntentSetting(): Intent = ir.aryanmo.utils.utils.makeIntentSetting(appContext!!)

    fun intentToSetting(activity: Activity)=ir.aryanmo.utils.utils.intentToSetting(activity)
}