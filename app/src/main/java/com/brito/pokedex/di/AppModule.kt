package com.brito.pokedex.di

import com.brito.pokedex.data.remote.PokeApi
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {

    val module = module {

    }

    val dataModule = module {
        single<PokeApi> {
            Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://pokeapi.co/api/v2")
                .build()
                .create(PokeApi::class.java)
        }
    }
}