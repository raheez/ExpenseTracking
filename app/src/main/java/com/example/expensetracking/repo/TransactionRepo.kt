package com.example.expensetracking.repo

import com.example.expensetracking.data.AppDatabase
import com.example.expensetracking.data.TransactionDao
import com.example.expensetracking.model.Transactions
import javax.inject.Inject

class TransactionRepo @Inject constructor(private val appDatabase: AppDatabase) {


    suspend fun insert(transactions: Transactions){
        appDatabase.getTransactionDao().insertTransaction(transactions)
    }

    suspend fun update(transactions: Transactions){
        appDatabase.getTransactionDao().updateTransaction(transactions)
    }

    suspend fun delete(transactions: Transactions){
        appDatabase.getTransactionDao().deleteTransaction(transactions)
    }

    suspend fun getAllTransactions(){
        appDatabase.getTransactionDao().getAllTransaction()
    }

    suspend fun getAllSingleTransactions(transactionsType: String){
        if (transactionsType=="Overall"){
            getAllTransactions()
        }else{
            appDatabase.getTransactionDao().getAllSingleTransaction(transactionsType)
        }
    }

    fun getById(id:Int) = appDatabase.getTransactionDao().getTransactionById(id)

    suspend fun deleteById(id: Int) =appDatabase.getTransactionDao().deleteTransactionByID(id)


}