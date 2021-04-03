package deak.david.mszr.cryptosky.network

import android.content.Context
import dagger.Module
import dagger.Provides
import deak.david.mszr.cryptosky.swagger.client.apis.MockCoinApi
import io.swagger.client.apis.CoinApi
import javax.inject.Singleton


@Module
class CryptoModule {
    @Provides
    @Singleton
    fun provideCoinApi(): CoinApi = CoinApi()

    @Provides
    @Singleton
    fun provideMockCoinApi(context: Context): MockCoinApi = MockCoinApi(context = context)
}