package com.geeks.hw1_4m

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class RegistrationFragment : Fragment() {
    private var _binding: RegistrationFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        val view = binding.root
    }
    binding.buttonSend.setOnClickListener{
        val name = binding.et_name.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()
    }
    val user = User(name,email, password)
    val action = RegistrationDirections.actionRegistrationFragmentToDetails(user)
    findNavController().navigate(
    action
    )
}
return view
}
override fun onDestroyView() {
    super.onDestroyView()
    _binding = null
}
