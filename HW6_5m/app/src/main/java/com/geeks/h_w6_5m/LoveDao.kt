package com.geeks.h_w6_5m

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoveDao {
    @Insert
    suspend fun insertLove(loveEntity: LoveEntity)
    @Delete
    suspend fun deleteLove(LoveEntity: LoveEntity)

    @Query("SELECT * FROM love" )
    suspend fun getAllLove():List<LoveEntity>
}