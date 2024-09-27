package com.geeks.h_w6_5m
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
 @Inject
    lateinit var loveViewModelFactory:ViewModelProvider.Factory
    private lateinit var loveViewModel:LoveViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loveViewModel = ViewModelProvider(this,loveViewModelFactory).get(LoveViewModel::class.java)
        loveViewModel.insertLove(LoveEntity(name = "Albina", age = 19 ))
        loveViewModel.deleteLove(LoveEntity(id = 1,name = "Albina", age = 19))
    }
}