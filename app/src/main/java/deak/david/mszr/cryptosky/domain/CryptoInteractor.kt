package deak.david.mszr.cryptosky.domain

import deak.david.mszr.cryptosky.network.CryptoNetworkDataSource
import deak.david.mszr.cryptosky.network.CryptoResult
import javax.inject.Inject

class CryptoInteractor @Inject constructor(
   private val cryptoNetworkDataSource: CryptoNetworkDataSource
) {
    suspend fun getCryptoResult(): CryptoResult {
        return cryptoNetworkDataSource.getCryptos()
    }
}