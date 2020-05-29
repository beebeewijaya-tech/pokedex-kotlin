package com.beebee.pokedex.model.services.pokemon

import com.beebee.pokedex.model.pojo.pokemon.PokemonTypes

interface IPokemonList {
	fun getPokemon(): List<PokemonTypes>
}