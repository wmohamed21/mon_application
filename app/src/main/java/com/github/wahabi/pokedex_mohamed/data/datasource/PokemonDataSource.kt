package com.github.wahabi.pokedex_mohamed.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.wahabi.pokedex_mohamed.PokeApi.PokemonApi
import com.github.wahabi.pokedex_mohamed.model.PokemonResult
import com.github.wahabi.pokedex_mohamed.utils.SEARCH_LOAD_SIZE
import com.github.wahabi.pokedex_mohamed.utils.STARTING_OFFSET_INDEX
import java.io.IOException


/**
 * j'ai utiliser android jetPack pour cette partie en suivant un tuto sur internet
 */
class PokemonDataSource(private val pokemonApi: PokemonApi, private val searchString: String?) :
    PagingSource<Int, PokemonResult>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonResult> {
        val offset = params.key ?: STARTING_OFFSET_INDEX


        val loadSize = if (searchString == null) params.loadSize else SEARCH_LOAD_SIZE
        return try {
            val data = pokemonApi.getPokemons(loadSize, offset)
            val filteredData = if (searchString != null) {
                data.results.filter { it.name.contains(searchString, true) }
            } else {
                data.results
            }

            LoadResult.Page(
                data = filteredData,
                prevKey = if (offset == STARTING_OFFSET_INDEX) null else offset - loadSize,
                nextKey = if (data.next == null) null else offset + loadSize
            )
        } catch (t: Throwable) {
            var exception = t

            if (t is IOException) {
                exception = IOException("verifier la connexion")
            }
            LoadResult.Error(exception)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, PokemonResult>): Int? {

        return state.anchorPosition

    }
}