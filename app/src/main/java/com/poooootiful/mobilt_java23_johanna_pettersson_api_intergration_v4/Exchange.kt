package com.poooootiful.mobilt_java23_johanna_pettersson_api_intergration_v4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Exchange :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.exchange)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.exchange)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val Exchange: Button = findViewById(R.id.exchangebtn)
        var input:Any = findViewById<EditText>(R.id.input)
        var result:Any = findViewById<EditText>(R.id.result)
        var selectfrom:Any = findViewById<Spinner>(R.id.fromcur)
        var selectto:Any = findViewById<Spinner>(R.id.tocur)

        Exchange.setOnClickListener(View.OnClickListener {

        })

    }
}