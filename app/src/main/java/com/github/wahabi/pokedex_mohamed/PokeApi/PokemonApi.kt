package com.github.wahabi.pokedex_mohamed.PokeApi

import com.github.wahabi.pokedex_mohamed.model.PokemonResponse
import com.github.wahabi.pokedex_mohamed.model.SinglePokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokemonApi {
    @GET("pokemon/")
    suspend fun getPokemons(
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?
    ): PokemonResponse

    @GET("pokemon/{id}/")
    suspend fun getSinglePokemon(
        @Path("id") id: Int
    ): SinglePokemonResponse
}