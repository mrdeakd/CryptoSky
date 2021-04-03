package deak.david.mszr.cryptosky.network

import io.swagger.client.apis.CoinApi
import io.swagger.client.models.ResponseListOfCoins
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoNetworkDataSource @Inject constructor(
    private val cryptoAPI: CoinApi
) {
    suspend fun getCryptos(): ResponseListOfCoins {
        return cryptoAPI.getCoins()
    }
}