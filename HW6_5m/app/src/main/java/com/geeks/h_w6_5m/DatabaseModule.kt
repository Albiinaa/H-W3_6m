package com.geeks.h_w6_5m

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(appContext:Context):LoveDatabase{
        return Room.databaseBuilder(
            appContext,
            LoveDatabase::class.java,
            "love_database"
        ).build()
    }
    @Singleton
    @Provides
    fun providesLoveDao(database: LoveDatabase): LoveDao{
        return database.loveDao()
    }
}