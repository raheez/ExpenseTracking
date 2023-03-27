package com.example.expensetracking.ui.main.viewmodel;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0006\u0010\u001b\u001a\u00020\u0018J\u0006\u0010\u001c\u001a\u00020\u0018J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020\tJ\u000e\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"J\u0006\u0010#\u001a\u00020\u0018R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\t0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f\u00a8\u0006$"}, d2 = {"Lcom/example/expensetracking/ui/main/viewmodel/TransactionViewmodel;", "Landroidx/lifecycle/ViewModel;", "mRepo", "Lcom/example/expensetracking/repo/TransactionRepo;", "(Lcom/example/expensetracking/repo/TransactionRepo;)V", "_detailState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/expensetracking/utils/viewState/DetailState;", "_transactionFilter", "", "_uiState", "Lcom/example/expensetracking/utils/viewState/ViewState;", "detailState", "Lkotlinx/coroutines/flow/StateFlow;", "getDetailState", "()Lkotlinx/coroutines/flow/StateFlow;", "getMRepo", "()Lcom/example/expensetracking/repo/TransactionRepo;", "transactionFilter", "getTransactionFilter", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "uiState", "getUiState", "addNewTransaction", "", "transactions", "Lcom/example/expensetracking/model/Transactions;", "allExpense", "allIncome", "getAllTransactions", "Lkotlinx/coroutines/Job;", "type", "getTransactionByID", "id", "", "overAll", "app_debug"})
public final class TransactionViewmodel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.example.expensetracking.repo.TransactionRepo mRepo = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.expensetracking.utils.viewState.ViewState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.expensetracking.utils.viewState.ViewState> uiState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.expensetracking.utils.viewState.DetailState> _detailState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.example.expensetracking.utils.viewState.DetailState> detailState = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _transactionFilter = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> transactionFilter = null;
    
    @javax.inject.Inject()
    public TransactionViewmodel(@org.jetbrains.annotations.NotNull()
    com.example.expensetracking.repo.TransactionRepo mRepo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.expensetracking.repo.TransactionRepo getMRepo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.expensetracking.utils.viewState.ViewState> getUiState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.example.expensetracking.utils.viewState.DetailState> getDetailState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getTransactionFilter() {
        return null;
    }
    
    public final void addNewTransaction(@org.jetbrains.annotations.NotNull()
    com.example.expensetracking.model.Transactions transactions) {
    }
    
    public final void getTransactionByID(int id) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlinx.coroutines.Job getAllTransactions(@org.jetbrains.annotations.NotNull()
    java.lang.String type) {
        return null;
    }
    
    public final void allIncome() {
    }
    
    public final void allExpense() {
    }
    
    public final void overAll() {
    }
}