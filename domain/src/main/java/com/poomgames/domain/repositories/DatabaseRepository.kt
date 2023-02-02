package com.poomgames.domain.repositories

import com.poomgames.domain.entities.Fact
import com.poomgames.domain.entities.ShopItem

interface DatabaseRepository {
    suspend fun getFacts(): List<Fact>
    suspend fun insertFact(fact: Fact)
    suspend fun getShopItems(): List<ShopItem>
    suspend fun insertShopItem(shopItem: ShopItem)
}