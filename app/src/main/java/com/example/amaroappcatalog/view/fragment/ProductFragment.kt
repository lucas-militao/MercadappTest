package com.example.amaroappcatalog.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.amaroappcatalog.databinding.FragmentProductBinding
import com.example.amaroappcatalog.model.Product

class ProductFragment : Fragment() {

    lateinit var binding: FragmentProductBinding
    lateinit var product: Product

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProductBinding.inflate(inflater)
        binding.lifecycleOwner = this

        product = ProductFragmentArgs.fromBundle(requireArguments()).product
        setupView()

        return binding.root
    }

    private fun setupView() {
//        Glide
//            .with(this)
//            .load(product.image)
//            .circleCrop()
//            .into(binding.productImage)


        binding.productName.text = product.name.capitalize()
        binding.productPrice.text = product.actualPrice
    }

}