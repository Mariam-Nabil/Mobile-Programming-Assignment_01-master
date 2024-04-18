package com.example.tryintente

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.tryintente.databinding.ActivityGreetingBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
class GreetingActivity : AppCompatActivity()  {
    lateinit var binding : ActivityGreetingBinding
    var lastNumeric=false
    var stateError=false
    private lateinit var experssion:Expression
    override fun onCreate(savedInstanceState: Bundle?){
            super.onCreate(savedInstanceState)
            binding = ActivityGreetingBinding.inflate(layoutInflater)
            setContentView(binding.root)
         //this the part of passing data to write name of the person from the login activity
          val greetname=intent.getStringExtra("username").toString()
          binding.helloNameuser.text=("Hello ,  $greetname")
          //this part to make the buttons clickable and show text in the problem


     }

    fun numClick(view: View) {

        if (stateError){
            binding.data.text=(view as Button).text
            stateError=false
        } else{
            binding.data.append((view as Button).text)
        }
        lastNumeric=true
        onEqual()
    }

    fun EqualsClick(view: View) {

        onEqual()
        binding.data.text=binding.Answer.text.toString().drop(1)


    }

    fun operatorClick(view: View) {
        binding.data.append((view as Button).text)
        lastNumeric=false
        onEqual()



    }

    fun ClearClick(view: View) {

        binding.data.text=""
        lastNumeric=false
/*
        binding.data.text=""
        binding.Answer.text=""
        stateError=false
        lastNumeric=false
        binding.Answer.visibility=View.GONE
        */

    }

   fun onEqual(){
       if(lastNumeric && !stateError){
           val txt=binding.data.text.toString()
           experssion=ExpressionBuilder(txt).build()
          try{
              val result=experssion.evaluate()

              binding.Answer.visibility=View.VISIBLE
              binding.Answer.text="="+result.toString()
          }
          catch (ex : ArithmeticException){
              Log.e("evaluate error", ex.toString() )
              binding.Answer.text="Error"
              lastNumeric=false
              stateError=true
          }




       }


    }
}
//        binding.showTotalTIP.text=getString(R.string.tip_amount,currencyTip)