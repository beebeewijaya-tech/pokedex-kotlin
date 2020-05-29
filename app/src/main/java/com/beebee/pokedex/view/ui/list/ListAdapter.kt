package com.beebee.pokedex.view.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.beebee.pokedex.R
import com.beebee.pokedex.model.pojo.pokemon.PokemonTypes
import com.beebee.pokedex.view.custom_view.list.ListItemCustomView

class ListAdapter(val listPokemon: MutableList<PokemonTypes> = mutableListOf()) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
	class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
		fun bind(pokemon: PokemonTypes) {
			(view as ListItemCustomView).initView(pokemon)
		}
	}

	fun updateList(updatedList: List<PokemonTypes>) {
		listPokemon.clear()
		listPokemon.addAll(updatedList)
		notifyDataSetChanged()
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder = ViewHolder(
		LayoutInflater.from(parent.context).inflate(R.layout.poke_list, parent, false)
	)

	override fun getItemCount(): Int = listPokemon.size

	override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
		holder.bind(listPokemon[position])
	}
}