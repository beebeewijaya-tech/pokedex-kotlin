package com.beebee.pokedex.view.ui.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.beebee.pokedex.R
import com.beebee.pokedex.view.custom_view.list.ListCustomView
import com.beebee.pokedex.viewmodel.list.ListViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_list.view.*

/**
 * A simple [Fragment] subclass.
 */
class ListFragment : Fragment(), SwipeRefreshLayout.OnRefreshListener {
    private lateinit var contentView: ListCustomView
    val viewModel: ListViewModel
        get() = ViewModelProvider(this).get(ListViewModel::class.java)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false).apply {
            contentView = this as ListCustomView
            contentView.setOnRefreshListener { onRefresh() }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_loader.visibility = View.VISIBLE
        poke_list.visibility = View.GONE

        renderContent()
        executeViewModel()
    }

    private fun executeViewModel() {
        viewModel.listPokemonLiveData.observe(viewLifecycleOwner, Observer {
            Log.d("Hello from obs", it.toString())
            list_loader.visibility = View.GONE
            poke_list.visibility = View.VISIBLE
            contentView.isRefreshing = false
            contentView.updateList(it)
        })
    }

    private fun renderContent() {
        contentView.initView(viewModel)
    }

    override fun onRefresh() {
        viewModel.getPokemon()
    }

}
