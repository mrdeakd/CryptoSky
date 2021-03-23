package deak.david.mszr.cryptosky

import co.zsmb.rainbowcake.navigation.SimpleNavActivity
import android.os.Bundle
import deak.david.mszr.cryptosky.ui.mainScreen.MainScreenFragment

class MainActivity : SimpleNavActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator.add(MainScreenFragment())
    }
}
