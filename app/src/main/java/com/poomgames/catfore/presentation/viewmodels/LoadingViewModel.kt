package com.poomgames.catfore.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.poomgames.domain.entities.Fact
import com.poomgames.domain.repositories.DatabaseRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

class LoadingViewModel @Inject constructor(
    private val databaseRepository: DatabaseRepository,
) : ViewModel() {

    fun getRandomFact() = liveData {
        emit(databaseRepository.getFacts().random())
    }

    fun insertFacts() {
        viewModelScope.launch {
            databaseRepository.insertFact(Fact("Football is the most popular sport in the world"))
            databaseRepository.insertFact(Fact("Football was invented in China around 476 B.C."))
            databaseRepository.insertFact(Fact("More than 3.5 billion people watch the FIFA World Cup"))
        }
    }
}

class LoadingViewModelFactory @Inject constructor(
    myViewModelProvider: Provider<LoadingViewModel>
) : ViewModelProvider.Factory {

    private val providers = mapOf<Class<*>, Provider<out ViewModel>>(
        LoadingViewModel::class.java to myViewModelProvider
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return providers[modelClass]!!.get() as T
    }
}
