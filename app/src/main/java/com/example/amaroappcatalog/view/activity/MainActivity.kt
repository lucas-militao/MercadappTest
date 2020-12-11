package com.example.amaroappcatalog.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.amaroappcatalog.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupView()
    }

    private fun setupView() {
        toolbar.title = "AMARO"
        toolbar.setTitleTextAppearance(this, R.style.ToolbarTitle)
        setSupportActionBar(toolbar)
    }
}