package deak.david.mszr.cryptosky.ui.detailsScreen

import co.zsmb.rainbowcake.withIOContext
import deak.david.mszr.cryptosky.disk.model.DBCoin
import deak.david.mszr.cryptosky.domain.CryptoInteractor
import javax.inject.Inject

class DetailsScreenPresenter @Inject constructor(
    private val cryptoInteractor: CryptoInteractor
) {
    suspend fun loadDetails(coinId: String): DBCoin = withIOContext {
        cryptoInteractor.loadDetails(coinId = coinId)
    }
}
