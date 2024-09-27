package com.geeks.h_w6_5m

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LoveEntity::class], version = 1)
abstract class LoveDatabase : RoomDatabase(){
    abstract fun loveDao(): LoveDao
}