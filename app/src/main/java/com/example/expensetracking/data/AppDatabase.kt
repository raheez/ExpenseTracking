package com.example.expensetracking.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.expensetracking.model.Transactions

@Database(entities = [Transactions::class], version = 4, exportSchema = false)
abstract class AppDatabase :RoomDatabase() {

    abstract fun getTransactionDao() : TransactionDao
}
