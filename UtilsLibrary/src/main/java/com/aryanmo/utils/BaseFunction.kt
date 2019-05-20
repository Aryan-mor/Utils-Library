package com.aryanmo.utils


interface BaseFunction : BaseGetFunction, BaseToastFunction, BasePrefFunction {

    var logLifeCycle: Boolean

    //Device
    fun isXLargeScreen(): Boolean {
        return com.aryanmo.utils.utils.isXLargeScreen(appContext!!)
    }

    fun isLargeScreen(): Boolean {
        return com.aryanmo.utils.utils.isLargeScreen(appContext!!)
    }

    fun isNormalScreen(): Boolean {
        return com.aryanmo.utils.utils.isNormalScreen(appContext!!)
    }

    fun isSmallScreen(): Boolean {
        return com.aryanmo.utils.utils.isSmallScreen(appContext!!)
    }

    fun isTablet(): Boolean {
        return isLargeScreen() || isXLargeScreen()
    }

    fun isPortrait(): Boolean {
        return com.aryanmo.utils.utils.isPortrait(appContext!!)
    }

    fun isLandscape(): Boolean {
        return com.aryanmo.utils.utils.isLandscape(appContext!!)
    }
}
