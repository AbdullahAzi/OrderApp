package com.example.dialog

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ratingTV : TextView = findViewById(R.id.choice)
        ratingTV.setOnClickListener{
            var dialog_var = CustomDialogFragment()
            dialog_var.show(supportFragmentManager, "Custom Dialog")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.listmenu,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> clearorders()
            R.id.item2 -> dismiss()
        }
        return true
    }

    private fun dismiss() {
        val back:TextView=findViewById(R.id.choice)
        back.text="Back to main"
        Toast.makeText(applicationContext,back.text, Toast.LENGTH_SHORT).show()
    }

    fun receiveFeedback(feedback: String){
        val ratingTV : TextView = findViewById(R.id.choice)
        ratingTV.text = "your order is: "+feedback;

    }

    fun clearorders(){
        val ch:TextView=findViewById(R.id.choice)
        ch.text="Nothing choosen!"
    }

}