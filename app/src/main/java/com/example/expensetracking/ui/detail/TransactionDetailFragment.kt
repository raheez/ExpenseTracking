package com.example.expensetracking.ui.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.expensetracking.R
import com.example.expensetracking.databinding.FragmentTransactionDetailBinding
import com.example.expensetracking.model.Transactions
import com.example.expensetracking.ui.base.BaseFragment
import com.example.expensetracking.ui.main.viewmodel.TransactionViewmodel
import com.example.expensetracking.utils.viewState.DetailState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class TransactionDetailFragment : BaseFragment<FragmentTransactionDetailBinding,TransactionViewmodel>() {

    private val args : TransactionDetailFragmentArgs by navArgs()
    override val viewModel: TransactionViewmodel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentTransactionDetailBinding {
        return FragmentTransactionDetailBinding.inflate(layoutInflater)
    }


    private fun initViews() {
        Log.d("detail_screen","initialised")
        val transactions = args.transactions
        getTransaction(transactions.mID)
        observeTransaction()
    }

    private fun observeTransaction()  = lifecycleScope.launch {
        viewModel.detailState.collect{
            detailState ->

            when(detailState){
                DetailState.Empty -> {
                    findNavController().navigateUp()
                }
                is DetailState.Error -> {
                    //show snackbar with error
                }
                DetailState.Loading -> {}
                is DetailState.Success -> {
                    onDetailsLoaded(detailState.transactions)
                }
            }
        }
    }

    private fun onDetailsLoaded(transactions: Transactions) = with(binding.transactionDetails){
        title.text = transactions.title
        amount.text = transactions.amount.toString()
        type.text = transactions.transactionType
        tag.text = transactions.tag
        date.text = transactions.date
        note.text = transactions.note
        createdAt.text = transactions.createdAt.toString()

        val bundle =Bundle().apply {
            putSerializable("transactions",transactions)
        }
        binding.editTransaction.setOnClickListener {
            findNavController().navigate(
                R.id.action_transactionDetailFragment_to_editTransactionFragment,bundle
            )
        }

    }

    private fun getTransaction(id: Int) {
        Log.d("detail_screen","getting_transaction")
        viewModel.getTransactionByID(id)
    }


    private fun initListener() {


    }

}