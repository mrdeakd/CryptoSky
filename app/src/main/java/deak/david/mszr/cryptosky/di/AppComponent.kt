package deak.david.mszr.cryptosky.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import dagger.Component
import deak.david.mszr.cryptosky.disk.RoomModule
import deak.david.mszr.cryptosky.network.CryptoModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ViewModelModule::class,
        ApplicationModule::class,
        CryptoModule::class,
        RoomModule::class
    ]
)
interface AppComponent : RainbowCakeComponent