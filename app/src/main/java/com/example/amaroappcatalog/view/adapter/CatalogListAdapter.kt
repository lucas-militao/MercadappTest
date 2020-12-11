package com.example.amaroappcatalog.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amaroappcatalog.R
import com.example.amaroappcatalog.databinding.CatalogItemBinding
import com.example.amaroappcatalog.model.Product
import kotlinx.android.synthetic.main.catalog_item.view.*

class CatalogListAdapter(var onClick: (Product) -> Unit) : RecyclerView.Adapter<CatalogListAdapter.ViewHolder>() {

    private var catalog = listOf<Product>()

    inner class ViewHolder(private var binding: CatalogItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(product: Product, onClick: (Product) -> Unit) {
            binding.productLayout.setOnClickListener { onClick(product) }
            binding.productName.text = product.name.toLowerCase().capitalize()
            Glide
                .with(itemView)
                .load(product.image)
                .centerCrop()
                .into(binding.imageView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(CatalogItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
        return catalog.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = catalog[position]
        holder.bind(product, onClick)
    }

    fun updateList(list: List<Product>) {
        catalog = list
        notifyDataSetChanged()
    }

}

