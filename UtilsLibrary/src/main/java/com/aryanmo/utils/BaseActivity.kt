package com.aryanmo.utils

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.Window
import android.view.WindowManager
import com.aryanmo.utils.utils.FLAG
import com.aryanmo.utils.utils.log.log
import com.aryanmo.utils.utils.log.logError


open class BaseActivity(private val fullScreen:Boolean = false) : AppCompatActivity(), BaseActivityFunction {

    override var appContext: Context? = null
        get() = this

    override var appActivity: AppCompatActivity? = null
        get() = this

    override var TAG: String = this::class.java.simpleName

    override var logLifeCycle: Boolean = false

    protected var normalScreen: Boolean = true

    protected var fullScreenInitialize: Boolean = false

    @ColorRes protected var statusBarColor = android.R.color.transparent
    set(value) {
        field = value
        onWindowFocusChanged(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (logLifeCycle)
            log("$TAG : onCreate()", "$FLAG-LifeCycle")

        if(fullScreen){
            fullScreen()
        }
    }

    override fun onStart() {
        super.onStart()
        if (logLifeCycle)
            log("$TAG : onStart()", "$FLAG-LifeCycle")
    }

    override fun onResume() {
        super.onResume()
        if (logLifeCycle)
            log("$TAG : onResume()", "$FLAG-LifeCycle")
    }

    override fun onPause() {
        super.onPause()
        if (logLifeCycle)
            log("$TAG : onPause()", "$FLAG-LifeCycle")
    }

    override fun onStop() {
        super.onStop()
        if (logLifeCycle)
            log("$TAG : onStop()", "$FLAG-LifeCycle")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (logLifeCycle)
            log("$TAG : onDestroy()", "$FLAG-LifeCycle")
    }

    override fun onRestart() {
        super.onRestart()
        if (logLifeCycle)
            log("$TAG : onRestart()", "$FLAG-LifeCycle")
    }

    private fun fullScreen() {
        try {
            normalScreen = false

            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT -> window.decorView.systemUiVisibility =
                    (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN -> window.decorView.systemUiVisibility =
                    (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            or View.SYSTEM_UI_FLAG_FULLSCREEN)
                else -> window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
            }

            if (!fullScreenInitialize) {
                fullScreenInitialize = true
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                this.window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
                )
            }
        } catch (e: Exception) {
            logError("fullScreen", e)
        }

    }

    private fun normalScreen() {
        try {
            normalScreen = true

            when {
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT ->
                    window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
                Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN ->
                    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            }

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val window = this.window
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
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
