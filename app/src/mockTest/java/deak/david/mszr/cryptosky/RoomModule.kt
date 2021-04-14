package deak.david.mszr.cryptosky

import dagger.Module
import dagger.Provides
import deak.david.mszr.cryptosky.disk.DatabaseDao
import deak.david.mszr.cryptosky.disk.MockDatabaseDao
import javax.inject.Singleton

@Module
class RoomModule {
    @Provides
    @Singleton
    fun provideDatabaseDao(): DatabaseDao {
        return MockDatabaseDao()
    }
}