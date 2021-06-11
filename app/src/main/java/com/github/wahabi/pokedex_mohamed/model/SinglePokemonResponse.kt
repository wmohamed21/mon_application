package com.github.wahabi.pokedex_mohamed.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class SinglePokemonResponse(
    val sprites: Sprites,
    val stats: List<Stats>,
    val taille: Int,
    val poids: Int
) : Parcelable

