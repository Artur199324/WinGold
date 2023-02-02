package com.poomgames.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.poomgames.data.local.enteties.DbShopItem

@Dao
interface ShopDao {

    @Query("SELECT * FROM DbShopItem")
    suspend fun getAllShopItems(): List<DbShopItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShopItem(shopItem: DbShopItem)
}