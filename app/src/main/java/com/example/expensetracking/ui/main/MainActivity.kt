package com.example.expensetracking.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.expensetracking.R
import com.example.expensetracking.data.AppDatabase
import com.example.expensetracking.databinding.ActivityMainBinding
import com.example.expensetracking.ui.TransactionViewmodel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var navHostFragment: NavHostFragment
    private lateinit var appBarConfiguration: AppBarConfiguration

    lateinit var  mBinding : ActivityMainBinding
    @Inject lateinit var mDb :AppDatabase
    var mAmount = 100
    var mId = 1
    val mViewmodel : TransactionViewmodel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding?.root)

        initView(mBinding)
        observeNavElements(mBinding,navHostFragment.navController)

        //createDatabase()
//        mBinding?.createButton?.setOnClickListener {
//            mAmount = mAmount+100
//            mId = mId+1
//            val mTransactions = Transactions(mId,"food${mId}",mAmount)
//            lifecycleScope.launch {
//               mViewmodel.addItem(mTransactions)
//            }
//        }
    }

    private fun observeNavElements(mBinding: ActivityMainBinding, navController: NavController) {
        navController?.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.dashboardFragment->{
                    supportActionBar?.setDisplayShowTitleEnabled(true)
                    mBinding.toolbar.title = getString(R.string.text_dashboard)
                }
            }
        }
    }

    private fun initView(mBinding: ActivityMainBinding) {
        setSupportActionBar(mBinding.toolbar)
        supportActionBar!!.setDisplayShowTitleEnabled(false)

        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment)
                as NavHostFragment ?
            ?:return

        with(navHostFragment.navController){
            appBarConfiguration = AppBarConfiguration(graph)
            setupActionBarWithNavController(this,appBarConfiguration)

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        navHostFragment.navController.navigateUp()
        return super.onSupportNavigateUp()
    }
}