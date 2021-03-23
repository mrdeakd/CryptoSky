package deak.david.mszr.cryptosky.ui.detailsScreen

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class DetailsScreenViewModel @Inject constructor(
    private val detailsScreenPresenter: DetailsScreenPresenter
) : RainbowCakeViewModel<DetailsScreenViewState>(Initial) {}