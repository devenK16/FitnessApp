package com.example.fitnessapp.api

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("X-RapidAPI-Key" , "9830b2a539msha7ccd3c60e0df5dp1e70e5jsn404d5157db65")
        request.addHeader("X-RapidAPI-Host" , "exercisedb.p.rapidapi.com")

        return chain.proceed(request.build())
    }

}