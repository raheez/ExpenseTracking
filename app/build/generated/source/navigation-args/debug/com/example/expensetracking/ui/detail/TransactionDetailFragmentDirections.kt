package com.example.expensetracking.ui.detail

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.expensetracking.R
import com.example.expensetracking.model.Transactions
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress

public class TransactionDetailFragmentDirections private constructor() {
  private data class ActionTransactionDetailFragmentToEditTransactionFragment(
    public val transactions: Transactions
  ) : NavDirections {
    public override val actionId: Int =
        R.id.action_transactionDetailFragment_to_editTransactionFragment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(Transactions::class.java)) {
          result.putParcelable("transactions", this.transactions as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(Transactions::class.java)) {
          result.putSerializable("transactions", this.transactions as Serializable)
        } else {
          throw UnsupportedOperationException(Transactions::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun actionTransactionDetailFragmentToDashboardFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_transactionDetailFragment_to_dashboardFragment)

    public fun actionTransactionDetailFragmentToEditTransactionFragment(transactions: Transactions):
        NavDirections = ActionTransactionDetailFragmentToEditTransactionFragment(transactions)
  }
}
