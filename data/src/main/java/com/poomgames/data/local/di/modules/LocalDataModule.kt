package com.poomgames.data.local.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.poomgames.data.local.dao.FactDao
import com.poomgames.data.local.dao.ShopDao
import com.poomgames.data.local.database.Database
import com.poomgames.domain.Utils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): Database {
        return Room.databaseBuilder(
            context,
            Database::class.java,
            Utils.DB_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideFactDao(database: Database): FactDao {
        return database.getFactDao()
    }

    @Provides
    @Singleton
    fun provideShopDao(database: Database): ShopDao {
        return database.getShopDao()
    }

    @Provides
    @Singleton
    fun provideSharedPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(Utils.FILE_SHARED_NAME, Context.MODE_PRIVATE)
    }
}