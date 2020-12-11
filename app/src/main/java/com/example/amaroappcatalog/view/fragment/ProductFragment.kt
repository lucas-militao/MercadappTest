package com.example.amaroappcatalog.view.fragment

import android.graphics.Paint
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.amaroappcatalog.R
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

        with(binding) {
            Glide
                .with(this@ProductFragment)
                .load(product.image)
                .centerCrop()
                .into(this.productImage)

            this.productName.text = product.name.capitalize()
            this.productRegularPrice.text = product.regularPrice
            if (product.discountPercentage != "") {
                this.productRegularPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                this.productRegularPrice.setTextSize(TypedValue.COMPLEX_UNIT_SP, resources.getDimension(R.dimen.mediumTextSize))
                this.productPromotionPrice.text = product.actualPrice
                this.productInstallments2.text = resources.getString(R.string.installmentsAvaillable, product.installments)
            } else {
                this.productInstallments.text = resources.getString(R.string.installmentsAvaillable, product.installments)
            }
        }

    }

}