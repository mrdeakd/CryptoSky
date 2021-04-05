package deak.david.mszr.cryptosky.disk

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule {
    @Provides
    @Singleton
    fun provideRoom(context: Context): CoinRoomDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            CoinRoomDatabase::class.java,
            "coins_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideDatabaseDao(coinRoomDatabase: CoinRoomDatabase): DatabaseDao {
        return coinRoomDatabase.coinDataDao()
    }
}
