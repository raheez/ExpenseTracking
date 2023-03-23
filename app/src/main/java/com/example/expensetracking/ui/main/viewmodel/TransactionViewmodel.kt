package com.example.expensetracking.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensetracking.model.Transactions
import com.example.expensetracking.repo.TransactionRepo
import com.example.expensetracking.utils.viewState.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewmodel @Inject constructor( val mRepo : TransactionRepo)  : ViewModel() {

    private val _uiState = MutableStateFlow<ViewState>(ViewState.Loading)
    val uiState :StateFlow<ViewState> = _uiState


    fun addNewTransaction(transactions: Transactions){
        viewModelScope.launch(){
            mRepo.insert(transactions)
        }
    }

    fun getAllTransactions(type:String) = viewModelScope?.launch {
        mRepo.getAllSingleTransactions(type).collect(){
            result->
            if (result.isNullOrEmpty()){
                _uiState.value = ViewState.Empty
            }else{
                _uiState.value = ViewState.Success(result)
            }
        }
    }

}