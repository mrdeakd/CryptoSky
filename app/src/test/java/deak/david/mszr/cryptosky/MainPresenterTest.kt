package deak.david.mszr.cryptosky

import deak.david.mszr.cryptosky.data.network.model.Coin
import deak.david.mszr.cryptosky.data.network.model.ResponseListOfCoins
import deak.david.mszr.cryptosky.data.network.model.ResponseObjectOfCoin
import deak.david.mszr.cryptosky.disk.DatabaseDao
import deak.david.mszr.cryptosky.disk.RoomDataSource
import deak.david.mszr.cryptosky.disk.model.DBCoin
import deak.david.mszr.cryptosky.disk.model.NewListWrapper
import deak.david.mszr.cryptosky.domain.CryptoInteractor
import deak.david.mszr.cryptosky.network.CryptoNetworkDataSource
import deak.david.mszr.cryptosky.network.api.BaseApi
import deak.david.mszr.cryptosky.ui.mainScreen.MainScreenPresenter
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class MainPresenterTest {

    private lateinit var mainPresenter: MainScreenPresenter
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
        mainPresenter = MainScreenPresenter(cryptoInteractor)
    }

    @Test
    fun `get all coins that it contains from cache after updating from API`() = runBlocking {
        every { runBlocking { cryptoAPI.getCoins() } } returns Response.success(ResponseListOfCoins(listOf(Coin(id= "btc", name = "Bitcoin"), Coin(name = "Ethereum")), 1))
        every {  databaseDao.getAllCoins() } returns listOf(
            DBCoin("btc","","","Bitcoin","","","","","","",""),
            DBCoin("","","","Ethereum","","","","","","","")
        )
        every { databaseDao.deleteCoinById("btc") } returns Unit
        every { databaseDao.insertCoin(
            DBCoin("btc","","","Bitcoin","","","","","","","")
        )
        } returns Unit

        var coins: List<DBCoin>
        runBlocking {
            coins = mainPresenter.getAllCoins()
        }

        verify {
            Functions.isConnected()
            roomDataSource.getCoins()
        }
        assertEquals(coins.count(), 2)
        assertEquals(coins[0].name, "Bitcoin")
        assertEquals(coins[1].name, "Ethereum")
    }

    @Test
    fun `add coin to list which exists in remote API list`() = runBlocking {
        every { runBlocking { cryptoAPI.getCoinById("Bitcoin") } } returns Response.success(ResponseObjectOfCoin(Coin(id = "btc", name = "Bitcoin"), 1))
        every { runBlocking { databaseDao.insertCoin(DBCoin("","","","Bitcoin","","","","","","","")) } } returns Unit
        every {   databaseDao.getAllCoins()  } returns listOf(
            DBCoin("","","","Bitcoin","","","","","","",""),
            DBCoin("","","","Ethereum","","","","","","","")
        )
        every { databaseDao.deleteCoinById("btc") } returns Unit
        every { databaseDao.insertCoin(
            DBCoin("btc","","","Bitcoin","","","","","","","")
        )
        } returns Unit


        var wrapper: NewListWrapper
        runBlocking {
            wrapper = mainPresenter.addCoinToList("Bitcoin")
        }

        verify {
            Functions.isConnected()
            roomDataSource.getCoins()
        }
        assertEquals(wrapper.listChanged, true)
    }

    @Test
    fun `add coin to list which doesn't exists in remote API list`() = runBlocking {
        every { runBlocking { cryptoAPI.getCoinById("Bitcoin") } } returns Response.success(ResponseObjectOfCoin(null, 1))
        every {   databaseDao.getAllCoins()  } returns listOf(
            DBCoin("","","","Bitcoin","","","","","","",""),
            DBCoin("","","","Ethereum","","","","","","","")
        )

        var wrapper: NewListWrapper
        runBlocking {
            wrapper = mainPresenter.addCoinToList("Bitcoin")
        }

        verify {
            Functions.isConnected()
            roomDataSource.getCoins()
        }
        assertEquals(wrapper.listChanged, false)
    }
}