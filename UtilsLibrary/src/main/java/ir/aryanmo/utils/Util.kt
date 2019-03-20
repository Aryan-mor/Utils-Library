package ir.aryanmo.utils

import android.content.Context
import android.support.v7.app.AppCompatActivity

class Util( override var appContext: Context?):BaseFunction {

    override var appActivity: AppCompatActivity? = null

    override var activityName: String = ""
        get() = this.javaClass.simpleName

    override var logLifeCycle: Boolean = false

}