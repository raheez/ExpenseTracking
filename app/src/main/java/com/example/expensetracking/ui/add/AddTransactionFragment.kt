package com.example.expensetracking.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.expensetracking.R
import com.example.expensetracking.databinding.FragmentAddTransactionBinding
import com.example.expensetracking.model.Transactions
import com.example.expensetracking.ui.main.viewmodel.TransactionViewmodel
import com.example.expensetracking.ui.base.BaseFragment
import com.example.expensetracking.utils.viewState.Constants
import com.example.expensetracking.utils.viewState.transformIntoDatePicker
import java.lang.Double.parseDouble
import java.util.Date


class AddTransactionFragment : BaseFragment<FragmentAddTransactionBinding, TransactionViewmodel>() {

    override val viewModel: TransactionViewmodel by activityViewModels()
    var mAmount = 100
    var mId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAddTransactionBinding {
        return FragmentAddTransactionBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

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

            binding.addTransactionLayout?.apply {

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
                            viewModel.addNewTransaction(transactions = transactions)
                            findNavController().navigate(
                                R.id.action_addTransactionFragment_to_dashboardFragment
                            )
                        }
                    }
                }

            }
        }

    }

    private fun getTransactionContent(): Transactions = binding.addTransactionLayout.let {
        val title = it.etTitle.text.toString()
        val amount = parseDouble(it.etAmount.text.toString())
        val transactionType = it.etTransactionType.text.toString()
        val tag = it.etTag.text.toString()
        val date = it.etWhen.text.toString()
        val note = it.etNote.text.toString()
        return Transactions(title, amount, transactionType, tag, date, note)
    }
}
