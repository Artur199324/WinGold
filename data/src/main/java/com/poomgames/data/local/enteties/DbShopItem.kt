package com.poomgames.data.local.enteties

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.poomgames.domain.entities.ShopItem

@Entity
data class DbShopItem (
    @PrimaryKey
    val imageRec: Int,
    val name: String,
    val price: Int,
    var bought: Boolean,
    var isBall: Boolean,
) {
    fun mapToShopItem(dbShopItem: DbShopItem): ShopItem {
        return ShopItem(
            dbShopItem.imageRec,
            dbShopItem.name,
            dbShopItem.price,
            dbShopItem.bought,
            dbShopItem.isBall
        )
    }
}