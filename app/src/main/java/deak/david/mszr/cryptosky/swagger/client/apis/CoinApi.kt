/**
* CryptoSky
* This is an API description for COINCAP API 2.0
*
* OpenAPI spec version: 1.0.0
* Contact: mrdeakd@gmail.com
*
* NOTE: This class is auto generated by the swagger code generator program.
* https://github.com/swagger-api/swagger-codegen.git
* Do not edit the class manually.
*/
package io.swagger.client.apis

import deak.david.mszr.cryptosky.swagger.client.apis.BaseApi
import io.swagger.client.models.ResponseListOfCoins
import io.swagger.client.models.ResponseObjectOfCoin

import io.swagger.client.infrastructure.*


class CoinApi(basePath: kotlin.String = "https://api.coincap.io/v2") : ApiClient(basePath), BaseApi {

    /**
    * Find coin by ID
    * Returns a single coin
    * @param id ID of coin to return 
    * @return ResponseObjectOfCoin
    */
    @Suppress("UNCHECKED_CAST")
    override fun getCoinById(id: kotlin.String) : ResponseObjectOfCoin {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mapOf()
        
        val contentHeaders: kotlin.collections.Map<kotlin.String,kotlin.String> = mapOf()
        val acceptsHeaders: kotlin.collections.Map<kotlin.String,kotlin.String> = mapOf("Accept" to "application/xml, application/json")
        val localVariableHeaders: kotlin.collections.MutableMap<kotlin.String,kotlin.String> = mutableMapOf()
        localVariableHeaders.putAll(contentHeaders)
        localVariableHeaders.putAll(acceptsHeaders)
        
        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/assets/{id}".replace("{"+"id"+"}", "$id"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val response = request<ResponseObjectOfCoin>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as ResponseObjectOfCoin
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

    /**
    * Get all avaiable crypto datas from server
    * 
    * @return ResponseListOfCoins
    */
    @Suppress("UNCHECKED_CAST")
    override fun getCoins(limit: kotlin.Int) : ResponseListOfCoins {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mapOf("limit" to listOf("$limit"))

        val contentHeaders: kotlin.collections.Map<kotlin.String,kotlin.String> = mapOf()
        val acceptsHeaders: kotlin.collections.Map<kotlin.String,kotlin.String> = mapOf("Accept" to "application/xml, application/json")
        val localVariableHeaders: kotlin.collections.MutableMap<kotlin.String,kotlin.String> = mutableMapOf()
        localVariableHeaders.putAll(contentHeaders)
        localVariableHeaders.putAll(acceptsHeaders)
        
        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/assets",
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val response = request<ResponseListOfCoins>(
            localVariableConfig,
            localVariableBody
        )

        return when (response.responseType) {
            ResponseType.Success -> (response as Success<*>).data as ResponseListOfCoins
            ResponseType.Informational -> TODO()
            ResponseType.Redirection -> TODO()
            ResponseType.ClientError -> throw ClientException((response as ClientError<*>).body as? String ?: "Client error")
            ResponseType.ServerError -> throw ServerException((response as ServerError<*>).message ?: "Server error")
        }
    }

}
