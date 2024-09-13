package com.poooootiful.mobilt_java23_johanna_pettersson_api_intergration_v4

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        val browse:Button = findViewById(R.id.toinb)


        browse.setOnClickListener(View.OnClickListener {
            showmenu()
        })

    }

    private fun showmenu () {
        supportFragmentManager.beginTransaction().replace(R.id.menuview, Theinbetween()).addToBackStack("menu")

        findViewById<FrameLayout>(R.id.menuview).visibility = View.VISIBLE

    }
}