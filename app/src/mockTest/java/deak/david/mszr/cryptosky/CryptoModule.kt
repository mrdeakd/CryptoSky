package deak.david.mszr.cryptosky

import android.content.Context
import dagger.Module
import dagger.Provides
import deak.david.mszr.cryptosky.network.api.BaseApi
import deak.david.mszr.cryptosky.network.api.MockCoinApi
import javax.inject.Singleton

@Module
class CryptoModule {
    @Provides
    @Singleton
    fun provideMockCoinApi(context: Context): BaseApi = MockCoinApi(context = context)
}