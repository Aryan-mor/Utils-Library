package com.aryanmo.utils.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager


@Deprecated(
    "isNetworkAvailable function is deprecated and change to Activity.checkNetwork()",
    ReplaceWith("activity.checkNetwork()")
)
@SuppressLint("MissingPermission")
fun isNetworkAvailable(activity: Activity): Boolean {
    return activity.checkNetwork()
}

@SuppressLint("MissingPermission")
fun Activity.checkNetwork(): Boolean {
    val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}
