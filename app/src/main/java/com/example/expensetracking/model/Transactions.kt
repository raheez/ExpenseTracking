package com.example.expensetracking.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.text.DateFormat

@Entity(tableName = "all_transactions")
data class Transactions(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var mID: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "amount")
    var amount: Int,

    @ColumnInfo(name = "createdAt")
    var createdAt: Long =
        System.currentTimeMillis(),

    @ColumnInfo(name = "transactionType")
    var transactionType: String,

    ) : java.io.Serializable {
    val createdAtDateFormat: String
        get() = DateFormat.getDateTimeInstance()
            .format(createdAt) // Date Format: Jan 11, 2021, 11:30 AM
}