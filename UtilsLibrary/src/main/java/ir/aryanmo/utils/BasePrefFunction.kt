package ir.aryanmo.utils

interface BasePrefFunction : Basic {


    fun addPref(key: String, value: Any): Boolean {
        return ir.aryanmo.utils.utils.addPref(appContext!!, key, value)
    }

    fun getPrefBoolean(key: String, defaultValue: Boolean): Boolean {
        return ir.aryanmo.utils.utils.getPrefBoolean(appContext!!, key, defaultValue)
    }

    fun getPrefString(key: String, defaultValue: String): String {
        return ir.aryanmo.utils.utils.getPrefString(appContext!!, key, defaultValue)
    }

    fun getPrefInt(key: String, defaultValue: Int): Int {
        return ir.aryanmo.utils.utils.getPrefInt(appContext!!, key, defaultValue)
    }

    fun getPrefFloat(key: String, defaultValue: Float): Float {
        return ir.aryanmo.utils.utils.getPrefFloat(appContext!!, key, defaultValue)
    }

    fun getPrefLong(key: String, defaultValue: Long): Long {
        return ir.aryanmo.utils.utils.getPrefLong(appContext!!, key, defaultValue)
    }

    fun <T> getPref(key: String, classOf: Class<T>): T? {
        return ir.aryanmo.utils.utils.getPref(appContext!!, key, classOf)
    }


}