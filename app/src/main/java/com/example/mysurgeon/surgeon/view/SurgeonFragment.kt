package com.example.mysurgeon.surgeon.view

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysurgeon.R
import com.example.mysurgeon.core.BaseActivity
import com.example.mysurgeon.core.BaseFragment
import com.example.mysurgeon.core.adapter.BaseRecyclerViewAdapter
import com.example.mysurgeon.core.status.Status
import com.example.mysurgeon.model.Surgeon
import com.example.mysurgeon.surgeon.SurgeonViewModel
import com.example.mysurgeon.surgeon.view.adapter.SurgeonAdapter
import com.example.mysurgeon.util.AppConstants
import com.example.mysurgeon.util.Extension.toast
import com.example.mysurgeon.util.ViewModelFactory
import kotlinx.android.synthetic.main.layout_surgeons_feed.*
import timber.log.Timber

class SurgeonFragment: BaseFragment(), BaseRecyclerViewAdapter.OnItemListener<Surgeon> {
    private val viewModel by lazy {
        return@lazy ViewModelProvider(requireActivity(), ViewModelFactory(activity = requireActivity() as BaseActivity))
                .get(SurgeonViewModel::class.java)
    }

    private val adapter by lazy {
        return@lazy SurgeonAdapter(requireContext())
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_surgeons_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.loadSurgeons()
        initViewModel()
        initRecyclerView()
        initViewListeners()
    }

    private fun initViewListeners() {
        swipeRefreshLayout.setOnRefreshListener {
            viewModel.loadSurgeons()
        }

        etSearch.doOnTextChanged { text, start, before, count ->
            viewModel.search(query = text.toString())
        }
    }

    private fun initRecyclerView() {
        rvSurgeonsFeeds.adapter = adapter
        rvSurgeonsFeeds.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter.setItemListener(this)
    }

    private fun initViewModel() {
        viewModel.surgeons.observe(viewLifecycleOwner, Observer {
            adapter.set(it)
        })

        viewModel.status.observe(viewLifecycleOwner, Observer {
            when(it) {
                is Status.Loading -> {
                    if (it.show) {
                        loadingIndicator.visibility = View.VISIBLE
                        rvSurgeonsFeeds.visibility = View.GONE
                    } else {
                        swipeRefreshLayout.isRefreshing = false
                        loadingIndicator.visibility = View.GONE
                        rvSurgeonsFeeds.visibility = View.VISIBLE
                    }
                }

                is Status.Error -> {
                    val message = if (it.resId == null) {
                        it.message
                    } else {
                        getString(it.resId)
                    }

                    message?.let {
                        toast(it)
                    }
                }
            }
        })
    }

    override fun onItemPressed(data: Surgeon, position: Int) {
        val bundle = Bundle()
        bundle.putSerializable(AppConstants.SURGEON_DATA, data)
        startActivity(Intent(requireActivity(), SurgeonDetailsViewImpl::class.java).putExtras(bundle))
    }

    override fun onItemSend(data: Surgeon, position: Int, isSms: Boolean) {
        val bundle = Bundle()
        bundle.putSerializable(AppConstants.SURGEON_DATA, data)
        bundle.putBoolean("isSms", isSms)
        startActivity(Intent(requireActivity(), SurgeonShareViewImpl::class.java).putExtras(bundle))
    }
}