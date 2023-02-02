package com.poomgames.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.poomgames.data.local.dao.FactDao
import com.poomgames.data.local.dao.ShopDao
import com.poomgames.data.local.enteties.DbFact
import com.poomgames.data.local.enteties.DbShopItem

@Database(entities = [DbFact::class, DbShopItem::class], version = 1)
abstract class Database : RoomDatabase() {
    abstract fun getFactDao(): FactDao
    abstract fun getShopDao(): ShopDao
}