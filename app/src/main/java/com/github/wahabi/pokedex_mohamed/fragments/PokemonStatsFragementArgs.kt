package com.github.wahabi.pokedex_mohamed.fragments

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import com.github.wahabi.pokedex_mohamed.model.PokemonResult
import java.io.Serializable
import java.lang.IllegalArgumentException

public data class PokemonStatsFragmentArgs(
    public val pokemonResult: PokemonResult,
    public val dominantColor: Int = 0,
    public val picture: String?
) : NavArgs {
    @Suppress("CAST_NEVER_SUCCEEDS")
    public fun toBundle(): Bundle {
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

    public companion object {
        @JvmStatic
        public fun fromBundle(bundle: Bundle): PokemonStatsFragmentArgs {
            bundle.setClassLoader(PokemonStatsFragmentArgs::class.java.classLoader)
            val __pokemonResult : PokemonResult?
            if (bundle.containsKey("pokemon_result")) {
                if (Parcelable::class.java.isAssignableFrom(PokemonResult::class.java) ||
                    Serializable::class.java.isAssignableFrom(PokemonResult::class.java)) {
                    __pokemonResult = bundle.get("pokemon_result") as PokemonResult?
                } else {
                    throw UnsupportedOperationException(PokemonResult::class.java.name +
                            " must implement Parcelable or Serializable or must be an Enum.")
                }
                if (__pokemonResult == null) {
                    throw IllegalArgumentException("Argument \"pokemon_result\" is marked as non-null but was passed a null value.")
                }
            } else {
                throw IllegalArgumentException("Required argument \"pokemon_result\" is missing and does not have an android:defaultValue")
            }
            val __dominantColor : Int
            if (bundle.containsKey("dominant_color")) {
                __dominantColor = bundle.getInt("dominant_color")
            } else {
                __dominantColor = 0
            }
            val __picture : String?
            if (bundle.containsKey("picture")) {
                __picture = bundle.getString("picture")
            } else {
                throw IllegalArgumentException("Required argument \"picture\" is missing and does not have an android:defaultValue")
            }
            return PokemonStatsFragmentArgs(__pokemonResult, __dominantColor, __picture)
        }
    }
}
