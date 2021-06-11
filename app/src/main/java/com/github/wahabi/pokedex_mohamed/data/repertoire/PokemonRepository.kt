package com.github.wahabi.pokedex_mohamed.repertoire

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.github.wahabi.pokedex_mohamed.PokeApi.PokemonApi
import com.github.wahabi.pokedex_mohamed.datasource.PokemonDataSource
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class PokemonRepository @Inject constructor(private val pokemonApi: PokemonApi) : BaseRepository() {
    fun getPokemon(searchString: String?) = Pager(
        config = PagingConfig(enablePlaceholders = false, pageSize = 25),
        pagingSourceFactory = {
            PokemonDataSource(pokemonApi, searchString)
        }
    ).flow

    suspend fun getSinglePokemon(id: Int) = safeApiCall {
        pokemonApi.getSinglePokemon(id)

    }


}