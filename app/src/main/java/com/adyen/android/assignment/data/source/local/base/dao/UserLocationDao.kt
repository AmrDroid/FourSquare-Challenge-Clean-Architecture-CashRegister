package com.adyen.android.assignment.data.source.local.base.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.adyen.android.assignment.domain.model.UserLocation


/**
 * Provides access to [UserLocation] underlying database
 * */
@Dao
interface UserLocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(userLocation: UserLocation?): Long?

    @Query("SELECT * FROM UserLocation LIMIT 1")
    suspend fun load(): UserLocation?

}