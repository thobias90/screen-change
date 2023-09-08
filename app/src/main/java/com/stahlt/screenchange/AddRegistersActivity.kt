package com.stahlt.screenchange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class AddRegistersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_registers)
    }

    fun btClearOnClick(view: View) {}
    fun btAddOnClick(view: View) {}
}