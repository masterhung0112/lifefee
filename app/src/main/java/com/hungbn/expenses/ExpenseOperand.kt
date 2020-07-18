package com.hungbn.expenses

import java.math.BigDecimal
import java.math.BigInteger
import java.math.MathContext

data class ExpenseOperand(
    val value: BigDecimal = BigDecimal(0)

    // Display format in currency
) {
    constructor(value: Double) : this(BigDecimal.valueOf(value)) {
    }

    constructor(value: BigInteger) : this(BigDecimal(value)) {
    }

    constructor(value: Int) : this(BigDecimal(value)) {
    }

    constructor(value: Long) : this(BigDecimal(value)) {
    }
}

open class ExpenseOperator {
    open fun apply(expenseOperands: List<ExpenseOperand>): List<ExpenseOperand> {
        return expenseOperands
    }
}

class AddExpenseOperator: ExpenseOperator() {
    override fun apply(expenseOperands: List<ExpenseOperand>): List<ExpenseOperand> {
        if (expenseOperands.size == 0) {
            return listOf(ExpenseOperand(0))
        }

        return listOf(expenseOperands.reduce { acc, expenseOperand -> ExpenseOperand(acc.value + expenseOperand.value) })
    }
}

