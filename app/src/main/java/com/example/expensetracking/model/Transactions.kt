package com.example.expensetracking.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "all_transactions")
data class Transactions(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var mID :Int,

    @ColumnInfo(name = "title")
    var title:String,

    @ColumnInfo(name = "amount")
    var amount: String
) :java.io.Serializable{

}