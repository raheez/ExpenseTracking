package com.example.expensetracking.utils.viewState

import android.view.View
import com.example.expensetracking.model.Transactions

sealed class DetailState {
    object Loading : DetailState()
    object Empty : DetailState()
    data class Success(val transactions: List<Transactions>): DetailState()
    data class Error(val exception: Throwable) : DetailState()

}

