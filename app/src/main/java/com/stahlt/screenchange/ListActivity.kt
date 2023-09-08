package com.stahlt.screenchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast

class ListActivity : AppCompatActivity() {
    private lateinit var lvProducts: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        lvProducts = findViewById(R.id.lvProducts)
        lvProducts.setOnItemClickListener { adapterView, view, pos, l ->
            Toast.makeText(this, "Position: $pos", Toast.LENGTH_SHORT).show()
            val code = pos.inc().toString()
            Intent().apply {
                putExtra("productCode", code)
                setResult(RESULT_OK, this)
            }
            finish()
        }
    }
}