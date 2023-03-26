package com.example.expensetracking.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.expensetracking.databinding.FragmentTransactionDetailBinding
import com.example.expensetracking.ui.base.BaseFragment
import com.example.expensetracking.ui.main.viewmodel.TransactionViewmodel


class TransactionDetailFragment : BaseFragment<FragmentTransactionDetailBinding,TransactionViewmodel>() {

    private val args : TransactionDetailFragmentArgs by navArgs()
    override val viewModel: TransactionViewmodel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val transactions = args.transactions
        binding.amount.text = transactions.amount.toString()
        binding.type.text = transactions.transactionType.toString()
    }


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTransactionDetailBinding {
        return FragmentTransactionDetailBinding.inflate(layoutInflater)
    }
}