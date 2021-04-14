package deak.david.mszr.cryptosky.ui.mainScreen

import deak.david.mszr.cryptosky.disk.model.DBCoin

sealed class MainScreenViewState

object Initial : MainScreenViewState()

object NoCoinFoundWithText : MainScreenViewState()

object NoInternetConnection : MainScreenViewState()

data class CoinsLoaded(val coinList: List<DBCoin>) : MainScreenViewState()