package deak.david.mszr.cryptosky.network.api

import android.content.Context
import com.google.gson.Gson
import deak.david.mszr.cryptosky.data.network.model.Coin
import deak.david.mszr.cryptosky.data.network.model.ResponseListOfCoins
import deak.david.mszr.cryptosky.data.network.model.ResponseObjectOfCoin
import deak.david.mszr.cryptosky.getJsonDataFromAsset
import retrofit2.Response


class MockCoinApi constructor(
    private val context: Context
) : BaseApi {
    override suspend fun getCoins(limit: kotlin.Int?) : Response<ResponseListOfCoins> {
        val jsonFileString = getJsonDataFromAsset(context, "coins.json") ?: ""
        val gson = Gson()
        val result = gson.fromJson(jsonFileString, ResponseListOfCoins::class.java)
        if (result != null) {
            return Response.success(result)
        }
        return Response.success(ResponseListOfCoins(data = emptyList<Coin>(), timestamp = 1))
    }

    override suspend fun getCoinById(id: kotlin.String) : Response<ResponseObjectOfCoin> {
        val jsonFileString = getJsonDataFromAsset(context, "coins.json") ?: ""
        val gson = Gson()
        val result = gson.fromJson(jsonFileString, ResponseListOfCoins::class.java)
        if (result?.data != null) {
            for (res in result.data) {
                if (res.id == id) {
                    return Response.success(ResponseObjectOfCoin(res, result.timestamp))
                }
            }
        }
        return Response.success(ResponseObjectOfCoin())
    }
}
