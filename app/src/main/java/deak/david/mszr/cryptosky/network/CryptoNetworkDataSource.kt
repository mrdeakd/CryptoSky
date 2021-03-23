package deak.david.mszr.cryptosky.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CryptoNetworkDataSource @Inject constructor(
        private val cryptoAPI: CryptoAPI
) {

    suspend fun getCryptos(): CryptoResult {
        var result = cryptoAPI.getCryptos()
        return result
    }

}