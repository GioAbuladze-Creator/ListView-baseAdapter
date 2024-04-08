package com.example.simplelistview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1- Adapter View: ListView
        val listView = findViewById<ListView>(R.id.listView)

        // 2 - Adapter
        val adapter = CountryAdapter(this, generateData())

        listView?.adapter = adapter

    }

    // 3- Data Source
    fun generateData(): ArrayList<CountryModel> {
        var countryList = arrayListOf(
            CountryModel("Brazil", "5", R.drawable.brazil),
            CountryModel("Germany", "4", R.drawable.germany),
            CountryModel("Italy", "4", R.drawable.italy),
            CountryModel("Spain", "1", R.drawable.spain),
            CountryModel("France", "2", R.drawable.france)
        )
        return countryList
    }


}