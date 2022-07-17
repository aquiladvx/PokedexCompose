package dev.aquiladvx.pokedexcompose.core.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberAsyncImagePainter
import dev.aquiladvx.pokedexcompose.R
import dev.aquiladvx.pokedexcompose.core.ui.theme.PokedexComposeTheme
import dev.aquiladvx.pokedexcompose.features.home.model.Pokemon

@Composable
fun PokemonCell(pokemon: Pokemon) {
    Surface(
        elevation = 5.dp,
        shape = RectangleShape
    ) {
        ConstraintLayout(modifier = Modifier
            .fillMaxWidth(1f)
            .padding(16.dp)) {
            val (title, image) = createRefs()

            Text(text = pokemon.name, modifier = Modifier
                .constrainAs(title) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                })
            Image(
                painter = rememberAsyncImagePainter(pokemon.getImageUrl()),
                contentDescription = "Pokemon Icon",
                modifier = Modifier
                    .constrainAs(image) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    }
                    .size(60.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PokedexComposeTheme {
        Column {
            val pokemon = Pokemon("Bulbassaur", "https://pokeapi.co/api/v2/pokemon/1/")
            PokemonCell(pokemon)
        }

    }
}