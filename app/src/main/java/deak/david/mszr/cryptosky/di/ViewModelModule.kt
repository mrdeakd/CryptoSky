package deak.david.mszr.cryptosky.di

import androidx.lifecycle.ViewModel
import co.zsmb.rainbowcake.dagger.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import deak.david.mszr.cryptosky.ui.aboutScreen.AboutScreenViewModel
import deak.david.mszr.cryptosky.ui.detailsScreen.DetailsScreenViewModel
import deak.david.mszr.cryptosky.ui.mainScreen.MainScreenViewModel

@Module
abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    abstract fun bindUserViewModel(userViewModel: MainScreenViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(DetailsScreenViewModel::class)
    abstract fun bindDetailsViewModel(detailsViewModel: DetailsScreenViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AboutScreenViewModel::class)
    abstract fun bindAboutViewModel(aboutViewModel: AboutScreenViewModel): ViewModel
}