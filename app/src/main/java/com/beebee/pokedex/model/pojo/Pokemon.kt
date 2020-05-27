package com.beebee.pokedex.model.pojo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
	val name: String,
	val type_one: String,
	val type_two: String? = null,
	val image: String
) : Parcelable
