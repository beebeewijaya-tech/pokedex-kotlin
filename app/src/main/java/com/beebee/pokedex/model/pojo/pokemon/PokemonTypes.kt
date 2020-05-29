package com.beebee.pokedex.model.pojo.pokemon

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class PokemonTypes(
	val id: Int,
	val name: String,

	@SerializedName("types")
	var types: @RawValue List<Types>
) : Parcelable

data class Types (
	val slot: Int,
	val type: Type? = null
)

data class Type (
	val name: String
)