package com.jk.stateofjavascript

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {
    private val viewModel: MainViewModel by viewModels()
    private val adapter = ToolsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onStart() {
        super.onStart()
        view_recycler.adapter = adapter
        viewModel.viewState.observe(this, androidx.lifecycle.Observer(::render))
        viewModel.start()
    }

    private fun render(viewState: MainViewState) {
        adapter.submitList(viewState.tools)
    }
}
