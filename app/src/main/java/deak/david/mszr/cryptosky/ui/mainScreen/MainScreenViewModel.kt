package deak.david.mszr.cryptosky.ui.mainScreen

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val mainScreenPresenter: MainScreenPresenter
) : RainbowCakeViewModel<MainScreenViewState>(Initial) {}