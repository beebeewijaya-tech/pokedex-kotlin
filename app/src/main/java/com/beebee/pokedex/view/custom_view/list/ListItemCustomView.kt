package com.beebee.pokedex.view.custom_view.list

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.View
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.beebee.pokedex.R
import com.beebee.pokedex.model.pojo.pokemon.PokemonTypes
import com.beebee.pokedex.utils.Color
import com.beebee.pokedex.view.ui.list.ListFragmentDirections
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.poke_list.view.*

class ListItemCustomView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {
	fun initView(pokemon: PokemonTypes) {
		renderItem(pokemon)
	}

	private fun renderItem(pokemon: PokemonTypes) {
		pokemon_name.text = pokemon.name.capitalize()
		pokemon.types.apply {
			if (this.size > 1) {
				pokemon_type_one.text = pokemon.types[0]?.type?.name?.capitalize()
				pokemon_type_two.text = pokemon.types[1]?.type?.name?.capitalize()
			} else {
				pokemon_type_one.text = pokemon.types[0]?.type?.name?.capitalize()
			}
		}

		// List Color
		changeColor(pokemon)

		// Pokemon Image
		Glide.with(this)
			.load("https://pokeres.bastionbot.org/images/pokemon/${pokemon.id}.png")
			.into(pokemon_image)

		// Condition for only 1 types pokemon EG. Charmender
		if (pokemon.types.size <= 1) {
			pokemon_type_two_wrapper.visibility = View.GONE
		}

		// Navigating to detail
		this.setOnClickListener {
			val action = ListFragmentDirections.actionListFragmentToDetailFragment(pokemon)
			findNavController().navigate(action)
		}
	}

	private fun changeColor(pokemon: PokemonTypes) {
		var color = Color.getColor(pokemon)
		var typeColor = Color.getTypeColor(pokemon)

		poke_list_container.setBackgroundColor(ContextCompat.getColor(context, color))
		pokemon_type_one_wrapper.setBackgroundTintList(
			ColorStateList.valueOf(
				ContextCompat.getColor(
					context,
					typeColor
				)
			)
		)
		pokemon_type_two_wrapper.setBackgroundTintList(
			ColorStateList.valueOf(
				ContextCompat.getColor(
					context,
					typeColor
				)
			)
		)
	}
}