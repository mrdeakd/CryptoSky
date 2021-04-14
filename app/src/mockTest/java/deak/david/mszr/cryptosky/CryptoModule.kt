package deak.david.mszr.cryptosky

import android.content.Context
import dagger.Module
import dagger.Provides
import deak.david.mszr.cryptosky.swagger.client.apis.BaseApi
import deak.david.mszr.cryptosky.swagger.client.apis.MockCoinApi
import javax.inject.Singleton

@Module
class CryptoModule {
    @Provides
    @Singleton
    fun provideMockCoinApi(context: Context): BaseApi  = MockCoinApi(context = context)
}