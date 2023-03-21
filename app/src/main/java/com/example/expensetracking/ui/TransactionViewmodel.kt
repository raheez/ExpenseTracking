package com.example.expensetracking.ui

import androidx.lifecycle.ViewModel
import com.example.expensetracking.data.AppDatabase
import com.example.expensetracking.model.Transactions
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TransactionViewmodel @Inject constructor( val mDb : AppDatabase)  : ViewModel() {

    init {
    }

    suspend fun addItem(transactions: Transactions){
        mDb.getTransactionDao().insertTransaction(transactions)
    }

}