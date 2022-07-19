package dev.aquiladvx.pokedexcompose.ui

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.aquiladvx.pokedexcompose.ui.Destinations.pokemonIdKey
import dev.aquiladvx.pokedexcompose.ui.pokemon.PokemonListScreen
import dev.aquiladvx.pokedexcompose.ui.pokemonDetail.PokemonDetailScreen

object Destinations {
    const val pokemonIdKey = "pokemonId"
    const val POKEMON_LIST = "pokemonList"
    const val POKEMON_DETAIL = "pokemonDetail"
}

@Composable
fun NavGraph(
    finishActivity: () -> Unit = {},
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    viewModel: PokemonViewModel
) {

    NavHost(
        navController = navController,
        startDestination = Destinations.POKEMON_LIST
    ) {
        composable(Destinations.POKEMON_LIST) {
            BackHandler {
                finishActivity()
            }

            PokemonListScreen(viewModel) {
                navController.navigate("${Destinations.POKEMON_DETAIL}/$it")
            }
        }

        composable("${Destinations.POKEMON_DETAIL}/{${pokemonIdKey}}", arguments = listOf(
            navArgument("pokemonId") {
                type = NavType.IntType
            }
        )) {
            val id = it.arguments?.getInt("pokemonId", 0)

            PokemonDetailScreen(id!!)
        }

    }

}