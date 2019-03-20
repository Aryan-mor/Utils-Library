package ir.aryanmo.utils

import ir.aryanmo.utils.log.BaseLogFunction


interface BaseFunction : BaseLogFunction, BaseGetFunction, BaseIntentFunction, BaseToastFunction, BaseConverterFunction, BasePrefFunction {

    var logLifeCycle: Boolean

    //Device
    fun isXLargeScreen(): Boolean {
        return ir.aryanmo.utils.utils.isXLargeScreen(appContext!!)
    }

    fun isLargeScreen(): Boolean {
        return ir.aryanmo.utils.utils.isLargeScreen(appContext!!)
    }

    fun isNormalScreen(): Boolean {
        return ir.aryanmo.utils.utils.isNormalScreen(appContext!!)
    }

    fun isSmallScreen(): Boolean {
        return ir.aryanmo.utils.utils.isSmallScreen(appContext!!)
    }

    fun isPortrait(): Boolean {
        return ir.aryanmo.utils.utils.isPortrait(appContext!!)
    }

    fun isLandscape(): Boolean {
        return ir.aryanmo.utils.utils.isLandscape(appContext!!)
    }
}
