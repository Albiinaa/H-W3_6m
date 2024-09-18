package com.geeks.hw1_4m

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

class Details : Fragment(){
    private var _binding: Details? = null
    private val binding get() = _binding!!
    private val args : DetailsArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = .inflate(inflater, container, false)
        val view = binding.root
        val userDetails = args.user
        binding.tvName.text = userDetails.name
        binding.tvEmail.text = userDetails.email
        binding.tvPassword.text = userDetails.password
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}