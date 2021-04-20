package deak.david.mszr.cryptosky.domain

import deak.david.mszr.cryptosky.Functions
import deak.david.mszr.cryptosky.data.network.model.ResponseListOfCoins
import deak.david.mszr.cryptosky.data.network.model.ResponseObjectOfCoin
import deak.david.mszr.cryptosky.data.network.model.mapToDomainDBCoin
import deak.david.mszr.cryptosky.disk.model.DBCoin
import deak.david.mszr.cryptosky.disk.RoomDataSource
import deak.david.mszr.cryptosky.disk.model.NewListWrapper
import deak.david.mszr.cryptosky.network.CryptoNetworkDataSource
import javax.inject.Inject

class CryptoInteractor @Inject constructor(
   private val cryptoNetworkDataSource: CryptoNetworkDataSource,
   private val roomDataSource: RoomDataSource
) {
    suspend fun getCryptoResult(): List<DBCoin> {
        if(Functions.isConnected()) {
            val coinFromExtList: ResponseListOfCoins = cryptoNetworkDataSource.getCryptos()
            val coinFromRoomList: List<DBCoin> = roomDataSource.getCoins()
            coinFromRoomList.forEach { coinFromRoom ->
                coinFromExtList.data?.forEach { coinFromExt ->
                    if (coinFromRoom.id == coinFromExt.id) {
                        roomDataSource.deleteCoinById(coinFromRoom.id)
                        roomDataSource.saveCoin(coinFromExt.mapToDomainDBCoin())
                    }
                }
            }
        }
        return roomDataSource.getCoins()
    }

    suspend fun addCoinToList(coinId: String): NewListWrapper {
        val coinFromExtList: ResponseObjectOfCoin = cryptoNetworkDataSource.getCryptoById(coinId = coinId)
        coinFromExtList.data?.id?.let {
            roomDataSource.deleteCoinById(it)
        }
        coinFromExtList.data?.let {
            roomDataSource.saveCoin(it.mapToDomainDBCoin())
        }
        coinFromExtList.data?.let {
            return NewListWrapper(roomDataSource.getCoins(),listChanged = true)
        }
        return NewListWrapper(roomDataSource.getCoins(),listChanged = false)
    }

    fun loadDetails(coinId: String): DBCoin {
        return roomDataSource.getCoinById(coinId)
    }
}