package com.stahlt.screenchange

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.net.URI

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

    fun btConfirmOnClick(view: View) {
        val sms = "Code: ${tvConfirmCode.text.toString()}, Quantity: ${tvConfirmQuantity.text.toString()} , Price: ${tvConfirmPrice.text.toString()}"

        val uri = Uri.parse("smsto:+5546991056342")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("address", "+554691056342");
        intent.putExtra("sms_body", sms);

        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT -> {
                //Getting the default sms app.
                val defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(this)

                // Can be null in case that there is no default, then the user would be able to choose
                // any app that support this intent.
                if (defaultSmsPackageName != null) intent.setPackage(defaultSmsPackageName)

                startActivity(intent)
            }
            else -> startActivity(intent)
        }

    }
}