package com.beebee.pokedex.view.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.beebee.pokedex.R
import com.beebee.pokedex.model.pojo.pokemon.PokemonTypes
import com.beebee.pokedex.view.custom_view.list.ListItemCustomView
import com.beebee.pokedex.viewmodel.list.ListDelegate

class ListAdapter(
	val listPokemon: MutableList<PokemonTypes> = mutableListOf()
) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
	inner class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
		fun bind(pokemon: PokemonTypes) {
			(view as ListItemCustomView).initView(pokemon)
		}
	}

	fun updateList(updatedList: List<PokemonTypes>) {
		val diffCalback = DiffUtilCallback(listPokemon, updatedList)
		val diffResult = DiffUtil.calculateDiff(diffCalback)
		listPokemon.clear()
		listPokemon.addAll(updatedList)
		diffResult.dispatchUpdatesTo(this)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder = ViewHolder(
		LayoutInflater.from(parent.context).inflate(R.layout.poke_list, parent, false)
	)

	override fun getItemCount(): Int = listPokemon.size

	override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
		holder.bind(listPokemon[position])
	}

	class DiffUtilCallback(val oldList: MutableList<PokemonTypes>, val newList: List<PokemonTypes>): DiffUtil.Callback() {
		override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
			oldList[oldItemPosition] == newList[newItemPosition]

		override fun getOldListSize(): Int = oldList.size

		override fun getNewListSize(): Int = newList.size

		override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
			oldList[oldItemPosition].id == newList[newItemPosition].id
	}
}