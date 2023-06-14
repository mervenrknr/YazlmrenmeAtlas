package com.example.yazlmrenmeatlas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProductDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_product_detail)

        val imageViewDetail = findViewById<ImageView>(R.id.imageViewDetail)
        val textViewNameDetail = findViewById<TextView>(R.id.textViewNameDetail)
        val textViewDescriptionDetail = findViewById<TextView>(R.id.textViewDescriptionDetail)

        val imageRes = intent.getIntExtra("imageRes", 0)
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")

        imageViewDetail.setImageResource(imageRes)
        textViewNameDetail.text = name
        textViewDescriptionDetail.text = description
    }

}