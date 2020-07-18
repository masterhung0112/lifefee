package com.hungbn

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.hungbn.databinding.FragmentNewExpenseBinding
import com.hungbn.expenses.ExpenseOperand
import kotlinx.android.synthetic.main.fragment_new_expense.*

class NewExpenseFragment : Fragment() {

    companion object {
        fun newInstance() = NewExpenseFragment()
    }

    private lateinit var newExpenseViewModel: NewExpenseViewModel
    private lateinit var totalViewModel: ExpenseTotalViewModel
    private lateinit var expenseItemInputViewModel: ExpenseItemInputViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<FragmentNewExpenseBinding>(inflater, R.layout.fragment_new_expense, container, false)
        newExpenseViewModel = ViewModelProviders.of(activity!!).get(NewExpenseViewModel::class.java)
        totalViewModel = ViewModelProviders.of(activity!!).get(ExpenseTotalViewModel::class.java)
        expenseItemInputViewModel = ViewModelProviders.of(activity!!).get(ExpenseItemInputViewModel::class.java)

        binding.viewmodel = newExpenseViewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        // Total View Model listen for new list of operands
        newExpenseViewModel.expenses.observe(this, Observer<List<ExpenseOperand>> {
            // Set the new value for expense
            totalViewModel.setNewExpenses(it)
        })

        // Listen for new value and add new value into expense list
        expenseItemInputViewModel.expenseItem.observe(this, Observer<ExpenseOperand> {
            newExpenseViewModel.addExpense(it)
        })
    }

}