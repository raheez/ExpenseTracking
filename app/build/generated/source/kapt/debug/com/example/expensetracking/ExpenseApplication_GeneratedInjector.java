package com.example.expensetracking;

import dagger.hilt.InstallIn;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = ExpenseApplication.class
)
@GeneratedEntryPoint
@InstallIn(SingletonComponent.class)
public interface ExpenseApplication_GeneratedInjector {
  void injectExpenseApplication(ExpenseApplication expenseApplication);
}
