package deak.david.mszr.cryptosky

import dagger.Module
import dagger.Provides
import deak.david.mszr.cryptosky.swagger.client.apis.BaseApi
import io.swagger.client.apis.CoinApi
import javax.inject.Singleton

@Module
class CryptoModule {
    @Provides
    @Singleton
    fun provideCoinApi(): BaseApi  = CoinApi()
}