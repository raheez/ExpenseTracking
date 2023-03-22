package com.example.expensetracking.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.expensetracking.databinding.FragmentDashboardBinding
import com.example.expensetracking.ui.TransactionViewmodel
import com.example.expensetracking.ui.base.BaseFragment

class DashboardFragment : BaseFragment<FragmentDashboardBinding,TransactionViewmodel>() {
    override val viewModel: TransactionViewmodel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding? {

        return FragmentDashboardBinding.inflate(inflater)

    }

}