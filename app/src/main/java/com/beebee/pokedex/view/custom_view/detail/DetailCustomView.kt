package com.beebee.pokedex.view.custom_view.detail

import android.content.Context
import android.content.res.ColorStateList
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.beebee.pokedex.model.pojo.pokemon.PokemonTypes
import com.beebee.pokedex.utils.Color
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detail.view.*

class DetailCustomView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

	fun initView(pokemon: PokemonTypes) {
		renderContent(pokemon)
		changeColor(pokemon)
	}

	private fun renderContent(pokemon: PokemonTypes) {
		detail_poke_name.text = pokemon.name.capitalize()
		detail_poke_id.text = "#0${pokemon.id}"

		// Pokemon types
		pokemon.types.apply {
			if (this.size > 1) {
				detail_pokemon_type_one.text = pokemon.types[0]?.type?.name?.capitalize()
				detail_pokemon_type_two.text = pokemon.types[1]?.type?.name?.capitalize()
			} else {
				detail_pokemon_type_one.text = pokemon.types[0]?.type?.name?.capitalize()
			}
		}

		// Poke Images
		Glide.with(this)
			.load("https://pokeres.bastionbot.org/images/pokemon/${pokemon.id}.png")
			.into(detail_poke_image)

		// Types conditional for one types
		if (pokemon.types.size <= 1) {
			detail_pokemon_type_two.visibility = View.GONE
		}

		// Main toolbar
		back_button.setOnClickListener {
			findNavController().popBackStack()
		}
	}

	private fun changeColor(pokemon: PokemonTypes) {
		var color = Color.getColor(pokemon)
		var typeColor = Color.getTypeColor(pokemon)

		detail_poke_container.setBackgroundTintList(
			ColorStateList.valueOf(
				ContextCompat.getColor(
					context,
					color
				)
			)
		)

		detail_pokemon_type_one_wrapper.setBackgroundTintList(
			ColorStateList.valueOf(
				ContextCompat.getColor(
					context,
					typeColor
				)
			)
		)

		detail_pokemon_type_two_wrapper.setBackgroundTintList(
			ColorStateList.valueOf(
				ContextCompat.getColor(
					context,
					typeColor
				)
			)
		)
	}
}
