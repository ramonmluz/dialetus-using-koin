package com.example.koinsampleapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.tw.shufflesongsapp.adapter.RegionsRecyclerViewAdapter
import com.example.koinsampleapp.R
import com.example.koinsampleapp.viewmodel.RegionViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: RegionViewModel by viewModel()

    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        initObserver()
        loadRegions()
    }

    private fun initRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        regionsRecyclerView.layoutManager = linearLayoutManager
        fillDivider()
    }

    private fun fillDivider() {
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        divider.setDrawable(ContextCompat.getDrawable(baseContext, R.drawable.divider)!!)
        regionsRecyclerView.addItemDecoration(divider)
    }

    private fun initObserver() {
        viewModel.getRegions().observe(this, Observer { regions ->
            regionsRecyclerView.adapter = RegionsRecyclerViewAdapter(regions)
        })
    }

    private fun loadRegions() {
        viewModel.loadRegions()
    }
}
