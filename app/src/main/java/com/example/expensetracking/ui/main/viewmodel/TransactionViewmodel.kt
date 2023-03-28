package com.example.expensetracking.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.expensetracking.model.Transactions
import com.example.expensetracking.repo.TransactionRepo
import com.example.expensetracking.utils.viewState.DetailState
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

    private val _detailState = MutableStateFlow<DetailState>(DetailState.Loading)
    val detailState :StateFlow<DetailState> = _detailState

    private val _transactionFilter = MutableStateFlow("Overall")
    val transactionFilter = _transactionFilter


    fun addNewTransaction(transactions: Transactions){
        viewModelScope.launch(){
            mRepo.insert(transactions)
        }
    }

    fun updateTransaction(transactions: Transactions){
        viewModelScope.launch(){
            mRepo.update(transactions)
        }
    }

    fun getTransactionByID(id : Int){
        _detailState.value = DetailState.Loading
        viewModelScope.launch {
            mRepo.getById(id)
            mRepo.getById(id).collect{
                result : Transactions?->
                if (result!=null){
                    _detailState.value = DetailState.Success(result)

                }
            }
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


    fun allIncome(){
        _transactionFilter.value = "income"
    }

    fun allExpense(){
        _transactionFilter.value = "expense"
    }

    fun overAll(){
        _transactionFilter.value = "Overall"
    }

}