package com.github.wahabi.pokedex_mohamed.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.github.wahabi.pokedex_mohamed.R
import com.github.wahabi.pokedex_mohamed.model.PokemonResult
import java.io.Serializable

public class PokemonListFragmentDirections private constructor() {
    private data class ToPokemonStatsFragment(
        public val pokemonResult: PokemonResult,
        public val dominantColor: Int = 0,
        public val picture: String?
    ) : NavDirections {
        public override fun getActionId(): Int = R.id.to_pokemonStatsFragment

        @Suppress("CAST_NEVER_SUCCEEDS")
        public override fun getArguments(): Bundle {
            val result = Bundle()
            if (Parcelable::class.java.isAssignableFrom(PokemonResult::class.java)) {
                result.putParcelable("pokemon_result", this.pokemonResult as Parcelable)
            } else if (Serializable::class.java.isAssignableFrom(PokemonResult::class.java)) {
                result.putSerializable("pokemon_result", this.pokemonResult as Serializable)
            } else {
                throw UnsupportedOperationException(PokemonResult::class.java.name +
                        " must implement Parcelable or Serializable or must be an Enum.")
            }
            result.putInt("dominant_color", this.dominantColor)
            result.putString("picture", this.picture)
            return result
        }
    }

    public companion object {
        public fun toPokemonStatsFragment(
            pokemonResult: PokemonResult,
            dominantColor: Int = 0,
            picture: String?
        ): NavDirections = ToPokemonStatsFragment(pokemonResult, dominantColor, picture)
    }
}
