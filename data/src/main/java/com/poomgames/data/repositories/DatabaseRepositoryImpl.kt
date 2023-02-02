package com.poomgames.data.repositories

import com.poomgames.data.local.dao.FactDao
import com.poomgames.data.local.dao.ShopDao
import com.poomgames.data.local.enteties.DbFact
import com.poomgames.data.local.enteties.DbShopItem
import com.poomgames.domain.entities.Fact
import com.poomgames.domain.entities.ShopItem
import com.poomgames.domain.repositories.DatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(
    private val factDao: FactDao,
    private val shopDao: ShopDao,
) : DatabaseRepository {

    override suspend fun getFacts() = withContext(Dispatchers.IO) {
        factDao.getAllFacts().map { it.mapToHint(it) }
    }

    override suspend fun insertFact(fact: Fact) = withContext(Dispatchers.IO) {
        factDao.insertFacts(DbFact(fact.hintText))
    }

    override suspend fun getShopItems() = withContext(Dispatchers.IO) {
        shopDao.getAllShopItems().map { it.mapToShopItem(it) }
    }

    override suspend fun insertShopItem(shopItem: ShopItem) = withContext(Dispatchers.IO) {
        shopDao.insertShopItem(
            DbShopItem(
                shopItem.imageRec,
                shopItem.name,
                shopItem.price,
                shopItem.bought,
                shopItem.isBall
            )
        )
    }
}