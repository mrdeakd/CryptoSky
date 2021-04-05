package deak.david.mszr.cryptosky.disk.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coinClass")
data class DBCoin(
    @PrimaryKey var id: kotlin.String,
    var rank: kotlin.String,
    var symbol: kotlin.String,
    var name: kotlin.String,
    var supply: kotlin.String,
    var maxSupply: kotlin.String,
    var marketCapUsd: kotlin.String,
    var volumeUsd24Hr: kotlin.String,
    var priceUsd: kotlin.String,
    var changePercent24Hr: kotlin.String,
    var vwap24Hr: kotlin.String
)