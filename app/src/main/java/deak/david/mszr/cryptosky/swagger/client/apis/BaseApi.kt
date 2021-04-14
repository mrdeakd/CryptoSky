package deak.david.mszr.cryptosky.swagger.client.apis

import io.swagger.client.models.ResponseListOfCoins
import io.swagger.client.models.ResponseObjectOfCoin

interface BaseApi {
    fun getCoinById(id: kotlin.String) : ResponseObjectOfCoin
    fun getCoins(limit: kotlin.Int = 2000) : ResponseListOfCoins
}