package com.example.expensetracking.ui.add

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.example.expensetracking.R

public class AddTransactionFragmentDirections private constructor() {
  public companion object {
    public fun actionAddTransactionFragmentToDashboardFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_addTransactionFragment_to_dashboardFragment)
  }
}
