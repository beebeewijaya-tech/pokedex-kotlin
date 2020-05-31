package com.beebee.pokedex.utils

import com.beebee.pokedex.R
import com.beebee.pokedex.model.pojo.pokemon.PokemonTypes

object Color {
	fun getColor(pokemon: PokemonTypes): Int {
		var color = when (pokemon.types[0]?.type?.name) {
			"grass" -> R.color.green
			"fire" -> R.color.red
			"water" -> R.color.blue
			"electric" -> R.color.yellow
			"normal" -> R.color.normal
			"bug" -> R.color.bug
			else -> R.color.green
		}
		return color
	}

	fun getTypeColor(pokemon: PokemonTypes): Int {
		var typeColor = when (pokemon.types[0]?.type?.name) {
			"grass" -> R.color.wild_carribean_green
			"fire" -> R.color.light_red
			"water" -> R.color.light_blue
			"electric" -> R.color.light_yellow
			"normal" -> R.color.light_normal
			"bug" -> R.color.light_bug
			else -> R.color.wild_carribean_green
		}
		return typeColor
	}
}