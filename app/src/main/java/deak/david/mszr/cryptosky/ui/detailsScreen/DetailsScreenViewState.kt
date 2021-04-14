package deak.david.mszr.cryptosky.ui.detailsScreen

import deak.david.mszr.cryptosky.disk.model.DBCoin

sealed class DetailsScreenViewState

object Initial : DetailsScreenViewState()

data class DetailsLoaded(val coin: DBCoin) : DetailsScreenViewState()