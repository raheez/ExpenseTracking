package com.example.expensetracking.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0018\u0010$\u001a\u00020#2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010%\u001a\u00020&H\u0002J\u0012\u0010\'\u001a\u00020#2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J\b\u0010*\u001a\u00020+H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\b\"\u0004\b\u0019\u0010\nR\u001b\u0010\u001a\u001a\u00020\u001b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010 \u001a\u00020!X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/example/expensetracking/ui/main/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "appBarConfiguration", "Landroidx/navigation/ui/AppBarConfiguration;", "mAmount", "", "getMAmount", "()I", "setMAmount", "(I)V", "mBinding", "Lcom/example/expensetracking/databinding/ActivityMainBinding;", "getMBinding", "()Lcom/example/expensetracking/databinding/ActivityMainBinding;", "setMBinding", "(Lcom/example/expensetracking/databinding/ActivityMainBinding;)V", "mDb", "Lcom/example/expensetracking/data/AppDatabase;", "getMDb", "()Lcom/example/expensetracking/data/AppDatabase;", "setMDb", "(Lcom/example/expensetracking/data/AppDatabase;)V", "mId", "getMId", "setMId", "mViewmodel", "Lcom/example/expensetracking/ui/main/viewmodel/TransactionViewmodel;", "getMViewmodel", "()Lcom/example/expensetracking/ui/main/viewmodel/TransactionViewmodel;", "mViewmodel$delegate", "Lkotlin/Lazy;", "navHostFragment", "Landroidx/navigation/fragment/NavHostFragment;", "initView", "", "observeNavElements", "navController", "Landroidx/navigation/NavController;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSupportNavigateUp", "", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity {
    private androidx.navigation.fragment.NavHostFragment navHostFragment;
    private androidx.navigation.ui.AppBarConfiguration appBarConfiguration;
    public com.example.expensetracking.databinding.ActivityMainBinding mBinding;
    @javax.inject.Inject()
    public com.example.expensetracking.data.AppDatabase mDb;
    private int mAmount = 100;
    private int mId = 1;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy mViewmodel$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.expensetracking.databinding.ActivityMainBinding getMBinding() {
        return null;
    }
    
    public final void setMBinding(@org.jetbrains.annotations.NotNull()
    com.example.expensetracking.databinding.ActivityMainBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.expensetracking.data.AppDatabase getMDb() {
        return null;
    }
    
    public final void setMDb(@org.jetbrains.annotations.NotNull()
    com.example.expensetracking.data.AppDatabase p0) {
    }
    
    public final int getMAmount() {
        return 0;
    }
    
    public final void setMAmount(int p0) {
    }
    
    public final int getMId() {
        return 0;
    }
    
    public final void setMId(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.expensetracking.ui.main.viewmodel.TransactionViewmodel getMViewmodel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void observeNavElements(com.example.expensetracking.databinding.ActivityMainBinding mBinding, androidx.navigation.NavController navController) {
    }
    
    private final void initView(com.example.expensetracking.databinding.ActivityMainBinding mBinding) {
    }
    
    @java.lang.Override()
    public boolean onSupportNavigateUp() {
        return false;
    }
}