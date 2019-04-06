package ir.aryanmo.utils

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.WindowManager
import ir.aryanmo.utils.utils.FLAG

open class BaseActivity : AppCompatActivity(), BaseActivityFunction {

    override var appContext: Context? = null
        get() = this

    override var appActivity: AppCompatActivity? = null
        get() = this

    override var activityName: String = ""
        get() = this.javaClass.simpleName

    override var logLifeCycle: Boolean = false

    private var normalScreen:Boolean= true

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



    protected fun fullScreen(@ColorRes statusBarColor:Int=android.R.color.transparent) {
        try {
            normalScreen = false
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = this.window
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                window.statusBarColor = ContextCompat.getColor(this, statusBarColor)
            }
        } catch (e: Exception) {
            logError("fullScreen", e)
        }

    }

    protected fun normalScreen(@ColorRes statusBarColor:Int=android.R.color.transparent) {
        try {
            normalScreen = true
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = this.window
                window.statusBarColor = ContextCompat.getColor(this, statusBarColor)
            }
        } catch (e: Exception) {
            logError("normalScreen", e)
        }
    }

    override fun isNormalScreen(): Boolean {
        return normalScreen
    }

    fun isFullScreen(): Boolean {
        return !isNormalScreen()
    }

//    @RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        try {
            if (normalScreen) {
                normalScreen()
                return
            }
            fullScreen()
        } catch (e: Exception) {
            logError("onWindowFocusChanged", e)
        }
    }
}
