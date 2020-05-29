package com.beebee.pokedex.view.custom_view.list

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.beebee.pokedex.model.pojo.pokemon.PokemonTypes
import com.beebee.pokedex.view.ui.list.ListAdapter
import com.beebee.pokedex.viewmodel.list.ListDelegate
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListCustomView(
	context: Context,
	attrs: AttributeSet?
) : SwipeRefreshLayout(context, attrs) {
	private lateinit var adapter: ListAdapter
	private lateinit var actionDelegate: ListDelegate
	private var isShowsFabs: Boolean = false

	fun initView(acDelegate: ListDelegate) {
		actionDelegate = acDelegate
		renderContent()
	}

	fun renderContent() {
		renderFabs()

		poke_list.layoutManager = GridLayoutManager(context, 2)
		adapter = ListAdapter()
		poke_list.adapter = adapter

		open_filter_pokemon.setOnClickListener {
			isShowsFabs = !isShowsFabs
			renderFabs()
		}

		grass_pokemon.setOnClickListener { filterPokemon("Grass") }
		fire_pokemon.setOnClickListener { filterPokemon("Fire") }
		water_pokemon.setOnClickListener { filterPokemon("Water") }
		bug_pokemon.setOnClickListener { filterPokemon("Bug") }
	}

	fun updateList(updateList: List<PokemonTypes>) {
		adapter.updateList(updateList)
	}

	private fun renderFabs() {
		if (isShowsFabs) {
			grass_pokemon.visibility = View.VISIBLE
			fire_pokemon.visibility = View.VISIBLE
			water_pokemon.visibility = View.VISIBLE
			bug_pokemon.visibility = View.VISIBLE
		} else {
			grass_pokemon.visibility = View.GONE
			fire_pokemon.visibility = View.GONE
			water_pokemon.visibility = View.GONE
			bug_pokemon.visibility = View.GONE
		}
	}

	private fun filterPokemon(type: String) {
		isShowsFabs = !isShowsFabs
		renderFabs()
		open_filter_pokemon.visibility = View.GONE
		actionDelegate.filterPokemon(type)
	}
}