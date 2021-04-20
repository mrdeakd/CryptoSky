package deak.david.mszr.cryptosky.ui.mainScreen

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import deak.david.mszr.cryptosky.Functions
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenPresenter: MainScreenPresenter
) : RainbowCakeViewModel<MainScreenViewState>(Initial) {
    fun loadAllCoinsOnSwipe() = execute {
        if (!Functions.isConnected()) {
            viewState = NoInternetConnection
        }
        viewState = CoinsLoaded(mainScreenPresenter.getAllCoins())
    }

    fun loadAllCoinsOnStart() = execute {
        viewState = CoinsLoaded(mainScreenPresenter.getAllCoins())
    }

    fun addCoinToList(coinId: String) = execute {
        if (!Functions.isConnected()) {
            viewState = NoInternetConnection
            return@execute
        }
        val listWrapper = mainScreenPresenter.addCoinToList(coinId = coinId)
        viewState = if (listWrapper.listChanged) {
            CoinsLoaded(listWrapper.listOfCoins)
        } else {
            NoCoinFoundWithText
        }
    }
}