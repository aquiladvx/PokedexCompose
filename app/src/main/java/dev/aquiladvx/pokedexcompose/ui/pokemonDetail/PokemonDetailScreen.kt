package dev.aquiladvx.pokedexcompose.ui.pokemonDetail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun PokemonDetailScreen(id: Int) {
    Text(text = id.toString())
}