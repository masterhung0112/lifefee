package com.hungbn.expenses

import java.math.BigDecimal

data class ExpenseOperand(
    val value: BigDecimal = BigDecimal(0)

    // Display format in currency
)

open class ExpenseOperator {
    open fun apply(expenseOperands: List<ExpenseOperand>): List<ExpenseOperand> {
        return expenseOperands
    }
}

class AddExpenseOperator: ExpenseOperator() {
    override fun apply(expenseOperands: List<ExpenseOperand>): List<ExpenseOperand>
            = listOf(expenseOperands.reduce { acc, expenseOperand -> ExpenseOperand(acc.value + expenseOperand.value)})
}

