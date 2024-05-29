package com.khalore.core.datasource.local.location

import com.khalore.core.dao.LocationDao
import com.khalore.core.entity.toDomain
import com.khalore.core.entity.toEntity
import com.khalore.core.model.GpsLocation
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocationLocalDataSourceImpl @Inject constructor(
    private val locationDao: LocationDao
) : LocationLocalDataSource {

    override fun getLocations() = locationDao.getLocations().map { list ->
        list.map { entity ->
            entity.toDomain()
        }
    }

    override suspend fun getLocationsCount() = runCatching {
        locationDao.getLocationsCount()
    }

    override suspend fun getLastPageLocations(pageSize: Long) = runCatching {
        locationDao.getLastPageLocations(pageSize).map { entity ->
            entity.toDomain()
        }
    }


    override suspend fun saveLocation(gpsLocation: GpsLocation) = runCatching {
        locationDao.saveLocation(gpsLocation.toEntity())
    }

}