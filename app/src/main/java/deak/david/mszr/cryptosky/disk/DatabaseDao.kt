package deak.david.mszr.cryptosky.disk

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import deak.david.mszr.cryptosky.disk.model.DBCoin

@Dao
interface DatabaseDao {
    @Query("DELETE FROM coinClass")
    fun deleteAllCoins()

    @Query("SELECT * FROM coinClass")
    fun getAllCoins(): List<DBCoin>

    @Query("SELECT * FROM coinClass WHERE id=:id")
    fun getCoinById(id: Int): DBCoin

    @Insert
    fun insertCoin(coin: DBCoin)
}