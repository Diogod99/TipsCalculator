package com.example.tipcalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tipcalculator.databinding.ActivitySummaryBinding

class SummaryActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySummaryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val Table = intent.getFloatExtra("Table", 0.0f)
        val nPeople = intent.getIntExtra("nPeople", 0)
        val percentage = intent.getIntExtra("percentage", 0)
        val totalFinal = intent.getFloatExtra("totalFinal", 0.0f)

        binding.tvBillAmountEuros.text = Table.toString()
        binding.tvNumberOfPeopleValue.text = nPeople.toString()
        binding.tvTipPercentageValue.text = percentage.toString() + "%"
        binding.tvTotalAmountEuros.text = totalFinal.toString()
        binding.btnNewCalculation.setOnClickListener {
            finish()
        }

    }
}