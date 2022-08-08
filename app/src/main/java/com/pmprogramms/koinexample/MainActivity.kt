package com.pmprogramms.koinexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.pmprogramms.koinexample.databinding.ActivityMainBinding
import com.pmprogramms.koinexample.util.RecyclerViewAdapter
import com.pmprogramms.koinexample.viewmodel.FactsViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val viewmodel: FactsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerViewAdapter = RecyclerViewAdapter()
        recyclerViewAdapter.setData(ArrayList())

        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = recyclerViewAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewmodel.data.observe(this) {
            it?.let { list ->
                recyclerViewAdapter.setData(list)
                recyclerViewAdapter.notifyDataSetChanged()
            }
        }
    }
}