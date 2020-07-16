package com.hungbn

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.hungbn.expenses.ExpenseOperand
import kotlinx.android.synthetic.main.fragment_new_expense.*

class NewExpenseFragment : Fragment() {

    companion object {
        fun newInstance() = NewExpenseFragment()
    }

    private lateinit var newExpenseViewModel: NewExpenseViewModel
    private lateinit var totalViewModel: ExpenseTotalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_new_expense, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        newExpenseViewModel = ViewModelProviders.of(activity!!).get(NewExpenseViewModel::class.java)
        totalViewModel = ViewModelProviders.of(activity!!).get(ExpenseTotalViewModel::class.java)

        // Total View Model listen for new list of operands
        newExpenseViewModel.expenses.observe(this, Observer<List<ExpenseOperand>> {
            totalViewModel.expenses.postValue(it)
        })
    }

}