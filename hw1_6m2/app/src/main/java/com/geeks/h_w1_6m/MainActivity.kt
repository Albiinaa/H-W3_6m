package com.geeks.h_w1_6m

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.geeks.h_w1_6m.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private val viewModel: CharacterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.fetchCharacters()
        viewModel.fetchEpisodes()
        viewModel.characters.observe(this, Observer { characters ->
            binding.tvCharacters.text = characters.joinToString { it.name }
        })
        viewModel.episodes.observe(this,Observer{ episodes ->
            binding.tvEpisodes.text = episodes.joinToString{ it.name }
        })
    }
}