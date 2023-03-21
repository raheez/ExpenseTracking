package com.example.expensetracking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expensetracking.data.AppDatabase
import com.example.expensetracking.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var  mBinding : ActivityMainBinding
    lateinit var mDb :AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding?.root)

        createDatabase()
        mBinding?.createButton?.setOnClickListener {

        }
    }

    private fun createDatabase(){
//        mDb = Room.databaseBuilder(this,AppDatabase::class.java,"transaction.db").fallbackToDestructiveMigration().build()
    }
}