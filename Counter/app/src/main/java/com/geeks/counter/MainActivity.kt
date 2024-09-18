package com.geeks.counter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.geeks.counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterContract {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val presenter = MainPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter.attachContract(this)

        binding.apply {
            btnIncrement.setOnClickListener {
                presenter.onIncrement()
            }
            btnDecrement.setOnClickListener {
                presenter.onDecrement()
            }
        }
    }

    override fun showResult(count: Int) = with(binding) {
        tvCount.text = count.toString()
    }

    override fun showToast(toast: String) {
        Toast.makeText(this, "Поздравляем", Toast.LENGTH_SHORT).show()
    }

    override fun changeColor(color: Int) {
        binding.tvCount.setTextColor(Color.GREEN)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachContract()
    }
}