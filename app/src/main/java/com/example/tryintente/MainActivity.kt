package com.example.tryintente

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.tryintente.databinding.ActivityMainBinding
import androidx.appcompat.app.AppCompatActivity
import java.text.NumberFormat
import kotlin.math.ceil


class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submitBtn.setOnClickListener{
          var NameID=binding.nameuser
          var name=NameID.text.toString()
           val intent=Intent(this,GreetingActivity::class.java)
            intent.putExtra("username",name)
           startActivity(intent)
        }
        fun user(){
            print("yes")
        }
    }



}

//val greeting_name = intent.getStringExtra("firstName").toString()





