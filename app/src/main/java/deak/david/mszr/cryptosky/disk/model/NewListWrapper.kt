package deak.david.mszr.cryptosky.disk.model

data class NewListWrapper(
    var listOfCoins: List<DBCoin>,
    var listChanged: Boolean
)