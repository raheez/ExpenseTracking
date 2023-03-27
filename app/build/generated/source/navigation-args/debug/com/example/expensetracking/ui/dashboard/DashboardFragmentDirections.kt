package com.example.expensetracking.ui.dashboard

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

public class DashboardFragmentDirections private constructor() {
  private data class ActionDashboardFragmentToTransactionDetailFragment(
    public val transactions: Transactions
  ) : NavDirections {
    public override val actionId: Int = R.id.action_dashboardFragment_to_transactionDetailFragment

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
    public fun actionDashboardFragmentToTransactionDetailFragment(transactions: Transactions):
        NavDirections = ActionDashboardFragmentToTransactionDetailFragment(transactions)

    public fun actionDashboardFragmentToAddTransactionFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dashboardFragment_to_addTransactionFragment)
  }
}
