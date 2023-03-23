package com.example.expensetracking.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensetracking.model.Transactions
import com.example.expensetracking.repo.TransactionRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewmodel @Inject constructor( val mRepo : TransactionRepo)  : ViewModel() {

    init {
        Log.d("transaction_view_model","initialised")
    }

    fun addNewTransaction(transactions: Transactions){
        viewModelScope.launch(){
            mRepo.insert(transactions)
        }
    }

}