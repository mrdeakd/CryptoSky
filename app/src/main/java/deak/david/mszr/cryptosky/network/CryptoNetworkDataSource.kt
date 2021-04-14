package deak.david.mszr.cryptosky.network

import deak.david.mszr.cryptosky.swagger.client.apis.BaseApi
import io.swagger.client.models.ResponseListOfCoins
import io.swagger.client.models.ResponseObjectOfCoin
import io.swagger.client.infrastructure.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoNetworkDataSource @Inject constructor(
    private val cryptoAPI: BaseApi
) {
    suspend fun getCryptos(): ResponseListOfCoins {
        return cryptoAPI.getCoins()
    }

    suspend fun getCryptoById(coinId: String): ResponseObjectOfCoin {
        return try {
            cryptoAPI.getCoinById(coinId)
        } catch (e: ClientException) {
            print(e.message)
            ResponseObjectOfCoin(null,null)
        }
    }
}