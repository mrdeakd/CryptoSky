package deak.david.mszr.cryptosky.network.api

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    const val BASE_URL = "https://api.coincap.io/v2/"

    fun start(): CoinApi {
        val gson = GsonBuilder()
            .setLenient()
            .create();

        val retrofit =  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

        val coinAPI = retrofit.create(CoinApi::class.java)

        return coinAPI
    }
}