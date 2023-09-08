package com.stahlt.screenchange

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btStartOnClick(view: View) {
        val intent = Intent(this, AddRegistersActivity::class.java)
        startActivity(intent)
    }
}