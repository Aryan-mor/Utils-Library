package ir.aryanmo.utils.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.NetworkInfo
import android.content.Context.CONNECTIVITY_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.net.ConnectivityManager
import android.support.v7.app.AppCompatActivity
import android.util.Log

@SuppressLint("MissingPermission")
fun isNetworkAvailable(activity: AppCompatActivity): Boolean {
    val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}