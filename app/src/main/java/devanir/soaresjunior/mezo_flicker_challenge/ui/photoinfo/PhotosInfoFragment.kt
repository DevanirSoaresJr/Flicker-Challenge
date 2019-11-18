package devanir.soaresjunior.mezo_flicker_challenge.ui.photoinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import devanir.soaresjunior.mezo_flicker_challenge.FlickrApp
import devanir.soaresjunior.mezo_flicker_challenge.R
import devanir.soaresjunior.mezo_flicker_challenge.common.GlideApp
import devanir.soaresjunior.mezo_flicker_challenge.common.NetworkState
import devanir.soaresjunior.mezo_flicker_challenge.common.Utils
import devanir.soaresjunior.mezo_flicker_challenge.di.fragment.FragmentModule
import kotlinx.android.synthetic.main.fragment_photo_info.*
import javax.inject.Inject

class PhotosInfoFragment : Fragment() {
    @Inject
    lateinit var viewModel: PhotosInfoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragmentComponent = (requireActivity().application as FlickrApp).applicationComponent
            .newFragmentComponent(FragmentModule(this))
        fragmentComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photo_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.getString(ARG_INFO)?.let {
            observePhotoInfo(it)
        }
    }

    private fun observePhotoInfo(photoId: String) {
        viewModel.fetchPhotoInfo(photoId).observe(this, Observer {
            when (it) {
                is NetworkState.Loading -> {
//                    pbLoading.visibility = View.VISIBLE
                }
                is NetworkState.Success -> {
//                    pbLoading.visibility = View.GONE
                    it.data?.let { photoInfo ->

                        // generate the url for the photo
                        val url = Utils.generateImageUrl(
                            photoInfo.photo.farm.toString(),
                            photoInfo.photo.server,
                            photoInfo.photo.id,
                            photoInfo.photo.secret,
                            'z'
                        )

                        // display the photo to image view
                        GlideApp.with(requireContext())
                            .load(url)
                            .override(200, 200)
                            .into(ivImage)

                        tvTitle.text = photoInfo.photo.views
                        tvDescription.text = photoInfo.photo.location.toString()
                    }
                }
                is NetworkState.Failure -> {
                    // Error handling here
//                    pbLoading.visibility = View.GONE
                }
            }
        })
    }

    companion object {
        private const val ARG_INFO = "photo_info"

        fun newInstance(photoId: String): PhotosInfoFragment {
            val args = Bundle()
            args.putString(ARG_INFO, photoId)
            val fragment = PhotosInfoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
