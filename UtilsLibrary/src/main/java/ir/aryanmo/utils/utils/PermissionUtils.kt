package ir.aryanmo.utils.utils

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.pm.PackageManager
import android.os.Build
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

private val PREFS_FILE_NAME = "AppPreferences"
    val REQUEST_READ_EXTERNAL_STORAGE_CODE = 11
    val REQUEST_WRITE_EXTERNAL_STORAGE_CODE = 22
    val REQUEST_CAMERA_CODE = 33
    val REQUEST_LOCATION_CODE = 44
    val REQUEST_VIBRATION_CODE = 55

    fun shouldAskPermission(): Boolean {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
    }

    private fun shouldAskPermission(context: Context, permission: String): Boolean {
        if (shouldAskPermission()) {
            val permissionResult = ActivityCompat.checkSelfPermission(context, permission)
            if (permissionResult != PackageManager.PERMISSION_GRANTED) {
                return true
            }
        }
        return false
    }

    fun firstTimeAskingPermission(context: Context, permission: String, isFirstTime: Boolean) {
        val sharedPreference = context.getSharedPreferences(PREFS_FILE_NAME, MODE_PRIVATE)
        sharedPreference.edit().putBoolean(permission, isFirstTime).apply()
    }

    fun isFirstTimeAskingPermission(context: Context, permission: String): Boolean {
        return context.getSharedPreferences(PREFS_FILE_NAME, MODE_PRIVATE).getBoolean(permission, true)
    }

    @SuppressLint("NewApi")
    fun checkPermission(activity: Activity, permission: String, listener: PermissionAskListener) {
        /*
         * If permission is not granted
         * */
        if (shouldAskPermission(activity, permission)) {
            /*
             * If permission denied previously
             * */
            if (activity.shouldShowRequestPermissionRationale(permission)) {
                listener.onPermissionPreviouslyDenied()
            } else {
                /*
                 * Permission denied or first time requested
                 * */
                if (isFirstTimeAskingPermission(activity, permission)) {
                    firstTimeAskingPermission(activity, permission, false)
                    listener.onNeedPermission()
                } else {
                    /*
                     * Handle the feature without permission or ask user to manually allow permission
                     * */
                    listener.onPermissionDisabled()
                }
            }
        } else {
            listener.onPermissionGranted()
        }
    }


    private fun requestPermission(activity: Activity, manifestPermission: String, requestCode: Int) {
        if (!shouldAskPermission())
            return

        ActivityCompat.requestPermissions(
                activity,
                arrayOf(manifestPermission),
                requestCode
        )
    }

    private fun hasPermission(context: Context, manifestPermission: String): Boolean {
        return if (!shouldAskPermission()) true else ContextCompat.checkSelfPermission(context, manifestPermission) == PackageManager.PERMISSION_GRANTED
    }


    //ss

    fun checkLocationPermission(activity: Activity, listener: PermissionAskListener) {
        checkPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION, listener)
    }

    fun requestLocationPermission(activity: Activity) {
        requestPermission(activity, Manifest.permission.ACCESS_FINE_LOCATION, REQUEST_LOCATION_CODE)
    }

    fun hasLocationPermission(context: Context): Boolean {
        return hasPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
    }

    fun checkReadExternalStoragePermission(activity: Activity, listener: PermissionAskListener) {
        checkPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE, listener)
    }

    fun requestReadExternalStoragePermission(activity: Activity) {
        requestPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE, REQUEST_READ_EXTERNAL_STORAGE_CODE)
    }

    fun hasReadExternalStoragePermission(context: Context): Boolean {
        return hasPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    fun checkWriteExternalStoragePermission(activity: Activity, listener: PermissionAskListener) {
        checkPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE, listener)
    }

    fun requestWriteExternalStoragePermission(activity: Activity) {
        requestPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE, REQUEST_WRITE_EXTERNAL_STORAGE_CODE)
    }

    fun hasWriteExternalStoragePermission(context: Context): Boolean {
        return hasPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE)
    }

    fun checkCameraPermission(activity: Activity, listener: PermissionAskListener) {
        checkPermission(activity, Manifest.permission.CAMERA, listener)
    }

    fun requestCameraPermission(activity: Activity) {
        requestPermission(activity, Manifest.permission.CAMERA, REQUEST_CAMERA_CODE)
    }

    fun hasCameraPermission(context: Context): Boolean {
        return hasPermission(context, Manifest.permission.CAMERA)
    }

    fun requestVibrationPermission(activity: Activity) {
        requestPermission(activity, Manifest.permission.VIBRATE, REQUEST_VIBRATION_CODE)
    }

    fun hasVibrationPermission(context: Context): Boolean {
        return hasPermission(context, Manifest.permission.VIBRATE)
    }

    interface PermissionAskListener {
        /*
         * Callback to ask permission
         * */
        fun onNeedPermission()

        /*
         * Callback on permission denied
         * */
        fun onPermissionPreviouslyDenied()

        /*
         * Callback on permission "Never show again" checked and denied
         * */
        fun onPermissionDisabled()

        /*
         * Callback on permission granted
         * */
        fun onPermissionGranted()
    }

