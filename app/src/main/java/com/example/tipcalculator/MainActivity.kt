package com.example.tipcalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculate.setOnClickListener {
            val tableTemp = binding.totalBill.text
            val numPeopleTemp = binding.totalNumPeople.text
            val percentageTemp = binding.totalPercentage.text

            if (tableTemp?.isEmpty() == true ||
                numPeopleTemp?.isEmpty() == true ||
                percentageTemp?.isEmpty() == true) {
                Snackbar.make(
                    binding.totalBill,
                    "Please fill in all the fields",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val table = tableTemp.toString().toFloat()
                val npeople = numPeopleTemp.toString().toInt()
                val percentage = percentageTemp.toString().toInt()
                val total_temp = table / npeople
                val tip_value = total_temp * percentage / 100
                val total_final = total_temp + tip_value

                val intent = Intent(this, SummaryActivity::class.java)
                intent.apply {
                    putExtra("Table",table)
                    putExtra("nPeople",npeople)
                    putExtra("percentage",percentage)
                    putExtra("totalFinal",total_final)
                }
                clean()
                startActivity(intent)
            }
        }

        binding.clean.setOnClickListener {
            clean()
        }
    }

    private fun clean (){
        binding.totalBill.setText("")
        binding.totalNumPeople.setText("")
        binding.totalPercentage.setText("")

    }
}