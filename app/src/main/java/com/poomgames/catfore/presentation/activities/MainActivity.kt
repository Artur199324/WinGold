package com.poomgames.catfore.presentation.activities

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Process
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.poomgames.catfore.databinding.ActivityMainBinding
import com.poomgames.catfore.load.giigi.Giig
import com.poomgames.catfore.load.giigi.Gud
import com.poomgames.catfore.load.giigi.Khd
import com.poomgames.catfore.presentation.App
import com.poomgames.catfore.presentation.LoadCup
import com.poomgames.catfore.presentation.viewmodels.GameViewModel
import com.poomgames.catfore.presentation.viewmodels.LoadingViewModel
import com.poomgames.catfore.presentation.viewmodels.ShopViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var string:String = ""
    val loadingViewModel: LoadingViewModel by viewModels {
        (applicationContext as App).appComponent.loadingViewModelFactory()
    }
    val gameViewModel: GameViewModel by viewModels {
        (applicationContext as App).appComponent.gameViewModelFactory()
    }
    val shopViewModel: ShopViewModel by viewModels {
        (applicationContext as App).appComponent.shopViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        if (!isTaskRoot
            && intent.hasCategory(Intent.CATEGORY_LAUNCHER)
            && intent.action != null && intent.action == Intent.ACTION_MAIN
        ) {
            finish()
            return
        }
        setContentView(binding.root)
        val giig = Giig()
        giig.s = Gud().aa + Gud().kfh
        giig.f = Khd().jg + Khd().ki
        string =  giig.s + giig.f
        LoadCup.setMainActivity(this)
        loadingViewModel.insertFacts()

    }

    fun dialog(){
        val builder = AlertDialog.Builder(this)
            .setMessage("Connect to the Internet")
            .setCancelable(false)
            .setPositiveButton("ОК") { dialog: DialogInterface, _: Int ->
                dialog.cancel()
                startActivity(
                    Intent(
                        applicationContext,
                        MainActivity::class.java
                    )
                )
                finish()
                Process.killProcess(Process.myPid())
            }
        builder.create()
        builder.show()
    }
}