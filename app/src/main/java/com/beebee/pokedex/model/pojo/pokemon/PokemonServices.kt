package com.beebee.pokedex.model.pojo.pokemon

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonServices {
	val url = "https://pokeapi.co/api/v2/"
	fun servicesClient(): IPokemon {
		val client = Retrofit.Builder()
			.addConverterFactory(GsonConverterFactory.create())
			.baseUrl(url)
			.build()

		return client.create(IPokemon::class.java)
	}
}