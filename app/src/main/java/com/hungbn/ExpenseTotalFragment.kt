package com.hungbn

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.hungbn.databinding.FragmentExpenseTotalBinding

class ExpenseTotalFragment : Fragment() {

    companion object {
        fun newInstance() = ExpenseTotalFragment()
    }

    private lateinit var viewModel: ExpenseTotalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var binding = DataBindingUtil.inflate<FragmentExpenseTotalBinding>(inflater, R.layout.fragment_expense_total, container, false)
        viewModel = ViewModelProviders.of(activity!!).get(ExpenseTotalViewModel::class.java)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}