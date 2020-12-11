package com.example.amaroappcatalog.view.fragment

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.amaroappcatalog.databinding.FragmentCatalogBinding
import com.example.amaroappcatalog.view.adapter.CatalogListAdapter
import com.example.amaroappcatalog.viewModel.CatalogViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_catalog.*

class CatalogFragment : Fragment() {

    private lateinit var binding: FragmentCatalogBinding
    private lateinit var catalogViewModel: CatalogViewModel
    private lateinit var catalogListAdapter: CatalogListAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalogBinding.inflate(inflater)
        binding.lifecycleOwner = this

        catalogViewModel = ViewModelProviders.of(this).get(CatalogViewModel::class.java)

        setupView()
        subscribeUI()

        return binding.root
    }

    private fun setupView() {
        val manager = GridLayoutManager(activity, 2)
        applySpaceBetweenItens()
        binding.catalog.layoutManager = manager
        catalogListAdapter = CatalogListAdapter { this.findNavController().navigate(CatalogFragmentDirections.actionCatalogFragmentToProductFragment(it)) }
        binding.catalog.adapter = catalogListAdapter
    }

    private fun subscribeUI() {
        catalogViewModel.response.observe(viewLifecycleOwner, Observer {
            catalogListAdapter.updateList(it.products)
        })
    }

    private fun applySpaceBetweenItens() {
        binding.catalog.addItemDecoration(object: RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
                outRect.left = 10;
                outRect.right = 35;
                outRect.bottom = 5;
            }
        })
    }
}