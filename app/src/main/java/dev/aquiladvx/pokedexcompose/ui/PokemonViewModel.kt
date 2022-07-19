package dev.aquiladvx.pokedexcompose.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import dev.aquiladvx.pokedexcompose.model.Pokemon
import dev.aquiladvx.pokedexcompose.model.PokemonRepository
import dev.aquiladvx.pokedexcompose.model.PokemonResponse
import dev.aquiladvx.pokedexcompose.model.network.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class PokemonViewModel(val dataSource: PokemonRepository): ViewModel() {

    val allPokemon: MutableState<Resource<PokemonResponse>> = mutableStateOf(Resource.Loading())

    init {
        viewModelScope.launch {
            delay(3000)
            getAllPokemon()
        }
    }

    private fun getAllPokemon() {
        viewModelScope.launch {
            allPokemon.value = Resource.Loading()
            dataSource.getAllPokemon().collect {
                allPokemon.value = Resource.Success(it)
            }
        }
    }

    class PokemonViewModelFactory(private val dataSource: PokemonRepository) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            PokemonViewModel(dataSource) as T
    }
}