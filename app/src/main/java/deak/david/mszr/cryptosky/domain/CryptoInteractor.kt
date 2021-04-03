package deak.david.mszr.cryptosky.domain

import deak.david.mszr.cryptosky.disk.model.DBCoin
import deak.david.mszr.cryptosky.disk.RoomDataSource
import deak.david.mszr.cryptosky.network.CryptoNetworkDataSource
import io.swagger.client.models.ResponseListOfCoins
import io.swagger.client.models.mapToDomainDBCoin
import javax.inject.Inject

class CryptoInteractor @Inject constructor(
   private val cryptoNetworkDataSource: CryptoNetworkDataSource,
   private val roomDataSource: RoomDataSource
) {
    suspend fun getCryptoResult(): List<DBCoin> {
        val coinList: ResponseListOfCoins = cryptoNetworkDataSource.getCryptos()
        roomDataSource.saveCoin(coinList.data[0].mapToDomainDBCoin())
        return roomDataSource.getCoins()
    }
}