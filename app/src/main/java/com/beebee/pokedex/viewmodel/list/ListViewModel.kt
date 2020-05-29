package com.beebee.pokedex.viewmodel.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.beebee.pokedex.model.pojo.pokemon.Pokemon
import com.beebee.pokedex.model.pojo.pokemon.PokemonServices
import com.beebee.pokedex.model.pojo.pokemon.PokemonTypes
import com.beebee.pokedex.model.services.pokemon.PokemonList
import kotlinx.android.parcel.RawValue
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListViewModel : ViewModel() {
	private val model: PokemonList
		get() = PokemonList()

	private val _listPokemonLiveData: MutableLiveData<List<PokemonTypes>> = MutableLiveData()
	var listPokemonLiveData = _listPokemonLiveData

	init {
		getPokemon()
	}

	private fun getPokemon() {
		val mutableListPokemon: MutableList<PokemonTypes> = mutableListOf()
		val pokemonServices = PokemonServices.servicesClient()

		pokemonServices.getPokemonList().enqueue(object: Callback<Pokemon> {
			override fun onFailure(call: Call<Pokemon>, t: Throwable) {
				Log.e("Error From ${PokemonList::class.java}", t.localizedMessage)
			}

			override fun onResponse(call: Call<Pokemon>, response: Response<Pokemon>) {
				if (response.isSuccessful) {
					val responsePokemon = response.body()?.results
					Thread {
						responsePokemon?.forEach {
							val id = it.url.takeLast(3).replace("/", "")
							val pokemonListData = pokemonServices.getPokemonTypes(id)
								.execute()
								.body()
							val sortedPokemon = pokemonListData?.types?.sortedWith(compareBy({ it.slot }))
							if (sortedPokemon != null) {
								pokemonListData?.types = sortedPokemon
							}
							Log.d("Pokemon data", sortedPokemon.toString())
							mutableListPokemon.add(pokemonListData as PokemonTypes)
						}
						_listPokemonLiveData.postValue(mutableListPokemon)
					}.start()
				} else {
					Log.e("Error From ${PokemonList::class.java}", response.message())
				}
			}
		})
	}
}