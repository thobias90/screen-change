package com.stahlt.screenchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

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
    fun btListOnClick(view: View) {
        val intent = Intent(this, ListActivity::class.java).let {
            register.launch(it)
        }
//        startActivity(intent)
    }

    val register = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                result.data?.let {
                    if (it.hasExtra("productCode")) {
                        val productCode = it.getStringExtra("productCode")
                        etCode.setText(productCode)
                    }
                }
            }
    }
}