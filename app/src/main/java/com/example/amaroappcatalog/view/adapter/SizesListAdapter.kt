package com.example.amaroappcatalog.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amaroappcatalog.databinding.SizeItemBinding
import com.example.amaroappcatalog.model.Size

class SizesListAdapter: RecyclerView.Adapter<SizesListAdapter.ViewHolder>() {

    private var sizes = listOf<Size>()

    inner class ViewHolder(private var binding: SizeItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(size: Size) {
            binding.size.text = size.size
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(SizeItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val size = sizes[position]
        if (!size.available) return
        holder.bind(size)
    }

    override fun getItemCount() = sizes.size

    fun updateList(list: List<Size>) {
        sizes = list
        notifyDataSetChanged()
    }
}