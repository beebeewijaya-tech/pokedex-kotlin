package com.beebee.pokedex.view.custom_view.list

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.beebee.pokedex.model.pojo.pokemon.PokemonTypes
import com.beebee.pokedex.view.ui.list.ListAdapter
import kotlinx.android.synthetic.main.fragment_list.view.*

class ListCustomView @JvmOverloads constructor(
	context: Context,
	attrs: AttributeSet? = null,
	defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
	private lateinit var adapter: ListAdapter
	fun initView() {
		renderContent()
	}

	fun renderContent() {
		poke_list.layoutManager = GridLayoutManager(context, 2)
		adapter = ListAdapter()
		poke_list.adapter = adapter
	}

	fun updateList(updateList: List<PokemonTypes>) {
		adapter.updateList(updateList)
	}
}