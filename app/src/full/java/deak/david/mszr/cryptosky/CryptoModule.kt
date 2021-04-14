package deak.david.mszr.cryptosky

import dagger.Module
import dagger.Provides
import deak.david.mszr.cryptosky.network.api.BaseApi
import deak.david.mszr.cryptosky.network.api.RetrofitClient
import javax.inject.Singleton

@Module
class CryptoModule {
    @Provides
    @Singleton
    fun provideCoinApi(): BaseApi = RetrofitClient.start()
}