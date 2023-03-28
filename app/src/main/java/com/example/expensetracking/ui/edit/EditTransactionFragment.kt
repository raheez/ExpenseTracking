package com.example.expensetracking.ui.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.expensetracking.R
import com.example.expensetracking.databinding.FragmentEditTransactionBinding
import com.example.expensetracking.model.Transactions
import com.example.expensetracking.ui.base.BaseFragment
import com.example.expensetracking.ui.main.viewmodel.TransactionViewmodel
import com.example.expensetracking.utils.viewState.Constants
import com.example.expensetracking.utils.viewState.transformIntoDatePicker
import java.lang.Double
import java.util.*
import kotlin.apply
import kotlin.getValue
import kotlin.isNaN
import kotlin.let
import kotlin.toString
import kotlin.with

class EditTransactionFragment : BaseFragment<FragmentEditTransactionBinding,TransactionViewmodel>() {

    private val args : EditTransactionFragmentArgs by navArgs()

    override val viewModel: TransactionViewmodel by activityViewModels()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEditTransactionBinding {
        return FragmentEditTransactionBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val transaction = args.transactions
        initViews()
        loadData(transaction)
    }




    private fun initViews() {

        val transactionTypeAdapter = ArrayAdapter(
            requireContext(),
            R.layout.item_autocomplete_layout,
            Constants.transactionType
        )
        val tagsAdapter = ArrayAdapter(
            requireContext(),
            R.layout.item_autocomplete_layout,
            Constants.transactionTags
        )

        with(binding) {

            addTransactionLayout.etTransactionType.setAdapter(transactionTypeAdapter)
            addTransactionLayout.etTag.setAdapter(tagsAdapter)


            addTransactionLayout.etWhen.transformIntoDatePicker(
                requireContext(),
                "dd/MM/yyyy",
                Date()
            )
        }

        binding.btnSaveTransaction.setOnClickListener {

            binding.addTransactionLayout.apply {

                val transactions = getTransactionContent()
                transactions.let {
                    when {
                        it.title.isEmpty() -> {
                            this.etTitleView.error = "title must not be empty"
                        }
                        it.amount.isNaN() -> {
                            this.etAmount.error = "Amount must not be empty"
                        }
                        it.transactionType.isEmpty() -> {
                            this.etTransactionType.error = "Transaction type must not be empty"
                        }
                        it.tag.isEmpty() -> {
                            this.etTag.error = "Tag must not be empty"
                        }
                        it.date.isEmpty() -> {
                            this.etWhen.error = "Date must not be empty"
                        }
                        it.note.isEmpty() -> {
                            this.etNote.error = "Note must not be empty"
                        }

                        else -> {
                            viewModel.updateTransaction(transactions = transactions)
                            findNavController().popBackStack()
                        }
                    }
                }

            }
        }

    }

    private fun loadData(transaction: Transactions) {
        with(binding) {
            addTransactionLayout.etTitle.setText(transaction.title)
            addTransactionLayout.etAmount.setText(transaction.amount.toString())
            addTransactionLayout.etTransactionType.setText(transaction.transactionType, false)
            addTransactionLayout.etTag.setText(transaction.tag, false)
            addTransactionLayout.etWhen.setText(transaction.date)
            addTransactionLayout.etNote.setText(transaction.note)
        }

    }

    private fun getTransactionContent(): Transactions = binding.addTransactionLayout.let {
        val title = it.etTitle.text.toString()
        val amount = Double.parseDouble(it.etAmount.text.toString())
        val transactionType = it.etTransactionType.text.toString()
        val tag = it.etTag.text.toString()
        val date = it.etWhen.text.toString()
        val note = it.etNote.text.toString()
        val id = args.transactions.id
        return Transactions(title, amount, transactionType, tag, date,note, createdAt = System.currentTimeMillis(),id)
    }

}