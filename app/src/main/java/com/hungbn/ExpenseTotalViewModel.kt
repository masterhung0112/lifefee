package com.hungbn

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.hungbn.expenses.AddExpenseOperator
import com.hungbn.expenses.ExpenseOperand

class ExpenseTotalViewModel : ViewModel() {
    var expenses = MutableLiveData<List<ExpenseOperand>>(listOf())

    // Get the total value of expense
    var totalExpense = Transformations.map(expenses) {
        AddExpenseOperator().apply(it)
    }
}