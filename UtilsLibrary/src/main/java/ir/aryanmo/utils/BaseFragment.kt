package ir.aryanmo.utils

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.aryanmo.utils.utils.FLAG

abstract class BaseFragment : Fragment(), BaseActivityFunction {

    override var activityName: String = ""
        get() = this.javaClass.simpleName
    override var appContext: Context? = null
        get() = context
    override var appActivity: AppCompatActivity? = null
        get() = activity as BaseActivity
    override var logLifeCycle: Boolean = false

    fun fragmentName(s: String) {
        activityName = s
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (logLifeCycle)
            logE("$activityName : onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (logLifeCycle)
            logE("$activityName : onCreate()", "${FLAG}-LifeCycle")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (logLifeCycle)
            logE("$activityName : onCreateView()", "${FLAG}-LifeCycle")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (logLifeCycle)
            logE("$activityName : onViewCreated()", "${FLAG}-LifeCycle")
    }

    override fun onStart() {
        super.onStart()
        if (logLifeCycle)
            logE("$activityName : onStart()", "${FLAG}-LifeCycle")
    }

    override fun onResume() {
        super.onResume()
        if (logLifeCycle)
            logE("$activityName : onResume()", "${FLAG}-LifeCycle")
    }

    override fun onPause() {
        super.onPause()
        if (logLifeCycle)
            logE("$activityName : onPause()", "${FLAG}-LifeCycle")
    }

    override fun onStop() {
        super.onStop()
        if (logLifeCycle)
            logE("$activityName : onStop()", "${FLAG}-LifeCycle")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (logLifeCycle)
            logE("$activityName : onDestroyView()", "${FLAG}-LifeCycle")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (logLifeCycle)
            logE("$activityName : onDestroy()", "${FLAG}-LifeCycle")
    }

    override fun onDetach() {
        super.onDetach()
        if (logLifeCycle)
            logE("$activityName : onDetach()", "${FLAG}-LifeCycle")
    }
}
