package com.example.expensetracking.ui.edit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.example.expensetracking.R
import com.example.expensetracking.databinding.FragmentEditTransactionBinding
import com.example.expensetracking.ui.base.BaseFragment
import com.example.expensetracking.ui.main.viewmodel.TransactionViewmodel

class EditTransactionFragment : BaseFragment<FragmentEditTransactionBinding,TransactionViewmodel>() {

    private val args : EditTransactionFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override val viewModel: TransactionViewmodel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_transaction, container, false)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentEditTransactionBinding {
        return FragmentEditTransactionBinding.inflate(layoutInflater)
    }

}