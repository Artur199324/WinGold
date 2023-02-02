package com.poomgames.catfore.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.poomgames.domain.entities.ShopItem
import com.poomgames.domain.repositories.DatabaseRepository
import com.poomgames.domain.repositories.SharedRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class ShopViewModel @Inject constructor(
    private val sharedRepository: SharedRepository,
    private val databaseRepository: DatabaseRepository,
) : ViewModel() {

    fun getShopItems() = liveData { emit(databaseRepository.getShopItems()) }

    fun getScore() = liveData { emit(sharedRepository.getScore()) }

    fun buyShopItem(shopItem: ShopItem): String {
        if (shopItem.bought) {
            changeItem(shopItem)
            return "Item changed!"
        }
        if (shopItem.price > sharedRepository.getScore()) return "You don't have much money!"

        sharedRepository.setScore(-shopItem.price)
        shopItem.bought = true
        changeItem(shopItem)
        viewModelScope.launch { databaseRepository.insertShopItem(shopItem) }
        return "Success!"
    }

    private fun changeItem(shopItem: ShopItem) {
        if (shopItem.isBall) {
            sharedRepository.setBall(shopItem.imageRec)
        } else {
            sharedRepository.setBackground(shopItem.imageRec)
        }
    }

}

class ShopViewModelFactory @Inject constructor(
    myViewModelProvider: Provider<ShopViewModel>
) : ViewModelProvider.Factory {

    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        ShopViewModel::class.java to myViewModelProvider
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return providers[modelClass]!!.get() as T
    }
}