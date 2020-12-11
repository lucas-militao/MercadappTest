package com.example.amaroappcatalog.view.fragment

import android.graphics.Paint
import android.graphics.Rect
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.amaroappcatalog.R
import com.example.amaroappcatalog.databinding.FragmentProductBinding
import com.example.amaroappcatalog.model.Product
import com.example.amaroappcatalog.model.Size
import com.example.amaroappcatalog.view.adapter.SizesListAdapter

class ProductFragment : Fragment() {

    lateinit var binding: FragmentProductBinding
    lateinit var product: Product
    lateinit var adapter: SizesListAdapter

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

            this.productName.text = product.name.toLowerCase()
            this.productRegularPrice.text = product.regularPrice
            if (product.discountPercentage != "") {
                this.productRegularPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
                this.productRegularPrice.setTextSize(TypedValue.COMPLEX_UNIT_SP, resources.getDimension(R.dimen.mediumTextSize))
                this.productInstallmentsOrDiscount.text = "- ${product.discountPercentage}"
                this.productPromotionPrice.text = product.actualPrice
                this.promotionProductInstallments.text = resources.getString(R.string.installmentsAvaillable, product.installments)
            } else {
                this.promotionProductInstallments.text = resources.getString(R.string.installmentsAvaillable, product.installments)
            }
        }

        adapter = SizesListAdapter()
        binding.sizesAvailableList.adapter = adapter

        var availableSizes = arrayListOf<Size>()

        for (size in product.sizes) {
            if (size.available)
                availableSizes.add(size)
        }
        adapter.updateList(availableSizes)

        activity?.actionBar?.setHomeButtonEnabled(true)

        applySpaceBetweenItens()
    }

    private fun applySpaceBetweenItens() {
        binding.sizesAvailableList.addItemDecoration(object: RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect, itemPosition: Int, parent: RecyclerView) {
                outRect.left = 10
                outRect.right = 50
            }
        })
    }

}