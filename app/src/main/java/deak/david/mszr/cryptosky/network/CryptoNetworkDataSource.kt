package deak.david.mszr.cryptosky.network

import deak.david.mszr.cryptosky.data.network.model.ResponseListOfCoins
import deak.david.mszr.cryptosky.data.network.model.ResponseObjectOfCoin
import deak.david.mszr.cryptosky.network.api.BaseApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoNetworkDataSource @Inject constructor(
    private val cryptoAPI: BaseApi
) {
    suspend fun getCryptos(): ResponseListOfCoins {
        return cryptoAPI.getCoins().body() ?: ResponseListOfCoins()
    }

    suspend fun getCryptoById(coinId: String): ResponseObjectOfCoin {
        return cryptoAPI.getCoinById(coinId).body() ?: ResponseObjectOfCoin()
    }
}