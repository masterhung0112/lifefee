package com.hungbn

import androidx.lifecycle.ViewModel
import com.badoo.reaktive.subject.publish.PublishSubject
import com.hungbn.expenses.ExpenseOperand

class ExpenseItemInputViewModel: ViewModel() {
    var expenseItemSubject = PublishSubject<ExpenseOperand>()

    fun addMoney(value: Long) {
        expenseItemSubject.onNext(value = ExpenseOperand(value))
    }
}