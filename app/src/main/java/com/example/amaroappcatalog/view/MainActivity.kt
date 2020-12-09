package com.example.amaroappcatalog.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.amaroappcatalog.R
import com.example.amaroappcatalog.viewModel.CatalogViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.log

class MainActivity : AppCompatActivity() {

    private val viewModel: CatalogViewModel by lazy {
        ViewModelProviders.of(this).get(CatalogViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
        subscribeUI()
    }

    private fun setupView() {
        setSupportActionBar(toolbar)
    }

    private fun subscribeUI() {
        viewModel.response.observe(this, Observer {

            if (it != null && it != "") {
                Log.d("RESPONSE",it)
                apiTest.text = it
            }
        })
    }
}