package com.example.expensetracking.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.expensetracking.R
import com.example.expensetracking.databinding.FragmentDashboardBinding
import com.example.expensetracking.ui.adapter.TransactionsAdapter
import com.example.expensetracking.ui.base.BaseFragment
import com.example.expensetracking.ui.main.viewmodel.TransactionViewmodel
import com.example.expensetracking.utils.viewState.ViewState
import kotlinx.coroutines.launch

class DashboardFragment : BaseFragment<FragmentDashboardBinding, TransactionViewmodel>() {

    override val viewModel: TransactionViewmodel by activityViewModels()
    lateinit var mAdapter: TransactionsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        initViews()
        initListeners()
        observeFilter()
        observeTransaction()
    }



    private fun setRecyclerView() {
        mAdapter = TransactionsAdapter()
        binding.rvTransactions.adapter = mAdapter
        binding.rvTransactions.layoutManager = LinearLayoutManager(requireActivity())
    }
    private fun initViews() {
        mAdapter.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("transactions",it)
            }
            findNavController().navigate(R.id.action_dashboardFragment_to_transactionDetailFragment,bundle)
        }
    }


    private fun observeFilter() {

        lifecycleScope.launch {

            viewModel.transactionFilter.collect{ filter->
                when(filter){
                    "Overall"->{

                    }
                    "icome"->{

                    }
                    "expense"->{

                    }
                }
                viewModel.getAllTransactions(filter)

            }
        }
    }


    private fun observeTransaction()  =lifecycleScope.launch {
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
                    mAdapter.differ.submitList(uiState.transactions)

                }
            }
        }
    }

    private fun initListeners() {

        binding.btnAddTransaction.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_addTransactionFragment)
        }

        binding.btnOverall.setOnClickListener {
            viewModel.overAll()
        }

        binding.btnIncome.setOnClickListener {
            viewModel.allIncome()
        }

        binding.btnExpense.setOnClickListener {
            viewModel.allExpense()
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