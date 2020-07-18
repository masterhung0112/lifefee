package com.hungbn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hungbn.expenses.ExpenseOperand

/*
 * UI will call
 * 200
 * 300
 * 500
 */
class NewExpenseViewModel : ViewModel() {

    var expenses = MutableLiveData<List<ExpenseOperand>>(listOf())

    // The initial operand

    // List of operands

    fun addExpense(value: ExpenseOperand) {
        expenses.postValue(expenses.value!!.toMutableList().plus(value))
    }

    fun removeExpenseByIndex(index: Int) {
        var newExpenses = expenses.value!!.toMutableList()
        newExpenses.removeAt(index)
        expenses.postValue(newExpenses)
    }

    fun removeExpense(value: ExpenseOperand) {
        expenses.postValue(expenses.value!!.minus(value))
    }
}