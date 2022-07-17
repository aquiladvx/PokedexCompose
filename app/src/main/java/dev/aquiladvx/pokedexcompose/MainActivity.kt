package dev.aquiladvx.pokedexcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.aquiladvx.pokedexcompose.core.ui.PokemonCell
import dev.aquiladvx.pokedexcompose.core.ui.theme.PokedexComposeTheme
import dev.aquiladvx.pokedexcompose.features.home.model.Pokemon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   LazyColumn {
                       items(getFakeList()) { pokemon ->
                           Surface(modifier = Modifier.padding(5.dp)) {
                               PokemonCell(pokemon = pokemon)
                           }

                       }
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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexComposeTheme {
    }
}