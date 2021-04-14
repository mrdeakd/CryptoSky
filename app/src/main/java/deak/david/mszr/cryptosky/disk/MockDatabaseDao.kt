package deak.david.mszr.cryptosky.disk

import deak.david.mszr.cryptosky.disk.model.DBCoin

class MockDatabaseDao: DatabaseDao {
    private var listOfCoins = mutableListOf<DBCoin>()

    override fun deleteAllCoins() {
        listOfCoins = mutableListOf()
    }

    override fun deleteCoinById(id: String) {
        for (item in listOfCoins) {
            if (item.id == id) {
                listOfCoins.remove(item)
            }
        }
    }

    override fun getAllCoins(): List<DBCoin> {
        return listOfCoins.toList()
    }

    override fun getCoinById(id: String): DBCoin {
        for (item in listOfCoins) {
            if (item.id == id) {
                return item
            }
        }
        return DBCoin("","","","","","","","","","","")
    }

    override fun insertCoin(coin: DBCoin) {
        listOfCoins.add(coin)
    }
}