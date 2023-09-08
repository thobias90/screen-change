package com.stahlt.screenchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class AddRegistersActivity : AppCompatActivity() {
    private lateinit var etCode: EditText
    private lateinit var etQuantity: EditText
    private lateinit var etPrice: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_registers)

        etCode = findViewById(R.id.etCode)
        etQuantity = findViewById(R.id.etQuantity)
        etPrice = findViewById(R.id.etPrice)
    }

    fun btClearOnClick(view: View) {}
    fun btAddOnClick(view: View) {
        val intent = Intent(this, RegisterConfirmActivity::class.java)
        intent.putExtra("code", etCode.text.toString())
        intent.putExtra("quantity", etQuantity.text.toString())
        intent.putExtra("price", etPrice.text.toString())
        startActivity(intent)
    }
}