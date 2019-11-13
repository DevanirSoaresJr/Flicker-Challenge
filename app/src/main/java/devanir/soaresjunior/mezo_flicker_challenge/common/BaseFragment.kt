package devanir.soaresjunior.mezo_flicker_challenge.common

import android.os.Bundle
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()

    }

    open fun inject() {}

}

