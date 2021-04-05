package deak.david.mszr.cryptosky.ui.aboutScreen

import co.zsmb.rainbowcake.base.RainbowCakeViewModel
import javax.inject.Inject

class AboutScreenViewModel @Inject constructor(
    private val aboutScreenPresenter: AboutScreenPresenter
) : RainbowCakeViewModel<AboutScreenViewState>(Initial)