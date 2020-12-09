package com.example.amaroappcatalog.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.amaroappcatalog.R
import com.example.amaroappcatalog.model.Product
import com.example.amaroappcatalog.model.ProductList
import kotlinx.android.synthetic.main.catalog_item.view.*

class CatalogListAdapter : RecyclerView.Adapter<CatalogListAdapter.ViewHolder>() {

    private var catalog = listOf<Product>()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.productName
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
        holder.title.text = product.name
    }

    fun updateList(list: List<Product>) {
        catalog = list
        notifyDataSetChanged()
    }

}

