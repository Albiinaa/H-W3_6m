package com.geeks.hw_2_5m

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.geeks.hw_2_5m.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnCalculateButton.setOnClickListener{
            val firstName = binding.edFirstName.text.toString()
            val secondName = binding.edSecondName.text.toString()
            val intent = Intent(this,LoveFragment::class.java)
            intent.putExtra("firstName",firstName)
            intent.putExtra("secondName",secondName)
            startActivity(intent)
        }
    }
}