package deak.david.mszr.cryptosky.ui.aboutScreen

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import deak.david.mszr.cryptosky.R

class AboutScreenFragment : RainbowCakeFragment<AboutScreenViewState, AboutScreenViewModel>() {

    override fun getViewResource() = R.layout.fragment_main

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun render(viewState: AboutScreenViewState) {
        when (viewState) {
            Initial -> {
            }
        }.exhaustive
    }
}