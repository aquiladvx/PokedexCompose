package dev.aquiladvx.pokedexcompose.model

import dev.aquiladvx.pokedexcompose.model.network.PokemonAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class PokemonRepository() {
    val remote = PokemonAPI.create()
//    val local = PokemonDAO

    suspend fun getAllPokemon(): Flow<PokemonResponse> {
        val response = remote.getAllPokemon()

        return flow {
            if (response.isSuccessful) {
                emit(response.body()!!)
            } else {
//                emit()
            }
        }.flowOn(Dispatchers.IO)
    }
}