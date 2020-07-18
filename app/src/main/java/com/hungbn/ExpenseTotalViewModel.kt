package com.hungbn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.badoo.reaktive.observable.subscribe
import com.badoo.reaktive.subject.publish.PublishSubject
import com.hungbn.expenses.AddExpenseOperator
import com.hungbn.expenses.ExpenseOperand

class ExpenseTotalViewModel : ViewModel() {
//    var expenses = PublishSubject<List<ExpenseOperand>>()
    var expenses = MutableLiveData<List<ExpenseOperand>>(listOf())

    // Get the total value of list in expense
    var totalExpense = MutableLiveData<String>()

    fun setNewExpenses(newExpenses: List<ExpenseOperand>) {
        expenses.value = newExpenses
        totalExpense.value = AddExpenseOperator().apply(newExpenses)[0].value.toString()
    }
}