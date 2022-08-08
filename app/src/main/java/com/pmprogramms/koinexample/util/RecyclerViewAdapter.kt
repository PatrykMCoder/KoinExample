package com.pmprogramms.koinexample.util

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.pmprogramms.koinexample.data.CatFact
import com.pmprogramms.koinexample.databinding.FactItemBinding

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>() {
    private lateinit var data: List<CatFact>
    inner class RecyclerViewHolder(private val binding: FactItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(catFact: CatFact) {
            binding.factValueTextView.text = catFact.text
            binding.publisherValueTextView.text = "${catFact.user}(${catFact.source})"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val binding: FactItemBinding = FactItemBinding.inflate(LayoutInflater.from(parent.context), null, false)
        binding.root.layoutParams = ConstraintLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun setData(data: List<CatFact>) {
        this.data = data
    }
}