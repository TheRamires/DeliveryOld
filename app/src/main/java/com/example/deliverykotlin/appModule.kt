package com.example.deliverykotlin

import com.example.deliverykotlin.components.favorites.FavoritesRepositoriy
import com.example.deliverykotlin.components.favorites.FavoritesViewModel
import com.example.deliverykotlin.components.menu.MenuRepositoriy
import com.example.deliverykotlin.components.menu.MenuViewModel
import com.example.deliverykotlin.room.AppDatabase
import com.example.deliverykotlin.room.DaoMenu
import org.koin.dsl.module

val appModule = module {
    single { AppDatabase.getInstance(get()).daoMenu() }
    single { AppDatabase.getInstance(get()).daoFavorites() }

    single { SplashRepositoriy(get()) }
    single { MenuRepositoriy(get()) }
    single { FavoritesRepositoriy(get()) }

    single { SplashViewModel(get()) }
    single { MenuViewModel(get()) }
    single { FavoritesViewModel(get()) }
    single { CartViewModel() }
}

