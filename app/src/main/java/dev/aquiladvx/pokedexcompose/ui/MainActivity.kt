package dev.aquiladvx.pokedexcompose.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dev.aquiladvx.pokedexcompose.model.PokemonRepository

class MainActivity : ComponentActivity() {

    private val viewModel: PokemonViewModel by viewModels {
        PokemonViewModel.PokemonViewModelFactory(PokemonRepository())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexApp(viewModel) {
                finish()
            }
        }
    }
}