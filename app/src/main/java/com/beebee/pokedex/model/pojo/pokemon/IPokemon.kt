package com.beebee.pokedex.model.pojo.pokemon

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IPokemon {
	@GET("pokemon")
	fun getPokemonList(): Call<Pokemon>

	@GET("pokemon/{id}")
	fun getPokemonTypes(@Path("id") id: String): Call<PokemonTypes>
}