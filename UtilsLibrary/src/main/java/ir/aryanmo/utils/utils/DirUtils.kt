package ir.aryanmo.utils.utils

import java.io.File


fun isExistsDir(path: String): Boolean {
    return File(path).exists()
}

fun createDir(path: String): Boolean {
    return File(path).mkdir()
}

fun checkDir(path: String): Boolean {
    if (!isExistsDir(path))
        return createDir(path)
    return true
}