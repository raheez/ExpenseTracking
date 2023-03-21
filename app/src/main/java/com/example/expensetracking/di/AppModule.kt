package com.example.expensetracking.di

import android.content.Context
import androidx.room.Room
import com.example.expensetracking.data.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun getAppDatabase(@ApplicationContext context: Context): AppDatabase =
         Room.databaseBuilder(context,AppDatabase::class.java,"transaction.db")
            .fallbackToDestructiveMigration().build()

}