package deak.david.mszr.cryptosky.disk

import androidx.room.Database
import androidx.room.RoomDatabase
import deak.david.mszr.cryptosky.disk.model.DBCoin

@Database(entities = [DBCoin::class], version = 1, exportSchema = false)
abstract class CoinRoomDatabase : RoomDatabase() {
    abstract fun coinDataDao(): DatabaseDao
}