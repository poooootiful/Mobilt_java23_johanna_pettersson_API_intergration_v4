package com.poooootiful.mobilt_java23_johanna_pettersson_api_intergration_v4

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Inbetween :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.theinbetween)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.inbetween)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val exchangepage: Button = findViewById(R.id.toexchange)
        val otherpage: Button = findViewById(R.id.toOther)

        exchangepage.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, Exchange::class.java)
            startActivity(intent)
        })

        otherpage.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, otherpage::class.java)
            startActivity(intent)
        })

    }
}