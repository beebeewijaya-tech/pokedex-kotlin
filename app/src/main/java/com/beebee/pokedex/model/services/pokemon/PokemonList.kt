package com.beebee.pokedex.model.services.pokemon

import android.util.Log
import com.beebee.pokedex.model.pojo.pokemon.Pokemon
import com.beebee.pokedex.model.pojo.pokemon.PokemonServices
import com.beebee.pokedex.model.pojo.pokemon.PokemonTypes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonList : IPokemonList {
	override fun getPokemon(): List<PokemonTypes> {
		return emptyList<PokemonTypes>()
	}
}