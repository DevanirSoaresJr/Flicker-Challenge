package devanir.soaresjunior.mezo_flicker_challenge.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import devanir.soaresjunior.mezo_flicker_challenge.R
import devanir.soaresjunior.mezo_flicker_challenge.ui.photolist.PhotoListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = PhotoListFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.flContainer, fragment, fragment.tag)
            .commit()
    }
}
