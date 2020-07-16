package com.hungbn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.badoo.reaktive.observable.subscribe
import com.badoo.reaktive.subject.publish.PublishSubject
import com.hungbn.expenses.AddExpenseOperator
import com.hungbn.expenses.ExpenseOperand

class ExpenseTotalViewModel : ViewModel {
    var expenses = PublishSubject<List<ExpenseOperand>>()

    // Get the total value of expense
    var totalExpense: MutableLiveData<ExpenseOperand> = MutableLiveData<ExpenseOperand>()

    constructor() {
        expenses.subscribe {
            if (it.size > 0) {
                var totalValue = AddExpenseOperator().apply(it)[0]
                totalExpense.postValue(totalValue)
            }
        }
    }
}