package com.github.wahabi.pokedex_mohamed.viewmodels

import androidx.lifecycle.ViewModel
import com.github.wahabi.pokedex_mohamed.repertoire.PokemonRepository
import com.github.wahabi.pokedex_mohamed.utils.NetworkResource
import com.github.wahabi.pokedex_mohamed.utils.extractId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject


@HiltViewModel
class PokemonStatsViewModel @Inject constructor(private val pokemonRepository: PokemonRepository) :
    ViewModel() {

    suspend fun getSinglePokemon(url: String) = flow {
        val id = url.extractId()
        emit(NetworkResource.Loading)
        emit(pokemonRepository.getSinglePokemon(id))
    }

}