package deak.david.mszr.cryptosky

import deak.david.mszr.cryptosky.disk.DatabaseDao
import deak.david.mszr.cryptosky.disk.RoomDataSource
import deak.david.mszr.cryptosky.disk.model.DBCoin
import deak.david.mszr.cryptosky.domain.CryptoInteractor
import deak.david.mszr.cryptosky.network.CryptoNetworkDataSource
import deak.david.mszr.cryptosky.network.api.BaseApi
import deak.david.mszr.cryptosky.ui.detailsScreen.DetailsScreenPresenter
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class DetailsPresenterTest {

    private lateinit var detailsPresenter: DetailsScreenPresenter
    lateinit var cryptoInteractor: CryptoInteractor
    private lateinit var cryptoNetworkDataSource: CryptoNetworkDataSource
    lateinit var roomDataSource: RoomDataSource
    private lateinit var cryptoAPI: BaseApi
    lateinit var databaseDao: DatabaseDao


    @Before
    @Throws(Exception::class)
    fun setup() {
        cryptoAPI = mockk()
        databaseDao = mockk()
        cryptoNetworkDataSource = CryptoNetworkDataSource(cryptoAPI)
        roomDataSource = RoomDataSource(databaseDao)
        cryptoInteractor = CryptoInteractor(cryptoNetworkDataSource, roomDataSource)
        detailsPresenter = DetailsScreenPresenter(cryptoInteractor)
    }

    @Test
    fun `open details and get a specific coin which is in the list BTC`() = runBlocking {
        every { databaseDao.getCoinById("bitcoin") } returns DBCoin("","","","Bitcoin","","","","","","","")

        var coin: DBCoin
        runBlocking {
            coin = detailsPresenter.loadDetails("bitcoin")
        }

        verify {
            roomDataSource.getCoinById("bitcoin")
            databaseDao.getCoinById("bitcoin")
        }
        assertEquals(coin.name, "Bitcoin")
    }

    @Test
    fun `open details and get a specific coin which is not in the list`() = runBlocking {
        every { databaseDao.getCoinById("bitcoin") } returns DBCoin("","","","","","","","","","","")

        var coin: DBCoin
        runBlocking {
            coin = detailsPresenter.loadDetails("bitcoin")
        }

        verify {
            roomDataSource.getCoinById("bitcoin")
            databaseDao.getCoinById("bitcoin")
        }
        assertEquals(coin.name, "")
    }
}