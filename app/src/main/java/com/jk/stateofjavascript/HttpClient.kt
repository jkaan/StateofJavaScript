package com.jk.stateofjavascript

import com.apollographql.apollo.ApolloClient

import okhttp3.OkHttpClient

class HttpClient {

    companion object {
        private const val BASE_URL = "https://api.stateofjs.com/graphql"

        val instance: ApolloClient by lazy {
            val okHttpClient = OkHttpClient.Builder().build()

            ApolloClient.builder()
                .serverUrl(BASE_URL)
                .okHttpClient(okHttpClient)
                .build()
        }
    }
}
