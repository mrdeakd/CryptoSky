package deak.david.mszr.cryptosky.ui.mainScreen

import co.zsmb.rainbowcake.withIOContext
import deak.david.mszr.cryptosky.disk.model.DBCoin
import deak.david.mszr.cryptosky.domain.CryptoInteractor
import javax.inject.Inject

class MainScreenPresenter @Inject constructor(
    private val cryptoInteractor: CryptoInteractor
) {
    suspend fun getAllCoins(): List<DBCoin> = withIOContext {
        cryptoInteractor.getCryptoResult()
    }
}
