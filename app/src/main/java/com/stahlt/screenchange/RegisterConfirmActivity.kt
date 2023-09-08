package com.stahlt.screenchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class RegisterConfirmActivity : AppCompatActivity() {
    private lateinit var tvConfirmCode: TextView
    private lateinit var tvConfirmQuantity: TextView
    private lateinit var tvConfirmPrice: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_confirm)

        tvConfirmCode = findViewById(R.id.tvConfirmCode)
        tvConfirmQuantity = findViewById(R.id.tvConfirmQuantity)
        tvConfirmPrice = findViewById(R.id.tvConfirmPrice)

        val code = intent.getStringExtra("code")
        val quantity = intent.getStringExtra("quantity")
        val price = intent.getStringExtra("price")

        tvConfirmCode.text = code
        tvConfirmQuantity.text = quantity
        tvConfirmPrice.text = price
    }

    fun btConfirmOnClick(view: View) {}
}