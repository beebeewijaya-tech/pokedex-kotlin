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
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.poke_list.view.*

class ListAdapter(val listPokemon: List<Pokemon>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {
	private var context: Context? = null
	class ViewHolder(val view: View): RecyclerView.ViewHolder(view) {
		fun bind(pokemon: Pokemon, context: Context) {
			view.pokemon_name.text = pokemon.name
			view.pokemon_type_one.text = pokemon.type_one
			view.pokemon_type_two.text = pokemon.type_two
			changeColor(pokemon, context)

			Glide.with(view)
				.load(pokemon.image)
				.into(view.pokemon_image)

			if (pokemon.type_two.isNullOrEmpty()) {
				view.pokemon_type_two_wrapper.visibility = View.GONE
			}
		}

		fun changeColor(pokemon: Pokemon, context: Context) {
			var color = when (pokemon.type_one) {
				"Grass" ->  R.color.green
				"Fire" -> R.color.red
				"Water" -> R.color.blue
				"Electric" -> R.color.yellow
				else -> R.color.green
			}
			var typeColor = when (pokemon.type_one) {
				"Grass" ->  R.color.wild_carribean_green
				"Fire" -> R.color.light_red
				"Water" -> R.color.light_blue
				"Electric" -> R.color.light_yellow
				else -> R.color.green
			}
			view.poke_list_container.setBackgroundColor(ContextCompat.getColor(context, color))
			view.pokemon_type_one_wrapper.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, typeColor)))
			view.pokemon_type_two_wrapper.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, typeColor)))
		}
	}
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
		context = parent.getContext();
		val view = LayoutInflater.from(parent.context).inflate(R.layout.poke_list, parent, false)
		return ViewHolder(view)
	}

	override fun getItemCount(): Int = listPokemon.size

	override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
		holder.bind(listPokemon[position], this.context as Context)
	}
}