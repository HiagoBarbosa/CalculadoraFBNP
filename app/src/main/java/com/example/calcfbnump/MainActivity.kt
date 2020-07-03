package com.example.calcfbnump

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_win_result.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // val txtVLStart = txtVLStart.text.toString().toInt()
        //val switchFBouNUMP = switchFBouNUMP.toString().toInt()

        switchFBouNUMP.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                switchFBouNUMP.text = getString(R.string.FiboOON)
            } else {
                switchFBouNUMP.text = getString(R.string.PrimeOFF)
            }
        }
        seekBarVlap.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Vl_Seek.text = progress.toString()
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        buttonStart.setOnClickListener{
            if(!txtVLStart.text.toString().equals("")){
                val NumStart = txtVLStart.text.toString().toInt()
                val amountOfValues = seekBarVlap.progress

                val concatenationResult: String

                if(switchFBouNUMP.isChecked){
                    concatenationResult = CalcFib(NumStart,amountOfValues )
                }else{
                    concatenationResult = CalcNump(NumStart,amountOfValues)
                }
                val intent = Intent(this, WinResult::class.java)
                intent.putExtra("concatenationResult", concatenationResult)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,getString(R.string.ERRO),Toast.LENGTH_LONG).show()
                txtVLStart.setText("")
            }
        }
    }

    private fun CalcFib(NumStart : Int, amountOfValues : Int): String{
        var previousNumber = 0
        var currentNumber = 1
        var i = 0
        var fibonacci: Int
        var concatenationResult = getString(R.string.txtFibonacci)
        do{
            fibonacci = previousNumber + currentNumber
            if(fibonacci >= NumStart){
                concatenationResult = "$concatenationResult $fibonacci |"
                i++
            }
            previousNumber = currentNumber
            currentNumber = fibonacci
        }while (i<amountOfValues)
        return concatenationResult
    }

    private fun CalcNump(NumStart: Int, amountOfValues: Int): String{

        var i = 0
        var startValue = NumStart
        var concatenationResult = getString(R.string.txtPrime)
        do{
            var divisor = 0
            for(a in 1.. NumStart){
                if (NumStart % a ==0){
                    divisor += 1
                }
            }
            if (divisor == 2){
                concatenationResult = "$concatenationResult $NumStart |"
                i++
            }
            startValue++
        }while (i < amountOfValues)
        return concatenationResult

    }



}



