package com.khalore.core.ext

import android.Manifest
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

// TODO location
fun getReadExternalStoragePermissions() = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU -> arrayOf(
        Manifest.permission.READ_MEDIA_AUDIO,
        Manifest.permission.READ_MEDIA_IMAGES,
        Manifest.permission.ACCESS_MEDIA_LOCATION
    )
    Build.VERSION.SDK_INT == Build.VERSION_CODES.Q -> arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.ACCESS_MEDIA_LOCATION
    )
    Build.VERSION.SDK_INT <= Build.VERSION_CODES.Q -> arrayOf(
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE,
    )
    else -> arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.ACCESS_MEDIA_LOCATION
    )
}

fun Map<String, Boolean>.isAllGranted(): Boolean {
    var isGranted = true
    forEach { (_, granted) ->
        isGranted = isGranted && granted
    }
    return isGranted
}

fun Map<String, Boolean>.findNotGrantedPermissions() = map {
    if (!it.value)
        it.key
    else null
}.filterNotNull().toSet()

fun Fragment.getReadFilesPermissionsLauncher(callback: PermissionCallback) =
    registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { result ->
        if (result.isAllGranted())
            callback.onAllGranted()
        else
            callback.onNotGranted(result.findNotGrantedPermissions())
    }

interface PermissionCallback {
    fun onAllGranted()

    fun onNotGranted(notGrantedPermissions: Set<String>)
}
