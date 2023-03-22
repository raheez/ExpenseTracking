package com.example.expensetracking.utils.viewState

import com.example.expensetracking.model.Transactions

sealed class ViewState {
    object Loading : ViewState()
    object Empty : ViewState()
    data class Success(val transactions: List<Transactions>): ViewState()
    data class Error(val exception: Throwable) : ViewState()

}