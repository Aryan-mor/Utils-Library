package com.aryanmo.utils

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aryanmo.utils.utils.FLAG
import com.aryanmo.utils.utils.log.logE

abstract class BaseFragment : Fragment() {

    var TAG: String = this::class.java.simpleName
    var logLifeCycle: Boolean = false

    fun fragmentTag(s: String) {
        TAG = s
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (logLifeCycle)
            logE("$TAG : onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (logLifeCycle)
            logE("$TAG : onCreate()", "${FLAG}-LifeCycle")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (logLifeCycle)
            logE("$TAG : onCreateView()", "${FLAG}-LifeCycle")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (logLifeCycle)
            logE("$TAG : onViewCreated()", "${FLAG}-LifeCycle")
    }

    override fun onStart() {
        super.onStart()
        if (logLifeCycle)
            logE("$TAG : onStart()", "${FLAG}-LifeCycle")
    }

    override fun onResume() {
        super.onResume()
        if (logLifeCycle)
            logE("$TAG : onResume()", "${FLAG}-LifeCycle")
    }

    override fun onPause() {
        super.onPause()
        if (logLifeCycle)
            logE("$TAG : onPause()", "${FLAG}-LifeCycle")
    }

    override fun onStop() {
        super.onStop()
        if (logLifeCycle)
            logE("$TAG : onStop()", "${FLAG}-LifeCycle")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        if (logLifeCycle)
            logE("$TAG : onDestroyView()", "${FLAG}-LifeCycle")
    }

    override fun onDestroy() {
        super.onDestroy()
        if (logLifeCycle)
            logE("$TAG : onDestroy()", "${FLAG}-LifeCycle")
    }

    override fun onDetach() {
        super.onDetach()
        if (logLifeCycle)
            logE("$TAG : onDetach()", "${FLAG}-LifeCycle")
    }
}
