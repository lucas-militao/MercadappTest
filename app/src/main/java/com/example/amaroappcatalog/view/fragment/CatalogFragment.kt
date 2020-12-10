package com.example.amaroappcatalog.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.amaroappcatalog.R
import com.example.amaroappcatalog.databinding.FragmentCatalogBinding

class CatalogFragment : Fragment() {

    lateinit var binding: FragmentCatalogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCatalogBinding.inflate(inflater)
        binding.lifecycleOwner = this

        return binding.root
    }
}