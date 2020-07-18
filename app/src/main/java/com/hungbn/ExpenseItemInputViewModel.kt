package com.hungbn

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.badoo.reaktive.subject.publish.PublishSubject
import com.hungbn.expenses.ExpenseOperand

class ExpenseItemInputViewModel: ViewModel() {
    var inputString = MutableLiveData<String>()
    var expenseItem = MutableLiveData<ExpenseOperand>()

    // Parse the value of input, if the value of input is not correct, display error


    fun addMoney() {
        if (inputString.value == null || inputString.value.isNullOrBlank()) {
            return
        }

        // Convert input string to Long value
        var inputNumber = inputString.value!!.toLong()

        // Clear the value in UI
        inputString.value = ""

        // Push the new value
        expenseItem.value = ExpenseOperand(inputNumber)
    }
}