package com.example.amaroappcatalog.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.amaroappcatalog.model.Product
import com.example.amaroappcatalog.model.ProductList
import com.example.amaroappcatalog.network.AmaroCatalogApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatalogViewModel : ViewModel() {

    private val _response = MutableLiveData<ProductList>()

    val response: LiveData<ProductList>
        get() = _response

    init {
        getCatalog()
    }

    private fun getCatalog() {
        AmaroCatalogApi.RETROFIT.getCatalog().enqueue(object: Callback<ProductList> {
            override fun onFailure(call: Call<ProductList>, t: Throwable) {

            }

            override fun onResponse(call: Call<ProductList>, response: Response<ProductList>) {
                _response.value = response.body()
            }

        })
    }

}