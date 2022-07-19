package com.brito.pokedex.repository

import com.brito.pokedex.data.remote.PokeApi
import com.brito.pokedex.data.remote.response.Pokemon
import com.brito.pokedex.data.remote.response.PokemonList
import com.brito.pokedex.util.Resource

class PokemonRepository(private val api: PokeApi) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (exception: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (exception: Exception) {
            return Resource.Error("An unknown error occured.")
        }
        return Resource.Success(response)
    }
}