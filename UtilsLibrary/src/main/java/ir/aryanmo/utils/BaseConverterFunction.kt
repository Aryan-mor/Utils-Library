package ir.aryanmo.utils


interface BaseConverterFunction :Basic{
    fun toString(any: Any): String = ir.aryanmo.utils.utils.toString(any)

    fun toInt(any: Any): Int = ir.aryanmo.utils.utils.toInt(any)

    fun toFloat(s: String): Float = ir.aryanmo.utils.utils.toFloat(s)
}
