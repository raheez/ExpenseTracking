package com.example.expensetracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expensetracking.data.AppDatabase
import com.example.expensetracking.databinding.ActivityMainBinding
import com.example.expensetracking.model.Transactions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var  mBinding : ActivityMainBinding
    @Inject lateinit var mDb :AppDatabase
    var mAmount = 100
    var mId = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding?.root)

        //createDatabase()
        mBinding?.createButton?.setOnClickListener {
            mAmount = mAmount+100
            mId = mId+1
            val mTransactions = Transactions(mId,"food${mId}",mAmount)
            lifecycleScope.launch {
                mDb.getTransactionDao().insertTransaction(mTransactions)
            }
        }
    }

    private fun createDatabase(){
        mDb = Room.databaseBuilder(this,AppDatabase::class.java,"transaction.db").fallbackToDestructiveMigration().build()
    }
}