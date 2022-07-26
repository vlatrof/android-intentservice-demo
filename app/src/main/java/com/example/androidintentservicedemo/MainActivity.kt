package com.example.androidintentservicedemo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val startServiceButton = Button(this)
        startServiceButton.text = "Start intent service"
        startServiceButton.setOnClickListener {

            val intent = Intent(this, MyIntentService::class.java)
            val bundle = Bundle()
            bundle.putLong("time", 2)
            bundle.putString("message", "hello")
            intent.putExtra("bundle", bundle)
            startService(intent)

        }

        val linearLayout = LinearLayout(this)
        linearLayout.addView(startServiceButton)

        setContentView(linearLayout)
    }
}