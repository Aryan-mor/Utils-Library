package com.aryanmo.utils.utils

import java.math.BigInteger
import java.security.MessageDigest


fun String.toMd5(): String {
    val md = MessageDigest.getInstance("MD5")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun String.toSHA_1(): String {
    val md = MessageDigest.getInstance("SHA-1")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun String.toSHA_224(): String {
    val md = MessageDigest.getInstance("SHA-224")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun String.toSHA_256(): String {
    val md = MessageDigest.getInstance("SHA-256")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun String.toSHA_384(): String {
    val md = MessageDigest.getInstance("SHA-384")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

fun String.toSHA_512(): String {
    val md = MessageDigest.getInstance("SHA-512")
    return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
}

