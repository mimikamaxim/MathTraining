package com.example.mathtraning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mathtraning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding){
            upto10.setOnClickListener {
                //TODO
            }
            upto20.setOnClickListener {
                //TODO
            }
            upto30.setOnClickListener {
                //TODO
            }
            upto40.setOnClickListener {
                //TODO
            }
            upto50.setOnClickListener {
                //TODO
            }
            upto100.setOnClickListener {
                //TODO
            }
        }
    }
}