package deak.david.mszr.cryptosky.swagger.client.apis

import android.content.Context
import deak.david.mszr.cryptosky.getJsonDataFromAsset
import io.swagger.client.models.ResponseListOfCoins

import io.swagger.client.infrastructure.*
import io.swagger.client.models.Coin
import javax.inject.Inject

class MockCoinApi @Inject constructor(basePath: kotlin.String = "https://api.coincap.io/v2", private val context: Context) : ApiClient(basePath) {
    fun getCoins() : ResponseListOfCoins {
        val jsonFileString = getJsonDataFromAsset(context, "coins.json") ?: ""
        val result = Serializer.moshi.adapter(ResponseListOfCoins::class.java).fromJson(jsonFileString)
        if (result != null) {
            return result
        }
        return ResponseListOfCoins(data = emptyArray<Coin>(), timestamp = 1)
    }
}
