package com.example.deliverykotlin.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.deliverykotlin.data.*

@Database(entities = [MyEntity::class, Brand::class, Type::class, Favorites::class],
        version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun daoMenu(): DaoMenu?
    abstract fun daoFavorites(): DaoFavorites?


    companion object {

        // For Singleton instantiation
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "database")
                .fallbackToDestructiveMigration()
                .build();
        }
    }
}