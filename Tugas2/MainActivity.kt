package com.example.modul2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity

class MainActivity : AppCompatActivity() {

    private lateinit var teks: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        teks = findViewById(R.id.editTextTextPersonName)

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.btn_intent_explicit -> {
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                startActivity(intent)
            }


            R.id.button3 -> {
                val text = teks.text.toString()
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra(MainActivity2.EXTRA_TEXT, text)
                startActivity(intent)
            }

            R.id.button2 -> {
                val carSpek = Car(
                    "Civic",
                    "Honda",
                    "Sedan",
                    1997,
                    57000000.00
                )
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra(MainActivity2.EXTRA_CAR, carSpek)
                intent.putExtra(MainActivity2.EXTRA_BOOL, true)
                startActivity(intent)
            }

            R.id.button -> {
                val phoneNumber = "082345643254"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}