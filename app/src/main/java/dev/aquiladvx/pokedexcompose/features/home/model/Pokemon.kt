package dev.aquiladvx.pokedexcompose.features.home.model

data class Pokemon(
    val name: String,
    val url: String,
) {
    private fun getId() = url.split("/").last { it != "" }.toInt()

    fun getImageUrl() =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${getId()}.png"
}