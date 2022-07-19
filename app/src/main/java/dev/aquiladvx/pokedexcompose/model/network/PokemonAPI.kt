package dev.aquiladvx.pokedexcompose.model.network

import dev.aquiladvx.pokedexcompose.BASE_POKEMON_API_URL
import dev.aquiladvx.pokedexcompose.model.PokemonResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokemonAPI {

    @GET("pokemon?limit=151")
    suspend fun getAllPokemon(): Response<PokemonResponse>

    companion object {
        fun create() : PokemonAPI {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_POKEMON_API_URL)
                .build()
            return retrofit.create(PokemonAPI::class.java)

        }
    }
}