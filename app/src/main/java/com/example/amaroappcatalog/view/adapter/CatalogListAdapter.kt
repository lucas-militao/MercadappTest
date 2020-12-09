package com.example.amaroappcatalog.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amaroappcatalog.R
import com.example.amaroappcatalog.model.Product
import kotlinx.android.synthetic.main.catalog_item.view.*

class CatalogListAdapter : RecyclerView.Adapter<CatalogListAdapter.ViewHolder>() {

    private var catalog = listOf<Product>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.productName
        val image = itemView.imageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.catalog_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return catalog.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = catalog[position]
        holder.name.text = product.name
        Glide
            .with(holder.itemView)
            .load(product.image)
            .centerCrop()
            .into(holder.image)
    }

    fun updateList(list: List<Product>) {
        catalog = list
        notifyDataSetChanged()
    }

}

