package com.geeks.h_w3_6m

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.geeks.h_w3_6m.databinding.ActivityMainBinding

class CharactersListAdapter: ListAdapter<Character, CharacterViewHolder>(diffItemCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
    return CharacterViewHolder(
    ActivityMainBinding.inflate(LayoutInflater.from(parent.context),
    parent,false)
  )
 }
 override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
  holder.onBind(getItem(position))
 }

 }

 class CharacterViewHolder(private val binding: ViewBinding): RecyclerView.ViewHolder(binding.root){
  fun onBind(character: Character){

  }
  }
  val diffItemCallback = object : DiffUtil.ItemCallback<Character>() {
   override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
    return oldItem.id == newItem.id
   }
   @SuppressLint("DiffUtilEquals")
   override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
    return oldItem == newItem
   }
  }
