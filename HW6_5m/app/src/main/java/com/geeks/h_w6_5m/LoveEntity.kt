package com.geeks.h_w6_5m

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "love")
class LoveEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val age: Int
)

