package deak.david.mszr.cryptosky.ui.detailsScreen

import android.os.Bundle
import android.view.View
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.extensions.applyArgs
import co.zsmb.rainbowcake.navigation.extensions.requireString
import deak.david.mszr.cryptosky.R
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsScreenFragment : RainbowCakeFragment<DetailsScreenViewState, DetailsScreenViewModel>() {

    override fun getViewResource() = R.layout.fragment_details

    override fun provideViewModel() = getViewModelFromFactory()

    companion object {
        private const val ARG_COIN_ID = "ARG_COIN_ID"

        fun newInstance(transactionId: String): DetailsScreenFragment {
            return DetailsScreenFragment().applyArgs {
                putString(ARG_COIN_ID, transactionId)
            }
        }
    }

    private lateinit var coinId: String

    private fun initArguments() {
        coinId = requireArguments().requireString(ARG_COIN_ID)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initArguments()
    }

    override fun onStart() {
        viewModel.loadDetails(coinId)
        super.onStart()
    }

    override fun render(viewState: DetailsScreenViewState) {
        when (viewState) {
            is Initial -> {
            }
            is DetailsLoaded -> {
                tvDetailRank.text = viewState.coin.rank
                tvDetailSymbol.text = viewState.coin.symbol
                tvDetailChangePercent24Hr.text = viewState.coin.changePercent24Hr
                tvDetailMarketCapUsd.text = viewState.coin.marketCapUsd
                tvDetailMaxSupply.text = viewState.coin.maxSupply
                tvDetailName.text = viewState.coin.name
                tvDetailPriceUsd.text = viewState.coin.priceUsd
                tvDetailSupply.text = viewState.coin.supply
                tvDetailVolumeUsd24Hr.text = viewState.coin.volumeUsd24Hr
                val imageId = resources.getIdentifier(viewState.coin.symbol.toLowerCase(), "mipmap", context?.packageName)
                when {
                    imageId > 0 -> {
                        ivCoinIcon.setImageResource(imageId)
                    }
                    else -> {
                        ivCoinIcon.setImageResource(R.mipmap.defaultcoin)
                    }
                }
            }
        }.exhaustive
    }
}