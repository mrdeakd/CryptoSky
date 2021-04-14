package deak.david.mszr.cryptosky.network.api

import retrofit2.http.*
import retrofit2.Response

import deak.david.mszr.cryptosky.data.network.model.ResponseListOfCoins
import deak.david.mszr.cryptosky.data.network.model.ResponseObjectOfCoin

interface CoinApi: BaseApi {
    /**
     * Find coin by ID
     * Returns a single coin
     * Responses:
     *  - 200: Successful
     *  - 400: Client error
     *  - 404: Coin not found
     *  - 500: Server Error
     * 
     * @param id ID of coin to return 
    * @return [ResponseObjectOfCoin]
     */
    @GET("assets/{id}")
    override suspend fun getCoinById(@Path("id") id: kotlin.String): Response<ResponseObjectOfCoin>

    /**
     * Get all avaiable crypto datas from server
     * 
     * Responses:
     *  - 200: Successful
     *  - 400: Client error
     *  - 500: Server Error
     * 
     * @param limit The amount of coins that gets downloaded (optional, default to 2000)
    * @return [ResponseListOfCoins]
     */
    @GET("assets")
    override suspend fun getCoins(@Query("limit") limit: kotlin.Int?): Response<ResponseListOfCoins>

}
