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

@Composable
fun PokemonListScreen(goToDetail: (Int) -> Unit) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            LazyColumn {
                items(getFakeList()) { pokemon ->
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
