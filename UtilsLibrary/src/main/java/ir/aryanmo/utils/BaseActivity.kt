package ir.aryanmo.utils

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ir.aryanmo.utils.utils.FLAG

open class BaseActivity : AppCompatActivity(), BaseActivityFunction {

    override var appContext: Context? = null
        get() = this

    override var appActivity: AppCompatActivity? = null
        get() = this

    override var activityName: String = ""
        get() = this.javaClass.simpleName

    override var logLifeCycle: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (logLifeCycle)
            logE("$activityName : onCreate()","${FLAG}-LifeCycle")
    }

    override fun onStart() {
        super.onStart()
        if (logLifeCycle)
            logE("$activityName : onStart()","${FLAG}-LifeCycle")
    }

    override fun onResume() {
        super.onResume()
        if (logLifeCycle)
            logE("$activityName : onResume()","${FLAG}-LifeCycle")
    }

    override fun onPause() {
        super.onPause()
        if (logLifeCycle)
            logE("$activityName : onPause()","${FLAG}-LifeCycle")
    }

    override fun onStop() {
        super.onStop()
        if (logLifeCycle)
            logE("$activityName : onStop()","${FLAG}-LifeCycle")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (logLifeCycle)
            logE("$activityName : onDestroy()","${FLAG}-LifeCycle")
    }

    override fun onRestart() {
        super.onRestart()
        if (logLifeCycle)
            logE("$activityName : onRestart()","${FLAG}-LifeCycle")
    }
}
