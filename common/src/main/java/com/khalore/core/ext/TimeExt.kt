package com.khalore.core.ext

import java.text.SimpleDateFormat
import java.util.Locale


object TimeFormatter {

    private const val TIME_DATE_PATTERN = "HH:mm dd.MM.yyyy"

    private val formatHhMmDdMmYyyy = SimpleDateFormat(TIME_DATE_PATTERN, Locale.getDefault())

    fun formatHhMmDdMmYyyy(timeMillis: Long) =
        formatHhMmDdMmYyyy.format(timeMillis)

}