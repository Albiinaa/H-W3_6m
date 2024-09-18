package com.geeks.h_w8_3m

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.geeks.myapplication.databinding.ItemCharacterBinding

class CharacterAdapter(
    private var characterList: ArrayList<CharacterModel>,
    val onClick: (model: CharacterModel) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterAdapter.ViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    override fun getItemCount(): Int {
        return characterList.size
    }

    inner class ViewHolder(private var binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CharacterModel) {
            binding.tvName.text = item.name
            binding.tvInfo.text = item.info
            Glide.with(binding.imgRick).load(item.image).into(binding.imgRick)
            itemView.setOnClickListener {
                onClick.invoke(item)
            }
        }
    }
}