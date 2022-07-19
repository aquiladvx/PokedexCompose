package dev.aquiladvx.pokedexcompose.ui.pokemon

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.aquiladvx.pokedexcompose.model.Pokemon
import dev.aquiladvx.pokedexcompose.model.PokemonResponse
import dev.aquiladvx.pokedexcompose.model.network.Resource
import dev.aquiladvx.pokedexcompose.ui.PokemonViewModel
import dev.aquiladvx.pokedexcompose.ui.common.Loader

@Composable
fun PokemonListScreen(viewModel: PokemonViewModel, goToDetail: (Int) -> Unit) {
    val allPokemonResource = viewModel.allPokemon.value

    when (allPokemonResource) {
        is Resource.Loading -> {
            Loader()
        }

        is Resource.Success -> {
            PokemonList(allPokemonResource.data!!.results, goToDetail)
        }

        is Resource.DataError -> {
            print("error")
        }
    }

}

@Composable
fun PokemonList(pokemon: List<Pokemon>, goToDetail: (Int) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn {
            items(pokemon) { pokemon ->
                Surface(modifier = Modifier.padding(5.dp)) {
                    PokemonCell(pokemon = pokemon) {
                        goToDetail(it.getId())
                    }
                }
            }
        }
    }
}

fun getFakeList(): List<Pokemon> {
    val res = mutableListOf(
        Pokemon("Bulbassaur", "https://pokeapi.co/api/v2/pokemon/1/"),
        Pokemon("Charmander", "https://pokeapi.co/api/v2/pokemon/4/"),
        Pokemon("Squirtle", "https://pokeapi.co/api/v2/pokemon/7/"),
        Pokemon("Pikachu", "https://pokeapi.co/api/v2/pokemon/25/"),
    )

    return res
}
