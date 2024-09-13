package com.poooootiful.mobilt_java23_johanna_pettersson_api_intergration_v4

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.fragment.app.Fragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONObject
import java.io.IOException


class Exchange : Fragment() {
    private lateinit var client: OkHttpClient

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_exchange, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val fromCur:Spinner = view.findViewById(R.id.fromcur)

        val toCur:Spinner = view.findViewById(R.id.tocur)

        val input:EditText = view.findViewById<EditText>(R.id.input)

        val resultfield:EditText = view.findViewById<EditText>(R.id.result)

        val options = listOf("SEK","GBP","USD", "CAD")

        val adapter = ArrayAdapter (requireContext(),android.R.layout.simple_spinner_item,options)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        fromCur.adapter = adapter

        toCur.adapter = adapter

        val Exchange: Button = view.findViewById(R.id.exchange)

        client = OkHttpClient()


        Exchange.setOnClickListener(View.OnClickListener {
            val fromcurency = fromCur.selectedItem as String

            val tocurrency = toCur.selectedItem as String

            val amount = input.text.toString()

            Log.d("Currency1",fromcurency)
            Log.d("Currency",tocurrency)
            Log.d("Amount",amount.toString())

            if (amount.isNotEmpty()) {
                // Make API call using coroutines for async task
                request(fromcurency, tocurrency, amount, resultfield)
            } else {
                resultfield.setText("Please enter a valid amount.")
            }

            val result = ""
            resultfield.setText(result)
        })
    }
    private fun request(fromCurrency: String, toCurrency: String, amount: String, resultfield: EditText) {
        val key = "30d539af761110193243f94f"
        val url ="https://v6.exchangerate-api.com/v6/"+key+"/pair/"+fromCurrency+"/"+toCurrency+"/"+amount

        // Launch a coroutine to handle the network request
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val request = Request.Builder().url(url).build()
                val response = client.newCall(request).execute()

                if (response.isSuccessful) {
                    val jsonResponse = response.body?.string()
                    val jsonObject = JSONObject(jsonResponse)
                    val conversionResult = jsonObject.getDouble("conversion_result") // Getting conversion result from JSON

                    withContext(Dispatchers.Main) {
                        // Update the result field with the API result on the UI thread
                        resultfield.setText(conversionResult.toString())
                    }
                } else {
                    withContext(Dispatchers.Main) {
                        resultfield.setText("Error: ${response.message}")
                    }
                }
            } catch (e: IOException) {
                Log.e("API Error", e.toString())
                withContext(Dispatchers.Main) {
                    resultfield.setText("Network error occurred.")
                }
            }
        }
    }

}