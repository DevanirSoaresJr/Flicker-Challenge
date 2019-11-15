package devanir.soaresjunior.mezo_flicker_challenge.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.pixelart.week6daily2flikrapi.model.PhotoData
import com.pixelart.week6daily2flikrapi.model.PhotoResponse
import com.pixelart.week6daily2flikrapi.model.photoinfo.InfoData
import devanir.soaresjunior.mezo_flicker_challenge.R
import devanir.soaresjunior.mezo_flicker_challenge.adapter.ImageAdapter
import devanir.soaresjunior.mezo_flicker_challenge.common.BaseFragment
import devanir.soaresjunior.mezo_flicker_challenge.ui.viewModel.vmdls.PhotosViewModel
import kotlinx.android.synthetic.main.fragment_photos.*
import javax.inject.Inject

class PhotoListFragment:BaseFragment() , ImageAdapter.OnItemClickedListener {

    @Inject
    lateinit var photosViewModel: PhotosViewModel
    private lateinit var photoList: ArrayList<PhotoData>
    private lateinit var photoInfo : InfoData
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private var adapter: ImageAdapter? = null
    private var photos = listOf<PhotoResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).activityComponent.inject(this)
        photoList = ArrayList()
        //photoInfo = ArrayList(photoList.size)
        layoutManager = GridLayoutManager(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photos, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        photosViewModel.getPhotos()
        photosViewModel.getPhotosObservable().observe(viewLifecycleOwner, Observer {

            adapter = ImageAdapter(it, this)
            rvPhotos.adapter = adapter
            photos = it
        })
    }




    override fun onItemClickedListener(position: Int) {
        val photoInfoFragment = PhotosInfoFragment.newInstance(photos[position].info)
        fragmentManager?.beginTransaction()
            ?.replace(R.id.flContainer, photoInfoFragment, PhotosInfoFragment().tag)
            ?.addToBackStack(PhotosInfoFragment().tag)
            ?.commit()    }

}
