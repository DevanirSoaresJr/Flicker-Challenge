package devanir.soaresjunior.mezo_flicker_challenge.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import devanir.soaresjunior.mezo_flicker_challenge.R
import devanir.soaresjunior.mezo_flicker_challenge.common.BaseFragment
import kotlinx.android.synthetic.main.fragment_photos.*
import javax.inject.Inject

class PhotoListFragment:BaseFragment() , OnItemClickedListener {
    @Inject
    lateinit var viewModel: HomeViewModel

    private var adapter: QuestionsAdapter? = null
    private var questions = listOf<QuestionsResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity).activityComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeQuestions()
    }

    private fun observeQuestions() {
        viewModel.showQuestionsInfo().observe(viewLifecycleOwner, Observer {
            adapter = PhotosAdapter(it, this)
            rvPhotos.adapter = adapter
            questions = it
        })
    }

    override fun onItemClicked(position: Int) {
        val photoInfoFragment = PhotosInfoFragment.newInstance(questions[position].choices)
        fragmentManager?.beginTransaction()
            ?.replace(R.id.flContainer, photoInfoFragment, PhotosInfoFragment().tag)
            ?.addToBackStack(PhotosInfoFragment().tag)
            ?.commit()
    }
}
