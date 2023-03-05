package com.zallpy.applogin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object {
        private const val URL_BASE: String = "https://restful-booker.herokuapp.com"

        fun <T> createRequest(service: Class<T>) : T {
            return getRetrofitInstance().create(service)
        }

        private fun getRetrofitInstance() : Retrofit {
            return Retrofit.Builder()
                .baseUrl(URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}