package com.example.mysurgeon.journal.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysurgeon.R
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.core.BaseFragment
import com.example.mysurgeon.journal.JournalViewModel
import com.example.mysurgeon.journal.view.adapter.JournalAdapter
import com.example.mysurgeon.util.ViewModelFactory
import kotlinx.android.synthetic.main.layout_journal.*

class JournalFragment: BaseFragment() {
    private val viewModel by lazy {
        return@lazy ViewModelProvider(requireActivity(), ViewModelFactory(activity = requireActivity() as BaseActivity))
            .get(JournalViewModel::class.java)
    }

    private val adapter by lazy {
        return@lazy JournalAdapter(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_journal, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.addJournalForSpecificIndex()
        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        rvJournalFeeds.adapter = adapter
        rvJournalFeeds.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun initViewModel() {
        viewModel.journal.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
    }
}