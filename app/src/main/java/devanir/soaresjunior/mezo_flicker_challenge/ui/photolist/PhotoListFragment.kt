package devanir.soaresjunior.mezo_flicker_challenge.ui.photolist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import devanir.soaresjunior.mezo_flicker_challenge.FlickrApp
import devanir.soaresjunior.mezo_flicker_challenge.R
import devanir.soaresjunior.mezo_flicker_challenge.adapter.ImageAdapter
import devanir.soaresjunior.mezo_flicker_challenge.common.NetworkState
import devanir.soaresjunior.mezo_flicker_challenge.common.Utils
import devanir.soaresjunior.mezo_flicker_challenge.data.dto.PhotoDto
import devanir.soaresjunior.mezo_flicker_challenge.di.fragment.FragmentModule
import devanir.soaresjunior.mezo_flicker_challenge.ui.photoinfo.PhotosInfoFragment
import kotlinx.android.synthetic.main.fragment_photos.*
import javax.inject.Inject

class PhotoListFragment : Fragment(), ImageAdapter.OnItemClickedListener {

    @Inject
    lateinit var photosViewModel: PhotosViewModel
    private val photoList = mutableListOf<PhotoDto>()
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var adapter: ImageAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fragmentComponent = (requireActivity().application as FlickrApp)
            .applicationComponent
            .newFragmentComponent(FragmentModule(this))
        fragmentComponent.inject(this)
        layoutManager = GridLayoutManager(requireContext(), 2)
        adapter = ImageAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photos, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvPhotos.apply {
            adapter = this@PhotoListFragment.adapter
        }

        btnSearchPhotos.setOnClickListener {
            val user = etUserName.text.toString()
            observeUserId(user)
        }
    }

    private fun observeUserId(username: String) {
        photosViewModel.fetchUserId(username).observe(this, Observer {
            when (it) {
                is NetworkState.Loading -> {
                    pbLoading.visibility = View.VISIBLE
                }
                is NetworkState.Success -> {
                    pbLoading.visibility = View.GONE

                    it.data?.let { userResponse ->
                        observePhotos(userResponse.user.nsid)
                        Log.d("UserId", "${userResponse.user.nsid}, ${userResponse.user.username}")
                    }
                }
                is NetworkState.Failure -> {
                    // Handle failure here
                    pbLoading.visibility = View.GONE
                }
            }
        })
    }

    private fun observePhotos(userId: String) {
        photosViewModel.fetchPhotos(userId, 20).observe(this, Observer {
            when (it) {
                is NetworkState.Loading -> {
                    pbLoading.visibility = View.VISIBLE
                }
                is NetworkState.Success -> {
                    pbLoading.visibility = View.GONE

                    it.data?.let { response ->
                        when (response.stat) {
                            "ok" -> {
                                // show photos
                                val photos = response.photos.photo

                                // Show message if there are no photos else show the list of photos
                                photoList.clear()
                                if (photos.isEmpty()) {
                                    tvMessage.visibility = View.VISIBLE
                                    tvMessage.text = getString(R.string.no_photos_message)
                                } else {
                                    tvMessage.visibility = View.INVISIBLE
                                    for (i in photos.indices) {
                                        photoList.add(PhotoDto(
                                            id = photos[i].id,
                                            title = photos[i].title,
                                            owner = photos[i].owner,
                                            url = Utils.generateImageUrl(
                                                photos[i].farm.toString(),
                                                photos[i].server,
                                                photos[i].id,
                                                photos[i].secret,
                                                'z'
                                            )
                                        ))
                                    }
                                    adapter?.setData(photoList)
                                    adapter?.notifyDataSetChanged()
                                }
                            }
                            "fail" -> {
                                // Show error message here
                                 tvMessage.text = response.message
                            }
                            else -> return@Observer
                        }
                    }
                }
                is NetworkState.Failure -> {
                    // Handle failure here
                    pbLoading.visibility = View.GONE
                }
            }
        })
    }

    override fun onItemClickedListener(position: Int) {
        val fragment = PhotosInfoFragment.newInstance(photoList[position].id)
        fragmentManager?.beginTransaction()
            ?.replace(R.id.flContainer, fragment, fragment.tag)
            ?.addToBackStack(this.tag)
            ?.commit()
    }

}
