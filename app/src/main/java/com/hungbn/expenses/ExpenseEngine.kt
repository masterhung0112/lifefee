package com.hungbn.expenses

interface IExpenseEngine {
    fun apply(operand: ExpenseOperand, operator: ExpenseOperator)
}

//class ExpenseEngine : IExpenseEngine {
//
//}