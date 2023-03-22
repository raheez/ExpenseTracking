package com.example.expensetracking.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.expensetracking.R
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

        initListeners()
    }

    private fun initListeners() {
        binding.btnDetail?.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_transactionDetailFragment)
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