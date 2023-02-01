package com.example.mathtraning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SeekBar
import android.widget.Toast
import com.example.mathtraning.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            startTraining.setOnClickListener {
                val b = TrainingObject.defineActions(
                    addition.isChecked,
                    subtract.isChecked,
                    multiply.isChecked,
                    division.isChecked
                )
                Log.d("MIMIKA",b.toString())
                if (b) {
                    TrainingObject.startTraining(amountExamplesSeekBar.progress + 3, 3, 100)
                } else
                    Toast.makeText(
                        this@MainActivity,
                        "Необходимо выбрать хотябы одно действие",
                        Toast.LENGTH_LONG
                    ).show()
            }
        }
        val seek = binding.amountExamplesSeekBar
        seek.setOnSeekBarChangeListener(object :
            SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seek: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
                binding.amountExamplesText.text = getString(R.string.amount_examples) +
                        " " +
                        (progress + 3)
            }

            override fun onStartTrackingTouch(seek: SeekBar) {
                // write custom code for progress is started
            }

            override fun onStopTrackingTouch(seek: SeekBar) {
                // write custom code for progress is stopped
//                Toast.makeText(this@MainActivity,
//                    "Progress is: " + seek.progress + "%",
//                    Toast.LENGTH_SHORT).show()
            }
        })
    }
}