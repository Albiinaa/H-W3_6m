package com.geeks.h_w8_3m

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.geeks.myapplication.R
import com.geeks.myapplication.databinding.FragmentCharacterBinding

class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding
    private val listOfCharacter = arrayListOf(
        CharacterModel(
            "https://i.pinimg.com/originals/f6/b4/51/f6b4519378cd1bb9be3b8715647882b7.jpg",
            "Rick Sanchez",
            "Alive"
        ),
        CharacterModel(
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSauq04SQwjZwgb2-FK_wRzY_oIOWznOxE63w&usqp=CAU",
            "Morty Smith",
            "Alive"
        ),
        CharacterModel(
            "https://img.freepik.com/fotos-premium/ilustracion-albert-einstein_553012-27427.jpg",
            "Albert Einstein",
            "Dead"
        ),
        CharacterModel(
            "https://i.pinimg.com/1200x/c5/be/4f/c5be4f955700ca3aad43cc2ac2d78015.jpg",
            "Jerry Smith",
            "Alive"
        ),
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CharacterAdapter(listOfCharacter,this::onClick)
        binding.recyclerView.adapter=adapter
    }
private fun onClick(model: CharacterModel){
    findNavController().navigate(R.id.signInFragment, bundleOf("character" to model))
}

}