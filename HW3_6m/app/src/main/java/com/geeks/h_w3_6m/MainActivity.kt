package com.geeks.h_w3_6m

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.geeks.h_w3_6m.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel by lazy { ViewModelProvider(this)[CharacterViewModel::class.java]}
    private val charactersAdapter by lazy { CharactersListAdapter() }
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setUpRecyclerView()

        viewModel.fetchCharacters().observe(this){res ->
            binding.progressBar.isVisible = res is Resource.Loading
            when(res){
                is Resource.Error -> {
                    Toast.makeText(this, res.message, Toast.LENGTH_SHORT).show()
                }
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                     charactersAdapter.submitList(res.data)
                }
            }
        }
    }
    private fun setUpRecyclerView() = with(binding.rvCharacters){
        adapter = charactersAdapter
        layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,
            false)
    }
}