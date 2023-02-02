package com.poomgames.catfore.presentation.di.components

import android.content.Context
import com.poomgames.catfore.presentation.viewmodels.GameViewModelFactory
import com.poomgames.catfore.presentation.viewmodels.LoadingViewModelFactory
import com.poomgames.catfore.presentation.viewmodels.ShopViewModelFactory
import com.poomgames.data.local.di.modules.LocalDataModule
import com.poomgames.data.local.di.modules.RepositoryModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [LocalDataModule::class, RepositoryModule::class])
interface AppComponent {

    fun loadingViewModelFactory(): LoadingViewModelFactory
    fun gameViewModelFactory(): GameViewModelFactory
    fun shopViewModelFactory(): ShopViewModelFactory

    @Component.Factory
    interface AppComponentFactory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}