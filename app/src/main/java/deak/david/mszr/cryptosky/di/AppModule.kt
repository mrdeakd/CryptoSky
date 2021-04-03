package deak.david.mszr.cryptosky.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class AppModule(context: Context) {
    private val context: Context = context

    @Singleton
    @Provides
    fun provideContext(): Context {
        return context
    }
}