package com.example.mysurgeon.procedure.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysurgeon.R
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.core.BaseFragment
import com.example.mysurgeon.core.adapter.BaseRecyclerViewAdapter
import com.example.mysurgeon.model.Procedure
import com.example.mysurgeon.procedure.ProcedureViewModel
import com.example.mysurgeon.procedure.view.adapter.ProcedureAdapter
import com.example.mysurgeon.util.ViewModelFactory
import kotlinx.android.synthetic.main.layout_surgeons_feed.*
import timber.log.Timber

class ProcedureFragment: BaseFragment(), BaseRecyclerViewAdapter.OnItemListener<Procedure> {

    private val viewModel by lazy {
        return@lazy ViewModelProvider(requireActivity(), ViewModelFactory(activity = activity as BaseActivity))
            .get(ProcedureViewModel::class.java)
    }

    private val adapter by lazy {
        return@lazy ProcedureAdapter(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_surgeons_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.addProcedureSpecificIndex()
        initViews()
        initViewModel()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvSurgeonsFeeds.adapter = adapter
        rvSurgeonsFeeds.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rvSurgeonsFeeds.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.HORIZONTAL))
        adapter.setItemListener(this)
    }

    private fun initViews() {
        etSearch.hint = getString(R.string.tv_search_hint_procedures)
    }

    private fun initViewModel() {
        viewModel.procedures.observe(viewLifecycleOwner, Observer {
            adapter.set(it)
        })
    }

    override fun onItemPressed(data: Procedure, position: Int) {
        startActivity(Intent(requireActivity(), ProcedureDetailsViewImpl::class.java))
    }

    override fun onItemSend(data: Procedure, position: Int, isSms: Boolean) {

    }
}