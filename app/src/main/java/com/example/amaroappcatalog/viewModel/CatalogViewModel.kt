package com.example.amaroappcatalog.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.amaroappcatalog.network.AmaroCatalogApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CatalogViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getCatalog()
    }

    private fun getCatalog() {
        AmaroCatalogApi.retrofitService.getProperties().enqueue(object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                _response.value = "Failure: " + t.message
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                _response.value = response.body()
            }

        })
    }

}