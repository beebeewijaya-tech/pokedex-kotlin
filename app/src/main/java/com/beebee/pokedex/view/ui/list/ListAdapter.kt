package com.beebee.pokedex.view.ui.list

import android.content.Context
import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.beebee.pokedex.R
import com.beebee.pokedex.model.pojo.Pokemon
import com.beebee.pokedex.view.custom_view.list.ListItemCustomView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.poke_list.view.*

class ListAdapter(val listPokemon: List<Pokemon>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
	class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
		fun bind(pokemon: Pokemon) {
			(view as ListItemCustomView).initView(pokemon)
		}
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder = ViewHolder(
		LayoutInflater.from(parent.context).inflate(R.layout.poke_list, parent, false)
	)

	override fun getItemCount(): Int = listPokemon.size

	override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
		holder.bind(listPokemon[position])
	}
}