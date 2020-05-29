package com.beebee.pokedex.model.pojo.pokemon

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Pokemon(
	@SerializedName("results")
	val results: List<PokemonResult>
)

data class PokemonResult(
	val url: String,
	val name: String
)