package com.poomgames.catfore.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.poomgames.catfore.R
import com.poomgames.domain.entities.ShopItem
import com.poomgames.domain.repositories.DatabaseRepository
import com.poomgames.domain.repositories.SharedRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class GameViewModel @Inject constructor(
    private val sharedRepository: SharedRepository,
    private val databaseRepository: DatabaseRepository
) : ViewModel() {

    fun getScore() = liveData { emit(sharedRepository.getScore()) }

    fun setScore(score: Int) = sharedRepository.setScore(score)

    fun getBackground() = sharedRepository.getBackground(R.drawable.background)

    fun getBall() = sharedRepository.getBall(R.drawable.ball)

    fun insertShopItems() {
        if (sharedRepository.isFirstStart()) {
            viewModelScope.launch {
                databaseRepository.insertShopItem(
                    ShopItem(
                        R.drawable.ball,
                        "Default ball",
                        0,
                        bought = true,
                        isBall = true
                    )
                )
                databaseRepository.insertShopItem(
                    ShopItem(
                        R.drawable.background,
                        "Default background",
                        0,
                        bought = true,
                        isBall = false
                    )
                )
                databaseRepository.insertShopItem(
                    ShopItem(
                        R.drawable.ic_baseline_sports_basketball_24,
                        "White ball",
                        50,
                        bought = false,
                        isBall = true
                    )
                )
                databaseRepository.insertShopItem(
                    ShopItem(
                        R.drawable.background_2,
                        "Modern background",
                        100,
                        bought = false,
                        isBall = false
                    )
                )
            }
        }
    }
}

class GameViewModelFactory @Inject constructor(
    myViewModelProvider: Provider<GameViewModel>
) : ViewModelProvider.Factory {

    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        GameViewModel::class.java to myViewModelProvider
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return providers[modelClass]!!.get() as T
    }
}