package com.example.rvlistadapter.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rvlistadapter.R


class ListFragment : Fragment(R.layout.fragment_list) {
    private lateinit var rv: RecyclerView
    private val listViewModel: ListViewModel by viewModels()
    private val adapter = ListJobsAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view = view)
        observerJobs()
    }

    private fun initViews(view: View) {
        rv = view.findViewById(R.id.rv_activities)
        rv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rv.adapter = adapter
    }

    private fun observerJobs() {
        listViewModel._jobs.observe(viewLifecycleOwner) { jobs ->
            adapter.submitList(jobs)
        }
    }
}