package deak.david.mszr.cryptosky.network

import retrofit2.http.GET

interface CryptoAPI {
    @GET("/cryptos")
    suspend fun getCryptos() : CryptoResult
}