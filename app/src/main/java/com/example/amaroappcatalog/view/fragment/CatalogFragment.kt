package com.example.amaroappcatalog.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.amaroappcatalog.databinding.FragmentCatalogBinding
import com.example.amaroappcatalog.view.adapter.CatalogListAdapter
import com.example.amaroappcatalog.viewModel.CatalogViewModel

class CatalogFragment : Fragment() {

    lateinit var binding: FragmentCatalogBinding
    lateinit var catalogViewModel: CatalogViewModel
    lateinit var catalogListAdapter: CatalogListAdapter

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
        catalogListAdapter = CatalogListAdapter { this.findNavController().navigate(CatalogFragmentDirections.actionCatalogFragmentToProductFragment(it)) }
        binding.catalog.adapter = catalogListAdapter
    }

    private fun subscribeUI() {
        catalogViewModel.response.observe(viewLifecycleOwner, Observer {
            catalogListAdapter.updateList(it.products)
        })
    }
}