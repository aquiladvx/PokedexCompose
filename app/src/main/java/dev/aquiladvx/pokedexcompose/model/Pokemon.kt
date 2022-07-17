package dev.aquiladvx.pokedexcompose.model

data class Pokemon(
    val name: String,
    val url: String,
) {
    fun getId() = url.split("/").last { it != "" }.toInt()

    fun getImageUrl() =
        "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${getId()}.png"
}