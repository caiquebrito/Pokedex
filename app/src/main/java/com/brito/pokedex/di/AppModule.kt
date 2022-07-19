package com.brito.pokedex.di

import com.brito.pokedex.data.remote.PokeApi
import com.brito.pokedex.pokemonlist.PokemonListViewModel
import com.brito.pokedex.repository.PokemonRepository
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {

    val api = module {
        single<PokeApi> {
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://pokeapi.co/api/v2")
                .build()
                .create(PokeApi::class.java)
        }
    }

    val repository = module {
        single { PokemonRepository(get()) }
    }

    val presentation = module {
        factory { PokemonListViewModel(get()) }
    }
}