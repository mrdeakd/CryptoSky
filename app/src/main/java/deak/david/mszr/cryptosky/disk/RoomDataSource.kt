package deak.david.mszr.cryptosky.disk

import deak.david.mszr.cryptosky.disk.model.DBCoin
import javax.inject.Inject

open class RoomDataSource @Inject constructor(
    private val databaseDao: DatabaseDao
) {
    fun saveCoin(coin: DBCoin) {
        databaseDao.insertCoin(coin)
    }

    fun getCoins(): List<DBCoin> {
        return databaseDao.getAllCoins()
    }

    fun deleteCoinById(id: String) {
        databaseDao.deleteCoinById(id)
    }

    fun getCoinById(id: String): DBCoin {
        return databaseDao.getCoinById(id)
    }
}