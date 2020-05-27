package com.beebee.pokedex.view.custom_view.list

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.beebee.pokedex.R
import com.beebee.pokedex.model.pojo.Pokemon
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.poke_list.view.*

class ListItemCustomView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {
	fun initView(pokemon: Pokemon) {
		renderItem(pokemon)
	}

	private fun renderItem(pokemon: Pokemon) {
		pokemon_name.text = pokemon.name
		pokemon_type_one.text = pokemon.type_one
		pokemon_type_two.text = pokemon.type_two
		changeColor(pokemon)

		Glide.with(this)
			.load(pokemon.image)
			.into(pokemon_image)

		if (pokemon.type_two.isNullOrEmpty()) {
			pokemon_type_two_wrapper.visibility = View.GONE
		}
	}

	private fun changeColor(pokemon: Pokemon) {
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
		poke_list_container.setBackgroundColor(ContextCompat.getColor(context, color))
		pokemon_type_one_wrapper.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, typeColor)))
		pokemon_type_two_wrapper.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, typeColor)))
	}
}