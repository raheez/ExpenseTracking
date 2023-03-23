package com.example.expensetracking.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.expensetracking.R
import com.example.expensetracking.databinding.FragmentDashboardBinding
import com.example.expensetracking.ui.main.viewmodel.TransactionViewmodel
import com.example.expensetracking.ui.base.BaseFragment
import com.example.expensetracking.utils.viewState.ViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DashboardFragment : BaseFragment<FragmentDashboardBinding, TransactionViewmodel>() {

    override val viewModel: TransactionViewmodel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListeners()
        observeFilter()
        observeTransaction()
    }


    private fun observeFilter() {

        lifecycleScope.launch {
            viewModel.getAllTransactions("expense")
        }
    }


    private fun observeTransaction()  =lifecycleScope?.launch {
        viewModel.uiState.collect(){
            uiState->
            when(uiState){
                ViewState.Empty -> {
                    Log.d("list_is","empty")
                }
                is ViewState.Error -> {
                    Log.d("list_is","error")
                }
                ViewState.Loading -> {
                    Log.d("list_is","loading")
                }
                is ViewState.Success -> {
                    for (a in uiState.transactions){
                        Log.d("list_is","title "+a.title + "amount" + a.amount+ "\n")
                    }
                }
            }
        }
    }

    private fun initListeners() {
        binding.btnDetail?.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_transactionDetailFragment)
        }

        binding.btnAdd?.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_addTransactionFragment)
        }
    }


    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {

        return FragmentDashboardBinding.inflate(inflater)

    }

}


//working logic
//class DashboardFragment :Fragment(){
//
//    lateinit var mDashboardBinding: FragmentDashboardBinding
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        mDashboardBinding = FragmentDashboardBinding.inflate(layoutInflater)
//        return mDashboardBinding.root
////        return super.onCreateView(inflater, container, savedInstanceState)
//
//    }
//}