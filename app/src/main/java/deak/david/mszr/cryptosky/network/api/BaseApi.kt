package deak.david.mszr.cryptosky.network.api

import deak.david.mszr.cryptosky.data.network.model.ResponseListOfCoins
import deak.david.mszr.cryptosky.data.network.model.ResponseObjectOfCoin
import retrofit2.Response

interface BaseApi {
    suspend fun getCoinById(id: kotlin.String) : Response<ResponseObjectOfCoin>
    suspend fun getCoins(limit: kotlin.Int? = 2000) : Response<ResponseListOfCoins>
}