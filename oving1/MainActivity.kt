package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onCreateOptionsMenu(meny: Menu): Boolean{
        super.onCreateOptionsMenu(meny)
        meny.add("Trygve")
        meny.add("Amundsen")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean{
        if (item.getTitle().equals("Trygve")){
            Log.w("Warning","Trygve")
        }
        else if(item.getTitle().equals("Amundsen")){
            Log.e("Error", "Amundsen")
        }
        return true
    }

}