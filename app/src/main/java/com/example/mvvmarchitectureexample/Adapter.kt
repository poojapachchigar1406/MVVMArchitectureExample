package com.example.mvvmarchitectureexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmarchitectureexample.databinding.ItemRowBinding

class Adapter(val list: List<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    private lateinit var binding: ItemRowBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ItemRowBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: ItemRowBinding) : RecyclerView.ViewHolder(itemView.root) {
        fun bind(item: String) {
            binding.apply {
                textView.text = item
            }
        }
    }
}
