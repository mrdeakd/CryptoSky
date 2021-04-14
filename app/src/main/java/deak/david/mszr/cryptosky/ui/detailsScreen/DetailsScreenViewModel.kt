package deak.david.mszr.cryptosky.ui.detailsScreen

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import deak.david.mszr.cryptosky.ui.mainScreen.CoinsLoaded
import javax.inject.Inject

class DetailsScreenViewModel @Inject constructor(
    private val detailsScreenPresenter: DetailsScreenPresenter
) : RainbowCakeViewModel<DetailsScreenViewState>(Initial) {
    fun loadDetails(coinId: String) = execute {
        viewState = DetailsLoaded(detailsScreenPresenter.loadDetails(coinId))
    }
}