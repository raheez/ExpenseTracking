package com.example.expensetracking.data;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001c\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\r0\fH\'J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\b\u001a\u00020\tH\'J\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0014"}, d2 = {"Lcom/example/expensetracking/data/TransactionDao;", "", "deleteTransaction", "", "transaction", "Lcom/example/expensetracking/model/Transactions;", "(Lcom/example/expensetracking/model/Transactions;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteTransactionByID", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllSingleTransaction", "Lkotlinx/coroutines/flow/Flow;", "", "transactionsType", "", "getAllTransaction", "getTransactionById", "insertTransaction", "updateTransaction", "app_debug"})
public abstract interface TransactionDao {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = 1)
    public abstract java.lang.Object insertTransaction(@org.jetbrains.annotations.NotNull()
    com.example.expensetracking.model.Transactions transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update(onConflict = 1)
    public abstract java.lang.Object updateTransaction(@org.jetbrains.annotations.NotNull()
    com.example.expensetracking.model.Transactions transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object deleteTransaction(@org.jetbrains.annotations.NotNull()
    com.example.expensetracking.model.Transactions transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM all_transactions ORDER by createdAt DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.expensetracking.model.Transactions>> getAllTransaction();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM all_transactions WHERE transactionType == :transactionsType ORDER by createdAt DESC")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.expensetracking.model.Transactions>> getAllSingleTransaction(@org.jetbrains.annotations.NotNull()
    java.lang.String transactionsType);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM all_transactions WHERE id = :id")
    public abstract kotlinx.coroutines.flow.Flow<com.example.expensetracking.model.Transactions> getTransactionById(int id);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM all_transactions WHERE id = :id")
    public abstract java.lang.Object deleteTransactionByID(int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
}