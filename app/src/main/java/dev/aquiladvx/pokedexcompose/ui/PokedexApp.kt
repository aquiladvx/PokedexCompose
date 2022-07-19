package dev.aquiladvx.pokedexcompose.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dev.aquiladvx.pokedexcompose.ui.theme.PokedexComposeTheme

@Composable
fun PokedexApp(viewModel: PokemonViewModel, finishActivity: () -> Unit) {
    PokedexComposeTheme {
        val navController = rememberNavController()
        Scaffold(backgroundColor = MaterialTheme.colors.primarySurface,) { innerPaddingModifier ->
            NavGraph(finishActivity = finishActivity, navController = navController, modifier = Modifier.padding(innerPaddingModifier), viewModel = viewModel)
        }

    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexComposeTheme {
    }
}
