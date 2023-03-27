package com.example.expensetracking.data

import androidx.room.*
import com.example.expensetracking.model.Transactions
import kotlinx.coroutines.flow.Flow

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTransaction(transaction: Transactions)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateTransaction(transaction: Transactions)

    @Delete
    suspend fun deleteTransaction(transaction: Transactions)

    @Query("SELECT * FROM all_transactions ORDER by createdAt DESC")
    fun getAllTransaction(): Flow<List<Transactions>>

    @Query("SELECT * FROM all_transactions WHERE transactionType == :transactionsType ORDER by createdAt DESC")
    fun getAllSingleTransaction(transactionsType: String): Flow<List<Transactions>>

    @Query("SELECT * FROM all_transactions WHERE id = :id")
    fun getTransactionById(id: Int): Flow<Transactions>

    @Query("DELETE FROM all_transactions WHERE id = :id")
    suspend fun deleteTransactionByID(id: Int)

}