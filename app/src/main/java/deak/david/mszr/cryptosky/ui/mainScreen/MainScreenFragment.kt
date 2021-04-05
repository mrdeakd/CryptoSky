package deak.david.mszr.cryptosky.ui.mainScreen

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import deak.david.mszr.cryptosky.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainScreenFragment : RainbowCakeFragment<MainScreenViewState, MainScreenViewModel>() {

    override fun getViewResource() = R.layout.fragment_main

    override fun provideViewModel() = getViewModelFromFactory()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            viewModel.loadAllCoins()
        }
    }

    override fun render(viewState: MainScreenViewState) {
        when (viewState) {
            is Initial -> {

            }
            is CoinsLoaded -> {
                viewState.coinList
            }
        }.exhaustive
    }
}