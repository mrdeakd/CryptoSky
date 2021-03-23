package deak.david.mszr.cryptosky.ui.detailsScreen

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import deak.david.mszr.cryptosky.R

class DetailsScreenFragment : RainbowCakeFragment<DetailsScreenViewState, DetailsScreenViewModel>() {

    override fun getViewResource() = R.layout.fragment_main

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun render(viewState: DetailsScreenViewState) {
        when (viewState) {
            Initial -> {
            }
        }.exhaustive
    }
}