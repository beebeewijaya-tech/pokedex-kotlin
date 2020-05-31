package com.beebee.pokedex.view.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import com.beebee.pokedex.R
import com.beebee.pokedex.model.pojo.pokemon.PokemonTypes
import com.beebee.pokedex.view.custom_view.detail.DetailCustomView

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment : Fragment() {
    private lateinit var contentView: DetailCustomView
    val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false).apply {
            contentView = this as DetailCustomView
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pokemon = args.pokemon
        renderContent(pokemon)
    }

    private fun renderContent(pokemonTypes: PokemonTypes) {
        contentView.initView(pokemonTypes)
    }
}
