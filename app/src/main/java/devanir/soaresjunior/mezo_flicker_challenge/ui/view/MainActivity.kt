package devanir.soaresjunior.mezo_flicker_challenge.ui.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import devanir.soaresjunior.mezo_flicker_challenge.FlickrApp
import devanir.soaresjunior.mezo_flicker_challenge.R
import devanir.soaresjunior.mezo_flicker_challenge.di.app.AppComponent
import devanir.soaresjunior.mezo_flicker_challenge.di.app.DaggerAppComponent
import devanir.soaresjunior.mezo_flicker_challenge.di.photos.DaggerPhotosComponent
import devanir.soaresjunior.mezo_flicker_challenge.di.photos.PhotosComponent
import devanir.soaresjunior.mezo_flicker_challenge.di.photos.PhotosModule
import devanir.soaresjunior.mezo_flicker_challenge.ui.viewModel.vmdls.PhotosViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var activityComponent: PhotosComponent


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDependencies()
    }
    override fun onStart() {
        super.onStart()
        registerReceiver(broadcastReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(broadcastReceiver)
    }


    override fun onPause() {
        super.onPause()
        //this method sets a Flag that will protect the contents of the FlickrApp From Being Shown
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE)

    }

    override fun onResume() {
        super.onResume()
        //this method in correlation with the onPause function clears the Flag set onPause
        window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE)
    }

    private fun disconnected() {
        img_no_internet.visibility = View.VISIBLE

    }

    private fun connected() {
        img_no_internet.visibility = View.INVISIBLE
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, SplashFragment(), SplashFragment().tag)
            .commit()

    }
    private var broadcastReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val notConnected = intent.getBooleanExtra(
                ConnectivityManager
                    .EXTRA_NO_CONNECTIVITY, false)
            if (notConnected) {
                disconnected()
            } else {
                connected()
            }
        }
    }
    private fun getDependencies() {
        DaggerPhotosComponent.builder().appComponent((application as FlickrApp).component()).photosModule(
            PhotosModule(this)
        ).build().inject(this)

    }

}
