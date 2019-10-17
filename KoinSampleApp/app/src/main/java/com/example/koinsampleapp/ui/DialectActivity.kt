package com.example.koinsampleapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.tw.shufflesongsapp.adapter.DialectsRecyclerViewAdapter
import com.example.koinsampleapp.R
import com.example.koinsampleapp.viewmodel.DialectViewModel
import kotlinx.android.synthetic.main.activity_dialect.*
import org.koin.android.viewmodel.ext.android.viewModel

class DialectActivity : AppCompatActivity() {

    private val viewModel: DialectViewModel by viewModel()
    private lateinit var region: String

    lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialect)

         region = intent?.extras?.getString("REGION") ?: ""

        initRecyclerView()
        initObserver()
        loadDialects()
    }

    private fun initRecyclerView() {
        linearLayoutManager = LinearLayoutManager(this)
        dialectsRecyclerView.layoutManager = linearLayoutManager
    }

    private fun initObserver() {
        viewModel.getDialects().observe(this, Observer { dialects ->
            dialectsRecyclerView.adapter = DialectsRecyclerViewAdapter(dialects)
        })
    }

    private fun loadDialects() {
        viewModel.loadDialects(region)
    }

}
