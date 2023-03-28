package com.example.expensetracking.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.expensetracking.R
import com.example.expensetracking.databinding.FragmentDashboardBinding
import com.example.expensetracking.model.Transactions
import com.example.expensetracking.ui.adapter.TransactionsAdapter
import com.example.expensetracking.ui.base.BaseFragment
import com.example.expensetracking.ui.main.viewmodel.TransactionViewmodel
import com.example.expensetracking.utils.viewState.ViewState
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class DashboardFragment : BaseFragment<FragmentDashboardBinding, TransactionViewmodel>() {

    override val viewModel: TransactionViewmodel by activityViewModels()
    lateinit var transactionAdapter: TransactionsAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView()
        initViews()
        initListeners()
        observeFilter()
        observeTransaction()
        swipeToDelete()
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater)
    }



    private fun setRecyclerView() {
        transactionAdapter = TransactionsAdapter()
        binding.rvTransactions.adapter = transactionAdapter
        binding.rvTransactions.layoutManager = LinearLayoutManager(requireActivity())
    }

    private fun initViews() {
        transactionAdapter.setOnClickListener {
            val bundle = Bundle().apply {
                putSerializable("transactions",it)
            }
            findNavController().navigate(R.id.action_dashboardFragment_to_transactionDetailFragment,bundle)
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

    private fun observeFilter() {

        lifecycleScope.launch {

            viewModel.transactionFilter.collect{ filter->
                when(filter){
                    "Overall"->{

                    }
                    "income"->{

                    }
                    "expense"->{

                    }
                }
                viewModel.getAllTransactions(filter)

            }
        }
    }


    private fun observeTransaction()  =lifecycleScope.launch {
        viewModel.uiState.collect(){ uiState->
            when(uiState){

                ViewState.Loading -> {
                    Log.d("list_is","loading")
                }
                is ViewState.Success -> {
//                    for (a in uiState.transactions){
//                        Log.d("list_is","title "+a.title + "amount" + a.amount+ "\n")
//                    }
//                    transactionAdapter.differ.submitList(uiState.transactions)
                    Log.d("list_is","Success")
                    onTransactionLoaded(uiState.transactions)

                }
                is ViewState.Error -> {
                    Log.d("list_is","error")
                }
                ViewState.Empty -> {
                    Log.d("list_is","empty")
                }

            }
        }
    }

    private fun onTransactionLoaded(transactions: List<Transactions>) =
        transactionAdapter.differ.submitList(transactions)

    private fun swipeToDelete() {
        // init item touch callback for swipe action
        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder,
            ): Boolean {
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                // get item position & delete notes
                val position = viewHolder.adapterPosition
                val transaction = transactionAdapter.differ.currentList[position]
                val transactionItem = Transactions(
                    transaction.title,
                    transaction.amount,
                    transaction.transactionType,
                    transaction.tag,
                    transaction.date,
                    transaction.note,
                    transaction.createdAt,
                    transaction.id
                )

                viewModel.deleteTransaction(transactionItem)
                Snackbar.make(
                    binding.root,
                    getString(R.string.success_transaction_delete),
                    Snackbar.LENGTH_LONG
                )
                    .apply {
                        setAction(getString(R.string.text_undo)) {
                            viewModel.addNewTransaction(transactionItem)
                        }
                        show()
                    }
            }
        }

        // attach swipe callback to rv
        ItemTouchHelper(itemTouchHelperCallback).apply {
            attachToRecyclerView(binding.rvTransactions)
        }
    }
}