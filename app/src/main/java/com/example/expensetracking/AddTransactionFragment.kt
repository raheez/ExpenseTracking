package com.example.expensetracking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.expensetracking.databinding.FragmentAddTransactionBinding
import com.example.expensetracking.model.Transactions
import com.example.expensetracking.ui.main.viewmodel.TransactionViewmodel
import com.example.expensetracking.ui.base.BaseFragment
import com.example.expensetracking.utils.viewState.DetailState


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

        binding.btnSaveTransaction.setOnClickListener {

            mAmount = mAmount + 100
            mId = mId+1
            var mStrType = ""
            if (mId%2==0){
                mStrType = "income"
            }else{
                mStrType = "expense"
            }
            val mTransactions = Transactions(mId,"food${mId}",mAmount,System.currentTimeMillis(),mStrType)
            viewModel.addNewTransaction(transactions = mTransactions)
//          }
        }

    }
}