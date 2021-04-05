package deak.david.mszr.cryptosky.ui.mainScreen

import android.os.Bundle
import android.text.Editable
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.zsmb.rainbowcake.base.RainbowCakeFragment
import co.zsmb.rainbowcake.dagger.getViewModelFromFactory
import co.zsmb.rainbowcake.extensions.exhaustive
import co.zsmb.rainbowcake.navigation.navigator
import deak.david.mszr.cryptosky.R
import deak.david.mszr.cryptosky.ui.aboutScreen.AboutScreenFragment
import deak.david.mszr.cryptosky.ui.detailsScreen.DetailsScreenFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainScreenFragment : RainbowCakeFragment<MainScreenViewState, MainScreenViewModel>(), CoinsAdapter.CoinsItemListener {

    override fun getViewResource() = R.layout.fragment_main

    override fun provideViewModel() = getViewModelFromFactory()

    private val adapter = CoinsAdapter(this)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadAllCoinsOnStart()

        bAbout.setOnClickListener {
            navigator?.add(AboutScreenFragment())
        }
        swipeRefreshLayoutCoins.setOnRefreshListener {
            viewModel.loadAllCoinsOnSwipe()
        }
        recyclerViewCoins.apply {
            adapter = this@MainScreenFragment.adapter
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        }
        bAddCoin.setOnClickListener {
            if(etCoin.text.toString() == "") {
                etCoin.error = "Field cannot be empty!"
                return@setOnClickListener
            }
            viewModel.addCoinToList(etCoin.text.toString().toLowerCase().replace(" ",""))
            etCoin.text?.clear()
        }
    }

    override fun render(viewState: MainScreenViewState) {
        swipeRefreshLayoutCoins.isRefreshing = false
        when (viewState) {
            is Initial -> {}
            is CoinsLoaded -> {
                adapter.submitList(viewState.coinList)
            }
            is NoCoinFoundWithText -> {
                Toast.makeText(context ,"Coin not found", Toast.LENGTH_LONG).show()
            }
            is NoInternetConnection -> {
                Toast.makeText(context ,"Internet connection is not on", Toast.LENGTH_LONG).show()
            }
        }.exhaustive
    }

    override fun onItemClick(coinId: String) {
        navigator?.add(DetailsScreenFragment.newInstance(coinId))
    }
}