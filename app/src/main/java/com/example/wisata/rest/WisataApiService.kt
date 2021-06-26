package com.example.wisata.rest

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WisataApiService {
    companion object {
        fun getClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("http://arslyn.com/wisataapi/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        }
    }
}