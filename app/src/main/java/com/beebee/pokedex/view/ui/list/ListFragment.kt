package com.beebee.pokedex.view.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager

import com.beebee.pokedex.R
import com.beebee.pokedex.model.pojo.Pokemon
import kotlinx.android.synthetic.main.fragment_list.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        poke_list.layoutManager = GridLayoutManager(activity, 2)
        val adapter = ListAdapter(
            listOf(
                Pokemon(
                    "Bulbasaur",
                    "Grass",
                    "Poison",
                    "https://static.pokemonpets.com/images/monsters-images-800-800/1-Bulbasaur.png"
                ),
                Pokemon(
                    "Ivysaur",
                    "Grass",
                    "Poison",
                    "https://cdn.bulbagarden.net/upload/7/73/002Ivysaur.png"
                ),
                Pokemon(
                    "Venusaur",
                    "Grass",
                    "Poison",
                    "https://cdn.bulbagarden.net/upload/thumb/a/ae/003Venusaur.png/1200px-003Venusaur.png"
                ),
                Pokemon(
                    "Charmender",
                    "Fire",
                    image = "https://cdn.bulbagarden.net/upload/7/73/004Charmander.png"
                ),
                Pokemon(
                    "Charmeleon",
                    "Fire",
                    image = "https://upload.wikimedia.org/wikipedia/id/f/fb/Charmeleon.png"
                ),
                Pokemon(
                    "Charizard",
                    "Fire",
                    "Flying",
                    "https://cdn.bulbagarden.net/upload/thumb/7/7e/006Charizard.png/1200px-006Charizard.png"
                ),
                Pokemon(
                    "Squirtle",
                    "Water",
                    image = "https://i.dlpng.com/static/png/6935487_preview.png"
                ),
                Pokemon(
                    "Wartortle",
                    "Water",
                    image = "https://upload.wikimedia.org/wikipedia/id/d/d7/Wartortle.png"
                ),
                Pokemon(
                    "Blastoise",
                    "Water",
                    image = "https://upload.wikimedia.org/wikipedia/id/thumb/4/41/Blastoise.png/200px-Blastoise.png"
                ),
                Pokemon(
                    "Pikachu",
                    "Electric",
                    image = "https://pngimg.com/uploads/pokemon/pokemon_PNG148.png"
                )
            )
        )
        poke_list.adapter = adapter
    }

}
