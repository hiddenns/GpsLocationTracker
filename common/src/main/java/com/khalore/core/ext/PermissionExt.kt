package com.khalore.core.ext

import android.Manifest
import android.os.Build
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment

fun getLocationPermissions() = when {
    Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q -> arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION,
        Manifest.permission.ACCESS_BACKGROUND_LOCATION
    )
    else -> arrayOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
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

interface PermissionCallback {
    fun onAllGranted()

    fun onNotGranted(notGrantedPermissions: Set<String>)
}
