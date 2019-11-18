package devanir.soaresjunior.mezo_flicker_challenge.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import devanir.soaresjunior.mezo_flicker_challenge.R
import devanir.soaresjunior.mezo_flicker_challenge.ui.photolist.PhotosViewModel
import kotlinx.android.synthetic.main.fragment_splash.*
import javax.inject.Inject


class SplashFragment : Fragment() {
    @Inject
    lateinit var viewModel: PhotosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //(activity as MainActivity).activityComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        pbLoading.visibility = View.VISIBLE
        observeNetworkStatus()
    }

    private fun observeNetworkStatus() {
        /*viewModel.getNetStatus().observe(viewLifecycleOwner, Observer {
            when (it.stat) {
                "ok" -> {
                    pbLoading.visibility = View.GONE
                    fragmentManager?.beginTransaction()
                        ?.replace(R.id.flContainer, PhotoListFragment(), PhotosInfoFragment().tag)
                        ?.commit()

                    fragmentManager?.popBackStack()
                }
                else -> {
                    pbLoading.visibility = View.GONE
                    ibRetry.visibility = View.VISIBLE

                    ibRetry.setOnClickListener {
                        pbLoading.visibility = View.VISIBLE
                        ibRetry.visibility = View.GONE
                        observeNetworkStatus()
                    }
                }
            }
        })*/
    }

}
